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
	<h1>All Your Resumes!</h1>
	<div style="width: 50%; hight: 100%; float: left；">
		<table id="table1">
			<tr>

				<td>Name</td>
				<td>Age</td>
				<td>Gender</td>
				<td>Education</td>
				<td>Capability</td>
				<td>JobPostId</td>
				<td>ResumeId</td>
				
				<td>Company</td>
				<td>Location</td>
				<td>Position</td>
				<td>Job Description</td>
				<td>Delete</td>

			</tr>

			<c:forEach items="${Resumes}" var="resume">

				<tr>

					<td>${resume.name}</td>

					<td>${resume.age}</td>
					<td>${resume.gender}</td>
					<td>${resume.education}</td>
					<td>${resume.capability}</td>
					
					<%-- <td>${resume.id}</td> --%>

					<td>${resume.jobPostId}</td>  

					 <td>${resume.id}</td> 

					<td>${resume.company}</td>

					<td>${resume.location}</td>

					<td>${resume.position}</td>

					<td>${resume.jobdescription}</td>

					<td><a href="<c:url value='/delete-${resume.id}-resume'/>">Delete</a></td>

				</tr>

			</c:forEach>

		</table>
		<!-- 	</div>
	<div style="width: 50%; hight: 100%; float: left；">
		<table id=table2>


		</table>
	</div> -->
</body>
</html>
