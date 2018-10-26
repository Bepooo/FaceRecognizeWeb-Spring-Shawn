<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>


<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body background="https://images.pexels.com/photos/994523/pexels-photo-994523.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940">

	<h1 class="text-light">Welcome~!</h1>
	<div style="width: 50%; hight: 100%; float: left；" class="text-light">
		<table id="table1" class="text-light">
			<%-- <p>${PersonInfo}</p> --%>
			<tr>

				<td>First</td>
				<td>Last</td>
				<!-- <td>Age</td> -->
				<td>Our Advices</td>
				

			</tr>

			<c:forEach items="${PersonInfo}" var="person">

				<tr>

					<td>${person.first}</td>

					<td>${person.last}</td>

					<%-- <td>${person.age}</td> --%>

					<td>
						${person.favor} ${person.advice}
					</td>





				</tr>

			</c:forEach>

		</table>
		<button onclick="window.location.href='FaceHome'" type="button" class="btn btn-secondary btn-sm font-weight-bold">Back
			to the home page</button>
</body>
</html>
