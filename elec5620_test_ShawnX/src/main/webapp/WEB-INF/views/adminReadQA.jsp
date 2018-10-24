<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<a href="http://localhost:8080/sydney/adminHome">Jobs Database</a>
<a href="http://localhost:8080/sydney/qaManagement">Q & A Mangement</a>
<a href="http://localhost:8080/sydney/announcementManagement">Announcement
	Management</a>

<style>
.error {
	color: #ff0000;
}
</style>

</head>
<body>



	<h3>All the QA here~</h3>
	<p>${qas}</p>
	<table>
        <tr>
            <!-- <td>ID</td> --><td>Questions</td><td>Answer</td><td>OPTION </td><td></td>

        </tr>


<c:forEach items="${qas}" var="QA">
            <tr>

        <%-- <td>${QA.id}</td> --%>
            <td>${QA.question}</td>

            <td>${QA.answer}</td>


            <td><a href="<c:url value='/edit-${QA.id}-qa' />">edit this question?</a></td>

            <td><a href="<c:url value='/delete-${QA.id}-qa' />">delete</a></td>

            </tr>

        </c:forEach>

    </table>

    <br/>

    <a href="http://localhost:8080/sydney/adminWriteQA">Add a New QA</a>
	

</body>
</html>
