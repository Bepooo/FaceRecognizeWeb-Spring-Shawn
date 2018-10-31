<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<head>
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<!--[if IE]>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
<![endif]-->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="ScriptsBundle">
<title>Admin Home</title>
<link rel="icon" href="images/favicon.ico" type="image/x-icon">

<%@ include file="Header.jsp"%>

</head>

<body>

	<div class="page category-page">
		<div id="spinner">
			<div class="spinner-img">
				<img alt="Opportunities Preloader" src="images/loader.gif" />
				<h2>Please Wait.....</h2>
			</div>
		</div>
		<nav id="menu-1" class="mega-menu fa-change-black" data-color="">
			<section class="menu-list-items">
				<ul class="menu-logo">
					<li><a href="index.html"> <img src="${careerhubLogo}"
							alt="logo" class="img-responsive">
					</a></li>
				</ul>
				<ul class="menu-links pull-right">
					<li><a href="adminHome"> Home <i
							class="fa fa-angle-down fa-indicator"></i></a></li>
					<li class="no-bg login-btn-no-bg"><a href="logout"
						class="login-header-btn"><i class="fa fa-sign-in"></i> Log Out</a></li>
				</ul>
			</section>
		</nav>
		<div class="clearfix"></div>

		<section class="job-breadcrumb">
			<div class="container">
				<div class="row">
					<div class="col-md-6 col-sm-7 co-xs-12 text-left">
						<h3>Job Database</h3>
					</div>
					<div class="col-md-6 col-sm-5 co-xs-12 text-right">
						<div class="bread">
							<ol class="breadcrumb">
								<li><a href="adminHome">Jobs Database</a></li>
								<li><a href="qaManagement">Q & A Mangement</a></li>
								<li><a href="announcementManagement">Announcement
										Management</a></li>

							</ol>
						</div>
					</div>
				</div>
			</div>
		</section>

		<section class="dashboard-body">
			<div class="container">
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12 nopadding">
						<div id="curve_chart" style="width: 900px; height: 500px"></div>

						<div class="col-md-8 col-sm-12 col-xs-12">
							<div class="heading-inner first-heading">
								<p class="title">All job posts</p>
							</div>
							<div class="resume-list">
								<div class="table-responsive">
									<table class="table  table-striped">
										<thead class="thead-inverse">
											<tr>
												<th>JobPostid</th>
												<th>Location</th>
												<th>Company</th>
												<th>Department</th>
												<th>Employment Type</th>
												<th>Delete it?</th>
												<th></th>
											</tr>
										</thead>
										<c:forEach items="${JobPosts}" var="JobPost">


											<tbody>
												<%-- <td>${QA.id}</td> --%>
												<tr>
													<th scope="row">${JobPost.id}</th>
													<td>
														<h5>${JobPost.location}</h5>
													</td>
													<td>
														<h5>${JobPost.company}</h5>
													</td>
													<td>
														<h5>${JobPost.department}</h5>
													</td>
													<td>
														<h5>${JobPost.employmenttype}</h5>
													</td>

													<td><a class="btn btn-primary btn-custom"
														href="<c:url value='/delete-${JobPost.id}-jobpost'/>">delete</a>
													</td>


												</tr>
										</c:forEach>
										</tbody>
									</table>
								</div>
							</div>

						</div>

					</div>

				</div>
			</div>
		</section>


		<a href="#" class="scrollup"><i class="fa fa-chevron-up"></i></a>

		<%@ include file="Js.jsp"%>


		<!-- CORE JS -->
		<script type="text/javascript" src="js/custom.js"></script>

		<!-- FOR THIS PAGE ONLY -->
		<script type="text/javascript" src="js/jquery.tagsinput.min.js"></script>
		<script type="text/javascript">
			$(".questions-category").select2({
				placeholder : "Select Post Category",
				allowClear : true,
				maximumSelectionLength : 3,
			/*width: "50%",*/
			});
			$('#tags').tagsInput({
				width : 'auto'
			});
		</script>

		<!-- CK-EDITOR -->
		<script src="http://cdn.ckeditor.com/4.5.10/standard/ckeditor.js"></script>
		<script type="text/javascript">
			CKEDITOR.replace('ckeditor');
		</script>
		<script type="text/javascript"
			src="https://www.gstatic.com/charts/loader.js"></script>
		<script type="text/javascript">
			google.charts.load('current', {
				'packages' : [ 'corechart' ]
			});
			google.charts.setOnLoadCallback(drawChart);

			function drawChart() {
				var data = google.visualization.arrayToDataTable([
						[ 'Time', 'Australia Employment Rate' ],
						[ '2017.01', 61 ], [ '2017.04', 61.3 ],
						[ '2017.07', 61.5 ], [ '2017.10', 61.5 ],
						[ '2017.10', 61.5 ], [ '2018.01', 62.2 ],
						[ '2018.04', 62 ], [ '2018.07', 63 ] ]);

				var options = {
					title : 'Company Performance',
					curveType : 'function',
					legend : {
						position : 'bottom'
					}
				};

				var chart = new google.visualization.LineChart(document
						.getElementById('curve_chart'));

				chart.draw(data, options);
			}
		</script>
	</div>
</body>

</html>