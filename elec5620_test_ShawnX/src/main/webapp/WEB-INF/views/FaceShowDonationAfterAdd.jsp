Feedbacks
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
<body>

<div class="alert alert-success" role="alert">
  <h4 class="alert-heading">Well done!</h4>
  <p>Yeah, you have successfully finished your donate process. We will send your donation to the people who need it.</p>
  <hr>
  <p class="mb-0">Thank you so much~</p>
</div>

	<h1>All Donations!</h1>

	<table>
<p>${Donations}</p>
		<tr>

			<!-- <td>Feedback id</td> -->
			<td>Donation Type</td>
			<td>Clothes Color</td>
			<td>Description</td>
			<td>Managed?</td>
			<td></td>

		</tr>

		<c:forEach items="${Donations}" var="Donation">

			<tr>
				<td>${Donation.type}</td>

				<td>${Donation.color}</td>
				
				<td>${Donation.description}</td>
				
				<td><a href="<c:url value='/delete-${Donation.id}-donation'/>">Already sent this donation</a></td>
			</tr>

		</c:forEach>

	</table>


</body>
</html>
