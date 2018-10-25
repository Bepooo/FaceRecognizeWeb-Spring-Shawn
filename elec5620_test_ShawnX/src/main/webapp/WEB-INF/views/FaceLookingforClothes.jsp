<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>


<body background="https://images.pexels.com/photos/994523/pexels-photo-994523.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940">
<div class="clearfix" style="margin-bottom: 50px;"></div>


	<h3 class="container-fluid text-light">
	<span style="font-size:40px;color:white;">Welcome, what kind of products are you looking for?</span>
	</h3>
	<table>
		<form id="saveForm" action="FaceQueryClothes"  modelAttribute="feedback" method="post">
		
	
		
		
		
				<tr>
					<td><span style="font-size:20px;color:white;">Types</span></td>
					
					
					<td><select name=type value= modelAttribute="jobpost" class="custom-select" style="color:gray;">
							<option value="Jacket">Jacket</option>
							<option value="T-shirt">T-shirt</option>
							<option value="Skirt">Skirt</option>
							<option value="Jeans">Jeans</option>
							<option value="Others">Others</option>
					</select></td>
					
				</tr>
				
				
				
				<tr>
					<td><span style="font-size:20px;color:white;">Color</span></td>
					<td><select name=feedback value=black class="custom-select " style="color:gray;">
							<option value="black">Black</option>
							<option value="blue">Blue</option>
							<option value="white">White</option>
							<option value="others">Others</option>
					</select></td>
				</tr>
				<tr>
				
			
				
				
				
					<td><button type="submit" class="btn btn-submit btn-lg">Submit</button></td>
					<td><input type="reset" value="Reset"  class="btn btn-submit btn-lg" /></td>
				</tr>
		</form>
		</table>
		<table id="1" style="display:none;">
		<p>${Clotheses}</p>
		<tr >

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
		<button onclick="window.location.href='FaceHome'" type="button" class="btn btn-secondary btn-lg font-weight-bold">Back
			to the home page</button>
</body>
</html>
