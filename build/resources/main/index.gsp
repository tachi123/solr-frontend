<%@ page import="solrinterface.SearchController; solrinterface.DocSolrType;" contentType="text/html;charset=UTF-8" %>
<g:javascript library="jquery"/>
<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Busc.AR</title>

    <!-- Global site tag (gtag.js) - Google Analytics -->
    <script async src="https://www.googletagmanager.com/gtag/js?id=UA-77715961-6"></script>
    <script>
        window.dataLayer = window.dataLayer || [];
        function gtag(){dataLayer.push(arguments);}
        gtag('js', new Date());

        gtag('config', ${grailsApplication.config.googleAnalitycsCode});
    </script>
</head>
<body>

    <g:set var="titleType" value=" ${message(code: 'skin.coreDisplay',args: [])}"/>
    <g:set var="descriptionType" value=" ${message(code: 'skin.description',args: [])}"/>
    <g:set var="backgroundImage" value="${evaluate('grailsApplication.config.banner.background.urlImage')}"/>
    <g:set var="backgroundColor" value="${evaluate('grailsApplication.config.banner.background.color')}"/>
    <g:set var="bannerImage" value="${evaluate('grailsApplication.config.banner.image')}"/>
    <g:set var="counter" value="${new solrinterface.SearchController().getNumfound()}" />
    <g:render template="search/searchBox"
              model="[bannerImage: bannerImage,backgroundColor: backgroundColor,backgroundImage:backgroundImage,title:titleType, description: descriptionType, displayActive: titleType]"/>

    <main role="main">
        <section class="bg-gray">
            <div class="container">
                <div class="panel-separator"></div>
                    <div class="row numbers">
                        <div class="col-md-4 col-md-offset-4">
                            <div class="h2 text-success">${counter}</div>
                            <p class="lead">Personas registradas en raíces</p>
%{--                            <p class="text-muted">+11,06% vs mes anterior</p>--}%
                        </div>
                    </div>
                    <div class="panel-separator"></div>
                </div>
            </div>
        </section>
        <section>
            <div class="container">
                <h4>También te puede interesar...</h4>

                <div class="row panels-row">
                    <g:each in="${grails.converters.JSON.parse(grailsApplication.config.otras.app)}" var="path">
                        <div class="col-xs-12 col-sm-6 col-md-6">
                            <a class="panel panel-default" href="${path.url}">
                                <div class="panel-body">
                                    <h3>${raw(path.display)}</h3>
                                </div>
                            </a>
                        </div>
                    </g:each>
                </div>

            </div>
        </section>
        <section class="bg-gray modulo-contacto">
            <div class="container">
                <div class="pane-content">
                    <h2 class="h3 section-title"><g:message code="section.index.contacto" args="[]"/></h2>
                    <p class="margin-40">
                        <strong><g:message code="section.index.direccion" args="[]"/></strong>${raw(grailsApplication.config.contacto.direccion)}
                        <br>
                        <strong><g:message code="section.index.cp" args="[]"/></strong> ${raw(grailsApplication.config.contacto.cp)}
                        <br>
                        <strong><g:message code="section.index.telefono" args="[]"/></strong> ${raw(grailsApplication.config.contacto.tel)}
                        <br>
                        <strong><g:message code="section.index.mail" args="[]"/></strong>
                        <a href="mailto:sact@mincyt.gob.ar">${grailsApplication.config.contacto.mail}</a>
                    </p>
                    <h5>Redes sociales del área</h5>
                    <div class="social-share">
                        <ul class="list-inline">
                            <li><a href="http://www.facebook.com/CienciayTecnologiaAR"><i class="fab fa-facebook"></i></a></li>
                            <li><a href="http://www.twitter.com/ciencia_ar"><i class="fab fa-twitter "></i></a></li>
                            <li><a href="http://www.instagram.com/cienciaytecnologiaar"><i class="fab fa-instagram"></i></a></li>
                            <li><a href="http://www.youtube.com/user/MinisterioDeCiencia"><i class="fab fa-youtube"></i></a></li>
                            <li><a href="http://www.flickr.com/ministeriodeciencia"><i class="fab fa-flickr"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </section>
    </main>

</body>
</html>

