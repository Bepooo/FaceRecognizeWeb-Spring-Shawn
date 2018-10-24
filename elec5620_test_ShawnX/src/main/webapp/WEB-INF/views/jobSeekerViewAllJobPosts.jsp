For candidatures
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
		<form id="saveForm" action="jobSeekerQueryJobposts"  modelAttribute="feedback" method="post">
		
				<tr>
					<td>Types</td>
					<td><select name=type value= type>
							<option value="Fulltime">FullTime</option>
							<option value="Parttime">PartTime</option>
							<option value="Others">Others</option>
					</select></td>
				</tr>
				<tr>
					<td>Location</td>
					<td><select name=feedback value=feedback>
							<option value="Sydney">Sydney</option>
							<option value="Melbourne">Melbourne</option>
							<option value="others">Others</option>
					</select></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit" /></td>
					<td><input type="reset" value="Reset" /></td>
				</tr>

			
		</form>




		<tr>

			<td>JobPostid</td>
			<td>Location</td>
			<td>Company</td>
			<td>Department</td>
			<td>Employment Type</td>
			<td>Apply?</td>
			<td></td>

		</tr>

		<c:forEach items="${JobPosts}" var="JobPost">

			<tr>

				<td>${JobPost.id}</td>

				<td>${JobPost.location}</td>

				<td>${JobPost.company}</td>

				<td>${JobPost.department}</td>

				<td>${JobPost.employmenttype}</td>
				
				<td>${JobPost.jobdescription}</td>
				
				<td><a href="<c:url value='/apply-${JobPost.id}-apply'/>">apply</a></td>

			</tr>

		</c:forEach>

	</table>


</body>
</html>
