<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<!--     <p><a href="http://localhost:8080/sydney/JobPostHome">Job Post</a>
    <a href="http://localhost:8080/sydney/ResumeCentre">Resume Centre</a>
    <a href="http://localhost:8080/sydney/JobCentre">Jobs Centre</a>
    </p> -->
</head>
<body>



	<h3>Welcome, what kind of products are you looking for?</h3>
	<table>
		<form id="saveForm" action="FaceQueryClothes"  modelAttribute="feedback" method="post">
		
				<tr>
					<td>Types</td>
					<td><select name=type value= modelAttribute="jobpost">
							<option value="Jacket">Jacket</option>
							<option value="T-shirt">T-shirt</option>
							<option value="Skirt">Skirt</option>
							<option value="Jeans">Jeans</option>
							<option value="Others">Others</option>
					</select></td>
				</tr>
				<tr>
					<td>Color</td>
					<td><select name=feedback value=black>
							<option value="black">Black</option>
							<option value="blue">Blue</option>
							<option value="white">White</option>
							<option value="others">Others</option>
					</select></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit" /></td>
					<td><input type="reset" value="Reset" /></td>
				</tr>
		</form>
		
		<p>${Clotheses}</p>
		<tr>

			<!-- <td>Feedback id</td> -->
			<td>Color</td>
			<td>Types</td>
			<td>Location</td>
			<td>Price</td>

		</tr>

		<c:forEach items="${Clotheses}" var="Clothes">

			<tr>

				<td>${Clothes.color}</td>

				<td>${Clothes.type}</td>

				<td>${Clothes.location}</td>
				
				<td>${Clothes.price}</td>
				
			</tr>

		</c:forEach>
		
		
		
		
		</table>
</body>
</html>
