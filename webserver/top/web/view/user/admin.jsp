<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Azzara Bootstrap 4 Admin Dashboard</title>
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
			urls : [ '../assets/css/fonts.css' ]
		},
		active : function() {
			sessionStorage.fonts = true;
		}
	});
</script>

<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	padding: 8px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}
</style>

<!-- CSS Files -->
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/azzara.min.css">
<!-- CSS Just for demo purpose, don't include it in your project -->
<link rel="stylesheet" href="assets/css/demo.css">
</head>
<body>
	<div class="wrapper">

		<div class="row">
			<div class="col-md-6">
				<div class="card">
					<div class="card-header">
						<h4 class="card-title">Admin Page</h4>
					</div>
					<div class="card-body">
						<ul class="nav nav-pills nav-secondary" id="pills-tab"
							role="tablist">

							<!--  신청자 보기  menu bar start -->
							<li class="nav-item"><a class="nav-link active"
								id="pills-home-tab" data-toggle="pill" href="#pills-home"
								role="tab" aria-controls="pills-home" aria-selected="true">신청자
									보기</a></li>
							<!--  신청자 보기 menu bar end -->

							<!--  iot 통신현황 menu bar start-->
							<li class="nav-item"><a class="nav-link"
								id="pills-profile-tab" data-toggle="pill" href="#pills-profile"
								role="tab" aria-controls="pills-profile" aria-selected="false">iot통신현황
									보기</a></li>

							<!--  iot 통신현황  menu bar end-->
							<!--  매출현황 menu bar start-->

							<li class="nav-item"><a class="nav-link"
								id="pills-contact-tab" data-toggle="pill" href="#pills-contact"
								role="tab" aria-controls="pills-contact" aria-selected="false">매츌현황보기</a>
							</li>
							<!--  매출현황 menu bar end -->
						</ul>

						<!--  신청자수 start -->

						<div class="tab-content mt-2 mb-3" id="pills-tabContent">

							<div class="tab-pane fade show active" id="pills-home"
								role="tabpanel" aria-labelledby="pills-home-tab">

								<table>
									<tr>
										<th>ChinId</th>
										<th>UserId</th>
										<th>신청자수</th>
										<th>신청날</th>
									</tr>
									<c:forEach var="notilist" items="${notilist}">
										<tr>
											<td>${notilist.chainID }</td>
											<td>${notilist.userID }</td>
											<td>${notilist.applyCnt }</td>
											<td>${notilist.regDate }</td>
										</tr>

									</c:forEach>
								</table>
							</div>
							<!--  신청자수 end -->

							<!--  iot 통신현황  start-->
							<div class="tab-pane fade" id="pills-profile" role="tabpanel"
								aria-labelledby="pills-profile-tab">
								<p>통신현황</p>
							</div>

							<!--  iot 통신현황  end-->

							<!--  매출에 대한 정보 start-->
							<div class="tab-pane fade" id="pills-contact" role="tabpanel"
								aria-labelledby="pills-contact-tab">
								<p>매출현황파악</p>

							</div>
							<!--  매출에 대한 정보 end-->

						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<div class="custom-toggle">
		<i class="flaticon-settings"></i>
	</div>

	<!-- End Custom template -->

	<!--   Core JS Files   -->
	<script src="assets/js/core/jquery.3.2.1.min.js"></script>
	<script src="assets/js/core/popper.min.js"></script>
	<script src="assets/js/core/bootstrap.min.js"></script>
	<!-- jQuery UI -->
	<script src="assets/js/plugin/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
	<script
		src="assets/js/plugin/jquery-ui-touch-punch/jquery.ui.touch-punch.min.js"></script>
	<!-- Bootstrap Toggle -->
	<script
		src="sassets/js/plugin/bootstrap-toggle/bootstrap-toggle.min.js"></script>
	<!-- jQuery Scrollbar -->
	<script src="assets/js/plugin/jquery-scrollbar/jquery.scrollbar.min.js"></script>
	<!-- Azzara JS -->
	<script src="assets/js/ready.min.js"></script>
	<!-- Azzara DEMO methods, don't include it in your project! -->
	<script src="assets/js/setting-demo.js"></script>
</body>
</html>