<header>
	<nav class="navbar navbar-top navbar-default bg-celeste-argentina" role="navigation">
		<div class="container">
			<div>
				<div class="navbar-header">
					<a class="navbar-brand" href="https://www.argentina.gob.ar/" target="_blank" aria-label="Argentina.gob.ar Presidencia de la Nación">
						<asset:image src="argentinagob-2.svg" height="50px" alt="Argentina.gob.ar"/>
					</a>
					<a class="btn btn-mi-argentina btn-login visible-xs" href="https://argob.github.io/proyectos/mi-argentina/v3/"><i class="icono-arg-mi-argentina fa-fw"></i></a>
					<a class="btn bg-white btn-login visible-xs" href="https://argob.github.io/poncho/plantillas/headers-y-footers/header-footer-v1.html#" onclick="$(&#39;.navbar.navbar-top&#39;).addClass(&#39;state-search&#39;);">
						<span class="fa fa-search fa-fw"></span>
					</a>
				</div>
				<div class="nav navbar-nav navbar-right hidden-xs">
					<a href="https://mi.argentina.gob.ar"  target="_blank" class="dropdown-toggle btn btn-mi-argentina hidden-xs bg-white" aria-label="Ingresar a Mi Argentina"> miArgentina</a>
				</div>
			</div>
		</div>
	</nav>
</header>

%{--<header>
	<nav class="navbar navbar-default navbar-static-top">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="https://datos.mincyt.gob.ar/#/"><asset:image src="01_logotipo.png" height="50px" alt="Portal de Datos Científicos"/></a>
				<a class="navbar-brand" href="https://sicytar.mincyt.gob.ar/#/"><asset:image src="logo_sicytar_ok.svg" height="50px" alt="SICYTAR"/></a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			  <ul class="nav navbar-nav navbar-right">
			  </ul>
			</div><!-- /.navbar-collapse -->
		</div><!-- /.container-fluid -->
	</nav>
</header>--}%

%{--  <li><a href="/">INICIO</a></li>
  <li><a href="${grailsApplication.config.external.link.blast}">BLAST</a></li>
  <li><a href="${grailsApplication.config.external.link.faq}">FAQ</a></li>
  <li><a target="_blank" href="/api">API</a></li>


%{--<sec:ifNotLoggedIn>
    <li class="${controllerName == '' ? 'active' : ''}"><g:link uri="/login">INICIAR SESI&Oacute;N</g:link></li>
    <li class="${controllerName == '' ? 'active' : ''}">
        <g:link uri="/register">Registrarse</g:link>
    </li>
</sec:ifNotLoggedIn>
<sec:ifLoggedIn>
    <sec:access expression="hasRole('ROLE_ADMIN')">
    <li class="dropdown"><a href="#" class="dropdown-toggle"
        data-toggle="dropdown" role="button" aria-expanded="false">ADMINISTRAR <span class="caret"></span>
    </a>
        <ul class="dropdown-menu" role="menu">

            <li><g:link controller="public" action="downloadInstructivo">Descargar manual</g:link></li>
            <li class="divider"></li>
            <li><a href="${createLink(controller: 'centro')}">Centros</a></li>
            <li><a href="${createLink(controller: 'unidad')}">Laboratorios</a></li>
            <li><a href="${createLink(controller: 'conjuntoDeDatos')}">Conjuntos de Datos</a></li>
            <li><a href="${createLink(controller: 'herramienta')}">Herramientas</a></li>
            <li class="divider"></li>
            <li><a href="${createLink(controller: 'institucion')}">Instituciones</a></li>
            <li><a href="${createLink(controller: 'user')}">Usuarios</a></li>
            <li><a href="${createLink(controller: 'userRoleCentro')}">Responsables de centros</a></li>
<%--						<li><a href="${createLink(controller: 'programa')}">Programas</a></li>--%>
<%--						<li><a href="${createLink(controller: 'area')}">&Aacute;reas</a></li>--%>
        </ul>
    </li>
    </sec:access>
    <li class="dropdown"><a href="#" class="dropdown-toggle"
        data-toggle="dropdown" role="button" aria-expanded="false">${sec.username()} <span class="caret"></span>
    </a>
        <ul class="dropdown-menu" role="menu">
            <li>
                <g:link controller="public" action="downloadInstructivo">
                    Descargar instructivo
                </g:link>
            </li>
            <li class="divider"></li>
            <li>
                <g:link controller="public" action="cambiarContrasenia">
                    Cambiar contrase&ntilde;a
                </g:link>
            </li>
            <li>
                <g:remoteLink class="logout" controller="logout" method="post" asynchronous="false" onSuccess="location.reload()">
                    Cerrar Sesi&oacute;n
                </g:remoteLink>
            </li>
<%--						<li><a href="${createLink(controller: 'medio')}">Medios</a></li>--%>
<%--						<li><a href="${createLink(controller: 'programa')}">Programas</a></li>--%>
<%--						<li class="divider"></li>--%>
<%--						<li><a href="${createLink(controller: 'area')}">&Aacute;reas</a></li>--%>
        </ul>
    </li>
</sec:ifLoggedIn>--}%