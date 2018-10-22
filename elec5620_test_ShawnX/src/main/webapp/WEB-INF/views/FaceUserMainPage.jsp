For candidatures
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resumes for your posts</title>
</head>
<body>

	<h1>All Resumes!</h1>
	<div style="width: 50%; hight: 100%; float: left；">
		<table id="table1">
			<p>${PersonInfo}</p>
			<tr>

				<td>First</td>
				<td>Last</td>
				<td>Age</td>
				<td>Our Advices</td>
				

			</tr>

			<c:forEach items="${PersonInfo}" var="person">

				<tr>

					<td>${person.first}</td>

					<td>${person.last}</td>

					<td>${person.age}</td>

					<td>
						${person.favor} ${person.advice}
					</td>





				</tr>

			</c:forEach>

		</table>
</body>
</html>
