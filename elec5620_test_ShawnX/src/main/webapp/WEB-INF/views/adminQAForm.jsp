<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<a href="http://localhost:8080/sydney/adminHome">Jobs Database</a>
    <a href="http://localhost:8080/sydney/qaManagement">Q & A Mangement</a>
    <a href="http://localhost:8080/sydney/announcementManagement">Announcement Management</a>
    
    	<style>
    .error {     color: #ff0000;    }

</style>
    
</head>
<body>



	<h3>All the QA here~</h3>
	<form:form method="POST" modelAttribute="qa">

        <%-- <form:input type="hidden" path="id" id="id"/> --%>

        <table>
            <tr>
                <td><label for="question">Question: </label> </td>
                <td><form:input path="question" id="question"/></td>
            <%--     <td><form:errors path="question" cssClass="error"/></td> --%>
                
            </tr>
            <tr>
               <td><label for="answer">Answer: </label> </td>
                <td><form:input path="answer" id="answer"/></td>
          <%--       <td><form:errors path="answer" cssClass="error"/></td> --%>
            </tr>
<tr>
                <td colspan="3">

                            <input type="submit" value="Update"/>

                            <input type="reset" value="Reset"/>

                </td>
            </tr>
        </table>
    </form:form>

	
</body>
</html>
