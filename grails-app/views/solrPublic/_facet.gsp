<%@ page import="org.apache.solr.client.solrj.response.FacetField" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
    <g:if test="${myFacet.getValues() != null && myFacet.getValues().size() > 0}">
        <div class="panel" id="familySection">
            <div class="panel-heading">
                <g:set var="facetDisplay" value="${message(code: 'facet.'+myFacet.getName()+'.display', args:[])}"></g:set>
                <h4 onclick="expandFacet('${myFacet.getName()}')">
                    <i class="fa fa-list"></i>
                    <a class="FieldName link">
                        <span>
                            ${facetDisplay != null && facetDisplay.size()>0 ? facetDisplay : myFacet.getName()}
                        </span>
                        <span class="pull-right">
                            <i id="${myFacet.getName()}+"  class="fa fa-plus-circle"></i>
                        </span>
                        <span class="pull-right">
                            <i id="${myFacet.getName()}-" class="fa fa-minus-circle" style="display: none;"></i>
                        </span>
                    </a>
                </h4>
            </div>
            <ul class="list-group" id="${myFacet.getName()}" style="display: none;">
                <g:each status="i" in="${myFacet.getValues()}" var="facetEntry">
                    <li class="list-group-item" >
                        <button type="submit" class="btn-link" onclick="injectHiddenField('newfq', '${myFacet.getName()+":\""+facetEntry.getName()+"\""}')">
                            ${facetEntry.getName() + " (" + facetEntry.getCount()+")"}
                        </button>
                    </li>
                </g:each>
            </ul>
        </div>
    </g:if>
</body>
</html>