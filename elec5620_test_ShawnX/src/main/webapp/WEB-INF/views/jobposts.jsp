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
<title>Resume centre</title>
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
					<li><a href="JobPostHome"> Home <i
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
						<h3>All job posts</h3>
					</div>
					<div class="col-md-6 col-sm-5 co-xs-12 text-right">
						<div class="bread">
							<ol class="breadcrumb">
								<li><a href="JobPostHome">JobPost Home</a></li>
								<li><a href="ResumeCentre">Resume centre</a></li>
								<li><a href="JobCentre">Job centre </a></li>
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

						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="heading-inner first-heading">
								<p class="title">All jobs</p>
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
												<th>Postition</th>
												<th>Employment Type</th>
												<th>Requirements</th>
												<th>Poster Name</th>
												<th>Delete it?</th>
												<th>Edit it?</th>
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
														<h5>${JobPost.position}</h5>
													</td>
													<td>
														<h5>${JobPost.employmenttype}</h5>
													</td>
													<td>
														<h5>${JobPost.requirements}</h5>
													</td>
													<td>
														<h5>${JobPost.postername}</h5>
													</td>
													<td>
														<a class="btn btn-primary btn-custom" href="<c:url value='/delete-${JobPost.id}-jobpost'/>">delete</a>
													</td>
													<td>
														<a class="btn btn-primary btn-custom" href="<c:url value='/edit-${JobPost.id}-jobpost'/>">edit</a>
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

	</div>

	<div class="modal add-resume-modal" tabindex="-1" role="dialog"
		aria-labelledby="">
		<div class="modal-dialog modal-md" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Add New Resume</h4>
				</div>
				<div class="modal-body">
					<div class="input-group image-preview form-group">
						<input type="text" class="form-control image-preview-filename"
							disabled="disabled"> <span class="input-group-btn">
							<button type="button" class="btn btn-default image-preview-clear"
								style="display: none;">
								<span class="glyphicon glyphicon-remove"></span> Clear
							</button>
							<div class="btn btn-default image-preview-input">
								<span class="glyphicon glyphicon-folder-open"></span> <span
									class="image-preview-input-title">Browse</span> <input
									type="file" accept="file_extension" name="input-file-preview" />
							</div>
						</span>
					</div>
					<p>Only pdf and doc files are accepted</p>
				</div>
				<div class="modal-footer">
					<a href="" type="button" class="btn btn-default">Save Resume</a>
				</div>
			</div>
		</div>
	</div>

	<a href="#" class="scrollup"><i class="fa fa-chevron-up"></i></a>

	<%@ include file="Js.jsp"%>

</body>

</html>