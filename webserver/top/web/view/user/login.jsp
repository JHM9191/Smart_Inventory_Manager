<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Login</title>
<meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no'
	name='viewport' />
<link rel="icon" href="assets/img/icon.ico" type="image/x-icon" />

<!-- Fonts and icons -->
<script src="assets/js/plugin/webfont/webfont.min.js"></script>
<script>
	WebFont.load({
		google : {
			"families" : [ "Open+Sans:300,400,600,700" ]
		},
		custom : {
			"families" : [ "Flaticon", "Font Awesome 5 Solid",
					"Font Awesome 5 Regular", "Font Awesome 5 Brands" ],
			urls : [ 'assets/css/fonts.css' ]
		},
		active : function() {
			sessionStorage.fonts = true;

		}
	});

	// radiobutton check ! 

	$(document).ready(function() {
		$('#ID').click(function() {
			var radioVal = $('input[name="radio"]:checked').val();
			if (radioVal == undefined) {
				alert("headquarter or user인지 체크해주세요");
			}
		})
	});
</script>

<!-- CSS Files -->
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/azzara.min.css">

<style>
.form-radio {
	display: inline-block;
	line-height: 20px;
	vertical-align: middle;
}

.form-radio::before {
	content: "";
	display: inline-block;
	width: 10px;
	height: 10px;
	background: #ffffff;
	border: 1px solid #e0e0e0;
	margin-right: 8px;
}

.form-radio::before {
	border-radius: 50%;
}

.input-radio {
	display: none;
}

.input-radio:checked+.form-radio::before {
	background: #749fbb;
}

.input-radio:checked+.form-radio {
	color: #749fbb;
}
</style>

</head>

<body class="login">
	<div class="wrapper wrapper-login">
		<div class="container container-login animated fadeIn">
			<h3 class="text-center">LOGIN</h3>
			<div class="login-form">
				<form class="loginform" action="loginimpl.top" method="post"
					novalidate="novalidate">

					<!--  ID  check box START -->
					<div class="row">
						<div class="col-xs-6 col-sm-3">
							<label for="login_user" class="placeholder"><b>check</b></label>
						</div>
						<div class="col-xs-6 col-sm-3">
							<span class="form-inline"> <input type="radio"
								class="input-radio" name="radio" id="radio1" value="hq">
								<label for="radio1" class="form-radio">HQ</label></span>

						</div>
						<div class="col-xs-6 col-sm-3">
							<span class="form-inline"> <input type="radio"
								class="input-radio" name="radio" id="radio2" value="user">
								<label for="radio2" class="form-radio">USER</label></span>
						</div>
					</div>
					<!--  ID  check box END -->



					<!--  ID 입력 START -->

					<div class="form-group">
						<label for="ID" class="placeholder"><b>*ID</b></label> <input
							id="ID" name="ID" type="text" class="form-control" required>
					</div>
					<!--  ID 입력 END -->

					<!--  PASSWORD 입력 START -->
					<div class="form-group">
						<label for="password" class="placeholder"><b>*Password</b></label>
						<div class="position-relative">
							<input id="password" name="password" type="password"
								class="form-control" required>

						</div>
					</div>
					<!--  PASSWORD 입력 END -->

					<!-- 마지막 제출하기 구간 START -->
					<div class="form-group form-action-d-flex mb-3">
						<div class="custom-control custom-checkbox">
							<input type="checkbox" class="custom-control-input"
								id="rememberme"> <label class="custom-control-label m-0"
								for="rememberme" onclick="lsRememberMe()">Remember Me</label>
						</div>

						<button
							class="btn btn-primary col-md-5 float-right mt-3 mt-sm-0 fw-bold"
							type="submit" value="submit" class="btn_3" id="login">log
							in</button>

					</div>


					<div class="login-account">
						<span class="msg">회원이 아니시나요?</span> <br>
						<a href="signup.top" class="link">가입하기</a>
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
	<script src="assets/js/logincheckup.js"></script>
</body>
</html>