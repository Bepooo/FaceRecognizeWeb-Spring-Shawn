<!DOCTYPE html>
<html lang="en">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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
						<h3>Announcement</h3>
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
		<section class="post-job">
			<div class="container">
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12">
						<div class="box-panel">
							<div class="Heading-title black">
								<h3>Current announcement</h3>
								<div>
									<h3>${Announcement.content}</h3>
								</div>
							</div>
							<form id="saveForm" action="SubmitNewAnnouncement" method="post">

								<div class="col-md-12 col-sm-12 col-xs-12">
									<div class="form-group">
										<label>Write Announcement</label>
										<textarea name="content" id="ckeditor"></textarea>
									</div>
								</div>
								<div class="col-md-12 col-sm-12 col-xs-12">
									<input name="Submit" type="submit" value="Submit" />
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