<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>

</head>
<body>
	<h3>Welcome, new bee~</h3>
	<h3>Enter your username and password</h3>
	<form id="saveForm" action="AddNewJobSeeker" method="post">
		<table style="font-size: :16px">
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" /></td>
			</tr>
			
			<tr>
				<td>Password</td>
				<td><input type="text" name="password" /></td>
			</tr>
			<tr>
			<td>Email</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
				<td><input type="reset" value="Reset" /></td>
			</tr>
		</table>
		</form>
</body>
</html>