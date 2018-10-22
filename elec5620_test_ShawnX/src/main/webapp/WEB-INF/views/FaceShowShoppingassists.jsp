<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>shoppingassists</title>
</head>
<body>
	<h1>All shoppingassists</h1>

	<table>
		<p>${Shoppingassists}</p>
		<tr>
			<td>Id</td>
			<td>Name</td>
			<td>Password</td>
			<td>Delete it?</td>
			<td></td>

		</tr>

		<c:forEach items="${Shoppingassists}" var="Shoppingassist">

			<tr>

				<td>${Shoppingassist.id}</td>

				<td>${Shoppingassist.name}</td>

				<td>${Shoppingassist.password}</td>


				<td><a href="<c:url value='/delete-${Shoppingassist.id}-shoppingassist'/>">delete</a></td>


			</tr>

		</c:forEach>

	</table>


</body>
</html>
