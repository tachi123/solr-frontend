package solrinterface

import grails.util.Holders
import grails.util.TypeConvertingMap
import org.springframework.web.servlet.support.RequestContextUtils

class ViewItemTagLib {

    static namespace = 'vi'     // namespace for headers and footers
    /**
     * All the following statics can be overridden by the specified config declarations.
     */

    def headerAndFooterBaseURL = Holders.config.headerAndFooter.baseURL ?: "https://www.ala.org.au/commonui-bs3"

    def cacheTimeout = (Holders.config.headerAndFooter.cacheTimeout ?: '1800000').toLong()

    def banner = { attrs ->
        out << load('banner', attrs)
    }

    /**
     *
     */
    def head = {
        out << load('head', [:])
    }

    /**
     * Displays the page footer.
     *
     * Usage: <hf:footer/>
     */
    def footer = { attrs ->
        out << load('footer', attrs)
    }

    /**
     * Cache for includes. Expires after 30 mins or when clearCache is called.
     */
    def hfCache = [
            banner: [timestamp: new Date().time, content: ""],
            footer: [timestamp: new Date().time, content: ""],
            head: [timestamp: new Date().time, content: ""]
    ]

    /**
     * Call this tag from a controller to clear the cache.
     */
    def clearCache = {
        hfCache.each { key, obj -> hfCache[key].content = ""}
        log.info "cache cleared"
    }

    /**
     * Get the content from cache of the web.
     * @param which specifies the include
     * @param attrs any specified params
     * @return
     */
    String load(which, attrs) {
        def content
        if (hfCache[which].content == "" || (new Date().time > hfCache[which].timestamp + cacheTimeout)) {
            content = getContent(which)
            hfCache[which].content = content
            hfCache[which].timestamp = new Date().time
        } else {
            content = hfCache[which].content
        }
        return transform(content, attrs)
    }

    /**
     * Loads the content from the web.
     * @param which specifies the include
     * @return
     */
    String getContent(which) {

        def url = headerAndFooterBaseURL + '/' + which + ".html" // Bootstrap versions
        def conn = new URL(url).openConnection()
        try {
            conn.setConnectTimeout(10000)
            conn.setReadTimeout(50000)
            return conn.content.text
        } catch (SocketTimeoutException e) {
            log.warn "Timed out getting ${which} template. URL= ${url}."
        } catch (Exception e) {
            log.warn "Failed to get ${which} template. ${e.getClass()} ${e.getMessage()} URL= ${url}."
        }
        return ""
    }

    /**
     * Does the appropriate substitutions on the included content.
     * @param content
     * @param attrs any specified params to override defaults
     * @return
     */
    String transform(content, attrs) {
        switch ( Holders.config.headerAndFooter.version ) {
            case "2":
                return transformV2(content, attrs)
            case "1":
            default:
                return transformV1(content, attrs)
        }
    }

    /**
     * @deprecated
     * Does the appropriate substitutions on the included content.
     * @param content
     * @param attrs any specified params to override defaults
     * @return
     */
    String transformV1(content, attrs) {
        content = content.replaceAll(/::headerFooterServer::/, headerAndFooterBaseURL)
        content = content.replaceAll(/::centralServer::/, alaBaseURL)
        content = content.replaceAll(/::searchServer::/, bieBaseURL) // change for BIE to grailServerURL
        content = content.replaceAll(/::searchPath::/, bieSearchPath)
        content = content.replaceAll(/::authStatusClass::/, isLoggedIn(attrs) ? LOGGED_IN_CLASS: LOGGED_OUT_CLASS)
        if (attrs.fluidLayout) {
            content = content.replaceAll('class="container"', 'class="container-fluid"')
        }
        if (content =~ "::loginLogoutListItem::") {
            // only do the work if it is needed
            content = content.replaceAll(/::loginLogoutListItem::/, buildLoginoutLink(attrs))
        }
        return content
    }

