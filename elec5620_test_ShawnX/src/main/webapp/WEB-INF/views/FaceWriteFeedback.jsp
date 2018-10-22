<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<!--     <p><a href="http://localhost:8080/sydney/JobPostHome">Job Post</a>
    <a href="http://localhost:8080/sydney/ResumeCentre">Resume Centre</a>
    <a href="http://localhost:8080/sydney/JobCentre">Jobs Centre</a>
    </p> -->
</head>
<body>



	<h3>Welcome, feel free to give us your feedback~</h3>
	<form id="saveForm" action="FaceSubmitFeedback"  modelAttribute="feedback" method="post">


		Your Feedback: <select name="type" value=  modelAttribute="jobpost">
			<option value="type a">a</option>
			<option value="type b">b</option>
			<option value="type c">c</option>
			<option value="type d">d</option>
		</select> <input type="text" style="width: 300px; height: 400px;"
			name="feedback" /> <input name="Submit" type="submit"
			value="Submit" /> <input type="reset" value="Reset" />
		<button onclick="window.location.href='FaceHome'" type="button">Back
			to home page</button>
	</FORM>
</body>
</html>
