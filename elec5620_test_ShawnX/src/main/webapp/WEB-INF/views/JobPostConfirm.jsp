<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<title>Getting Started: Handling Form Submission</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>

	<h1>JobPostConfirm</h1>

	<table>
		<tr>
			<td><form:label path="JobPostid">Id</form:label></td>
			<td>${jobpostid}</td>
		</tr>
		<tr>
			<td><form:label path="time">Time</form:label></td>
			<td>${time}</td>
		</tr>
		<tr>
			<td><form:label path="location">Location</form:label></td>
			<td>${location}</td>
		</tr>
		<tr>
			<td><form:label path="company">Company</form:label></td>
			<td>${company}</td>
		</tr>
		<tr>
			<td><form:label path="department">Department</form:label></td>
			<td>${department}</td>
		</tr>
		<tr>
			<td><form:label path="position">Position</form:label></td>
			<td>${position}</td>
		</tr>
		<tr>
			<td><form:label path="employmenttype">Employment Type</form:label></td>
			<td>${employmenttype}</td>
		</tr>
		<tr>
			<td><form:label path="jobdescription">
                      Job Description</form:label></td>
			<td>${jobdescription}</td>
		</tr>
		<tr>
			<td><form:label path="requirements">
                      Requirements</form:label></td>
			<td>${requirements}</td>
		</tr>

		<tr>
			<td>
				<button onclick="window.location.href='deleteLatestJobPost'" type="button">Delete it</button>
			</td>
			<td><button
					onclick="location.href='http://localhost:8080/sydney/JobPostHome'"
					type="button">Confirmed, let's go back</button></td>
		</tr>
	</table>


	<a href="http://localhost:8080/sydney/JobPostHome">Submit another
		Job Post</a>
</body>
</html>