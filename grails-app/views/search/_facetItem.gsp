<%@ page import="grails.converters.JSON; org.apache.solr.client.solrj.response.FacetField" contentType="text/html;charset=UTF-8" %>
<g:set var="nameCode" value="${message(code: 'facet.'+facetName+'.'+facetItem.getName().replaceAll(' ', '').toUpperCase())}"/>
<li class="list-group-item">
    <button type="submit" class="btn-link btn-personalizado text-left" onclick="injectHiddenField('newfq', '${facetName+":\""+facetItem.getName()+"\""}')">
        ${nameCode != 'facet.'+facetName+'.'+facetItem.getName().replaceAll(' ', '').toUpperCase() ? nameCode : facetItem.getName()}${" (" + facetItem.getCount()+")"}
    </button>
</li>