%{--

<g:javascript library='jquery'>

    $(document).ready(function () {
        getFacets()
    })
    function getFacets() {
        return $.get("${grailsApplication.config.solr.url}/query",
                {
                    'q': '*:*',
                    'fl': 'numFound',
                    'facet': true,
                    'rows': 0,
                    'start': 0,
                    'cache':false
                },
                function(data, status){
                        var dataJson = JSON.parse(data);
                        var element = document.getElementById("counter");
                        if(element != null) element.innerText = dataJson.response.numFound;
                });
    }
</g:javascript>

      <g:render template="search/searchBox"/>

      <section class="bg-gray section-sm">
             <div class="container">
                 <div class="row m-y-4">
                     <g:render template="typeBoxIndex" var="typeKey" collection="${grailsApplication.config.search.sections.enabled.split('\\|')}"/>
                 </div>
             </div>
         </section>
        <section>
             <div class="container">
                 <div class="panel-separator"></div>
                 <div class="panel-pane pane-atajos">
                     <div class="pane-content">
                         <div class="row panels-row">
                             <g:if test="${grailsApplication.config.index.sections.enabled.contains('CENTROS')}">
                                 <div class="col-xs-12 col-sm-4 col-md-4">
                                     <g:link controller="search" action="searchCentros" class="panel panel-default">
                                         <g:set var="urlImgSection" value="${grailsApplication.config.section.CENTROS.urlImg}"></g:set>
                                         <div style="background-image:url('${resource(dir: 'images', file: urlImgSection)}');" class="panel-heading"></div>
                                         <div class="panel-body">
                                             <h4>${message(code: "section.CENTROS.display", args: [])}</h4>
                                             <div class="text-muted">
                                                 <p>${message(code: "section.CENTROS.description", args: [])}</p>
                                             </div>
                                         </div>
                                     </g:link>
                                 </div>
                             </g:if>
                             <g:if test="${grailsApplication.config.index.sections.enabled.contains('TOOL')}">
                                 <div class="col-xs-12 col-sm-4 col-md-4">
                                     <g:link controller="search" action="search" params="[type:10]" class="panel panel-default">
                                         <g:set var="urlImgSection" value="${grailsApplication.config.section.TOOL.urlImg}"></g:set>
                                         <div style="background-image:url('${resource(dir: 'images', file: urlImgSection)}');" class="panel-heading"></div>
                                         <div class="panel-body">
                                             <h4>${message(code: "section.TOOL.display", args: [])}</h4>
                                             <div class="text-muted">
                                                 <p>${message(code: "section.TOOL.description", args: [])}</p>
                                             </div>
                                         </div>
                                     </g:link>
                                 </div>
                             </g:if>
                         </div>
                     </div>
                 </div>
             </div>
         </section>
         <hr>
         <section>
             <div class="container">
                 <div class="row panels-row">
                     <div class="col-xs-12 col-sm-6 col-md-4">
                         <g:link controller="estatica" action="estadisticas" class="panel panel-default panel-icon panel-primary">
                             <div class="panel-heading hidden-xs bg-maiz">
                                 <i class="icono-arg-informes-y-estadisticas"></i>
                             </div>
                             <div class="panel-body">
                                 <h3><span class="visible-xs-inline">
                                     <i class="icono-arg-informes-y-estadisticas text-secondary"></i>&nbsp;
                                 </span>Estadísticas del SNDG</h3>
                                 <!--p class="text-muted">quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo</p-->
                             </div>
                         </g:link>
                     </div>
                 </div>
             </div>
         </section>
         <section>
             <div class="container">
                 <div class="panel-pane pane-texto">
                     <div class="pane-content">
                         <div class="">
                             <h3>Herramientas</h3>
                         </div>
                     </div>
                 </div>
                 <div class="row panels-row">
                     <div class="col-xs-12 col-sm-6 col-md-3">
                         <a class="panel panel-icon" href="api/" target="_blank">
                             <div class="panel-heading hidden-xs bg-warning"><i class="fa fa-laptop"></i></div>
                             <div class="panel-body">
                                 <h3><span class="visible-xs-inline"><i class="fa fa-laptop text-warning"></i> </span>Cosechanos</h3>
                                 <p class="text-muted">A través del protocolo OAI-PMH</p>
                             </div>
                         </a>
                     </div>
                     <div class="col-xs-12 col-sm-6 col-md-3">
                         <a class="panel panel-icon" href="api-rest/" target="_blank">
                             <div class="panel-heading hidden-xs  bg-warning"><i class="fa fa-code"></i></div>
                             <div class="panel-body">
                                 <h3><span class="visible-xs-inline"><i class="fa fa-code text-warning"></i> </span>API</h3>
                                 <p class="text-muted">Usa nuestra API para insertar resultados en tu sitio</p>
                             </div>
                         </a>
                     </div>
                 </div>
             </div>
         </section>
         --}%