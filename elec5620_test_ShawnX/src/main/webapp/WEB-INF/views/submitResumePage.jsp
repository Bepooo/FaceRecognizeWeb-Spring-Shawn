<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<head>
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="ScriptsBundle">
<title>Resume</title>
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
						<h3>Post A Job</h3>
					</div>
					<div class="col-md-6 col-sm-5 co-xs-12 text-right">
						<div class="bread">
							<ol class="breadcrumb">
								<li><a href="jobSeekerViewAllJobPosts">JobSeeker Homes</a></li>
								<li><a href="jobSeekerManageResumes">Manage your Resumes</a></li>
							</ol>
						</div>
					</div>
				</div>
			</div>
		</section>
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="box-panel">
						<div class="Heading-title black">
							<h3>Apply a job</h3>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
								sed do eiusmod tempor.At vero eos et accusamus et iusto odio
								dignissimos ducimus qui blanditiis praesentium</p>
						</div>
						<form class="row" id="saveForm" action="save-${model}-resume"
							method="post">
							<div class="col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label>JobPost Id : ${model}</label> <input type="hidden" value="${model}"
										name="model"  class="form-control">
								</div>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label>Name</label> <input type="text" value="${Resume.name }"
										placeholder="Name "name="name" class="form-control">
								</div>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label>Age</label> <input type="text" value="${Resume.age }"
										placeholder="Age"name="age" class="form-control">
								</div>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label>Gender</label> <select
										class="questions-category form-control" name="gender">
										<option value="Male">Male</option>
										<option value="Female">Female</option>
									</select>
								</div>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label>Education</label> <input type="text"
										value="${Resume.education }" name="education"
										 placeholder="Education" class="form-control">
								</div>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label>Capability</label> <input type="text"
										value="${Resume.capability }" name="capability"
										 placeholder="Capability"class="form-control">
								</div>
							</div>
							<div class="col-md-12 col-sm-12 col-xs-12">
								<input class="btn btn-default pull-right" type="submit"
									value="Submit"><i class="fa fa-angle-right"></i></input>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<a href="#" class="scrollup"><i class="fa fa-chevron-up"></i></a>


	<%@ include file="Js.jsp"%>


	<!-- CK-EDITOR -->
	<script src="http://cdn.ckeditor.com/4.5.10/standard/ckeditor.js"></script>
	<script type="text/javascript">
		CKEDITOR.replace('ckeditor');
	</script>
	</div>
</body>

</html>