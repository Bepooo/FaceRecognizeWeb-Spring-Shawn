<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<!--     <p><a href="http://localhost:8080/sydney/JobPostHome">Job Post</a>
    <a href="http://localhost:8080/sydney/ResumeCentre">Resume Centre</a>
    <a href="http://localhost:8080/sydney/JobCentre">Jobs Centre</a>
    </p> -->
</head>
<body background="https://images.pexels.com/photos/994523/pexels-photo-994523.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940">
	<h3>Welcome, enter your personal information</h3>
	<form id="saveForm" action="FaceAddPerson" method="post">
	<div class="form-group">
		<table style="font-size: :16px" class="text-light" class="table">
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
				<td>Phone number</td>
				<td><input type="text" name="phonenumber" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><!-- <input type="text" name="gender" /> -->
				<select name="gender" name="gender" style="color:gray;">
			<option value="male">male</option>
			<option value="female">female</option>

		</select>
		</td>
			</tr>
			<tr>
				<td>Favor</td>
				<td><!-- <input type="text" name="favor" /> -->
				<select name="favor" name="favor"  style="color:gray;">
				<option value="black">Black</option>
			<option value="blue">Blue</option>
			<option value="white">White</option></td>
			</tr>
			<tr>
				<td>Height</td>
				<td><input type="text"  name="height" /></td>
			</tr>
			<tr>
				<!-- <td>FaceToken</td> -->
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
			</div>
		</table>
		<p>
		</p>
		<p>
		</p>
		<button onclick="window.location.href='FaceHome'" type="button" class="btn btn-secondary btn-sm font-weight-bold">Back
			to the home page</button>
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