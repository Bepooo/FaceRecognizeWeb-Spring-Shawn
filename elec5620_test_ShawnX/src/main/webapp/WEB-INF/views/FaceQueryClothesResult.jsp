<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<!--     <p><a href="http://localhost:8080/sydney/JobPostHome">Job Post</a>
    <a href="http://localhost:8080/sydney/ResumeCentre">Resume Centre</a>
    <a href="http://localhost:8080/sydney/JobCentre">Jobs Centre</a>
    </p> -->
</head>
<body>



	<h3>Welcome, are you looking for these clothes?</h3>
	<table>
		
		<p>${Clotheses}</p>
		<tr>

			<!-- <td>Feedback id</td> -->
			<td>Color</td>
			<td>Types</td>
			<td>Location</td>
			<td>Price</td>

		</tr>

		<c:forEach items="${Clotheses}" var="Clothes">

			<tr>

				<td>${Clothes.color}</td>

				<td>${Clothes.type}</td>

				<td>${Clothes.location}</td>
				
				<td>${Clothes.price}</td>
				
			</tr>

		</c:forEach>
		
		
		
		
		</table>
</body>
</html>
