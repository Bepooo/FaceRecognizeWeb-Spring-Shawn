<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome~</title>
</head>
<body>
	<h1>Welcome~</h1><h1> ${model} </h1>
<p><button onclick="window.location.href='FaceReadFeedback'" type="button">Read Feedback</button>
<button onclick="window.location.href='FaceWriteClothes'" type="button">Add new Product</button>
<button onclick="window.location.href='FaceManageDonation'" type="button">Manage Donation</button></p>
	<table>
</body>
</html>
