<%@ page import="solrinterface.Item;solrinterface.DocSolrType" contentType="text/html;charset=UTF-8" %>
<g:javascript library="jquery"/>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <g:set var="titleType" value="${message(code: 'section.CENTROS.display',args: [])}"/>
        <g:set var="descriptionType" value="${message(code: 'section.CENTROS.description',args: [])}"/>
        <g:set var="urlImgSection" value="${evaluate('grailsApplication.config.section.ORGANIZATION.urlImg')}"></g:set>
        <g:set var="colorClass" value="${evaluate('grailsApplication.config.section.ORGANIZATION.color')}"></g:set>
        <g:render template="searchBox"
                  model="[colorClass: colorClass,urlImg:urlImgSection,title:titleType, description: descriptionType, displayActive: titleType, optionsVisible: false]"/>
    <div class="container" role="main">
        <div class="row">
            <g:form name="searchForm" action="searchCentros" controller="search">
                <g:hiddenField name="q" value="${this.q}"></g:hiddenField>
                <g:hiddenField name="type" value="${this.type}"></g:hiddenField>
                <g:hiddenField name="rows" value="${this.rows}"></g:hiddenField>
                <g:hiddenField name="sort" value="${this.sort}"></g:hiddenField>

                <%def pageCant=Math.round(Math.floor(this.numFound/this.rows)+1) %>
                <%def pageActual=Math.round(Math.floor(1+this.start/this.rows)) %>

                <div class="col-md-12">
                    <div class="text-center">
                        <g:render template="pagination"  model="[pageCant:pageCant,pageActual:pageActual]"/>
                    </div>
                    <br/>
                    <g:render template="item"  var="myItem" collection="${this.items}" typeItem="${this.typeItem}"/>
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
