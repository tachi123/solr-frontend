<%@ page import="grails.converters.JSON; org.apache.solr.client.solrj.response.FacetField" contentType="text/html;charset=UTF-8" %>
<li class="list-group-item" >
    <button type="submit" class="btn-link btn-personalizado" onclick="injectHiddenField('newfq', '${facetName+":\""+facetItem.getName()+"\""}')">
        ${facetItem.getName() + " (" + facetItem.getCount()+")"}
    </button>
</li>