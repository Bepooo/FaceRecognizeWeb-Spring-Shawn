<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<head>
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<!--[if IE]>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
<![endif]-->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="ScriptsBundle">
<title>Jobpost Home</title>
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
						<h3>JobPost Home</h3>
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
		<section class="post-job">
			<div class="container">
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="box-panel">
							<div class="Heading-title black">
								<h3>Post A job</h3>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
									sed do eiusmod tempor.At vero eos et accusamus et iusto odio
									dignissimos ducimus qui blanditiis praesentium</p>
							</div>
							<form class="row" method="POST" action="/sydney/addJobPost"
								modelAttribute="jobpost">
								<div class="col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label path="company">Company</label> <input type="text"
											path="company" name="company" placeholder="Company"
											class="form-control">
									</div>
								</div>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label path="location">Location</label> <select
											class="questions-category form-control" path="location"
											name="location" "
											class="form-control"">
											<option value="Sydney">Sydney</option>
											<option value="Melbourne">Melbourne</option>
											<option value="Others">Others</option>
										</select>
									</div>
								</div>
								
								<div class="col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label path="department">Department</label> <input type="text"
											path="department" name="department" placeholder="Department"
											class="form-control">
									</div>
								</div>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label path="position">Position</label> <input type="text"
											path="position" name="Position" placeholder="Position"
											class="form-control">
									</div>
								</div>

								<div class="col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label path="jobdescription"> Job Description</label> <input
											type="text" path="jobdescription" name="jobdescription"
											placeholder="Job Description" class="form-control">
									</div>
								</div>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label path="requirements">Requirements</label> <input
											type="text" path="requirements" name="requirements"
											placeholder="Requirements" class="form-control">
									</div>

								</div>
								<div class="col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label path="employmenttype">Employment Type</label> <select
											class="questions-category form-control" path="employmenttype"
											name="employmenttype">
											<option value="Fulltime">Fulltime</option>
											<option value="Parttime">Parttime</option>
										</select>
									</div>
								</div>

								<div class="col-md-6 col-sm-6 col-xs-12">
									<input class="btn btn-default pull-right" type="submit"
										value="Submit"><i class="fa fa-angle-right"></i></input>
								</div>
						</div>

						</form>
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
	</div>
</body>

</html>