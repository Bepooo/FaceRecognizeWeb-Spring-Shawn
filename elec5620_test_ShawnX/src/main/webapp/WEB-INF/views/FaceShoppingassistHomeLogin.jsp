<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<body background="https://images.pexels.com/photos/994523/pexels-photo-994523.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940">
<div class="clearfix" style="margin-bottom: 50px;"></div>


	<h3 class="container-fluid text-light">Welcome Shoppingassist Login</h3>
	<table>
		<form id="saveForm" action="FaceShoppingassistLogin"  modelAttribute="shoppingassist" method="post">
		<tr>
				<td class="text-light">Name</td>
				<td><input type="text" name="name" /></td>
			</tr>
			
			<tr>
				<td class="text-light">Password</td>
				<td><input type="text" name="password" /></td></tr>
				<tr>
					<td><input type="submit" value="Submit" class="btn btn-secondary btn-lg" /></td>
					<td><input type="reset" value="Reset" class="btn btn-secondary btn-lg" /></td>
				</tr>
		</form>	
		
		</table>
		
		<p></p>
			<button onclick="window.location.href='FaceHome'" type="button" class="btn btn-secondary btn-lg font-weight-bold">Back
			to home page</button>
		
</body>
</html>
