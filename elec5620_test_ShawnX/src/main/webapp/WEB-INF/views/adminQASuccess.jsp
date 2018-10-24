<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>QA Confirmation Page</title>
<a href="http://localhost:8080/sydney/adminHome">Jobs Database</a>
<a href="http://localhost:8080/sydney/qaManagement">Q & A Mangement</a>
<a href="http://localhost:8080/sydney/announcementManagement">Announcement
	Management</a>
</head>
<body>
<div>
    message : ${success}
    </div>
    <br/>
    <br/>
    Go back to <a href="http://localhost:8080/sydney/adminHome">Go back</a>
     
</body>
 
</html>
