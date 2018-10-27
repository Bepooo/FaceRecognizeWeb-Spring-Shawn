<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Login</title>

    <!-- Bootstrap core CSS-->
    <spring:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" var="bootstrapminCSS" />
	<link href="${bootstrapminCSS}" rel="stylesheet" />

    <!-- Custom fonts for this template-->
    <spring:url value="/resources/vendor/fontawesome-free/css/all.min.css" var="allminCSS" />
	<link href="${allminCSS}" rel="stylesheet" />
	
    <!-- Custom styles for this template-->
    <spring:url value="/resources/css/sb-admin.css" var="sbadminCSS" />
	<link href="${sbadminCSS}" rel="stylesheet" />

  </head>

  <body class="bg-dark">

    <div class="container">
      <div class="card card-login mx-auto mt-5">
        <div class="card-header">Login</div>
        <div class="card-body">
          <form method="POST" action="Login" modelAttribute="login">
            <div class="form-group">
            <label for="inputEmail">Email address</label>
              <div class="form-label-group">
                <input type="email" name="Email"id="inputEmail" class="form-control" placeholder="Email address" required="required" autofocus="autofocus">   
              </div>
            </div>
            <div class="form-group">
            	<label for="inputPassword">Password</label>
              <div class="form-label-group">
                <input type="password"  name="password" id="inputPassword" class="form-control" placeholder="Password" required="required">
              </div>
            </div>
            <input class="btn btn-primary btn-block" type="submit" value="login"></input>
          </form>
          <div class="text-center">
            <a class="d-block small mt-3" href="RegisterForm">Register an Account</a>
          </div>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <spring:url value="/resources/vendor/jquery/jquery.min.js" var="jqueryminJS" />
	<script src="${jqueryminJS}"></script>
	<spring:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js" var="bootstrapbundleminJS" />
	<script src="${bootstrapbundleminJS}"></script>

    <!-- Core plugin JavaScript-->
    <spring:url value="/resources/vendor/jquery-easing/jquery.easing.min.js" var="jqueryeasingminJS" />
	<script src="${jqueryeasingminJS}"></script>

  </body>

</html>