<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">

<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
    <!--[if IE]>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
<![endif]-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ScriptsBundle">
    <title>JobSeeker Login</title>
    <%@ include file="Header.jsp" %>
</head>

<body>
<script type="text/javascript">
/* Fn();
     function Fn(){ 
        if (${PersonInfo}==null)
        	{
        	window.location.href = "http://localhost:8080/sydney/HomePage";
        	}
     }
         */
  
</script>




    <div class="page category-page">
        <div id="spinner">
            <div class="spinner-img"> <img alt="Opportunities Preloader" src="images/loader.gif" />
                <h2>Please Wait.....</h2>
            </div>
        </div>
        <section class="login-page-4 parallex">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                    <form method="POST" action="JobPosterLogin" modelAttribute="login">
                        <div class="login-container">
                            <div class="loginbox">
                                <img src="${careerhubLogo}" alt="logo" class="img-responsive center-block">
                                <div class="loginbox-title">Welcome to Career Hub!</div>
                             <div class="loginbox-or">
                                    <div class="or-line"></div>
                                </div>
                                <div class="form-group">
                                    <label>Email: <span class="required">*</span></label>
                                    <input placeholder="" name ="email" class="form-control" type="email">
                                </div>
                                <div class="form-group">
                                    <label>Password: <span class="required">*</span></label>
                                    <input placeholder="" name="password" class="form-control" type="password">
                                </div>
                                <div class="form-group">
                                    <input name="name" value=${model.JobPosterInfo} class="form-control" type="hidden">
                                </div>
                                
                                <div class="loginbox-submit">
                                    <input type="submit" class="btn btn-default btn-block" value="Login">
                                </div>
                                <div class="loginbox-signup">
                                    <a href="jobPosterRegisterForm">Don't have a account?</a>
                                </div>
                            </div>
                        </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>

        <a href="#" class="scrollup"><i class="fa fa-chevron-up"></i></a>

        <%@ include file="Js.jsp" %>

        <script type="text/javascript">
            $(".full-page").height($(window).height());
            $(window).resize(function() {
                $(".full-page").height($(window).height());
            });
        </script>

    </div>
</body>

</html>