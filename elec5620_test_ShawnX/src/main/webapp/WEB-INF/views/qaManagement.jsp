<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<a href="http://localhost:8080/sydney/adminHome">Jobs Database</a>
    <a href="http://localhost:8080/sydney/qaManagement">Q & A Mangement</a>
    <a href="http://localhost:8080/sydney/announcementManagement">Announcement Management</a>
</head>
<body>



	<h3>Write new announcement here~</h3>
	<form id="saveForm" action="WriteNewAnnouncement"  modelAttribute="feedback" method="post">


		Announcement:<input type="text" style="width: 300px; height: 400px;"
			name="announcement" /> <input name="Submit" type="submit"
			value="Submit" /> <input type="reset" value="Reset" />
		<button onclick="window.location.href='adminHome'" type="button">Back
			to admin home page</button>
	</FORM>
</body>
</html>
