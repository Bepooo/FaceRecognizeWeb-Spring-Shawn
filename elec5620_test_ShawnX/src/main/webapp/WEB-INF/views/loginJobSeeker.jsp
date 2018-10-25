<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
</head>
<body>



	<h3>Welcome, Log in</h3>
	<table>
		<form id="saveForm" action="JobSeekerlogin"  modelAttribute="jobSeeker" method="post">
		<tr>
				<td>Name</td>
				<td><input type="text" name="name" /></td>
			</tr>
			
			<tr>
				<td>Password</td>
				<td><input type="text" name="password" /></td></tr>
				<tr>
					<td><input type="submit" value="Submit" /></td>
					<td><input type="reset" value="Reset" /></td>
				</tr>
		</form>	
		
		</table>
</body>
</html>
