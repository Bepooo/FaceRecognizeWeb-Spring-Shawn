<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>


<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body background="https://images.pexels.com/photos/994523/pexels-photo-994523.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940">



	<h3>Change your personal information here~</h3>
	<form:form method="POST" modelAttribute="person">

        <%-- <form:input type="hidden" path="id" id="id"/> --%>

        <table>
            <tr>
                <td><label for="first">First: </label> </td>
                <td><form:input path="first" id="first"/></td>
                
            </tr>
            <tr>
               <td><label for="last">Last: </label> </td>
                <td><form:input path="last" id="last"/></td>
            </tr>
            <tr>
               <td><label for="age">Age: </label> </td>
                <td><form:input path="age" id="age"/></td>
            </tr>
            <tr>
               <td><label for="phonenumber">Phonenumber: </label> </td>
                <td><form:input path="phonenumber" id="phonenumber"/></td>
            </tr>
            <tr>
               <td><label for="email">Email: </label> </td>
                <td><form:input path="email" id="email"/></td>
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
