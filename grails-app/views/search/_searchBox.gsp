<%@ page import="org.apache.solr.client.solrj.response.FacetField" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
    <header>
        <div class="panel-pane pane-imagen-destacada">
            <div class="pane-content">
                <section class="jumbotron" style="${backgroundImage != null && backgroundImage.length() > 0 ? "background-image: url('${resource(dir: "assets", file: backgroundImage )}')" : 'background-color: '+backgroundColor};">
                    <div class="jumbotron_bar">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-12">
                                    <ol class="breadcrumb pull-left">
                                        <g:each in="${grails.converters.JSON.parse(grailsApplication.config.banner.breadcrumb.path)}" var="path">
                                            <li><a href="${path.url}">${raw(path.display)}</a></li>
                                        </g:each>
                                        <li class="active"><span >${raw(displayActive != null ? displayActive : grailsApplication.config.banner.breadcrumb.activoDisplay)}</span></li>
                                    </ol>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="jumbotron_body">
                        <fieldset class="container">
                            <div class="row">
                                <div class="col-xs-12 col-md-8 col-md-offset-2 text-center">
                                    <g:if test="bannerImage">
                                        <g:img dir="assets" file="${bannerImage}"/>
                                    </g:if>
                                    <g:else>
                                        <h1>${raw(title != null ? title : grailsApplication.config.title)}</h1>
                                        <p>${raw(description != null ? description : grailsApplication.config.description)}</p>
                                    </g:else>
                                </div>
                            </div>
                            <g:if test="${buscadorEnabled != false}">
                                <div id="buscador" class="row">
                                    <g:form name="searchForm" action="results" controller="search">
                                        <div class="col-md-3">
                                            <g:if test="${(grailsApplication.config.solr.queryFieldsOptionsEnabled).equals("true")}">
%{--                                                noSelection="${['null':'Todos']}"
                                                </g:each>--}%
                                                <g:select name="queryField"
                                                          id="queryField"
                                                          from="${grails.converters.JSON.parse(grailsApplication.config.solr.queryFieldsOptions)}"
                                                          optionValue="display"
                                                          optionKey="value"
                                                          class="form-control"
                                                />
                                            </g:if>
                                        </div>
                                        <div class="col-md-7">
                                            <input placeholder="Buscar..." class="form-control form-text" type="text" id="q" name="q" value="" size="20" maxlength="255">
                                        </div>
                                        <div class="col-md-1">
                                            <button class="btn-primary btn form-control form-submit btn-primary-personalizado" type="submit" id="edit-submit" style="margin:0px; color: white; border: none;"><i class="fa fa-search"></i></button>
                                        </div>
                                    </g:form>
                                </div>
                            </g:if>
                        </fieldset>
                    </div>
                    <div class="overlay"></div>
                </section>
            </div>
        </div>
    </header>
</body>
</html>