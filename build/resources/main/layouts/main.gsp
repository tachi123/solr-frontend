<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>Portal de datos genómicos</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />

%{--    <asset:stylesheet src="application.css"/>--}%

    <asset:javascript src="jquery-2.2.0.min.js"/>
    <asset:javascript src="bootstrap.js"/>

    <asset:stylesheet src="bootstrap.css"/>
    <asset:stylesheet src="bootstrap-theme.css"/>
    <asset:stylesheet src="poncho.css"/>
    <asset:stylesheet src="roboto-fontface.css"/>
    <asset:stylesheet src="icono-arg.css"/>
    <asset:stylesheet src="font-awesome.min.css"/>

    <g:layoutHead/>

    <!-- Global site tag (gtag.js) - Google Analytics -->
    <script async src="https://www.googletagmanager.com/gtag/js?id=UA-85741610-2"></script>
    <script>
        window.dataLayer = window.dataLayer || [];
        function gtag(){dataLayer.push(arguments);}
        gtag('js', new Date());

        gtag('config', 'UA-85741610-2');
    </script>

</head>
<body>

    <g:render template="/templates/header"/>
    <g:layoutBody/>
    <br/>
    <g:render template="/templates/footer"/>

    <g:javascript library="jquery">
        function expandFacet(facetName){
            if(document.getElementById(facetName).style.display == "none"){
                document.getElementById(facetName).style.display="block";
                document.getElementById(facetName+"+").style.display="none";
                document.getElementById(facetName+"-").style.display="block";
            }else{
                document.getElementById(facetName).style.display="none";
                document.getElementById(facetName+"+").style.display="block";
                document.getElementById(facetName+"-").style.display="none";
            }
        }
    </g:javascript>
</body>
</html>
