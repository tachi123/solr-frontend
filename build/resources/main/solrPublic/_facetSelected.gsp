<%@ page import="solrinterface.Item;solrinterface.DocSolrType" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
    <ul class="list-group">
        <li class="list-group-item" >
            <button type="submit" class="btn-link" onclick="injectHiddenField('delfq', '${facetSelected}')">
                <span>
                    <g:message code="facet.${facetSelected.split(':')[0]}.display" args="[]"/>: ${facetSelected.split(':')[1]}
                </span>
                <span class="pull-right">
                    <i class="fa fa-times-circle"></i>
                </span>
            </button>
        </li>
    </ul>
</body>
</html>