<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
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
    
    
    
</body>
</html>
