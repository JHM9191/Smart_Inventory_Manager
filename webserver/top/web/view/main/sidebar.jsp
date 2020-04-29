<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Sidebar START -->
<div class="sidebar">
	<div class="sidebar-background"></div>
	<div class="sidebar-wrapper scrollbar-inner">
		<div class="sidebar-content">
			<div class="user">
				<div class="avatar-sm float-left mr-2">
					<img src="assets/img/profile2.jpg" alt="..."
						class="avatar-img rounded-circle">
				</div>
				<div class="info">
					<a data-toggle="collapse" href="#collapseExample"
						aria-expanded="true"> <span> Jo Hyun Min <span
							class="user-level">관리자</span> <span class="caret"></span>
					</span>
					</a>
					<div class="clearfix"></div>

					<div class="collapse in" id="collapseExample">
						<ul class="nav">
							<c:choose>
								<c:when test="${who == 'hq'}">
									<li><a href="addAddr.top"> <span class="link-collapse">
												가맹점추가하기</span>
									</a></li>
									<li><a href="admin.top"> <span class="link-collapse">
												관리자페이지</span>
									</a></li>

									<li><a href="update.top"> <span class="link-collapse">
												나의 정보 수정하기</span>
									</a></li>

								</c:when>
								<c:otherwise>
									<li><a href="apply.top"> <span class="link-collapse">
												가입 신청하기 </span>
									</a></li>

								</c:otherwise>
							</c:choose>
							<li><a href="logout.top"> <span class="link-collapse">
										로그아웃</span>
							</a></li>
						</ul>
					</div>
				</div>
			</div>

			<!-- MENU START HERE -->
			<ul class="nav">

				<!-- HOME -->
				<li class="nav-item active"><a
					onclick="location.href='main.top'"> <i class="fas fa-home"></i>
						<p>홈</p> <!-- <span class="badge badge-count">5</span> -->
				</a></li>

				<!-- Menu -->
				<li class="nav-section"><span class="sidebar-mini-icon">
						<i class="fa fa-ellipsis-h"></i>
				</span>
					<h4 class="text-section">메뉴</h4></li>

				<!-- Inventory Management -->
				<li class="nav-item"><a data-toggle="collapse" href="#base">
						<i class="fas fa-layer-group"></i>
						<p>재고관리</p>
				</a></li>


				<!-- Delivery Status -->
				<li class="nav-item"><a data-toggle="collapse" href="#forms">
						<i class="fas fa-pen-square"></i>
						<p>발주현황</p>
				</a></li>

				<!-- Chain Access Management -->
				<li class="nav-item"><a data-toggle="collapse" href="#tables">
						<i class="fas fa-table"></i>
						<p>권한관리</p>
				</a></li>

				<!-- Menu Management -->
				<li class="nav-item"><a data-toggle="collapse" href="#maps">
						<i class="fas fa-map-marker-alt"></i>
						<p>메뉴관리</p>
				</a></li>

				<!-- Container Management -->
				<li class="nav-item"><a data-toggle="collapse" href="#submenu"
					class="collapsed" aria-expanded="false"> <i
						class="far fa-chart-bar" aria-expanded="false"></i>
						<p>컨테이너관리</p> <span class="caret"></span>
				</a>
					<div class="collapse" id="submenu" style>
						<ul>
							<li class="submenu"><a data-toggle="collapse"
								href="#subnav1" class=""
								onclick="location.href='containerRegisterWizard.top'"> <span
									class="sub-item">컨테이너 추가</span>
							</a></li>
							<li class="submenu"><a data-toggle="collapse"
								href="#subnav1" class=""
								onclick="location.href='showContainerUpdateList.top'"> <span
									class="sub-item">컨테이너 수정</span>
							</a></li>
						</ul>
					</div></li>


				<!-- about TOP -->
				<li class="nav-item"><a onclick="location.href='about.top'"> <i
						class="fas fa-desktop"></i>
						<p>TOP 회사</p>
				</a></li>
			</ul>
		</div>
	</div>
</div>
<!-- Sidebar END -->