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
	<h3 class="container-fluid text-light">Let's add some new products!</h3>
	<form id="saveForm" action="FaceAddClothes" method="post">
		<table style="font-size: :16px">
			<tr>
				<td class="text-light">Type</td>
				<td><select name="type" name="type">
						<option value="Jacket">Jacket</option>
						<option value="T-shirt">T-shirt</option>
						<option value="Skirt">Skirt</option>
						<option value="Jeans">Jeans</option>
						<option value="Others">Others</option>

				</select></td>
			</tr>
			<tr>
				<td class="text-light">Color</td>
				<td><select name="color" name="color">
						<option value="black">Black</option>
						<option value="blue">Blue</option>
						<option value="white">White</option>
						<option value="others">Others</option>
				</select></td>
			</tr>

			<tr>
				<td class="text-light">Location</td>
				<td><select name="location" name="location">
						<option value="A">A</option>
						<option value="B">B</option>
						<option value="C">C</option>
				</select></td>
			</tr>

			<tr>
				<td class="text-light">Price</td>
				<td><input type="text" name="price" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" class="btn btn-secondary btn-lg"/></td>
				<td><input type="reset" value="Reset" class="btn btn-secondary btn-lg"/></td>
			</tr>
		</table>
		
		<p>
</p>
<button onclick="javascript:history.back(-1);" type="button" class="btn btn-warning btn-lg font-weight-bold">Back
			to the last page</button>
		
		</form>
</body>
</html>