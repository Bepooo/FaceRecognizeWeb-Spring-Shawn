<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<a href="http://localhost:8080/sydney/adminHome">Jobs Database</a>
<a href="http://localhost:8080/sydney/qaManagement">Q & A Mangement</a>
<a href="http://localhost:8080/sydney/announcementManagement">Announcement
	Management</a>
</head>
<body>


	<p>${Announcements}</p>

	<h3>Write new announcement here~</h3>
	<c:forEach items="${Announcements}" var="Announcement">

		<tr>
			<td>${Announcement.id}</td>
			<td>${Announcement.content}</td>
		</tr>
		<%-- 	<form id="saveForm"  action="WriteNewAnnouncement"  method="post">
		Announcement:<input type="text" value=${Announcement.content}  style="width: 300px; height: 400px;"
			name="content" /> <input name="Submit" type="submit"
			value="Submit" /> <input type="reset" value="Reset" />
		<button onclick="window.location.href='adminHome'" type="button">Back
			to admin home page</button>
	</FORM> --%>

	</c:forEach>





</body>
</html>
