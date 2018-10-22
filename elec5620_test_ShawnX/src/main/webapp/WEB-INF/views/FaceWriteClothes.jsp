<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<!--     <p><a href="http://localhost:8080/sydney/JobPostHome">Job Post</a>
    <a href="http://localhost:8080/sydney/ResumeCentre">Resume Centre</a>
    <a href="http://localhost:8080/sydney/JobCentre">Jobs Centre</a>
    </p> -->
</head>
<body>
	<h3>Let's add some new products~</h3>
	<form id="saveForm" action="FaceAddClothes" method="post">
		<table style="font-size: :16px">
			<tr>
				<td>Type</td>
				<td><select name="type" name="type">
						<option value="Jacket">Jacket</option>
						<option value="T-shirt">T-shirt</option>
						<option value="Skirt">Skirt</option>
						<option value="Jeans">Jeans</option>
						<option value="Others">Others</option>

				</select></td>
			</tr>
			<tr>
				<td>Color</td>
				<td><select name="color" name="color">
						<option value="black">Black</option>
						<option value="blue">Blue</option>
						<option value="white">White</option>
						<option value="others">Others</option>
				</select></td>
			</tr>

			<tr>
				<td><select name="location" name="location">
						<option value="A">A</option>
						<option value="B">B</option>
						<option value="C">C</option>
				</select></td>
			</tr>

			<tr>
				<td>Price</td>
				<td><input type="text" name="price" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
				<td><input type="reset" value="Reset" /></td>
			</tr>
		</table>
		</form>
</body>
</html>