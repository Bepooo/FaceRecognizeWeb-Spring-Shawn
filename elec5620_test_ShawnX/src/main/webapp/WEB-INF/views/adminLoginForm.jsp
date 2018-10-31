<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">

<head>
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<!--[if IE]>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
<![endif]-->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="ScriptsBundle">
<title>Admin Login</title>
<%@ include file="Header.jsp"%>

</head>

<body>
<script>
	// This is called with the results from from FB.getLoginStatus().
	/*  function action() {
	  document.getElementById('login').style.display='block';
	 } */
	function statusChangeCallback(response) {
		console.log('statusChangeCallback');
		console.log(response);
		// The response object is returned with a status field that lets the
		// app know the current login status of the person.
		// Full docs on the response object can be found in the documentation
		// for FB.getLoginStatus().
		if (response.status === 'connected') {
			// Logged into your app and Facebook.
			testAPI();
		} else {
			// The person is not logged into your app or we are unable to tell.
			document.getElementById('status').innerHTML = 'Please log '
					+ 'into this app.';
		}
	}

	// This function is called when someone finishes with the Login
	// Button.  See the onlogin handler attached to it in the sample
	// code below.
	function checkLoginState() {
		FB.getLoginStatus(function(response) {
			statusChangeCallback(response);
		});
	}

	window.fbAsyncInit = function() {
		FB.init({
			appId : '270562556998637',
			cookie : true, // enable cookies to allow the server to access 
			// the session
			xfbml : true, // parse social plugins on this page
			version : 'v3.1' // use graph api version 2.8
		});

		// Now that we've initialized the JavaScript SDK, we call 
		// FB.getLoginStatus().  This function gets the state of the
		// person visiting this page and can return one of three states to
		// the callback you provide.  They can be:
		//
		// 1. Logged into your app ('connected')
		// 2. Logged into Facebook, but not your app ('not_authorized')
		// 3. Not logged into Facebook and can't tell if they are logged into
		//    your app or not.
		//
		// These three cases are handled in the callback function.

		FB.getLoginStatus(function(response) {
			statusChangeCallback(response);
		});

	};

	// Load the SDK asynchronously
	(function(d, s, id) {
		var js, fjs = d.getElementsByTagName(s)[0];
		if (d.getElementById(id))
			return;
		js = d.createElement(s);
		js.id = id;
		js.src = "https://connect.facebook.net/en_US/sdk.js";
		fjs.parentNode.insertBefore(js, fjs);
	}(document, 'script', 'facebook-jssdk'));

	// Here we run a very simple test of the Graph API after login is
	// successful.  See statusChangeCallback() for when this call is made.
	function testAPI() {
		console.log('Welcome!  Fetching your information.... ');
		FB
				.api(
						'/me',
						function(response) {
							console.log('Successful login for: '
									+ response.name);
							document.getElementById('status').innerHTML = 'Thanks for logging in, '
									+ response.name + '!';
/* 							window.location.replace("http://localhost:8080/sydney/adminHome"); */
							
							document.getElementById('facebooklogin').hidden = '';
 							
						});
	}
</script>
	<div class="page category-page">
		<div id="spinner">
			<div class="spinner-img">
				<img alt="Opportunities Preloader" src="${careerhubLogo}" />
				<h2>Please Wait.....</h2>
			</div>
		</div>
		<section class="login-page-4 parallex">
			<div class="container">
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<form method="POST" action="AdminLogin"
							modelAttribute="adminlogin">
							<div class="login-container">
								<div class="loginbox">
									<img src="${careerhubLogo}" alt="logo"
										class="img-responsive center-block">
									
									
									<div class="form-group">
										<label>Email: <span class="required">*</span></label> <input
											placeholder="" name="email" class="form-control" type="email">
									</div>
									<div class="form-group">
										<label>Password: <span class="required">*</span></label> <input
											placeholder="" name="password" class="form-control"
											type="password">
									</div>
									<div class="loginbox-submit">
										<input type="submit" class="btn btn-default btn-block"
											value="Login">
									</div>
									<div class="loginbox-signup">
										<a href="jobPosterRegisterForm">Don't have a account?</a>
									</div>
									<div class="loginbox-or">
										<div class="or-line"></div>
										<div class="or">OR</div>
									</div>
									<div class="loginbox-title">sign in using social accounts</div>
									<fb:login-button scope="public_profile,email"
										onlogin="checkLoginState();">
									</fb:login-button>

									<div id="status"></div>
									<div id="facebooklogin" hidden="hidden">
										<button
											onclick="window.location.href='http://localhost:8080/sydney/adminHome'"
											type="button" class="btn btn-default btn-block">Use
											this account to login</button>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</section>

		<a href="#" class="scrollup"><i class="fa fa-chevron-up"></i></a>

		<%@ include file="Js.jsp"%>

		<script type="text/javascript">
			$(".full-page").height($(window).height());
			$(window).resize(function() {
				$(".full-page").height($(window).height());
			});
		</script>

	</div>
</body>

</html>