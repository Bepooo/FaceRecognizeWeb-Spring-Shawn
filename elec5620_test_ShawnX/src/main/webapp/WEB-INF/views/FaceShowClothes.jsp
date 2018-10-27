<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Feedbacks</title>
</head>
<body class="p-3 mb-2 bg-secondary text-white">

	<h1 class="text-light">All Feedbacks!</h1>

	<table class="text-light">
<%-- <p>${Feedbacks}</p> --%>
		<tr>

			<!-- <td>Feedback id</td> -->
			<td>Clothes id</td>
			<td>Color</td>
			<td>Type</td>
			<td>Price</td>
			<td>Location</td>
			

		</tr>

		<c:forEach items="${Clotheses}" var="Clothes">

			<tr>

				<%-- <td>${feedback.id}</td> --%>

				<td>${Clothes.id}</td>
				
				<td>${Clothes.color}</td>

				<td>${Clothes.type}</td>
				
				<td>${Clothes.price}</td>

				
				<td>${Clothes.location}</td>
				
				
				<td><a href="<c:url value='/delete-${Clothes.id}-clothes'/>">Delete this Clothes</a></td>
			</tr>

		</c:forEach>

	</table>
<p>
</p>
<button onclick="javascript:history.back(-1);" type="button" class="btn btn-warning btn-lg font-weight-bold">Back
			to the last page</button>
</body>
</html>
