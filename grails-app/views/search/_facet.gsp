<%
    def replaceStringToCompare = { it ->
        it = it.replaceAll('Á', '&accute;').replaceAll('Í', '&iccute;').replaceAll('É', '&eccute;').replaceAll('Ó', '&occute;').replaceAll('Ú', '&uccute;')
        return it.toUpperCase().replaceAll('Ñ', '&ntilde;')
    }
%>
<%@ page import="java.text.Normalizer; grails.converters.JSON; org.apache.solr.client.solrj.response.FacetField" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
    <g:set var="facetsProperties" value="${grails.converters.JSON.parse(grailsApplication.config.solr.facetsProperties)}"></g:set>
    <g:if test="${myFacet.getValues() != null && myFacet.getValues().size() > 0}">
        <div class="panel" id="familySection">
            <div class="panel-heading">
                <g:set var="facetDisplay" value="${message(code: 'facet.'+myFacet.getName()+'.display', args:[])}"></g:set>
                <h4 onclick="expandFacet('${myFacet.getName()}')">
                    <i class="fa fa-list text-personalizado-secundario"></i>
                    <a class="FieldName link">
                        <span>
                            ${facetDisplay != null && facetDisplay.size()>0 ? facetDisplay : myFacet.getName()}
                        </span>
                        <span class="pull-right text-personalizado">
                            <i id="${myFacet.getName()}+"  class="fa fa-plus-circle"></i>
                        </span>
                        <span class="pull-right text-personalizado">
                            <i id="${myFacet.getName()}-" class="fa fa-minus-circle" style="display: none;"></i>
                        </span>
                    </a>
                </h4>
            </div>
            <ul class="list-group" id="${myFacet.getName()}" style="display: none;">
                <g:if test="${facetsProperties[myFacet.getName()] != null}">
                    <g:if test="${facetsProperties[myFacet.getName()].sort}">

                        <g:set var="facetSortFirstName" value="${facetsProperties[myFacet.getName()].get('sort.first')}"/>
                        <g:set var="facetSortLastName" value="${facetsProperties[myFacet.getName()].get('sort.last')}"/>
                        <g:set var="facetItemsBody" value="${facetsProperties[myFacet.getName()].get('sort.body')}"/>

                        <g:if test="${facetSortFirstName.length() > 0}">
                            <g:each status="i" in="${myFacet.getValues()}" var="facetEntry">
                                <g:set var="facetItemName" value="${replaceStringToCompare(facetEntry.getName())}"/>
                                <g:if test="${facetItemName.equalsIgnoreCase(facetSortFirstName)}">
                                    <g:render template="facetItem"  model="[facetName: myFacet.getName(),facetItem: facetEntry]"/>
                                </g:if>
                            </g:each>
                        </g:if>

                        <g:if test="${facetItemsBody.size() > 0}">
                            <g:if test="${!facetItemsBody[0].equals("ASC") && !facetItemsBody[0].equals("DESC")}">
                                <g:each status="v" in="${facetItemsBody}" var="itemBody">
                                    <g:each status="i" in="${myFacet.getValues()}" var="facetEntry">
                                        <g:set var="facetItemName" value="${replaceStringToCompare(facetEntry.getName())}"/>
                                        <g:if test="${facetItemName.equalsIgnoreCase(itemBody) }">
                                            <g:render template="facetItem"  model="[facetName: myFacet.getName(),facetItem: facetEntry]"/>
                                        </g:if>
                                    </g:each>
                                </g:each>
                            </g:if>
                            <g:else>
                                <g:if test="${facetItemsBody[0].equals("DESC")}">
                                    <g:each status="i" in="${myFacet.getValues().sort{it.getName()}.reverse()}" var="facetEntry">
                                        <g:set var="facetItemName" value="${replaceStringToCompare(facetEntry.getName())}"/>
                                        <g:if test="${!facetItemName.equalsIgnoreCase(facetSortFirstName) && !facetItemName.equalsIgnoreCase(facetSortLastName)}">
                                            <g:render template="facetItem"  model="[facetName: myFacet.getName(),facetItem: facetEntry]"/>
                                        </g:if>
                                    </g:each>
                                </g:if>
                                <g:else>
                                    <g:each status="i" in="${myFacet.getValues().sort { it.getName() }}" var="facetEntry">
                                        <g:set var="facetItemName" value="${replaceStringToCompare(facetEntry.getName())}"/>
                                        <g:if test="${!facetItemName.equalsIgnoreCase(facetSortFirstName) && !facetItemName.equalsIgnoreCase(facetSortLastName)}">
                                            <g:render template="facetItem"  model="[facetName: myFacet.getName(),facetItem: facetEntry]"/>
                                        </g:if>
                                    </g:each>
                                </g:else>
                            </g:else>
                        </g:if>
                        <g:else>
                            <g:each status="i" in="${myFacet.getValues()}" var="facetEntry">
                                <g:set var="facetItemName" value="${replaceStringToCompare(facetEntry.getName())}"/>
                                    <g:if test="${!facetItemName.equalsIgnoreCase(facetSortFirstName) && !facetItemName.equalsIgnoreCase(facetSortLastName)}">
                                        <g:render template="facetItem"  model="[facetName: myFacet.getName(),facetItem: facetEntry]"/>
                                    </g:if>
                            </g:each>
                        </g:else>

                        <g:if test="${facetSortLastName.length() > 0}">
                            <g:each status="i" in="${myFacet.getValues()}" var="facetEntry">
                                <g:set var="facetItemName" value="${replaceStringToCompare(facetEntry.getName())}"/>
                                <g:if test="${facetItemName.equalsIgnoreCase(facetSortLastName)}">
                                    <g:render template="facetItem"  model="[facetName: myFacet.getName(),facetItem: facetEntry]"/>
                                </g:if>
                            </g:each>
                        </g:if>
                    </g:if>
                    <g:else>
                        <g:each status="i" in="${myFacet.getValues()}" var="facetEntry">
                            <g:render template="facetItem"  model="[facetName: myFacet.getName(),facetItem: facetEntry]"/>
                        </g:each>
                    </g:else>
                </g:if>
                <g:else>
                    <g:each status="i" in="${myFacet.getValues()}" var="facetEntry">
                        <g:render template="facetItem"  model="[facetName: myFacet.getName(),facetItem: facetEntry]"/>
                    </g:each>
                </g:else>
            </ul>
        </div>
    </g:if>
</body>
</html>