    /**
     * Does the appropriate substitutions on the included content.
     * @param content
     * @param attrs any specified params to override defaults
     * @return
     */
    String transformV2(content, attrs) {
        content = content.replaceAll(/::headerFooterServer::/, headerAndFooterBaseURL)
        content = content.replaceAll(/::centralServer::/, alaBaseURL)
        content = content.replaceAll(/::searchServer::/, bieBaseURL) // change for BIE to grailServerURL
        content = content.replaceAll(/::searchPath::/, bieSearchPath)

        if ((attrs.fluidLayout?:"true").toBoolean()) {
            content = content.replaceAll('::containerClass::', "container-fluid")
        } else {
            content = content.replaceAll('::containerClass::', "container")
        }

        def signedInOutClass = isLoggedIn(attrs) ? 'signedIn' : 'signedOut'
        content = content.replaceAll(/::loginURL::/, buildLoginLink(attrs))
        content = content.replaceAll(/::logoutURL::/, buildLogoutLink(attrs))
        content = content.replaceAll(/::loginStatus::/, signedInOutClass)

        return content
    }

    boolean isLoggedIn(attrs) {
        (attrs.ignoreCookie != "true" &&
                AuthenticationCookieUtils.cookieExists(request, AuthenticationCookieUtils.ALA_AUTH_COOKIE)) ||
                request.userPrincipal
    }

    /**
     * Builds the login or logout link based on current login status.
     * @param attrs any specified params to override defaults
     * @return
     */
    String buildLoginoutLink(attrs) {
        switch ( Holders.config.headerAndFooter.version ) {
            case "2":
                return buildLoginoutLinkV2(attrs)
            case "1":
            default:
                return buildLoginoutLinkV1(attrs)
        }
    }

    /**
     * @deprecated
     * Builds the login or logout link based on current login status.
     * @param attrs any specified params to override defaults
     * @return
     */
    String buildLoginoutLinkV1(attrs) {
        def requestUri = removeContext(grailServerURL) + request.forwardURI
        def logoutUrl = attrs.logoutUrl ?: grailServerURL + "/session/logout"
        def logoutReturnToUrl = attrs.logoutReturnToUrl ?: requestUri
        def casLogoutUrl = attrs.casLogoutUrl ?: casLogoutUrl

        // TODO should this be attrs.logoutReturnToUrl?
        if (!attrs.loginReturnToUrl && request.queryString) {
            logoutReturnToUrl += "?" + URLEncoder.encode(request.queryString, "UTF-8")
        }

        if (isLoggedIn(attrs)) {
            return "<a href='${logoutUrl}" +
                    "?casUrl=${casLogoutUrl}" +
                    "&appUrl=${logoutReturnToUrl}' " +
                    "class='${attrs.cssClass}'>Logout</a>"
        } else {
            // currently logged out
            return "<a href='${buildLoginLink(attrs)}' class='${attrs.cssClass}'>Log in</a>"
        }
    }

    /**
     * Builds the login or logout link based on current login status.
     * @param attrs any specified params to override defaults
     * @return
     */
    String buildLoginoutLinkV2(attrs) {
        def requestUri = removeContext(grailServerURL) + request.forwardURI
        def logoutUrl = attrs.logoutUrl ?: grailServerURL + "/session/logout"
        def logoutReturnToUrl = attrs.logoutReturnToUrl ?: requestUri
        def casLogoutUrl = attrs.casLogoutUrl ?: casLogoutUrl

        // TODO should this be attrs.logoutReturnToUrl?
        if (!attrs.loginReturnToUrl && request.queryString) {
            logoutReturnToUrl += "?" + URLEncoder.encode(request.queryString, "UTF-8")
        }

        if (isLoggedIn(attrs)) {
            return "<a href='${logoutUrl}" +
                    "?casUrl=${casLogoutUrl}" +
                    "&appUrl=${logoutReturnToUrl}' " +
                    "class='btn btn-outline-white btn-sm'>Logout</a>"
        } else {
            // currently logged out
            return "<a href='${buildLoginLink(attrs)}' class='btn btn-primary btn-sm'>Login</a>"
        }
    }

