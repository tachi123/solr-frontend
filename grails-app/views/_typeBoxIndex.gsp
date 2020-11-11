<g:set var="icon" value="${evaluate('grailsApplication.config.section.'+typeKey+'.icon')}"></g:set>
<g:set var="colorClass" value="${evaluate('grailsApplication.config.section.'+typeKey+'.color')}"></g:set>
<div class="col-xs-12 col-sm-6 col-md-3">
    <div style="display: block;text-align: center;">
        <i id="${icon}" style="min-height: 60px" class="icono-2x fa-2x ${icon != null && icon.size() > 0 ? icon : grailsApplication.config.section.DEFAULT.icon} ${colorClass != null && colorClass.length()>0 ? 'text-'+colorClass : 'text-gray'}" data-clipboard-text="${icon}"></i>
        <h3 id="${solrinterface.DocSolrType.getByKey(typeKey).getId()}Counter">--</h3>
        <p><g:message code="solrinterface.DocSolrType.${typeKey}"/></p>
    </div>
</div>
%{--<g:if test="${grailsApplication.config.section.ICON.type == 'PNG'}">
    <g:set var="urlImgSection" value="${evaluate('grailsApplication.config.section.'+typeKey+'.urlImg')}"></g:set>
    <g:img dir="images" file="${urlImgSection != null && urlImgSection.size() > 0 ? urlImgSection : grailsApplication.config.section.DEFAULT.urlImg}" width="inherit" height="100px"/>
</g:if>--}%