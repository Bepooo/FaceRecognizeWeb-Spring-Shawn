<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<a href="http://localhost:8080/sydney/adminHome">Jobs Database</a>
    <a href="http://localhost:8080/sydney/qaManagement">Q & A Mangement</a>
    <a href="http://localhost:8080/sydney/announcementManagement">Announcement Management</a>
</head>
<body>


<p>${Announcement}</p>
<div>
	<h3>Current announcement here~</h3>
				<td>${Announcement.content}</td>
</div>

<div>
<button onclick="window.location.href='WriteNewAnnouncement'" type="button">Write a new announcement</button>
<button onclick="window.location.href='adminHome'" type="button">Back
			to admin home page</button>
</div>


</body>
</html>
