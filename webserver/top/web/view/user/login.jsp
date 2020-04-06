<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<title>Login</title>
	<meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no' name='viewport' />
	<link rel="icon" href="assets/img/icon.ico" type="image/x-icon"/>

	<!-- Fonts and icons -->
	<script src="assets/js/plugin/webfont/webfont.min.js"></script>
	<script>
		WebFont.load({
			google: {"families":["Open+Sans:300,400,600,700"]},
			custom: {"families":["Flaticon", "Font Awesome 5 Solid", "Font Awesome 5 Regular", "Font Awesome 5 Brands"], urls: ['assets/css/fonts.css']},
			active: function() {
				sessionStorage.fonts = true;
			}
		});
	</script>
	
	<!-- CSS Files -->
	<link rel="stylesheet" href="assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/css/azzara.min.css">
</head>

<body class="login">
	<div class="wrapper wrapper-login">
		<div class="container container-login animated fadeIn">
			<h3 class="text-center">LOGIN</h3>
			<div class="login-form">
			<form class="loginform" action="loginimpl.top" method="post"
				novalidate="novalidate">	
					<!--  ID 입력 START -->
					<div class="form-group">
						<label for="ID" class="placeholder"><b>ID</b></label> <input
							id="ID" name="ID" type="text" class="form-control" required>
					</div>
					<!--  ID 입력 END -->

					<!--  PASSWORD 입력 START -->
					<div class="form-group">
						<label for="password" class="placeholder"><b>Password</b></label>
						<a href="#" class="link float-right">Forget Password ?</a>
						<div class="position-relative">
							<input id="password" name="password" type="password"
								class="form-control" required>
							<div class="show-password">
								<i class="flaticon-interface"></i>
							</div>
						</div>
					</div>
					<!--  PASSWORD 입력 END -->

					<!-- 마지막 제출하기 구간 START -->
					<div class="form-group form-action-d-flex mb-3">
						<div class="custom-control custom-checkbox">
							<input type="checkbox" class="custom-control-input"
								id="rememberme"> <label class="custom-control-label m-0"
								for="rememberme">Remember Me</label>
						</div>

						<button
							class="btn btn-primary col-md-5 float-right mt-3 mt-sm-0 fw-bold"
							type="submit" value="submit" class="btn_3">log in</button>

					</div>

					<div class="login-account">
						<span class="msg">Don't have an account yet ?</span> <a href="#"
							id="show-signup" class="link">Sign Up</a>
					</div>
					<!-- 마지막 제출하기 구간 END -->
			</form>
		</div>
	</div>
</div>

	<script src="assets/js/core/jquery.3.2.1.min.js"></script>
	<script src="assets/js/plugin/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
	<script src="assets/js/core/popper.min.js"></script>
	<script src="assets/js/core/bootstrap.min.js"></script>
	<script src="assets/js/ready.js"></script>
</body>
</html>