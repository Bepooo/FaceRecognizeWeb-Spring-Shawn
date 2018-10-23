<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>

</head>
<body>



	<h3>Welcome, feel free to make your donation~</h3>
	<form id="saveForm" action="FaceAddDonation" method="post">
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
				<input type="text" name="description" />
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
				<td><input type="reset" value="Reset" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
