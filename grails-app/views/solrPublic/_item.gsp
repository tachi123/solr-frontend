<%@ page import="solrinterface.Item;solrinterface.DocSolrType" contentType="text/html;charset=UTF-8" %>

<g:set var="href" value="${myItem.django_id != null ? grailsApplication.config.external.link.exactas + solrinterface.DocSolrType.getById(Integer.parseInt(myItem.getType())).getKey().toLowerCase()+'/'+myItem.django_id : '/estatica/'+myItem.id.replace('.','/')}"></g:set>

<g:if test="${typeItem == 'blocks'}">
    <div class="col-xs-12 col-sm-6 col-md-4">
        <a class="panel panel-default"  href="${href}">
            <div class="panel-body" style="overflow: hidden">
                <p>
                    <span>${myItem.getName()}</span>
                </p>
                <p class="text-muted">
                    <g:if test="${myItem.marker_exact != null && myItem.marker_exact.size() > 0}">
                        <br/>
                        <strong>Marcador: </strong>${myItem.marker_exact}
                    </g:if>
                    <span class="text-warning" tabindex="0" data-toggle="tooltip" title="Validaci&oacute;n pendiente">
                        <span class="glyphicon glyphicon-alert" aria-hidden="true"></span>
                    </span>
                    <span class="text-primary pull-right">
                        Ver <i id="fa fa-sign-in" class="fa fa-sign-in icono-4x" data-clipboard-text="fa-sign-in"></i>
                    </span>
                </p>
            </div>
        </a>
    </div>
</g:if>
<g:else>
    <a class="panel panel-default"  href="${href}">
        <div class="panel-body" style="padding-top: 0px;padding-bottom: 0px;">
                <h3 style="margin: 0px;">
            ${myItem.getName()}
            <g:if test="${myItem.getStatus() == null || myItem.getStatus() == 0}">
                <span class="d-inline-block text-warning" tabindex="0" data-toggle="tooltip" title="Validaci&oacute;n pendiente">
                    <span class="glyphicon glyphicon-alert" aria-hidden="true"></span>
                </span>
            </g:if>
            <g:else test="${myItem.getStatus() == 'Validado institucionalmente'}">
                <span class="d-inline-block text-success" tabindex="0" data-toggle="tooltip" title="Validado institucionalmente">
                    <span class="glyphicon glyphicon-check" aria-hidden="true"></span>
                </span>
            </g:else>
            %{--                <span class="d-inline-block text-primary" tabindex="0" data-toggle="tooltip" title="Dato validado por el usuario">
                            <span class="glyphicon glyphicon-ok-sign" aria-hidden="true"></span>
                        </span>
                        --}%
        </h3>
            <p class="text-muted">
            %{--            <strong>Id: </strong>${myItem.getId()}--}%
                <g:if test="${myItem.bold_org_exact != null && myItem.bold_org_exact.size() > 0}">
                %{--                <br/>--}%
                    <strong>Organización: </strong>${myItem.bold_org_exact}
                </g:if>
                <g:if test="${myItem.taxon_exact != null && myItem.taxon_exact.size() > 0}">
                    <br/>
                    <strong>Taxón: </strong>${myItem.taxon_exact[0]}
                </g:if>
                <g:if test="${myItem.marker_exact != null && myItem.marker_exact.size() > 0}">
                    <br/>
                    <strong>Marcador: </strong>${myItem.marker_exact}
                </g:if>
                <g:if test="${myItem.subdivision_exact != null && myItem.subdivision_exact.size() > 0}">
                    <br/>
                    <strong>Lugar: </strong>${myItem.subdivision_exact}
                </g:if>
                <span class="text-primary pull-right">
                    Ver <i id="fa fa-sign-in" class="fa fa-sign-in icono-4x" data-clipboard-text="fa-sign-in"></i>
                </span>
            </p>
              </div>
    </a>
</g:else>