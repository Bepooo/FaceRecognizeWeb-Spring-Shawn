<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<!--     <p><a href="http://localhost:8080/sydney/JobPostHome">Job Post</a>
    <a href="http://localhost:8080/sydney/ResumeCentre">Resume Centre</a>
    <a href="http://localhost:8080/sydney/JobCentre">Jobs Centre</a>
    </p> -->
</head>
<body>
	<h3>Welcome, enter your personal information</h3>
	<form id="saveForm" action="FaceAddPerson" method="post">
		<table style="font-size: :16px">
			<tr>
				<td>First Name</td>
				<td><input type="text" name="first" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="last" /></td>
			</tr>
			
			<tr>
				<td>Age</td>
				<td><input type="text" name="age" /></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><!-- <input type="text" name="gender" /> -->
				<select name="gender" name="gender">
			<option value="male">male</option>
			<option value="female">female</option>

		</select>
		</td>
			</tr>
			<tr>
				<td>Favor</td>
				<td><!-- <input type="text" name="favor" /> -->
				<select name="favor" name="favor">
				<option value="black">Black</option>
			<option value="blue">Blue</option>
			<option value="white">White</option></td>
			</tr>
			<tr>
				<td>Height</td>
				<td><input type="text" name="height" /></td>
			</tr>
			<tr>
				<td>FaceToken</td>
				<td><input type="hidden" value=${model} name="faceto" /></td>
			</tr>
<!-- 			<tr>
				<td>FaceType</td>
				<td><input type="text" value=${ft} name="facety" /></td>
			</tr> -->
			<tr>
				<td><input type="submit" value="Submit" /></td>
				<td><input type="reset" value="Reset" /></td>
			</tr>
		</table>
</body>
</html>
<%-- <form:form method="POST" action="/sydney/FaceAddPerson" modelAttribute="person">
             <table>
                <tr>
                    <td><form:label path="name">First Name</form:label></td>
                    <td><form:input path="first" value="first"/></td>
                </tr>
                <tr>
                    <td><form:label path="name">Last Name</form:label></td>
                    <td><form:input path="last" value="last"/></td>
                </tr>
                <tr>
                    <td><form:label path="age">Age</form:label></td>
                    <td><form:input path="age" /></td>
                </tr>
                <tr>
                    <td><form:label path="gender">Gender</form:label></td>
                    <td><form:input path="gender"/></td>
                </tr>
                
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                    <td><input type="reset" value="Reset"/></td>
                </tr>
            </table>
        </form:form> --%>