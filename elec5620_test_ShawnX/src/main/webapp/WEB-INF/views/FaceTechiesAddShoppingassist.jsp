<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body class="p-3 mb-2 bg-secondary text-white">
	<h3>Welcome, developer~</h3>
	<h3>Enter new shopping assist information</h3>
	<form id="saveForm" action="FaceAddShoppingassist" method="post">
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
				<td><input type="submit" value="Submit" /></td>
				<td><input type="reset" value="Reset" /></td>
			</tr>
		</table>
		</form>
		<p>
		</p>
		<button onclick="window.location.href='FaceHome'" type="button" class="btn btn-warning btn-lg font-weight-bold">Back
			to home page</button></div>
			</body>
</html>