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
    <title>JobSeeker Register</title>
    <link rel="icon" href="images/favicon.ico" type="image/x-icon">
 	<%@ include file="Header.jsp" %>
</head>

<body>
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
                    <form method="POST" action="JobSeekerRegister" modelAttribute="register">
                        <div class="login-container">
                            <div class="loginbox">
                                <div class="loginbox-title">Please enter your information!</div>
                              <div class="loginbox-or">
                                    <div class="or-line"></div>
                                </div>
                                <div class="form-group">
                                    <label>Username: <span class="required">*</span></label>
                                    <input placeholder=""  name="name" class="form-control" type="text">
                                </div>
                                <div class="form-group">
                                    <label>Email: <span class="required">*</span></label>
                                    <input placeholder="" name="email" class="form-control" type="email">
                                </div>
                                <div class="form-group">
                                    <label>What's your favorite color? <span class="required">*</span></label>
                                    <input placeholder="" name="qanswer" class="form-control" type="text">
                                </div>
                                <div class="form-group">
                                    <label>Password: <span class="required">*</span></label>
                                    <input placeholder="" name="password" class="form-control" type="password"id="password"  onblur="validate()" >
                                </div>
                                <div class="form-group">
                                    <label>Confirm Password: <span class="required">*</span></label>
                                    <input placeholder="" class="form-control" type="password" id="confirm_password"  onblur="validate()">
                                </div>
                                <div class="loginbox-submit">
                                    <input type="submit" class="btn btn-default btn-block" value="Register">
                                </div>
                                <div class="loginbox-signup"> Already have account ? <a href="JobSeekerLoginForm">Sign in</a> </div>
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
        <script>
        function validatePassword(){
        	  if(password.value != confirm_password.value) {
        	    confirm_password.setCustomValidity("Passwords Don't Match");
        	  } else {
        	    confirm_password.setCustomValidity('');
        	  }
        	}

		</script>

    </div>
</body>

</html>