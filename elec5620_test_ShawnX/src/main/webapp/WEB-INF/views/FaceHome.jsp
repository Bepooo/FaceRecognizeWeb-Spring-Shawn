<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<title>Trandiano</title>
</head>
<body background="https://images.pexels.com/photos/994523/pexels-photo-994523.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940">
<div class="clearfix" style="margin-bottom: 50px;"></div>
<h1  class="container-fluid text-light">
	Welcome to Trandiano~ 
</h1>
<div class="container-fluid">
<p class="text-light">Welcome~ The time is ${serverTime}. </p>
<div>
<table>
<h3>
<button onclick="window.location.href='FaceLookingfor'" type="button" class="btn btn-secondary btn-lg">Looking for Something</button>
<div class="clearfix" style="margin-bottom: 30px;"></div>
</h3>

<h3>
<button onclick="window.location.href='FaceRegisterHome'" type="button" class="btn btn-secondary btn-lg">Register</button>
<button onclick="window.location.href='FaceLoginHome'" type="button" class="btn btn-secondary btn-lg">Customer Log in</button>
<div class="clearfix" style="margin-bottom: 30px;"></div>
</h3>

<h3>
<button onclick="window.location.href='FaceWriteFeedback'" type="button" class="btn btn-secondary btn-lg">Write Feedback</button>
<button onclick="window.location.href='FaceMakeDonation'" type="button" class="btn btn-secondary btn-lg">Make Donation</button>
<div class="clearfix" style="margin-bottom: 100px;"></div>
</h3>
<p>
<button onclick="window.location.href='FaceShoppingassistHomeLogin'" type="button" class="btn btn-outline-dark"">Employee Log in</button>
</p>
<p>
<button onclick="window.location.href='FaceFacebookLogin'" type="button" class="btn btn-outline-dark"">Techies login</button>
<div class="clearfix" style="margin-bottom: 30px;"></div>

</p>
</table>
</div>

</body>
</html>
