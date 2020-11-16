<%@ page import="solrinterface.Item;" contentType="text/html;charset=UTF-8" %>
<g:javascript library="jquery"/>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <g:set var="titleType" value=" ${message(code: 'skin.coreDisplay',args: [])}"/>
        <g:set var="descriptionType" value="${this.q != null && this.q.size() > 0 ? message(code: 'section.search.terminoBuscado',args: [this.q]) : ''}"/>
        <g:set var="urlImgSection" value="${evaluate('grailsApplication.config.section.DEFAULT.urlImg')}"></g:set>
        <g:set var="colorClass" value="${evaluate('grailsApplication.config.section.DEFAULT.color')}"></g:set>
        <g:render template="searchBox"
                  model="[colorClass: colorClass,urlImg:urlImgSection,title:titleType, description: descriptionType, displayActive: titleType]"/>
    <div class="container" role="main">
        <div class="row">
            <g:form name="searchForm" action="search" controller="solrPublic">
                <g:hiddenField name="q" value="${this.q}"></g:hiddenField>
                <g:hiddenField name="type" value="${this.type}"></g:hiddenField>
                <g:hiddenField name="rows" value="${this.rows}"></g:hiddenField>
                <g:hiddenField name="sort" value="${this.sort}"></g:hiddenField>
                <g:hiddenField name="typeItem" value="${this.typeItem}"></g:hiddenField>
                <g:hiddenField name="fqstring" value="${this.fqstring}"></g:hiddenField>
                <%def pageCant=Math.round(Math.floor(this.numFound/this.rows)+1) %>
                <%def pageActual=Math.round(Math.floor(1+this.start/this.rows)) %>

%{--                <g:set var="cantPages" value="this.rows"/>--}%
                <div class="col-md-3">
                    <h4 class="text-primary">${this.q}</h4>
                    <p><g:message code="section.search.numFound" args="[this.numFound]"/></p>
                    <g:if test="${this.fq != null && this.fq.size() > 0}">
              %{--          <h4><g:message code="section.search.facetSelected" args="[]"/></h4>--}%
                        <g:render template="facetSelected"  var="facetSelected" collection="${this.fq}"/>
                    </g:if>
                    <br/>
                    <div>
                        <g:render template="facet"  var="myFacet" collection="${this.facets}"/>
                    </div>
                </div>
                <div class="col-md-9">
                    <div class="row">
                        <div class="col-md-6 col-sm-12">
                            <div class="btn-group">
                                <button type="button" class="btn-link dropdown-toggle" data-toggle="dropdown">
                                    Ordenar por <span class="glyphicon glyphicon-triangle-bottom" aria-hidden="true"></span>
                                </button>
                                <ul class="dropdown-menu" style="min-width: 0">
                                    <g:each var="sortField" in="${grails.converters.JSON.parse(grailsApplication.config.solr.sorts)}">
                                        <li>
                                            <button type="submit" class="btn-link" onclick="injectHiddenField('sort', '${sortField.value}')">
                                                <a>${sortField.display}</a>
                                            </button>
                                        </li>
                                    </g:each>
                                </ul>
                            </div>
                            |
                            <div class="btn-group">
                                <button type="button" class="btn-link dropdown-toggle" data-toggle="dropdown">
                                    <span class="glyphicon glyphicon-list" aria-hidden="true"></span>
                                </button>
                                <ul class="dropdown-menu" style="min-width: 0">
                                    <g:each var="rowField" in="${grails.converters.JSON.parse(grailsApplication.config.solr.rows)}">
                                        <li>
                                            <button type="submit" class="btn-link" onclick="injectHiddenField('rows', '${rowField.value}');injectHiddenField('typeItem', 'list')">
                                                <a>${rowField.display}</a>
                                            </button>
                                        </li>
                                    </g:each>
                                </ul>
                            </div>
                            <div class="btn-group">
                                <button type="button" class="btn-link dropdown-toggle" data-toggle="dropdown">
                                    <span class="glyphicon glyphicon-th-large" aria-hidden="true"></span>
                                </button>
                                <ul class="dropdown-menu" style="min-width: 0">
                                    <g:each var="rowField" in="${grails.converters.JSON.parse(grailsApplication.config.solr.rows)}">
                                        <li>
                                            <button type="submit" class="btn-link" onclick="injectHiddenField('rows', '${rowField.value}');injectHiddenField('typeItem', 'blocks')">
                                                <a>${rowField.display}</a>
                                            </button>
                                        </li>
                                    </g:each>
                                </ul>
                            </div>
                        </div>
                        <div class="col-md-6 col-sm-12 text-right">
                            <g:render template="pagination"  model="[pageCant:pageCant,pageActual:pageActual,cant:3]"/>
                        </div>
                    </div>
                    <br/>
                    <g:render template="item"  var="myItem" collection="${this.items}"/>

                    <div class="text-center">
                        <g:render template="pagination"  model="[pageCant:pageCant,pageActual:pageActual]"/>
                    </div>
                </div>
            </g:form>
        </div>
    </div>
    <g:javascript library="jquery">
        function injectHiddenField(name, value) {
            var control = $("input[type=hidden][name='" + name + "']");
            if (control.size() == 0) {
                console.log(name + " not found; adding...");
                control = $("<input type=\"hidden\" id=\"" + name + "\" name=\"" + name + "\">");
                $("form").append(control);
            }
            control.val(value);
        }
    </g:javascript>
    </body>
</html>