    /**
     * Build the login link
     * @param attrs any specified params to override defaults
     * @return The login url
     */
    String buildLoginLink(attrs) {
        def casLoginUrl = attrs.casLoginUrl ?: casLoginUrl
        def loginReturnToUrl = attrs.loginReturnToUrl ?: (removeContext(grailServerURL) + request.forwardURI + (request.queryString ? "?" + URLEncoder.encode(request.queryString, "UTF-8") : ""))
        String loginUrl = "${casLoginUrl}?service=${loginReturnToUrl}"
        return loginUrl
    }

    /**
     * Build the logout link
     * @param attrs any specified params to override defaults
     * @return The logout url
     */
    String buildLogoutLink(attrs) {
        def requestUri = removeContext(grailServerURL) + request.forwardURI
        def logoutUrl = attrs.logoutUrl ?: grailServerURL + "/session/logout"
        def logoutReturnToUrl = attrs.logoutReturnToUrl ?: requestUri
        String url = "${logoutUrl}?casUrl=${casLogoutUrl}&appUrl=${logoutReturnToUrl}"
        return url
    }

    /**
     * Remove the context path and params from the url.
     * @param urlString
     * @return
     */
    private String removeContext(urlString) {
        def url = urlString.toURL()
        def protocol = url.protocol != -1 ? url.protocol + "://" : ""
        def port = url.port != -1 ? ":" + url.port : ""
        return protocol + url.host + port
    }

    /*
     * This g:paginate tag fix is based on:
     * https://github.com/grails/grails-core/blob/master/grails-plugin-gsp/src/main/groovy/org/codehaus/groovy/grails/plugins/web/taglib/RenderTagLib.groovy
     *
     * It has been moved into the hf taglib as the g.paginate override isn't working in Grails 3.2.11
     */

