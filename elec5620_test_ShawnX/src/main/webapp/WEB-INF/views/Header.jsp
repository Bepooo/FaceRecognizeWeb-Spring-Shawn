<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="author" content="ScriptsBundle">
    <title>Career Hub</title>

    <!-- =-=-=-=-=-=-= Favicons Icon =-=-=-=-=-=-= -->
    <spring:url value="/resources/images/favicon.ico" var="faviconImg" />
    <link rel="icon" href="images/favicon.ico" type="image/x-icon" />

    <!-- =-=-=-=-=-=-= Mobile Specific =-=-=-=-=-=-= -->
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">

    <!-- BOOTSTRAPE STYLESHEET CSS FILES -->
    <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapminCSS" />
	<link href="${bootstrapminCSS}" rel="stylesheet" />

    <!-- JQUERY SELECT -->
     <spring:url value="/resources/css/select2.min.css" var="select2minCSS" />
	<link href="${select2minCSS}" rel="stylesheet" />
    

    <!-- JQUERY MENU -->
    <spring:url value="/resources/css/mega_menu.min.css" var="mega_menuCSS" />
    <link href="${mega_menuCSS}" rel="stylesheet" />


    <!-- ANIMATION -->
    <spring:url value="/resources/css/animate.min.css" var="animateminCSS" />
    <link href="${animateminCSS}" rel="stylesheet" />

    <!-- OWl  CAROUSEL-->
    <spring:url value="/resources/css/owl.carousel.css" var="owlcarouselCSS" />
    <link href="${owlcarouselCSS}" rel="stylesheet" />
    
    <spring:url value="/resources/css/owl.style.css" var="owlstyleCSS" />
    <link href="${owlstyleCSS}" rel="stylesheet" />
   

    <!-- TEMPLATE CORE CSS -->
    <spring:url value="/resources/css/style.css" var="styleCSS" />
    <link href="${styleCSS}" rel="stylesheet" />
   

    <!-- FONT AWESOME -->
    <spring:url value="/resources/css/font-awesome.min.css" var="font-awesomeminCSS" />
    <link href="${font-awesomeminCSS}" rel="stylesheet" />
    <spring:url value="/resources/css/et-line-fonts.css" var="et-line-fontsCSS" />
    <link href="${et-line-fontsCSS}" rel="stylesheet"  type="text/css"/>
    

    <!-- Google Fonts -->
    <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,900" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600,700" rel="stylesheet" type="text/css">

    <!-- JavaScripts -->
    <spring:url value="/resources/js/modernizr.js" var="modernizrJS" />
	<script src="${modernizrJS}"></script>
	
	<spring:url value="/resources/images/careerhubLogo.png" var="careerhubLogo" />
	<script src="${careerhubLogo}"></script>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
</head>