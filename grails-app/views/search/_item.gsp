<%@ page import="solrinterface.Item;" contentType="text/html;charset=UTF-8" %>
<%@ page import="java.text.Normalizer;" contentType="text/html;charset=UTF-8" %>
<%@ page import="java.text.Normalizer.Form" contentType="text/html;charset=UTF-8" %>

<g:set var="flagValue" value="${grailsApplication.config.skin.flag}"/>
<g:set var="href" value="${grailsApplication.config.item.externalView + myItem.getProperty(grailsApplication.config.item.identificador)}"></g:set>

<g:if test="${typeItem == 'blocks'}">
    <div class="col-xs-12 col-sm-6 col-md-4">
        <a class="panel panel-default panel-personalizado"  href="${href}">
            <div class="panel-body" style="overflow: hidden;height: 175px; border-radius: 4px;">
                <p>
                    <g:if test="${flagValue != null && myItem.getProperty(flagValue) != null}">
                        <asset:image src="${"banderas/"+ Normalizer.normalize(myItem.getProperty(flagValue), Normalizer.Form.NFKD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "").toUpperCase() +".PNG"}" style="height:1.3em;padding-left: 3px;"/>
                    </g:if>
                    <g:each var="fieldTitle" in="${grails.converters.JSON.parse(grailsApplication.config.skin.typeBox.title)}">
                        <g:if test="${fieldTitle.type == 'property'}">
                            ${myItem.getProperty(fieldTitle.value)}
                        </g:if>
                        <g:if test="${fieldTitle.type == 'string'}">
                            ${fieldTitle.value}
                        </g:if>
                    </g:each>
                </p>
                <p class="text-muted">
                    <g:each var="fieldVisible" in="${grailsApplication.config.skin.typeBox.otherFields.split(",")}">
                        <g:if test="${myItem.getProperty(fieldVisible) != null}">
                            <p><strong>${message(code: 'skin.typeBox.'+fieldVisible, args:[])}: </strong>${myItem.getProperty(fieldVisible).replace("[","").replace("]","")}</p>
                        </g:if>
                    </g:each>
                </p>
            </div>
        </a>
    </div>
</g:if>
<g:else>
    <a class="panel panel-default panel-personalizado"  href="${href}">
        <div class="panel-body" style="padding-bottom: 0px;">
            <h3 style="margin: 0px; display:inline-flex;">
                <g:each var="fieldTitle" in="${grails.converters.JSON.parse(grailsApplication.config.skin.listItem.title)}">
                    <g:if test="${fieldTitle.type == 'property'}">
                        ${myItem.getProperty(fieldTitle.value)}
                    </g:if>
                    <g:if test="${fieldTitle.type == 'string'}">
                        ${fieldTitle.value}
                    </g:if>
                </g:each>
                <g:if test="${flagValue != null && myItem.getProperty(flagValue) != null}">
                    <asset:image src="${"banderas/"+Normalizer.normalize(myItem.getProperty(flagValue), Normalizer.Form.NFKD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "").toUpperCase()+".PNG"}" style="height:1.3em;padding-left: 3px;"/>
                </g:if>
            </h3>
            <p class="text-muted">
                <g:each var="fieldVisible" in="${grailsApplication.config.skin.listItem.otherFields.split(",")}">
                    <g:if test="${myItem.getProperty(fieldVisible) != null}">
                        <p><strong>${message(code: 'skin.listItem.'+fieldVisible, args:[])}: </strong>${myItem.getProperty(fieldVisible).toString().replace("[","").replace("]","")}</p>
                    </g:if>
                </g:each>
                <span class="text-primary pull-right text-personalizado">
                    Ver <i id="fa fa-sign-in" class="fa fa-sign-in icono-4x" data-clipboard-text="fa-sign-in"></i>
                </span>
            </p>
         </div>
    </a>
</g:else>