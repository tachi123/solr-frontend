<%@ page import="solrinterface.DocSolrType;" contentType="text/html;charset=UTF-8" %>
<g:if test="${grailsApplication.config.search.sections.enabled.contains(solrinterface.DocSolrType.getById(Integer.parseInt(typeDoc.getName())).getKey())}">
    <div class="col-xs-12 col-sm-4 col-md-4">
        <g:link controller="search" action="results" params="[type:typeDoc.getName(), q:this.q]" class="panel panel-default">
            <div class="panel-body" style="min-height: 8.5em;">
                <div class="media">
                    <div class="media-body">
                        <h1>
                            ${typeDoc.getCount()}
                        </h1>
                        <div class="text-muted">
                            <h3>
                                <g:message code="solrinterface.DocSolrType.${solrinterface.DocSolrType.getById(Integer.parseInt(typeDoc.getName())).getKey()}"/>
                            </h3>
                        </div>
                    </div>
                    <div class="media-right padding-5">
                        <g:if test="${grailsApplication.config.section.ICON.type == 'ICON'}">
                            <g:set var="icon" value="${evaluate('grailsApplication.config.section.'+solrinterface.DocSolrType.getById(Integer.parseInt(typeDoc.getName())).getKey()+'.icon')}"></g:set>
                            <g:set var="colorClass" value="${evaluate('grailsApplication.config.section.'+solrinterface.DocSolrType.getById(Integer.parseInt(typeDoc.getName())).getKey()+'.color')}"></g:set>
                            <i id="${icon}" style="font-size: 4em !important;" class="icono-4x ${icon != null && icon.size() > 0 ? icon : grailsApplication.config.section.DEFAULT.icon} ${colorClass != null && colorClass.length()>0 ? 'text-'+colorClass : 'text-gray'}" data-clipboard-text="${icon}"></i>
                        </g:if>
                        <g:if test="${grailsApplication.config.section.ICON.type == 'PNG'}">
                            <g:set var="urlImgSection" value="${evaluate('grailsApplication.config.section.'+solrinterface.DocSolrType.getById(Integer.parseInt(typeDoc.getName())).getKey()+'.urlImg')}"></g:set>
                            <g:img dir="images" file="${urlImgSection != null && urlImgSection.size() > 0 ? urlImgSection : grailsApplication.config.section.DEFAULT.urlImg}" width="inherit" height="100px"/>
                        </g:if>
                    </div>
                </div>
            </div>
        </g:link>
    </div>
</g:if>