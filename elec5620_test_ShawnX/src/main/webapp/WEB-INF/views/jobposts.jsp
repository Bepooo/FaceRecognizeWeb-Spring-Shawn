<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Job Posts</title>
</head>
<body>
	<h1>All Your Job Posts!</h1>

	<table>
<p>${JobPosts}</p>
		<tr>

			<td>JobPostid</td>
			<td>Location</td>
			<td>Company</td>
			<td>Department</td>
			<td>Employment Type</td>
			<td>Poster Name</td>
			<td>Delete it?</td>
			<td></td>

		</tr>

		<c:forEach items="${JobPosts}" var="JobPost">

			<tr>

				<td>${JobPost.id}</td>

				<td>${JobPost.location}</td>

				<td>${JobPost.company}</td>

				<td>${JobPost.department}</td>

				<td>${JobPost.employmenttype}</td>
				
				<td>${JobPost.postername}</td>
				
				<td><a href="<c:url value='/delete-${JobPost.id}-jobpost'/>">delete</a></td>


			</tr>

		</c:forEach>

	</table>


</body>
</html>
