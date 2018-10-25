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


	<h2 class="text-white">Welcome, feel free to give us your feedback~</h2>
	<form id="saveForm" action="FaceSubmitFeedback"  modelAttribute="feedback" method="post">

<h3 class="text-white">Then, we will try our best to improve~
</h3>
<div class="form-row">
    <div class="col-4">
<div class="text-white">
		<p>Feedback type:</p> <select name="type" value=  modelAttribute="jobpost" class="form-control form-control-sm">
			<option value="type a">aaaaaaaaaaaaa</option>
			<option value="type b">bbbbbbbbbbbbb</option>
			<option value="type c">ccccccccccccc</option>
			<option value="type d">ddddddddddddd</option>
		</select>
		</div>
		</div>
		</div>
		
		 <input type="text" style="width: 415px; height: 200px;"
			name="feedback" /> 
			<div>
			<input name="Submit" type="submit"	value="Submit" class="btn btn-secondary btn-lg"/> 
			<input type="reset" value="Reset" class="btn btn-secondary btn-lg"/>
			</div>
			<p></p>
			<div>
		<button onclick="window.location.href='FaceHome'" type="button" class="btn btn-secondary btn-lg font-weight-bold">Back
			to home page</button></div>
	</form>
</body>
</html>
