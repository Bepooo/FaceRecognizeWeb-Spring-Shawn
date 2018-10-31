<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">

<head>
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<!--[if IE]>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
<![endif]-->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="ScriptsBundle">
<title>Job center</title>
<link rel="icon" href="images/favicon.ico" type="image/x-icon">

<%@ include file="Header.jsp"%>
</head>

<body>

	<div class="page category-page">
		<div id="spinner">
			<div class="spinner-img">
				<img alt="Opportunities Preloader" src="${careerhubLogo}" />
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
					<li><a href="jobSeekerViewAllJobPosts"> Home <i
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
						<h3>All the job posts</h3>
					</div>
					<div class="col-md-6 col-sm-5 co-xs-12 text-right">
						<div class="bread">
							<ol class="breadcrumb">
								<li><a href="jobSeekerViewAllJobPosts">JobSeeker Home</a></li>
								<li><a href="jobSeekerManageResumes">Manage your
										Resumes</a></li>

							</ol>
						</div>
					</div>
				</div>
			</div>
		</section>
		<div id="map"></div>
		<script>
			var map;
			function initMap() {
				map = new google.maps.Map(document.getElementById('map'), {
					center : {
						lat : -34.397,
						lng : 150.644
					},
					zoom : 8
				});
			}
		</script>
		<script
			src="https://maps.googleapis.com/maps/api/js?key=AIzaSyC7S8Nji1WIfzLPGjrXqHj2evpuXCAE78s&callback=initMap"
			async defer></script>
		<section class="breadcrumb-search parallex">
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12 nopadding">
						<div
							class="col-md-8 col-sm-12 col-md-offset-2 col-xs-12 nopadding">
							<div class="search-form-contaner">
								<form class="form-inline" id="saveForm"
									action="jobSeekerQueryJobposts" modelAttribute="feedback"
									method="post">
									<div class="col-md-7 col-sm-7 col-xs-12 nopadding">
										<div class="form-group">
											<select name="type" class="select-category form-control">
												<option value="Fulltime">FullTime</option>
												<option value="Parttime">PartTime</option>
												<option value="Others">Others</option>
											</select>
										</div>
									</div>
									<div class="col-md-3 col-sm-3 col-xs-12 nopadding">
										<div class="form-group">
											<select name="feedback" class="select-category form-control">
												<option value="Sydney">Sydney</option>
												<option value="Melbourne">Melbourne</option>
												<option value="others">Others</option>
											</select>
										</div>
									</div>
									<div class="col-md-2 col-sm-2 col-xs-12 nopadding">
										<div class="form-group form-action">
											<input type="submit"
												class="btn btn-default btn-search-submit" value="Search">
											<i class="fa fa-angle-right"></i>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<section class="dashboard-body">
			<div class="container">
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12 nopadding">

						<div class="col-md-8 col-sm-12 col-xs-12">
							<div class="heading-inner first-heading">
								<p class="title">Jobs</p>
							</div>
							<div class="resume-list">
								<div class="table-responsive">
									<table class="table  table-striped">
										<thead class="thead-inverse">
											<tr>
												<th>JobPostid Type</th>
												<th>Postername</th>
												<th>Location</th>
												<th>Company</th>
												<th>Department</th>
												<th>Employment Type</th>
												<th>Apply?</th>
											</tr>
										</thead>
										<c:forEach items="${JobPosts}" var="JobPost">

											<tbody>
												<tr>
													<th scope="row">${JobPost.id}</th>
													<td>
														<h5>${JobPost.postername}</h5>
													</td>
													<td><h5>${JobPost.location}</h5></td>
													<td>
														<h5>${JobPost.company}</h5>
													</td>
													<td>
														<h5>${JobPost.employmenttype}</h5>
													</td>
													<td>
														<h5>${JobPost.jobdescription}</h5>
													</td>
													<td><a class="btn btn-primary btn-custom"
														href="<c:url value='/apply-${JobPost.id}-resume'/>">apply</a>
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
	</div>
	<a href="#" class="scrollup"><i class="fa fa-chevron-up"></i></a>

	<%@ include file="Js.jsp"%>

	</div>
</body>

</html>