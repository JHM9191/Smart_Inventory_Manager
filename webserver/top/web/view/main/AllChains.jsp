<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.3/jquery.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/data.js"></script>
<script src="https://code.highcharts.com/modules/drilldown.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>
<style>
.highcharts-figure, .highcharts-data-table table {
	min-width: 310px;
	max-width: 800px;
	margin: 1em auto;
}

#container_highcharts {
	height: 400px;
}

.highcharts-data-table table {
	font-family: Verdana, sans-serif;
	border-collapse: collapse;
	border: 1px solid #EBEBEB;
	margin: 10px auto;
	text-align: center;
	width: 100%;
	max-width: 500px;
}

.highcharts-data-table caption {
	padding: 1em 0;
	font-size: 1.2em;
	color: #555;
}

.highcharts-data-table th {
	font-weight: 600;
	padding: 0.5em;
}

.highcharts-data-table td, .highcharts-data-table th,
	.highcharts-data-table caption {
	padding: 0.5em;
}

.highcharts-data-table thead tr, .highcharts-data-table tr:nth-child(even)
	{
	background: #f8f8f8;
}

.highcharts-data-table tr:hover {
	background: #f1f7ff;
}
</style>
<script>
	function showContainer(chainID) {
		location.href = 'containerProgress.top?chainID=' + chainID;
	};
	function display(result) {

		Highcharts
				.chart(
						'container_highcharts',
						{
							chart : {
								type : 'column'
							},
							title : {
								text : '매출 현황 (가맹점 전체)'
							},
							accessibility : {
								announceNewData : {
									enabled : true
								}
							},
							xAxis : {
								type : 'category',
								labels : {
									rotation : -45,
									style : {
										fontSize : '13px',
										fontFamily : 'Verdana, sans-serif'
									}
								}
							},
							yAxis : {
								title : {
									text : 'Total Sales(Ten thousand KRW)'
								}
							},
							legend : {
								enabled : false
							},
							plotOptions : {
								series : {
									borderWidth : 0,
									dataLabels : {
										enabled : true,
										/* rotation : -90, */
										/* color : '#FFFFFF', */
										/* align : 'right', */
										format : '{point.y:,f}' // one decimal
									/* y : 10, // 10 pixels down from the top */
									/* style : {
										fontSize : '13px',
										fontFamily : 'Verdana, sans-serif'
									} */
									}
								}
							},
							tooltip : {
								headerFormat : '<span style="font-size:14px">{series.name} of </span>',
								pointFormat : '<span style="color:{point.color}"> {point.name}</span>: <br><b>{point.y:,f}</b> ten thousand won<br>'
							},
							series : [ {
								name : 'Total Sales',
								colorByPoint : true,
								data : result[0]

							} ],
							drilldown : {
								series : result[1]

							}
						});
	};

	function getData(year) {
		$.ajax({
			url : 'getSalesData.top?year=' + year,
			success : function(data) {
				/* alert(data) */
				console.log(data[0]);
				console.log(data[1]);
				display(data);
			}
		});
	};

	$(document).ready(function() {
		getData('${year}');
	});
</script>
<h1 class="page-title">메인 페이지</h1>
<div class="card">
	<div class="card-body">
		<div class="row">
			<div class="col-6 col-md-4">
				<div class="nav flex-column nav-pills nav-secondary"
					id="v-pills-tab" role="tablist" aria-orientation="vertical">
					<a class="nav-link active" id="v-pills-home-tab" data-toggle="pill"
						href="#v-pills-home" role="tab" aria-controls="v-pills-home"
						aria-selected="true" onclick="getData('2019');">전체 가맹점</a>
					<c:forEach var="s" items="${salesData }">
						<a class="nav-link" id="v-pills-profile-tab" data-toggle="pill"
							href="#" role="tab" onclick="showContainer('${s.chainID }');"
							aria-controls="v-pills-profile" aria-selected="true">${s.chainID }</a>
					</c:forEach>
				</div>
			</div>
			<div class="col-12 col-md-8">
				<div class="highcharts-figure">
					<div class="col-6 col-md-6 ml-auto">
						<ul class="nav nav-pills nav-secondary nav-pills-no-bd"
							id="pills-tab-without-border" role="tablist">
							<!-- <li class="nav-item submenu"><a class="nav-link active show"
							id="Today" data-toggle="pill" href="#pills-home-nobd" role="tab"
							aria-controls="pills-home-nobd" aria-selected="true">Today</a></li> -->
							<li class="nav-item submenu"><a class="nav-link active show"
								id="pills-profile-tab-nobd" data-toggle="pill"
								href="#pills-profile-nobd" role="tab"
								aria-controls="pills-profile-nobd" aria-selected="false"
								onclick="getData('2019');">2019년</a></li>
							<li class="nav-item submenu"><a class="nav-link"
								id="pills-profile-tab-nobd" data-toggle="pill"
								href="#pills-profile-nobd" role="tab"
								aria-controls="pills-profile-nobd" aria-selected="false"
								onclick="getData('2018');">2018년</a></li>
							<li class="nav-item submenu"><a class="nav-link"
								id="pills-profile-tab-nobd" data-toggle="pill"
								href="#pills-profile-nobd" role="tab"
								aria-controls="pills-profile-nobd" aria-selected="false"
								onclick="getData('2017');">2017년</a></li>
						</ul>
					</div>
					<br>
					<div id="container_highcharts"></div>
				</div>
			</div>
		</div>
	</div>
</div>
<h1 class="card-sub">Chart License: Highcharts.com</h1>