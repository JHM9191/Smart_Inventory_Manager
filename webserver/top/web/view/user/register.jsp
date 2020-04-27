<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />

<title>Register TEST</title>
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
			sessionStorage.fonts = false;
		}
	});

	document.domain = "127.0.0.1";

	function goPopup() {
		var pop = window.open("view/address/jusoPopup.jsp", "pop",
				"width=570,height=420, scrollbars=yes, resizable=yes");

	}

	function jusoCallBack(roadFullAddr, addrDetail) {
		document.getElementById("address").value = roadFullAddr;

	}

	function addcnt() {
		var num = document.getElementById("chaincnt").value;
		var parse_num = parseInt(num) + 1;
		alert(parse_num);
		document.getElementById("chaincnt").value = parse_num;
	}

	function minuscnt() {
		var num = document.getElementById("chaincnt").value;
		if (num != 1) {
			var parse_num = parseInt(num) - 1;
			alert(parse_num);
			document.getElementById("chaincnt").value = parse_num;
		}
	}

	function checkup() {
		var pwd = document.getElementById("hqpwd").value;
		var checkpwd = document.getElementById("confirmpassword").value;
		if (checkpwd.length == 0) {
			document.getElementById("check").innerHTML = "";
		}

	}

	function confirm() {
		var pwd = document.getElementById("hqpwd").value;
		var checkpwd = document.getElementById("confirmpassword").value;

		if (pwd != null && checkpwd != null) {
			if (pwd != checkpwd) {
				document.getElementById("check").innerHTML = "비밀번호가 일치하지 않습니다";

			} else {
				document.getElementById("check").innerHTML = "비밀번호가 일치합니다";
			}

		}

	}
</script>




<!-- CSS Files -->
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/azzara.min.css">
</head>


<body class="login">
	<div class="wrapper wrapper-login">
		<div class="container container-login animated fadeIn">
			<h3 class="text-center">HQ Sign Up</h3>
			<div class="login-form">

				<form class="signupform" action="signupimpl.top" method="post"
					accept-charset="utf-8" novalidate="novalidate">


					<!--  company START -->
					<div class="form-group">
						<label for="cname" class="placeholder"><b>chainname</b></label> <input
							id="cname" name="cname" type="text" class="form-control" required>
					</div>
					<!--  company ?대쫫  END -->

					<!--  ID  START-->
					<div class="form-group">
						<label for="ID" class="placeholder"><b>ID</b></label> <a href="#"
							class="link float-right"></a> <input id="hqid" name="hqid"
							type="text" class="form-control" required>
					</div>
					<!--  ID  END-->

					<!--  PWD START -->
					<div class="form-group">
						<label for="password" class="placeholder"><b>Password</b></label>
						<input id="hqpwd" name="hqpwd" type="password" onkeyup="checkup()"
							class="form-control" required>

					</div>
					<!--  PWD END -->

					<!--  PWD_CONFRIM START -->
					<div class="form-group">
						<label for="confirmpassword" class="placeholder"><b>Confirm
								Password</b></label> <input id="confirmpassword" name="confirmpassword"
							type="password" onkeyup="confirm()" class="form-control" required>
						<font size="2" id="check" color="red"></font>
					</div>


					<!--  PWD_CONFRIM END -->

					<!--  Email START -->
					<div class="form-group">
						<label for="Email" class="placeholder"><b>Email</b></label> <input
							id="hqemail" name="hqemail" type="text" class="form-control"
							required>
					</div>
					<!--  Email  END -->


					<!--  phone START -->
					<div class="form-group">
						<label for="phonenumber" class="placeholder"><b>Phone</b></label>
						<input id="hqphone" name="hqphone" type="text"
							class="form-control" required>
					</div>
					<!--  phone  END -->



					<!--  chain Count START -->
					<div class="form-group">
						<label for="chaincnt" class="placeholder"><b>chaincount</b></label>
						<a href="#" class="link float-right"> <span class="btn"
							onclick="addcnt()">+</span> <span class="btn"
							onclick="minuscnt()">ㅡ</span></a> <input type="text"
							style="width: 100px" id="chaincnt" name="chaincnt" value="1"
							class="form-control">
					</div>

					<!--  chain Count END -->

					<!--  본사주소 START -->
					<div id="addressarea">
						<label for="caddress" class="placeholder"><b>Address</b></label> <input
							type="text" id="address" name="caddr"
							placeholder="주소를 입력하기 위해 클릭해주세요" class="form-control"
							onclick="goPopup()">
					</div>
					<!-- 본사주소  END -->

					<!--  button START  -->
					<div class="row form-action">
						<div class="col-md-6">
							<a href="main.top" id="show-signin"
								class="btn btn-danger btn-link w-100 fw-bold">Cancel</a>
						</div>

						<div class="col-md-6">
							<button class="btn btn-primary" type="submit" value="submit"
								class="btn_3">submit</button>
						</div>
					</div>

					<!--  button END  -->
				</form>
			</div>
		</div>
	</div>
	<script src="assets/js/core/jquery.3.2.1.min.js"></script>
	<script src="assets/js/plugin/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
	<script src="assets/js/core/popper.min.js"></script>
	<script src="assets/js/core/bootstrap.min.js"></script>
	<script src="assets/js/ready.js"></script>
	<script src="assets/js/idcheck.js" charset="UTF-8"></script>

</body>
</html>


