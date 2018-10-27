<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="zh">
<head>

<%-- <%@ include file="Header.jsp" %> --%>

<title>Homepage</title>
<spring:url value="/resources/css/index.css" var="indexCSS" />
<spring:url value="/resources/js/index.js" var="indexJS" />
<spring:url value="/resources/css/font-awesome.css" var="fontawesomeCSS" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<spring:url value="/resources/img/mainpage1.png" var="mainpage1Img" />
<link href="${indexCSS}" rel="stylesheet" />
<link href="${fontawesomeCSS}" rel="stylesheet" />
<script src="${indexJS}"></script>
</head>


<body class="lang-en-us">
<nav id="headerContainer" style="background-color:rgba(0, 0, 0, .85);" class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
			<span class="sr-only">Toggle navigation</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/index" id="logo1">
				<img src="/images/logo/leanote_black.png" title="mailnotes, Not Just A Notepad!"/>
			</a>
		</div>
		
		<div id="navbar" class="navbar-collapse collapse">

			<ul class="nav navbar-nav navbar-left">
				<li><a href="/index#" data-target="body" class="smooth-scroll">Home</a></li>
				<li style="position: relative; margin-right: 3px;">
					<a href="#" target="_blank" class="">Discussion</a>
				</li>


				<li><a href="#" target="_blank" title="mailnotes.online" class="">CareerHub</a></li>

				
			</ul>
		</div>
	</div>
</nav>


<section>
	<div class="header">
		<h2>CareerHub, Fine Your Future!</h2>
		<p>Brief But Not Simple</p>

		
		<div>
			<a class="btn btn-default btn-primary" href="RegisterForm">Sign up</a> 
			&nbsp;
			&nbsp;
			
				<a class="btn btn-default" href="LoginForm">Sign in</a>
				&nbsp;
				&nbsp;
			
			
			
		</div>
	</div>
	
	<div class="preview" style="position: relative;">
		<div>
			<div class="img-header">
				<img src="/images/home/mac-btns.png"/>
			</div>
			<div id="webSliderContainer">
			    <img class="web-slider" data-text="Default theme - markdown" src="${mainpage1Img}"/>
			    <img class="web-slider hide-img" data-text="Default theme - rich editor"  src="/images/slider/v2/simple_tinymce.png"/>
			    <img class="web-slider hide-img" data-text="Simple theme - markdown" src="/images/slider/v2/simple_markdown.png"/>
			    <img class="web-slider hide-img" data-text="Writting mode" src="/images/slider/v2/writting.png"/>
			</div>
		</div>
	</div>
</section>

<div class="container" id="aboutLeanote">
	<h2>About CareerHub</h2>
     <div class="row">
        <div class="col-md-3">
          <h3>Knowledge</h3>
          <p>Use Mailnotes as a note, manage your knowledge in Mailnotes.</p>
        </div>
         <div class="col-md-3">
          <h3>Blog</h3>
          <p>You can public your knowledge and mailnotes is your blog!</p>
        </div>
        <div class="col-md-3">
          <h3>Share</h3>
          <p>Share your knowledge to your friends in Mailnotes.</p>
       </div>
        <div class="col-md-3">
          <h3>Cooperation</h3>
          <p>Collaborate with friends to improve your knowledge.</p>
        </div>
      </div>
</div>

<div id="footer">
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<i class="fa fa-envelope-o fa-3x icon-muted"></i>
				<h2>Contact</h2>
				<br />
			</div>
			<div class="col-md-6">
				<i class="fa fa-globe fa-3x icon-muted"></i>
				<h2>Join Us</h2>
			</div>
		</div>
	</div>
	
	<div class="footer-leanote">
		Copyright © <a href="#">mailnotes</a>
		<br/>
		Proudly powered by <a href="#">mailnotes</a>
	</div>
	
</div>


<script>
var lang = 'en-us';
</script>
<script src="/js/home/index.js"></script>


</body>
</html>