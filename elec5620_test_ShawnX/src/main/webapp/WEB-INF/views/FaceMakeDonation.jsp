<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body background="https://images.pexels.com/photos/994523/pexels-photo-994523.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940">


<!--  class="text-white" -->
	<h3 class="container-fluid text-light">Welcome, feel free to make your donation~</h3>
	<form id="saveForm" action="FaceAddDonation" method="post">
		<table style="font-size: :18px" class="text-light">
			<tr>
				<td class="text-light">Type</td>
				<td><select name="type" name="type" class="form-control form-control-sm">
						<option value="Jacket">Jacket</option>
						<option value="T-shirt">T-shirt</option>
						<option value="Skirt">Skirt</option>
						<option value="Jeans">Jeans</option>
						<option value="Others">Others</option>

				</select></td>
			</tr>
			<tr>
				<td class="text-light">Color</td>
				<td><select name="color" name="color" class="form-control form-control-sm">
						<option value="black">Black</option>
						<option value="blue">Blue</option>
						<option value="white">White</option>
						<option value="others">Others</option>
				</select></td>
			</tr>
			<tr ><td>Description:</td><td> <input type="text" name="description"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" class="btn btn-secondary btn-lg"/></td>
				<td><input type="reset" value="Reset" class="btn btn-secondary btn-lg" /></td>
			</tr>
		</table>
	</form>
	<p></p>
			<button onclick="window.location.href='FaceHome'" type="button" class="btn btn-secondary btn-lg font-weight-bold">Back
			to home page</button></div>
</body>
</html>
