
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="author" content="ScriptsBundle">
    <title>Career Hub</title>

    <%@ include file="Header.jsp"%>
</head>

<body>
    <div class="page">
        <div id="spinner">
            <div class="spinner-img"> <img alt="Opportunities Preloader" src="images/loader.gif" />
                <h2>Please Wait.....</h2>
            </div>
        </div>
        <nav id="menu-1" class="mega-menu fa-change-black" data-color="">
            <section class="menu-list-items">
                <div class="container">
                    <ul class="menu-logo">
                        <li>
                            <a href="/"> <img src="${careerhubLogo}" alt="logo" class="img-responsive"> </a>
                        </li>
                    </ul>
                    <ul class="menu-links pull-right">
                        <li> <a href="javascript:void(0)"> Home <i class="fa fa-angle-down fa-indicator"></i></a>
                </li>
                 </ul>       
            </section>
        </nav>
        <div class="clearfix"></div>
        <div class="search">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12 nopadding">
                        <div class="input-group">
                            <div class="input-group-btn search-panel">
                                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"> <span id="search_concept">Filter By</span> <span class="caret"></span> </button>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="#">By Company</a></li>
                                    <li><a href="#">By Function</a></li>
                                    <li><a href="#">By City </a></li>
                                    <li><a href="#">By Salary </a></li>
                                    <li><a href="#">By Industry</a></li>
                                </ul>
                            </div>
                            <input type="hidden" name="search_param" value="all" id="search_param">
                            <input type="text" class="form-control search-field" name="x" placeholder="Search term...">
                            <span class="input-group-btn">
                        <button class="btn btn-default" type="button"><span class="fa fa-search"></span></button>
                            </span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <section class="index5-main-section">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-6 col-sm-6 col-xs-12 nopadding">
                        <div class="employer-main-section parallex-employer">
                            <h1>Hundreds of users searching for their Dream Job.</h1>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor.At vero eos et accusamus et iusto.</p>
                            <a href="JobPosterLoginHome" class="btn-default"> Poster Sign in <i class="fa fa-angle-right"></i> </a>
                        <a href="jobPosterRegisterForm" class="btn-default">Poster Register <i class="fa fa-angle-right"></i> </a>
                       
                        </div>
                    </div>
                    <div class="col-md-6 col-sm-6 col-xs-12 nopadding">
                        <div class="employee-main-section parallex-employee">
                            <h1>The Best and Easiest way to get your New Dream job.</h1>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor.At vero eos et accusamus et iusto.</p>
                            <a href="JobSeekerLoginForm" class="btn-default">Seeker Sign In <i class="fa fa-angle-right"></i></a>
                       		<a href="JobSeekerRegisterForm" class="btn-default">Seeker Register <i class="fa fa-angle-right"></i> </a> 
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section class="light-grey">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="Heading-title black">
                            <h1>Latest Jobs</h1>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor.At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium</p>
                        </div>
                    </div>
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="all-jobs-list-box2">
                            <div class="job-box job-box-2">
                                <div class="col-md-2 col-sm-2 col-xs-12 hidden-sm">
                                    <div class="comp-logo">
                                     
                                    </div>
                                </div>
                                <div class="col-md-10 col-sm-10 col-xs-12">
                                    <div class="job-title-box">
                                        <a href="#">
                                            <div class="job-title"> Technical Documentation Specialist</div>
                                        </a> <a href="#"><span class="comp-name">conversi Pvt. Ltd. United States </span></a>
                                        <a href="" class="job-type jt-full-time-color"> <i class="fa fa-clock-o"></i> Full time </a>
                                    </div>
                                    <p>Prompta numquam mel ad, tempor definiebas id usu, cum cu feugiat bonorum. Eu pri labores maiorum patrioque, sea an tation utinam. Idque albucius prodesset ei est, sea te vide contentiones consectetuer.......<a href="">Read More</a> </p>
                                </div>
                                <div class="job-salary"> <i class="fa fa-money"></i> $400 - $500 </div>
                            </div>
                            <div class="job-box job-box-2">
                                <div class="col-md-2 col-sm-2 col-xs-12  hidden-xs hidden-sm">
                                    <div class="comp-logo">
                                      
                                    </div>
                                </div>
                                <div class="col-md-10 col-sm-10 col-xs-12">
                                    <div class="job-title-box">
                                        <a href="#">
                                            <div class="job-title"> Assistant Engineer (IT/Networks)</div>
                                        </a> <a href="#"><span class="comp-name">conversi Pvt. Ltd. Malaysia</span></a>
                                        <a href="" class="job-type jt-part-time-color"> <i class="fa fa-clock-o"></i> Part Time </a>
                                    </div>
                                    <p>Prompta numquam mel ad, tempor definiebas id usu, cum cu feugiat bonorum. Eu pri labores maiorum patrioque, sea an tation utinam. Idque albucius prodesset ei est, sea te vide contentiones consectetuer.......<a href="">Read More</a> </p>
                                </div>
                                <div class="job-salary"> <i class="fa fa-money"></i> $200 - $300 </div>
                            </div>
                            <div class="job-box job-box-2">
                                <div class="col-md-2 col-sm-2 col-xs-12  hidden-xs hidden-sm">
                                    <div class="comp-logo">
                                     
                                    </div>
                                </div>
                                <div class="col-md-10 col-sm-10 col-xs-12">
                                    <div class="job-title-box">
                                        <a href="#">
                                            <div class="job-title"> Technical Network Director (IT/Networks)</div>
                                        </a> <a href="#"><span class="comp-name">conversi Pvt. Ltd. United States</span></a>
                                        <a href="" class="job-type jt-remote-color"> <i class="fa fa-clock-o"></i> Remote </a>
                                    </div>
                                    <p>Prompta numquam mel ad, tempor definiebas id usu, cum cu feugiat bonorum. Eu pri labores maiorum patrioque, sea an tation utinam. Idque albucius prodesset ei est, sea te vide contentiones consectetuer.......<a href="">Read More</a> </p>
                                </div>
                                <div class="job-salary"> <i class="fa fa-money"></i> $200 - $250 </div>
                            </div>
                            <div class="job-box job-box-2">
                                <div class="col-md-2 col-sm-2 col-xs-12  hidden-xs hidden-sm">
                                    <div class="comp-logo">
                                       
                                    </div>
                                </div>
                                <div class="col-md-10 col-sm-10 col-xs-12">
                                    <div class="job-title-box">
                                        <a href="#">
                                            <div class="job-title"> Technical Documentation Specialist</div>
                                        </a> <a href="#"><span class="comp-name">conversi Pvt. Ltd. United States</span></a>
                                        <a href="" class="job-type jt-intern-color"> <i class="fa fa-clock-o"></i> Internship </a>
                                    </div>
                                    <p>Prompta numquam mel ad, tempor definiebas id usu, cum cu feugiat bonorum. Eu pri labores maiorum patrioque, sea an tation utinam. Idque albucius prodesset ei est, sea te vide contentiones consectetuer.......<a href="">Read More</a> </p>
                                </div>
                                <div class="job-salary"> <i class="fa fa-money"></i> $100 - $150 </div>
                            </div>
                            <div class="col-md-12 col-sm-12 col-xs-12">
                               
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section class="facts">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6 col-md-3 col-xs-6">
                        <div class="fact-box">
                            <div class="single-facts-area">
                                <div class="facts-icon"> <i class="icon-megaphone"></i> </div>
                                <span class="counter">180</span>
                                <h3>Jobs</h3>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-md-3 col-xs-6">
                        <div class="fact-box">
                            <div class="single-facts-area">
                                <div class="facts-icon"> <i class="icon-document"></i> </div>
                                <span class="counter">175</span>
                                <h3> Resume </h3>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-md-3 col-xs-6">
                        <div class="fact-box">
                            <div class="single-facts-area">
                                <div class="facts-icon"> <i class="icon-profile-male"></i> </div>
                                <span class="counter">20</span>
                                <h3>Members</h3>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-md-3 col-xs-6">
                        <div class="fact-box">
                            <div class="single-facts-area">
                                <div class="facts-icon"> <i class="icon-toolbox"></i> </div>
                                <span class="counter">2142</span>
                                <h3>Company</h3>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section id="categories-section-2">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12 nopadding">
                        <div class="categories-section-2">
                            <ul id="popular-categories">
                                <li><a href="#"><i class="fa fa-line-chart"></i> Accounting Jobs <span>( 230 )</span></a></li>
                                <li><a href="#"><i class="fa fa-wrench"></i> Automotive Jobs <span>( 930 )</span></a></li>
                                <li><a href="#"><i class="fa fa-building-o"></i> Construction Jobs <span>( 560 )</span></a></li>
                                <li><a href="#"><i class="fa fa-graduation-cap"></i> Educational Jobs <span>( 150 )</span></a></li>
                                <li><a href="#"><i class="fa fa-medkit"></i> Healthcare Jobs <span>( 458 )</span> </a></li>
                                <li><a href="#"><i class="fa fa-cutlery"></i> Food Service Jobs <span>( 652 )</span></a></li>
                                <li><a href="#"><i class="fa fa-globe"></i> Logistics Jobs <span>( 552 )</span></a></li>
                                <li><a href="#"><i class="fa fa-laptop"></i> Telecom Jobs <span>( 87 )</span></a></li>
                                <li><a href="#"><i class="fa fa-home"></i> Real Estate Jobs <span>( 332 )</span></a></li>
                                <li><a href="#"><i class="fa fa-plane"></i> Designing Jons <span>( 85 )</span></a></li>
                            </ul>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
      
      
        <section class="download-app">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <h1>People always Love to use our App. <br>
                        Get it now and Enjoy</h1>
                </div>
            </div>
        </section>
        <div class="fixed-footer">
            <footer class="footer">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-6 col-md-3 col-xs-12">
                            <div class="footer_block">
                                <a href="index.html" class="f_logo"><img src="${careerhubLogo}" class="img-responsive" alt="logo"></a>
                                <p>Aoluptas sit aspernatur aut odit aut fugit, sed elits quias horisa hinoe magni  magni dolores eos qui ratione volust luptatem sequised .</p>
                                <div class="social-bar">
                                    <ul>
                                        <li>
                                            <a class="fa fa-twitter" href="#"></a>
                                        </li>
                                        <li>
                                            <a class="fa fa-pinterest" href="#"></a>
                                        </li>
                                        <li>
                                            <a class="fa fa-facebook" href="#"></a>
                                        </li>
                                        <li>
                                            <a class="fa fa-behance" href="#"></a>
                                        </li>
                                        <li>
                                            <a class="fa fa-instagram" href="#"></a>
                                        </li>
                                        <li>
                                            <a class="fa fa-linkedin" href="#"></a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6 col-md-2 col-xs-12">
                            <div class="footer_block">
                                <h4>Hot Links</h4>
                                <ul class="footer-links">
                                    <li> <a href="#">Home</a> </li>
                                    <li> <a href="AdminLoginForm">Admin Login</a> </li>
                                </ul>
                            </div>
                        </div>
                       
                        <div class="col-sm-6 col-md-3 col-xs-12">
                            <div class="footer_block">
                                <h4>Contact Information</h4>
                                <ul class="personal-info">
                                    <li><i class="fa fa-map-marker"></i> </li>
                                    <li><i class="fa fa-envelope"></i> </li>
                                    <li><i class="fa fa-phone"></i> </li>
                                    <li><i class="fa fa-clock-o"></i> </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </footer>
            <section class="footer-bottom-section">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="footer-bottom">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                        <p>Copyright ©2018 - CareerHub group team - All rights Reserved.</p>
                                        <p>Reproduction of material from scriptsBundle without permission is strictly prohibited. </p>
                                    </div>
                                    <div class="col-md-12 col-sm-12 col-xs-12 hidden-xs hidden-sm">
                                        <ul class="footer-menu">
                                            <li> <a href="#">Jobs in australia</a> </li>
                                            <li> <a href="#">Jobs in malaysia</a> </li>
                                            <li> <a href="#">Jobs in england</a> </li>
                                            <li> <a href="#">Jobs in saudi arabia</a> </li>
                                            <li> <a href="#">Jobs in south africa</a> </li>
                                            <li> <a href="#">Jobs in saudi Pakistan</a> </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>

        <a href="#" class="scrollup"><i class="fa fa-chevron-up"></i></a>

        <!-- JAVASCRIPT JS  -->
        <spring:url value="/resources/js/jquery-2.2.3.min.js" var="jquery223minJS" />
		<script src="${jquery223minJS}" type="text/javascript"></script>

        <!-- BOOTSTRAP CORE JS -->
        
        <spring:url value="/resources/js/bootstrap.min.js" var="bootstrapminJS" />
		<script src="${bootstrapminJS}" type="text/javascript"></script>
	

        <!-- JQUERY SELECT -->
        <spring:url value="/resources/js/select2.min.js" var="select2minJS" />
		<script src="${select2minJS}" type="text/javascript"></script>
        

        <!-- MEGA MENU -->
        <spring:url value="/resources/js/mega_menu.min.js" var="megamenuminJS" />
		<script src="${megamenuminJS}" type="text/javascript"></script>
	

        <!-- JQUERY EASING -->
        <spring:url value="/resources/js/easing.js" var="easingJS" />
		<script src="${easingJS}" type="text/javascript"></script>
		


        <!-- JQUERY COUNTERUP -->
        
        <spring:url value="/resources/js/counterup.js" var="counterupJS" />
		<script src="${counterupJS}" type="text/javascript"></script>
	

        <!-- JQUERY WAYPOINT -->
        <spring:url value="/resources/js/waypoints.min.js" var="waypointsminJS" />
		<script src="${waypointsminJS}" type="text/javascript"></script>

        <!-- JQUERY REVEAL -->
        <spring:url value="/resources/js/footer-reveal.min.js" var="footerrevealminJS" />
		<script src="${footerrevealminJS}" type="text/javascript"></script>

        <!-- Owl Carousel -->
        <spring:url value="/resources/js/owl-carousel.js" var="owlcarouselJS" />
		<script src="${owlcarouselJS}" type="text/javascript"></script>
        

        <!-- CORE JS -->
        <spring:url value="/resources/js/custom.js" var="customJS" />
		<script src="${customJS}" type="text/javascript"></script>
    </div>
</body>

</html>