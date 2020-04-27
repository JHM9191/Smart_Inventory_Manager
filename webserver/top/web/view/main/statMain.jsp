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


<!-- Common -->
<script>
	var interval_showAllContainer;
	var interval_showSelectedContainer;
</script>

<!-- 매출 상세 -->
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

	function getSalesData(year) {

		//clearInterval(interval_showAllContainer);
		//clearInterval(interval_showSelectedContainer);

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
</script>




<!-- 오늘의 매출 -->
<style>
.highcharts-figure, .highcharts-data-table table {
	min-width: 320px;
	max-width: 800px;
	margin: 1em auto;
}

#dailySalesChartcontainer {
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
	var chart;
	function drawChartOnLoad(data) {
		chart = Highcharts.chart('dailySalesChartcontainer', {
			chart : {
				type : 'spline',
				animation : Highcharts.svg, // don't animate in old IE
				marginRight : 10,
			/* events : {
				load : function() {

					// set up the updating of the chart each second
					var series = this.series[0];
					setInterval(function() {
						var x = (new Date()).getTime(), // current time
						y = Math.random();
						series.addPoint([ x, y ], true, true);
					}, seconds);
					// set up the updating of the chart each second
					var series2 = this.series[1];
					setInterval(function() {
						var x2 = (new Date()).getTime(), // current time
						y2 = 0.75;
						series2
								.addPoint([ x2, y2 ], true,
										true);
					}, seconds);

				}
			} */
			},
			time : {
				useUTC : false
			},

			title : {
				text : '오늘 매출 실시간 현황'
			},
			xAxis : {
				type : 'datetime',
				tickPixelInterval : 150
			},

			yAxis : {
				title : {
					text : '매출'
				},
				plotLines : [ {
					value : 0,
					width : 1,
					color : '#808080'
				} ]
			},

			tooltip : {
				headerFormat : '<b>{series.name}</b><br/>',
				pointFormat : '{point.x:%Y-%m-%d %H:%M:%S}<br/>{point.y:.2f} 원'
			},

			legend : {
				enabled : false
			},

			exporting : {
				enabled : false
			},

			series : data
		});

	}

	function getDailySalesChart() {

		//clearInterval(interval_showAllContainer);
		//clearInterval(interval_showSelectedContainer);

		$.ajax({
			url : 'showDailySalesChart.top',
			success : function(data) {
				//console.log(data);
				//console.log(data[0]);
				//console.log(typeof (data[0]));

				for (var i = 0; i < data.length; i++) {

					chart.series[i].addPoint(data[i].data);

				}

				//				displayDailySalesChart(3000, data);
			}
		});
	}

	function getDailySalesChartOnLoad() {

		$.ajax({
			url : 'showDailySalesChart.top',
			success : function(data) {
				//console.log(data);
				//console.log(data[0]);
				//console.log(typeof (data[0]));

				drawChartOnLoad(data);
			}
		});
	}

	$(document).ready(function() {
		getDailySalesChartOnLoad();
		setInterval(function() {
			getDailySalesChart();
		}, 3000);
	});
</script>

<!-- IoT 컨테이너 현황 -->
<script>
	function getContainerDataAllChains() {
		console.log('entered getContainerDataAllChains');
		clearInterval(interval_showSelectedContainer);
		interval_showAllContainer = setInterval(function() {
			$.ajax({
				url : 'getAllRealTimeContainerData.top',
				success : function(data) {
					console.log(data);
					console.log(typeof (data));

					//console.log(data.size());
					console.log(Object.keys(data));

					var chainID_list = [];

					for (chainID in data) {
						console.log(chainID);
						chainID_list.push(chainID);
					}

					/* for (var i = 0; i < data.size; i++) {
						var chainID = Object.keys(data)[i];
						console.log(chainID);
						chainID_list.push(chainID);
					} */
					//setChart(data);
					makeChainSelect(chainID_list, data);
					makeProgressBarAllChains(chainID_list, data);
				}
			});

		}, 3000);
	}

	function makeProgressBarAllChains(chainID_list, data) {
		console.log('entered makeProgressBarAllChains');
		$('#showContainerList').html('');
		var result = '';
		for (var c = 0; c < chainID_list.length; c++) {
			var conList = data[chainID_list[c]];
			console.log('conList : ' + conList);
			result += '<div class="card">';
			result += '<div class="card-header">';
			result += '<div class="card-title"><p class="h1">';
			result += chainID_list[c];
			result += '</p></div></div>';
			result += "<div class='card-body'>";
			for (var i = 0; i < conList.length; i++) {

				result += "<div class='top_progressbar'>"
				result += "<div class='card'>"
				result += "<div class='card-body'>"
				result += "<div class='card-title'><p class=\"h1\"><b>"
						+ conList[i]['ingName']
						+ "</b></p><p class=\"text-info\">(컨테이너 ID : "
						+ conList[i]['conID'] + ")</p></div>";
				result += '<div id="task-complete" class="chart-circle mt-4 mb-3">';
				result += '<div class="circles-wrp" style="position: relative; display: inline-block;">';
				result += '<svg xmlns="http://www.w3.org/2000/svg" width="150" height="150">';
				result += '<path fill="transparent" stroke="#eeeeee" stroke-width="8" d="M 74.98553920253764 4.000001472638488 A 71 71 0 1 1 74.90138242439691 4.000068488950063 Z" class="circles-maxValueStroke"></path>';
				result += '<path fill="transparent" stroke="#1D62F0" stroke-width="8" d="M 74.98553920253764 4.000001472638488 A 71 71 0 1 1 7.458509176231658 53.11057293342702 " class="circles-valueStroke"></path></svg>';
				result += '<div class="circles-text" style="position: absolute; top: 0px; left: 0px; text-align: center; width: 100%; font-size: 52.5px; height: 150px; line-height: 150px;">';
				result += ((conList[i]['conCurrWeight'] / conList[i]['conFullWeight']) * 100)
						.toFixed(2)
						+ '%';
				result += '</div></div></div></div></div></div>';
			}
			result += '</div></div>';
		}
		$('#showContainerList').append(result);
	}

	function makeChainSelect(chainIDList, data) {

		var all = '<li class="nav-item"><a class="nav-link active" id="pills-home-tab" data-toggle="pill" href="#pills-home" role="tab" aria-controls="pills-home" aria-selected="true" onclick="getContainerDataAllChains();">전체</a></li>'

		$('#chainSelect_tab').html(all);

		console.log('chainIDList.length : ' + chainIDList.length);
		console.log('chainIDList[0] : ' + chainIDList[0]);
		var result = '';
		for (var i = 0; i < chainIDList.length; i++) {
			result += '<li class="nav-item">';
			result += '<a class="nav-link" id="pills-profile-tab" data-toggle="pill" href="#pills-profile" role="tab" aria-controls="pills-profile" aria-selected="false" onclick="';
			result += 'getContainerDataChainSelected(\'' + chainIDList[i]
					+ '\');';
			result += '">';
			result += chainIDList[i];
			result += '</a></li>';

		}

		$('#chainSelect_tab').append(result);

	}

	function getContainerDataChainSelected(chainID) {
		console.log('entered getContainerDataChainSelected');
		console.log('chainID : ' + chainID);
		clearInterval(interval_showAllContainer);
		clearInterval(interval_showSelectedContainer);
		interval_showSelectedContainer = setInterval(function() {
			$.ajax({
				url : 'getRealTimeContainerData.top?chainID=' + chainID,
				success : function(data) {
					console.log(data);
					makeProgressBarChainSelected(data);
				}
			});
		}, 3000);
	}

	function makeProgressBarChainSelected(conList) {
		console.log('entered makeProgressBarChainSelected');
		$('#showContainerList').html('');
		var result = '';
		for (var i = 0; i < conList.length; i++) {

			result += "<div class='top_progressbar'>"
			result += "<div class='card'>"
			result += "<div class='card-header'>"
			result += "<div class='card-title'><p class=\"h1\"><b>"
					+ conList[i]['ingName']
					+ "</b></p><p class=\"text-info\">(컨테이너 ID : "
					+ conList[i]['conID'] + ")</p></div></div>";
			result += '<div class="card-body">';
			result += '<div id="task-complete" class="chart-circle mt-4 mb-3">';
			result += '<div class="circles-wrp" style="position: relative; display: inline-block;">';
			result += '<svg xmlns="http://www.w3.org/2000/svg" width="150" height="150">';
			result += '<path fill="transparent" stroke="#eee" stroke-width="8" d="M 74.98553920253764 4.000001472638488 A 71 71 0 1 1 74.90138242439691 4.000068488950063 Z" class="circles-maxValueStroke"></path>';
			result += '<path fill="transparent" stroke="#1D62F0" stroke-width="8" d="M 74.98553920253764 4.000001472638488 A 71 71 0 1 1 7.458509176231658 53.11057293342702 " class="circles-valueStroke"></path></svg>';
			result += '<div class="circles-text" style="position: absolute; top: 0px; left: 0px; text-align: center; width: 100%; font-size: 52.5px; height: 150px; line-height: 150px;">';
			result += ((conList[i]['conCurrWeight'] / conList[i]['conFullWeight']) * 100)
					.toFixed(2)
					+ '%';
			result += '</div></div></div></div></div></div>';
		}
		$('#showContainerList').append(result);
	}
</script>

<script>

</script>

<div class="card">
	<div class="card-header">
		<h4 class="card-title">메인 페이지</h4>
	</div>
	<div class="card-body">
		<ul
			class="nav nav-pills nav-secondary  nav-pills-no-bd nav-pills-icons justify-content-center"
			id="pills-tab-with-icon" role="tablist">
			<li class="nav-item submenu"><a class="nav-link active show"
				id="pills-home-tab-icon" data-toggle="pill" href="#pills-home-icon"
				role="tab" aria-controls="pills-home-icon" aria-selected="true">
					<i class="flaticon-coins"></i> 오늘의 매출
			</a></li>
			<li class="nav-item submenu"><a class="nav-link"
				id="pills-profile-tab-icon" data-toggle="pill"
				href="#pills-profile-icon" role="tab"
				aria-controls="pills-profile-icon" aria-selected="false"
				onclick="getSalesData('2019');"> <i class="flaticon-graph"></i>
					매출 상세
			</a></li>
			<li class="nav-item submenu"><a class="nav-link"
				id="pills-contact-tab-icon" data-toggle="pill"
				href="#pills-contact-icon" role="tab"
				aria-controls="pills-contact-icon" aria-selected="false"
				onclick="getContainerDataAllChains();"> <i
					class="flaticon-box-2"></i> IoT 컨테이너 현황
			</a></li>
			<li class="nav-item submenu"><a class="nav-link"
				id="pills-contact-tab-icon2" data-toggle="pill"
				href="#pills-contact-icon2" role="tab"
				aria-controls="pills-contact-icon2" aria-selected="false"
				onclick="inventoryAnalysis();"> <i class="flaticon-analytics"></i>
					재고 분석
			</a></li>
		</ul>
		<div class="tab-content mt-2 mb-3" id="pills-with-icon-tabContent">


			<!-- 오늘의 매출 -->
			<div class="tab-pane fade active show" id="pills-home-icon"
				role="tabpanel" aria-labelledby="pills-home-tab-icon">
				<div class="card">
					<div class="card-body">

						<figure class="highcharts-figure">
							<div id="dailySalesChartcontainer"></div>
						</figure>
					</div>
				</div>



			</div>


			<!-- 매출 상세 -->
			<div class="tab-pane fade" id="pills-profile-icon" role="tabpanel"
				aria-labelledby="pills-profile-tab-icon">
				<div class="card">
					<div class="card-body">
						<div class="row">
							<div class="card-body">
								<div class="highcharts-figure">
									<div class="col-6 col-md-6 ml-auto">
										<ul class="nav nav-pills nav-secondary nav-pills-no-bd"
											id="pills-tab-without-border" role="tablist">
											<li class="nav-item submenu"><a
												class="nav-link active show" id="pills-profile-tab-nobd"
												data-toggle="pill" href="#pills-profile-nobd" role="tab"
												aria-controls="pills-profile-nobd" aria-selected="false"
												onclick="getSalesData('2019');">2019년</a></li>
											<li class="nav-item submenu"><a class="nav-link"
												id="pills-profile-tab-nobd" data-toggle="pill"
												href="#pills-profile-nobd" role="tab"
												aria-controls="pills-profile-nobd" aria-selected="false"
												onclick="getSalesData('2018');">2018년</a></li>
											<li class="nav-item submenu"><a class="nav-link"
												id="pills-profile-tab-nobd" data-toggle="pill"
												href="#pills-profile-nobd" role="tab"
												aria-controls="pills-profile-nobd" aria-selected="false"
												onclick="getSalesData('2017');">2017년</a></li>
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
			</div>


			<!-- IoT 컨테이너 현황 -->
			<div class="tab-pane fade" id="pills-contact-icon" role="tabpanel"
				aria-labelledby="pills-contact-tab-icon">

				<div class="temp">
					<ul class="nav nav-pills nav-secondary" id="chainSelect_tab"
						role="tablist">


					</ul>
					<div id="showContainerList"></div>
				</div>
			</div>

			<!-- 재고 분석 -->
			<div class="tab-pane fade" id="pills-contact-icon2" role="tabpanel"
				aria-labelledby="pills-contact-tab-icon2">
				<p>재고 분석</p>
			</div>
		</div>
	</div>
</div>