    /**
     * Creates next/previous links to support pagination for the current controller.<br/>
     *
     * &lt;g:paginate total="${Account.count()}" /&gt;<br/>
     *
     * @emptyTag
     *
     * @attr total REQUIRED The total number of results to paginate
     * @attr action the name of the action to use in the link, if not specified the default action will be linked
     * @attr controller the name of the controller to use in the link, if not specified the current controller will be linked
     * @attr id The id to use in the link
     * @attr params A map containing request parameters
     * @attr prev The text to display for the previous link (defaults to "Previous" as defined by default.paginate.prev property in I18n messages.properties)
     * @attr next The text to display for the next link (defaults to "Next" as defined by default.paginate.next property in I18n messages.properties)
     * @attr max The number of records displayed per page (defaults to 10). Used ONLY if params.max is empty
     * @attr maxsteps The number of steps displayed for pagination (defaults to 10). Used ONLY if params.maxsteps is empty
     * @attr offset Used only if params.offset is empty
     * @attr fragment The link fragment (often called anchor tag) to use
     */
    Closure paginate = { Map attrsMap ->
        TypeConvertingMap attrs = (TypeConvertingMap)attrsMap

        def writer = out
        if (attrs.total == null) {
            throwTagError("Tag [paginate] is missing required attribute [total]")
        }
        def messageSource = grailsAttributes.messageSource
        def locale = RequestContextUtils.getLocale(request)

        def total = attrs.int('total') ?: 0
        def action = (attrs.action ? attrs.action : (params.action ? params.action : "index"))
        def offset = params.int('offset') ?: 0
        def max = params.int('max')
        def maxsteps = (attrs.int('maxsteps') ?: 10)

        if (!offset) offset = (attrs.int('offset') ?: 0)
        if (!max) max = (attrs.int('max') ?: 10)

        def linkParams = [:]
        if (attrs.params) linkParams.putAll(attrs.params)
        linkParams.offset = offset - max
        linkParams.max = max
        if (params.sort) linkParams.sort = params.sort
        if (params.order) linkParams.order = params.order

        def linkTagAttrs = [action: action]
        if (attrs.namespace) {
            linkTagAttrs.namespace = attrs.namespace
        }
        if (attrs.controller) {
            linkTagAttrs.controller = attrs.controller
        }
        if (attrs.id != null) {
            linkTagAttrs.id = attrs.id
        }
        if (attrs.fragment != null) {
            linkTagAttrs.fragment = attrs.fragment
        }
        //add the mapping attribute if present
        if (attrs.mapping) {
            linkTagAttrs.mapping = attrs.mapping
        }

        linkTagAttrs.params = linkParams

        def cssClasses = "pagination"
        if (attrs.class) {
            cssClasses = "pagination " + attrs.class
        }

        // determine paging variables
        def steps = maxsteps > 0
        int currentstep = (offset / max) + 1
        int firststep = 1
        int laststep = Math.round(Math.ceil(total / max))

        writer << "<nav aria-label=\"Page navigation\">"
        writer << "<ul class=\"${cssClasses}\">"
        // display previous link when not on firststep
        if (currentstep > firststep) {
            linkParams.offset = offset - max
            writer << '<li>'
            writer << link(linkTagAttrs.clone()) {
                (attrs.prev ?: messageSource.getMessage('paginate.prev', null, '&laquo;', locale))
            }
            writer << '</li>'
        } else {
            writer << '<li class="disabled">'
            writer << '<span>'
            writer << (attrs.prev ?: messageSource.getMessage('paginate.prev', null, '&laquo;', locale))
            writer << '</span>'
            writer << '</li>'
        }

        // display steps when steps are enabled and laststep is not firststep
        if (steps && laststep > firststep) {
            linkTagAttrs.class = 'step'

            // determine begin and endstep paging variables
            int beginstep = currentstep - Math.round(maxsteps / 2) + (maxsteps % 2)
            int endstep = currentstep + Math.round(maxsteps / 2) - 1

            if (beginstep < firststep) {
                beginstep = firststep
                endstep = maxsteps
            }
            if (endstep > laststep) {
                beginstep = laststep - maxsteps + 1
                if (beginstep < firststep) {
                    beginstep = firststep
                }
                endstep = laststep
            }

            // display firststep link when beginstep is not firststep
            if (beginstep > firststep) {
                linkParams.offset = 0
                writer << '<li>'
                writer << link(linkTagAttrs.clone()) { firststep.toString() }
                writer << '</li>'
                writer << '<li class="disabled"><span>...</span></li>'
            }

            // display paginate steps
            (beginstep..endstep).each { i ->
                if (currentstep == i) {
                    writer << "<li class=\"active\">"
                    writer << "<span>${i}</span>"
                    writer << "</li>";
                } else {
                    linkParams.offset = (i - 1) * max
                    writer << "<li>";
                    writer << link(linkTagAttrs.clone()) { i.toString() }
                    writer << "</li>";
                }
            }

            // display laststep link when endstep is not laststep
            if (endstep < laststep) {
                writer << '<li class="disabled"><span>...</span></li>'
                linkParams.offset = (laststep - 1) * max
                writer << '<li>'
                writer << link(linkTagAttrs.clone()) { laststep.toString() }
                writer << '</li>'
            }
        }

        // display next link when not on laststep
        if (currentstep < laststep) {
            linkParams.offset = offset + max
            writer << '<li>'
            writer << link(linkTagAttrs.clone()) {
                (attrs.next ? attrs.next : messageSource.getMessage('paginate.next', null, '&raquo;', locale))
            }
            writer << '</li>'
        } else {
            linkParams.offset = offset + max
            writer << '<li class="disabled">'
            writer << '<span>'
            writer << (attrs.next ? attrs.next : messageSource.getMessage('paginate.next', null, '&raquo;', locale))
            writer << '</span>'
            writer << '</li>'
        }

        writer << '</ul>'
        writer << '</nav>'
    }
}