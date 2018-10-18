<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Woolies</title>
</head>
<body>
<h1>
	Welcome to Woolworths!  
</h1>
<button onclick="window.location.href='FaceRegisterHome'" type="button">Register VIP</button>
<button onclick="window.location.href='FaceLoginHome'" type="button">Customer Log in</button>
<button onclick="window.location.href='FaceEmployeeLoginHome'" type="button">Employee Log in</button>
<P>  Welcome~ The time on the server is ${serverTime}. </P>
</body>
</html>
