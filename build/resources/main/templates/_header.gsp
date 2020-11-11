<header>
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
				<a class="navbar-brand" href="/"><asset:image src="logo_sistemas_nacionales.png" height="50px" alt="Sistema Nacional de Datos Genómicos"/></a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			  <ul class="nav navbar-nav navbar-right">
				  <li><a href="/">INICIO</a></li>
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
			  </ul>
			</div><!-- /.navbar-collapse -->
		</div><!-- /.container-fluid -->
	</nav>
</header>