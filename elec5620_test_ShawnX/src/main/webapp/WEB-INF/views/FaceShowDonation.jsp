<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Donations</title>
</head>
<body background="https://images.pexels.com/photos/994523/pexels-photo-994523.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940">
	<h1 class="container-fluid text-light">All Donations!</h1>

	<table>

		<tr  class="container-fluid text-light">

			<!-- <td>Feedback id</td> -->
			<td>Donation Type</td>
			<td>Clothes Color</td>
			<td>Description</td>
			<td>Managed?</td>
			<td></td>

		</tr>

		<c:forEach items="${Donations}" var="Donation">

			<tr  class="container-fluid text-light">
				<td>${Donation.type}</td>

				<td>${Donation.color}</td>
				
				<td>${Donation.description}</td>
				
				<td><a href="<c:url value='/delete-${Donation.id}-donation'/>">Already sent this donation</a></td>
			</tr>

		</c:forEach>

	</table>
	
	<p>
</p>
<button onclick="javascript:history.back(-1);" type="button" class="btn btn-warning btn-lg font-weight-bold">Back
			to the last page</button>


</body>
</html>
