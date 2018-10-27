<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

	<title>Home</title>
</head>
<body class="p-3 mb-2 bg-secondary text-white">
<h1>
	Hello world! </h1>
	<h2> 
	Add New Shopping Assists in This Page~
</h2>
<div>
<P>  
    <a href="http://localhost:8080/sydney/FaceReadShoppingassist">Manage the shopping assist database</a> </P>
    </div>
    <div>
    
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
    </div>
    
    
    <button onclick="window.location.href='FaceHome'" type="button" class="btn btn-warning btn-lg font-weight-bold">Back
			to home page</button></div>
			<div><p>
			</p>
			<button onclick="window.location.href='FaceReadFeedback'" type="button" class="btn btn-warning btn-lg font-weight-bold">Read Feedbacks</button></div>
			<p>
			</p>
			<div>
			<button onclick="href='https://github.com/Bepooo/FaceRecognizeWeb-Spring-Shawn/commits/Shawn'" type="button" class="btn btn-warning btn-lg font-weight-bold">Historical Versions
</body>
</html>
