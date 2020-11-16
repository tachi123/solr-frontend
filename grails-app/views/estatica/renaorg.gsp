<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <title>${ title }</title>
</head>
<body>
%{--	<g:set var="urlImgSection" value="${evaluate('grailsApplication.config.section.CENTROS.urlImg')}"></g:set>
	<g:render template="/solrPublic/searchBox"
			  model="[urlImg:urlImgSection,title: this.title, description: '',buscadorEnabled: false, displayActive: this.title]"
	/>
	<main role="main">
		<section>
		    <div class="container">
				<iframe src="${ url }"	frameborder="0" style="overflow:hidden;height:600px;width:inherit;" ></iframe>
			</div>
		</section>
	</main>--}%
</body>