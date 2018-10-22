Feedbacks
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Feedbacks</title>
</head>
<body>
	<h1>All Feedbacks!</h1>

	<table>
<p>${Feedbacks}</p>
		<tr>

			<!-- <td>Feedback id</td> -->
			<td>Submitted Time</td>
			<td>Feedback Type</td>
			<td>Feedback</td>
			<td>Delete?</td>
			<td></td>

		</tr>

		<c:forEach items="${Feedbacks}" var="Feedback">

			<tr>

				<%-- <td>${feedback.id}</td> --%>

				<td>${Feedback.time}</td>

				<td>${Feedback.type}</td>

				<td>${Feedback.feedback}</td>
				
				<td><a href="<c:url value='/delete-${Feedback.id}-feedback'/>">Delete this feedback</a></td>
			</tr>

		</c:forEach>

	</table>


</body>
</html>
