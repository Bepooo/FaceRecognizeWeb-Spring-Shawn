<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome~</title>
</head>
<body background="https://images.pexels.com/photos/994523/pexels-photo-994523.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940">
	<h1 class="container-fluid text-light">Welcome!</h1><h1 class="container-fluid text-light"> ${model} </h1>
<p><button onclick="window.location.href='FaceReadFeedback'" type="button" class="btn btn-secondary btn-lg">Read Feedback</button>
<button onclick="window.location.href='FaceWriteClothes'" type="button" class="btn btn-secondary btn-lg">Add new Product</button>
<button onclick="window.location.href='FaceManageDonation'" type="button" class="btn btn-secondary btn-lg">Manage Donation</button></p>
	<table>
	<p></p>
		<button onclick="window.location.href='FaceHome'" type="button" class="btn btn-secondary btn-lg font-weight-bold">Back
			to home page</button>
	
</body>
</html>
