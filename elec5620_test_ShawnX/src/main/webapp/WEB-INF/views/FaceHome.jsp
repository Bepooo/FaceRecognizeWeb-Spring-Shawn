<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Trandiano</title>
</head>
<body>
<h1>
	Welcome to Trandiano~ 
</h1>
<button onclick="window.location.href='FaceLookingfor'" type="button">Looking for Something</button>
<button onclick="window.location.href='FaceRegisterHome'" type="button">Register</button>
<button onclick="window.location.href='FaceLoginHome'" type="button">Customer Log in</button>
<button onclick="window.location.href='FaceWriteFeedback'" type="button">Write Feedback</button>
<button onclick="window.location.href='FaceReadFeedback'" type="button">Read Feedback</button>
<button onclick="window.location.href='FaceEmployeeLoginHome'" type="button">Employee Log in</button>
<button onclick="window.location.href='FaceWriteClothes'" type="button">Add new Product</button>
<button onclick="window.location.href='FaceFacebookLogin'" type="button">Techies login</button>
<P>  Welcome~ The time on the server is ${serverTime}. </P>
</body>
</html>
