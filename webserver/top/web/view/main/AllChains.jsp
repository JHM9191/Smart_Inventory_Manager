<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
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
	min-width: 120px;
	max-width: 1000px;
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

	function showDailySalesChart() {
		location.href = "showDailySalesChart.top";
	}
</script>
<h1 class="page-title">메인 페이지</h1>


<ul
	class="nav nav-pills nav-secondary  nav-pills-no-bd nav-pills-icons justify-content-center"
	id="pills-tab-with-icon" role="tablist">

	<li class="nav-item"><a class="nav-link active"
		id="iotContainer-icon" data-toggle="pill" href="#pills-profile-icon"
		role="tab" aria-controls="iotContainer" aria-selected="false"> <i
			class="flaticon-user-4"></i> 컨테이너 현황
	</a></li>
	<li class="nav-item"><a class="nav-link" id="inventory-icon"
		data-toggle="pill" href="#pills-contact-icon" role="tab"
		aria-controls="inventory" aria-selected="false"> <i
			class="flaticon-mailbox"></i> 재고분석
	</a></li>
	<li class="nav-item"><a class="nav-link" id="dailySalesChart-icon"
		data-toggle="pill" onclick="showDailySalesChart();"
		href="#pills-contact-icon" role="tab" aria-controls="dailySalesChart"
		aria-selected="false"> <i class="flaticon-mailbox"></i> 오늘의 매출
	</a></li>
	<li class="nav-item"><a class="nav-link" id="salesChart-icon"
		data-toggle="pill" onclick="showSalesChart();" role="tab"
		aria-controls="salesChart" aria-selected="true"> <i
			class="flaticon-home"></i> 매출현황
	</a></li>
	<li class="nav-item"><a class="nav-link"
		id="pills-contact-tab-icon" data-toggle="pill"
		href="#pills-contact-icon" role="tab"
		aria-controls="pills-contact-icon" aria-selected="false"> <i
			class="flaticon-mailbox"></i> Contact
	</a></li>
	<li class="nav-item"><a class="nav-link"
		id="pills-contact-tab-icon" data-toggle="pill"
		href="#pills-contact-icon" role="tab"
		aria-controls="pills-contact-icon" aria-selected="false"> <i
			class="flaticon-mailbox"></i> Contact
	</a></li>
	<li class="nav-item"><a class="nav-link"
		id="pills-contact-tab-icon" data-toggle="pill"
		href="#pills-contact-icon" role="tab"
		aria-controls="pills-contact-icon" aria-selected="false"> <i
			class="flaticon-mailbox"></i> Contact
	</a></li>
	<li class="nav-item"><a class="nav-link"
		id="pills-contact-tab-icon" data-toggle="pill"
		href="#pills-contact-icon" role="tab"
		aria-controls="pills-contact-icon" aria-selected="false"> <i
			class="flaticon-mailbox"></i> Contact
	</a></li>
	<li class="nav-item"><a class="nav-link"
		id="pills-contact-tab-icon" data-toggle="pill"
		href="#pills-contact-icon" role="tab"
		aria-controls="pills-contact-icon" aria-selected="false"> <i
			class="flaticon-mailbox"></i> Contact
	</a></li>
	<li class="nav-item"><a class="nav-link"
		id="pills-contact-tab-icon" data-toggle="pill"
		href="#pills-contact-icon" role="tab"
		aria-controls="pills-contact-icon" aria-selected="false"> <i
			class="flaticon-mailbox"></i> Contact
	</a></li>
</ul>



<div class="tab-content mt-2 mb-3" id="pills-with-icon-tabContent">

	<div class="tab-pane fade active show" id="dailySalesChart"
		role="tabpanel" aria-labelledby="dailySalesChart-icon">
		<p>Far far away, behind the word mountains, far from the countries
			Vokalia and Consonantia, there live the blind texts. Separated they
			live in Bookmarksgrove right at the coast of the Semantics, a large
			language ocean.</p>

		<p>A small river named Duden flows by their place and supplies it
			with the necessary regelialia. It is a paradisematic country, in
			which roasted parts of sentences fly into your mouth.</p>
	</div>



	<div class="tab-pane fade" id="iotContainer" role="tabpanel"
		aria-labelledby="iotContainer-icon">

		<p>hello~</p>
	</div>



</div>


<!-- ------- -->
<div class="tab-pane fade" id="inventory" role="tabpanel"
	aria-labelledby="inventory-icon">
	<p>Inventory</p>
</div>
<div class="tab-pane fade" id="pills-profile-icon" role="tabpanel"
	aria-labelledby="pills-profile-tab-icon">
	<p>Even the all-powerful Pointing has no control about the blind
		texts it is an almost unorthographic life One day however a small line
		of blind text by the name of Lorem Ipsum decided to leave for the far
		World of Grammar.</p>
	<p>The Big Oxmox advised her not to do so, because there were
		thousands of bad Commas, wild Question Marks and devious Semikoli, but
		the Little Blind Text didn�셳 listen. She packed her seven versalia,
		put her initial into the belt and made herself on the way.</p>
</div>
<div class="tab-pane fade" id="pills-contact-icon" role="tabpanel"
	aria-labelledby="pills-contact-tab-icon">
	<p>Pityful a rethoric question ran over her cheek, then she
		continued her way. On her way she met a copy. The copy warned the
		Little Blind Text, that where it came from it would have been
		rewritten a thousand times and everything that was left from its
		origin would be the word "and" and the Little Blind Text should turn
		around and return to its own, safe country.</p>

	<p>But nothing the copy said could convince her and so it didn�셳
		take long until a few insidious Copy Writers ambushed her, made her
		drunk with Longe and Parole and dragged her into their agency, where
		they abused her for their</p>
</div>