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
	<p> ${location} </p>
	<p>${jobpost.getLocation()}</p>
	<p> ${company} </p>
	<p> ${department} </p>
	<p> ${position} </p>
	<p> ${employmenttype} </p>
	<p> ${jobdescription} </p>
	<p> ${requirements} </p>
	<button type="button" onclick="alert('To be continued')">Submit!</button>
	<button type="button" onclick="history.back(-1)">Do it again!</button>
    <a href="http://localhost:8080/sydney/JobPostHome">Submit another Job Post</a>
</body>
</html>