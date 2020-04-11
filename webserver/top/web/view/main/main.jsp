<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />

<title>TOP Smart Inventory Management System</title>
<meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no'
	name='viewport' />
<link rel="icon" href="assets/img/icon.ico" type="image/x-icon" />

<!-- Fonts and icons -->
<script src="assets/js/plugin/webfont/webfont.min.js"></script>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
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

<!-- CSS Just for demo purpose, don't include it in your project -->
<link rel="stylesheet" href="assets/css/demo.css">
</head>
<body>
	<div class="wrapper">

		<c:choose>
			<c:when test="${loginId == null }">
				<jsp:include page="../user/login.jsp" />
			</c:when>

			<c:otherwise>
				<jsp:include page="header.jsp" />
				<jsp:include page="sidebar.jsp" />

				<!--  Center Page Here! -->
				<div class="main-panel">
					<div class="content">
						<div class="page-inner">
							<!-- Real Time Inventory START! -->
							<c:choose>
								<c:when test="${inventory_realtime == null }">
									<jsp:include page="empty.jsp" />
								</c:when>
								<c:otherwise>
									<jsp:include page="${inventory_realtime }.jsp" />
								</c:otherwise>
							</c:choose>
							<!-- Real Time Inventory END! -->


							<!-- Ingredient List START! -->
							<c:choose>
								<c:when test="${ingredientListTable == null }">
									<jsp:include page="empty.jsp" />
								</c:when>
								<c:otherwise>
									<jsp:include page="${ingredientListTable }.jsp" />
								</c:otherwise>
							</c:choose>
							<!-- Ingredient List END! -->

							<!-- Product Suggestion START! -->
							<c:choose>
								<c:when test="${suggestion == null }">
									<jsp:include page="empty.jsp" />
								</c:when>
								<c:otherwise>
									<jsp:include page="${suggestion }.jsp" />
								</c:otherwise>
							</c:choose>
							<!-- Product Suggestion END! -->

							<!-- Visual Analysis START! -->
							<c:choose>
								<c:when test="${analysis == null }">
									<jsp:include page="empty.jsp" />
								</c:when>
								<c:otherwise>
									<jsp:include page="${analysis }.jsp" />
								</c:otherwise>
							</c:choose>
							<!-- Visual Analysis END! -->
						</div>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</body>

<!--   Core JS Files   -->
<script src="assets/js/core/jquery.3.2.1.min.js"></script>
<script src="assets/js/core/popper.min.js"></script>
<script src="assets/js/core/bootstrap.min.js"></script>

<!-- jQuery UI -->
<script src="assets/js/plugin/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
<script
	src="assets/js/plugin/jquery-ui-touch-punch/jquery.ui.touch-punch.min.js"></script>

<!-- jQuery Scrollbar -->
<script src="assets/js/plugin/jquery-scrollbar/jquery.scrollbar.min.js"></script>

<!-- Moment JS -->
<script src="assets/js/plugin/moment/moment.min.js"></script>

<!-- Chart JS -->
<script src="assets/js/plugin/chart.js/chart.min.js"></script>

<!-- jQuery Sparkline -->
<script src="assets/js/plugin/jquery.sparkline/jquery.sparkline.min.js"></script>

<!-- Chart Circle -->
<script src="assets/js/plugin/chart-circle/circles.min.js"></script>

<!-- Datatables -->
<script src="assets/js/plugin/datatables/datatables.min.js"></script>

<!-- Bootstrap Notify -->
<script src="assets/js/plugin/bootstrap-notify/bootstrap-notify.min.js"></script>

<!-- Bootstrap Toggle -->
<script src="assets/js/plugin/bootstrap-toggle/bootstrap-toggle.min.js"></script>

<!-- jQuery Vector Maps -->
<script src="assets/js/plugin/jqvmap/jquery.vmap.min.js"></script>
<script src="assets/js/plugin/jqvmap/maps/jquery.vmap.world.js"></script>

<!-- Google Maps Plugin -->
<script src="assets/js/plugin/gmaps/gmaps.js"></script>

<!-- Sweet Alert -->
<script src="assets/js/plugin/sweetalert/sweetalert.min.js"></script>

<!-- Azzara JS -->
<script src="assets/js/ready.min.js"></script>

<!-- Azzara DEMO methods, don't include it in your project! -->
<script src="assets/js/setting-demo.js"></script>
<script src="assets/js/demo.js"></script>
</html>