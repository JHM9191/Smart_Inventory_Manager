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
		var num = document.getElementById("ucnt").value;
		var parse_num = parseInt(num) + 1;
		document.getElementById("ucnt").value = parse_num;
	}

	function minuscnt() {
		var num = document.getElementById("ucnt").value;
		if (num != 1) {
			var parse_num = parseInt(num) - 1;
			document.getElementById("ucnt").value = parse_num;
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
			<h3 class="text-center">User 가입자 신청</h3>
			<div class="login-form">

				<form class="applyform" action="applyimpl.top" method="post"
					accept-charset="utf-8" novalidate="novalidate">


					<!--  company이름  START 수정 필요한것 : 글씨체 -->
					<div class="form-group">
						<label for="exampleFormControlSelect1">chainname</label> <select
							class="form-control" id="exampleFormControlSelect1" name = "cname">
							<c:forEach var="clist" items="${cname}">
								<option>${cname}</option>
							</c:forEach>

						</select>

					</div>
					<!--  company 이름  END -->


					<!--  주소입력 START -->
					
					<div id="addressarea">
					<label for="caddress" class="placeholder"><b>chain주소를 입력해주세요</b></label>
						<input type="text" id="address" name="caddr"
							placeholder="주소를 입력하기 위해 클릭하세요" class="form-control"
							onclick="goPopup()">
					</div>
					<!--  주소입력  END -->


				

					<!--  user Count START -->
					<div class="form-group">
						<label for="ucnt" class="placeholder"><b>user 신청자 수 
							</b></label> <a href="#" class="link float-right"> <span class="btn"
							onclick="addcnt()">+</span> <span class="btn"
							onclick="minuscnt()">ㅡ</span>
						</a> <input type="text" style="width: 100px" id="ucnt"
							name="ucnt" value="1" class="form-control">
					</div>

					<!--  chain Count END -->

					<!--  마지막 취소 및 SUBMIT 버튼 START  -->
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

					<!--  마지막 취소 및 SUBMIT 버튼 END  -->
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


