<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>

<html lang="en">
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<title>certification</title>
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
			<h3 class="text-center">인증창</h3>
			<div class="login-form">
			<!--  인증값 입력구간  start-->
				<div class="form-group">
					<label for="certification_value" class="placeholder"><b>인증값을 입력해주세요</b></label>
					 <input id="certification_value" name="certification_value" type="text" class="form-control" placeholder="XXXX-XXXX-XXXX" required>
				</div>
			<!--  인증값 입력구간  end -->	
		    
		    <!--  버튼 2개 구간 start -->
				<div class="row form-action">
					<div class="col-md-6">
						<a href="#" id="" class="btn btn-danger btn-link w-100 fw-bold">main으로돌아가기</a>
					</div>
					<div class="col-md-6">
						<a href="#" class="btn btn-primary w-100 fw-bold">Submit</a>
					</div>
				</div>
	       <!--  버튼 2개 구간 end -->
							
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