<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>${grailsApplication.config.header.title}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />

%{--    <asset:stylesheet src="application.css"/>--}%

    <asset:javascript src="jquery-2.2.4.min.js"/>
    <asset:javascript src="bootstrap.min.js"/>

    <asset:stylesheet src="bootstrap.css"/>
%{--    <asset:stylesheet src="bootstrap-theme.css"/>--}%
    <asset:stylesheet src="poncho.min.css"/>
    <asset:stylesheet src="argentina.css"/>
    <asset:stylesheet src="roboto-fontface.css"/>
    <asset:stylesheet src="icono-arg.css"/>
    <asset:stylesheet src="font-awesome.min.css"/>

    <link href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" media="all" rel="stylesheet" type="text/css">
    <g:layoutHead/>

    <!-- Global site tag (gtag.js) - Google Analytics -->
    <script async src="https://www.googletagmanager.com/gtag/js?id=${grailsApplication.config.googleAnalitycsCode}"></script>
    <script>
        window.dataLayer = window.dataLayer || [];
        function gtag(){dataLayer.push(arguments);}
        gtag('js', new Date());

        gtag('config', ${grailsApplication.config.googleAnalitycsCode});
    </script>

    <style>
        .text-personalizado{
            color: #009ADA!important;
        }
        .text-personalizado-secundario{
            color: #E5B449!important;
        }
        .btn-primary-personalizado{
            color: white!important;
            background-color: #009ADA;
        }
        .btn-personalizado{
            color: #009ADA;
            background-color: #fff;
            border-color: transparent!important;
            font-weight: normal;
            border-radius: 0;
        }
        .btn-personalizado > a{
            text-decoration: none!important;
            color: #009ADA;
        }
        .btn-personalizado:active,.btn-personalizado[disabled]{
            color: #201815;
        }
        .panel-personalizado{
            border: solid 1px #E5B449;
            border-radius: 10px;
            box-shadow: none;
            color: #201815;
            display: block;
            text-decoration: none!important;
        }
    </style>
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
