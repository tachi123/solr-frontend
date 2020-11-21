<%@ page import="solrinterface.Item" contentType="text/html;charset=UTF-8" %>
<g:javascript library="jquery"/>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <g:set var="titleType" value=" ${message(code: 'section.ALL.display',args: [])}"/>
        <g:set var="descriptionType" value="${this.q != null && this.q.size() > 0 ? message(code: 'section.search.terminoBuscado',args: [this.q]) : ''}"/>
        <g:set var="urlImgSection" value="${evaluate('grailsApplication.config.section.DEFAULT.urlImg')}"></g:set>
        <g:set var="color" value="${evaluate('grailsApplication.config.section.DEFAULT.color')}"></g:set>

        <g:render template="searchBox"
                  model="[color: color,urlImg:urlImgSection,title:titleType, description: descriptionType, displayActive: titleType]"/>
        <br/>

%{--        <div class="container">
            <div class="row">
                <g:each status="i" in="${facets[0].getValues()}" var="facetType">
                    <g:render template="typeBox"  var="typeDoc" collection="${facetType}"/>
                </g:each>
            </div>
        </div>--}%
    </body>
</html>
