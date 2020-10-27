<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!--Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html>
<head>
<title>ADMIN LOGIN</title>
<script src="/FinalWeb09/admins/js/jquery.min.js"></script>
<!-- Custom Theme files -->
<link href="/FinalWeb09/clients/css/login.css" rel="stylesheet"
	type="text/css" media="all" />
<!-- for-mobile-apps -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Classy Login form Responsive, Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<!-- //for-mobile-apps -->
<!--Google Fonts-->
<link href='//fonts.googleapis.com/css?family=Roboto+Condensed:400,700'
	rel='stylesheet' type='text/css'>
</head>
<body>
	<!--header start here-->
	<div class="header">
		<div class="header-main">
			<h1>Log In</h1>
			<p>${errMsg }</p>
			<div class="header-bottom">
				<div class="header-right w3agile">

					<div class="header-left-bottom agileinfo">

						<form action="/FinalWeb09/login-client" method="post">
							<input type="text" value="User name" name="userName"
								onfocus="this.value = '';"
								onblur="if (this.value == '') {this.value = 'User name';}" /> <input
								type="password" value="Password" name="matKhau"
								onfocus="this.value = '';"
								onblur="if (this.value == '') {this.value = 'password';}" />
							<div class="remember">
								<span class="checkbox1"> <label class="checkbox"><input
										type="checkbox" name="" checked=""><i> </i>Remember me</label>
								</span>
								<div class="forgot">
									<h6>
										<a href="#">Forgot Password?</a>
									</h6>
								</div>
								<div class="clear"></div>
							</div>

							<input type="submit" value="Login">
						</form>
						<div class="header-left-top">
							<div class="sign-up">
								<h2>or</h2>
							</div>

						</div>
						<div class="header-social wthree">
							<a href="https://vi-vn.facebook.com" class="face"><h5>Facebook</h5></a>
							<a href="/FinalWeb09/dangki" class="twitt"><h5>SignUp</h5></a>
						</div>

					</div>
				</div>

			</div>
		</div>
	</div>
	<!--header end here-->

	<!--footer end here-->
</body>
</html>