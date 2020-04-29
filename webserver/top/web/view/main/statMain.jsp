<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv=“Content-Type” content=“text/html; charset=UTF-8”>

<!DOCTYPE html>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.3/jquery.min.js"></script>

<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/data.js"></script>
<script src="https://code.highcharts.com/modules/drilldown.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>

<!-- Bootstrap Tagsinput -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/bootstrap.tagsinput/0.4.2/bootstrap-tagsinput.css" />
<script
	src="https://cdn.jsdelivr.net/bootstrap.tagsinput/0.4.2/bootstrap-tagsinput.min.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-sparklines/2.1.2/jquery.sparkline.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.js"></script>

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
			contentType : 'application/json; charset=UTF-8',
			dataType : 'JSON',
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
				type : 'category',
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
				pointFormat : '{point.x: }<br/>{point.y:.2f} 원'
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
					var shiftFlag = chart.series[i].data.length > 4;

					chart.series[i].addPoint(data[i].data, true, shiftFlag);

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

<!-- 재고분석 -->

<script>
	$(document)
			.ready(
					function() {
						var pill = '';
						$('#ingSelected')
								.change(
										function() {

											$('#ingSelectedPill ul').html('');
											console.log('select changed');

											var ingSelected = $(this).children(
													'option:selected').val();
											console.log('ingSelected : '
													+ ingSelected);

											pill += '<li class="nav-item">';
											pill += '<a rel="';
											pill += ingSelected;
											pill += '" class="nav-link active tag badge badge-info" data-toggle="pill" data-role="remove" href="#pills-home-nobd" role="tab" aria-controls="pills-home-nobd" aria-selected="true" value="';
											pill += ingSelected;
											pill += '">';
											pill += ingSelected;
											pill += '<span data-role="remove"></span></a>';
											pill += '</li>';
											$('#ingSelectedPill ul').append(
													pill);
										});
					});

	function analyze() {

		console.log('entered analyze function');

		var demand = $('#annual_demand_quantity').val();
		var order_cost = $('#order_cost').val();
		var order_quantity = $('#order_quantity').val();
		var holding_cost = $('#annual_holding_cost').val();
		var ingredient = $('#ingSelected option:selected').val();
		var ingPrice = $('#ingSelected option:selected').attr('price');
		var ingUnit = $('#ingSelected option:selected').attr('unit');

		console.log(demand);
		console.log(order_cost);
		console.log(order_quantity);
		console.log(holding_cost);
		console.log(ingredient);
		console.log(ingPrice);
		console.log(ingUnit);
		/* var ingList = new Array(); */

		/* $('#ingSelectedPill ul').each(function(i) {
			$(this).find('li a').each(function() {
				ingList.push($(this).attr('rel'));
			});
		}); */
		/* for (var i = 0; i < ingList.length; i++) {
			console.log('ingList[i] : ' + ingList[i]);
		} */

		var obj = {
			"demand" : demand,
			"order_cost" : order_cost,
			"order_quantity" : order_quantity,
			"holding_cost" : holding_cost,
			"ingredient" : ingredient,
			"ingPrice" : ingPrice
		};
		console.log();

		$.ajax({
			url : 'EOQparameter.top',
			type : 'post',
			contentType : 'application/json; charset=utf-8',
			dataType : 'json',
			data : JSON.stringify(obj),
			success : function(data) {
				console.log(data);
				//showSparkline();
				showChartJS(data[0], ingUnit, ingPrice);
				$('#lineChart').html('');
			}
		});
	}

	function showChartJS(result, unit, ingPrice) {
		var lineChart = document.getElementById('lineChart').getContext('2d');
		lineChart.height = 300;

		var myLineChart = new Chart(lineChart, {
			type : 'line',
			data : {
				labels : result['label'],
				datasets : [ {
					label : '재고량',
					data : result['data'],
					backgroundColor : [ 'rgba(255, 99, 132, 0.2)',
							'rgba(54, 162, 235, 0.2)',
							'rgba(255, 206, 86, 0.2)',
							'rgba(75, 192, 192, 0.2)',
							'rgba(153, 102, 255, 0.2)',
							'rgba(255, 159, 64, 0.2)' ],
					borderColor : [ 'rgba(255,99,132,1)',
							'rgba(54, 162, 235, 1)', 'rgba(255, 206, 86, 1)',
							'rgba(75, 192, 192, 1)', 'rgba(153, 102, 255, 1)',
							'rgba(255, 159, 64, 1)' ],
					borderWidth : 1,
					lineTension : 0
				} ]
			},

			/* 	data: {
			    	labels: [new Date("2015-3-15 13:3").toLocaleString(), new Date("2015-3-25 13:2").toLocaleString()],
			    	datasets: [{
			    		label: 'Demo',
			    		data: [{
					        t: new Date("2020-01-01 13:3"),
					        y: 940
					    }, {
					        t: new Date("2020-02-01 13:3"),
					        y: 200
					    }]
			    	}]
			    }, */

			options : {
				scales : {
					xAxes : [ {
						type : 'time',
						distribution : 'linear'
					} ],
					yAxes : [ {
						id : 'y-axis-0',
						gridLines : {
							display : true,
							lineWidth : 1,
							color : "rgba(0,0,0,0.30)"
						},
						ticks : {
							beginAtZero : true,
							mirror : false,
							suggestedMin : 0,
							suggestedMax : 500,
						},
						afterBuildTicks : function(chart) {

						}
					} ]
				},
				maintainAspectRatio : false,
			}
		});

		/* var myLineChart = new Chart(lineChart, {
			type: 'line',
			data: {
				labels: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
				datasets: [{
					label: "경제적 주문량",
					borderColor: "#1d7af3",
					pointBorderColor: "#FFF",
					pointBackgroundColor: "#1d7af3",
					pointBorderWidth: 2,
					pointHoverRadius: 4,
					pointHoverBorderWidth: 1,
					pointRadius: 4,
					backgroundColor: 'transparent',
					fill: true,
					borderWidth: 2,
					data: [940, 200, 940, 200, 940, 200, 940, 200, 940, 200, 940, 200]
				}]
			},
			options : {
				responsive: true, 
				maintainAspectRatio: false,
				legend: {
					position: 'bottom',
					labels : {
						padding: 10,
						fontColor: '#1d7af3',
					}
				},
				tooltips: {
					bodySpacing: 4,
					mode:"nearest",
					intersect: 0,
					position:"nearest",
					xPadding:10,
					yPadding:10,
					caretPadding:10
				},
				layout:{
					padding:{left:15,right:15,top:15,bottom:15}
				}
			}
		}); */

		//////
		////
		/* Show Result in words */

		$('#analysisResult').html('');

		var cycle = result['cycle'];
		var order = result['order'];
		var quantity = result['quantity'];

		var txt = '';
		txt += '<div class="demo-icon justify-content-center">';
		txt += '<div class="icon-preview">';
		txt += '<i class="far fa-thumbs-up text-secondary"></i>';
		txt += '<span class="h3">';
		txt += ' <b>EOQ</b> 결과에 따라 ';
		txt += '해당 재료는 <span class="text-primary h1"><b>';
		txt += cycle;
		txt += '</b></span>일마다';
		txt += ', 1년에 총 <span class="text-danger h1"><b>';
		txt += order;
		txt += '</b></span>회 주문,';
		txt += ' 1건당 <span class="text-success h1"><b>';
		txt += quantity;
		txt += '</b></span> ';
		txt += unit;
		txt += '를 구매하는 것을 추천드립니다.</span></div></div>';

		$('#analysisResult').html(txt);

		$('#reorder_point').text(cycle + ' 일');
		$('#reorder_times').text(order + ' 회');
		$('#reorder_quantity').text(quantity + ' ' + unit);
		$('#reorder_price').text('₩ ' + (quantity * ingPrice));

	}

	function showSparkline() {
		$('#lineChart').sparkline(
				[ 102, 109, 120, 99, 110, 80, 87, 74, 102, 109, 120, 99, 110,
						80, 87, 74 ], {
					type : 'line',
					height : '100',
					width : '250',
					lineWidth : '2',
					lineColor : '#177dff',
					fillColor : 'rgba(23, 125, 255, 0.2)'
				});

	}
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
									<div class="col-md-6 ml-auto">
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

				<p class="h1 ">EOQ 재고분석</p>
				<p class="text-muted">(EOQ: Economic Order Quantity)</p>
				<p class="text-muted">
					<b>재고유지비용</b>을 줄이기 위해서는 <u>재고량을 줄여야 하고</u><br> <b>주문비용</b>을
					줄이기 위해서는 <u>재고량을 늘려</u> 주문횟수를 감소해야 합니다.<br> 이러한 교환관계에 균형을 맞추고
					<span class="text-warning">비용을 최소화</span>하는 최적의 재고수준을 결정하는 것을 <span
						class="text-danger"><u><b>경제적 주문량(EOQ)</b></u></span>이라고 합니다.
				</p>
				<div class="form-group form-inline">
					<label for="inlineinput" class="col-md-3 col-form-label">연간
						필요량</label>
					<div class="col-md-9 p-0">
						<input type="number" class="form-control input-full"
							id="annual_demand_quantity" placeholder="하루 평균 사용량 x 365일">
					</div>
				</div>
				<div class="form-group  form-inline">
					<label for="inlineinput" class="col-md-3 col-form-label">재료</label>
					<div class="col-md-9 p-0">
						<select class="form-control input-solid" id="ingSelected">
							<c:forEach var="ing" items="${ingList }">
								<option value="${ing.ingName }" price="${ing.ingPrice }"
									unit="${ing.ingUnit }">${ing.ingName }${ing.ingWeight }
									${ing.ingUnit } (${ing.ingPrice }원)</option>
							</c:forEach>
						</select>
					</div>
					<!-- <div class="col-md-9 p-0">
						<div class="" id="ingSelectedPill">
							<ul class="nav nav-pills nav-secondary nav-pills-no-bd"
								id="pills-tab-without-border" role="tablist" id="tagsinput">
							</ul>
						</div>
					</div> -->
				</div>
				<div class="form-group form-inline">
					<label for="inlineinput" class="col-md-3 col-form-label">연간
						재료 유지 비용</label>
					<div class="col-md-9 p-0 input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">￦</span>
						</div>
						<input type="number" class="form-control" id="annual_holding_cost"
							placeholder="1년 동안 해당 재료 유지를 위해 사용되는 비용(ex. 우유 보관 전용 냉장고 1년에 300만원)">
						<div class="input-group-append">
							<span class="input-group-text">.00</span>
						</div>
					</div>
				</div>
				<div class="form-group  form-inline">
					<label for="inlineinput" class="col-md-3 col-form-label">건당
						주문량</label>
					<div class="col-md-9 p-0">
						<input type="number" class="form-control input-full"
							id="order_quantity" placeholder="ex. 배송 1회당 우유 1L 500팩">
					</div>
				</div>
				<div class="form-group  form-inline">
					<label for="inlineinput" class="col-md-3 col-form-label">건당
						배송 비용</label>
					<div class="col-md-9 p-0 input-group">
						<div class="input-group-prepend">
							<span class="input-group-text">￦</span>
						</div>
						<input type="number" class="form-control" id="order_cost"
							placeholder="배송 1건당 소요되는 예상 배송 비용을 입력하세요">
						<div class="input-group-append">
							<span class="input-group-text">.00</span>
						</div>
					</div>
				</div>
				<p class="text-muted"></p>
				<div class="row justify-content-center align-items-center">
					<div class="col-6 col-md-6">
						<button class="btn btn-secondary btn-block" onclick="analyze();">
							<span><i class="la flaticon-presentation"></i>&nbsp;&nbsp;&nbsp;제출</span>
						</button>
					</div>
				</div>



				<br> <br>
				<!-- ChartJS Line Chart -->
				<div class="card">
					<div class="card-header">
						<div class="card-title">분석 결과</div>
					</div>
					<div class="card-body">
						<div class="chart-container" height="300px" style="height: 300px;">
							<div class="chartjs-size-monitor"
								style="position: absolute; left: 0px; top: 0px; right: 0px; bottom: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
								<div class="chartjs-size-monitor-expand"
									style="position: absolute; left: 0; top: 0; right: 0; bottom: 0; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
									<div
										style="position: absolute; width: 1000000px; height: 300px; left: 0; top: 0"></div>
								</div>
								<div class="chartjs-size-monitor-shrink"
									style="position: absolute; left: 0; top: 0; right: 0; bottom: 0; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;">
									<div
										style="position: absolute; width: 200%; height: 300px; left: 0; top: 0"></div>
								</div>
							</div>
							<canvas id="lineChart" width="332" height="300px"
								class="chartjs-render-monitor"
								style="display: block; width: 332px; height: 300px;"></canvas>
						</div>
					</div>

				</div>

				<br> <br>
				<div>
					<p id="analysisResult"></p>

				</div>

				<div class="row row-card-no-pd">
					<div class="col-sm-6 col-md-3">
						<div class="card card-stats card-round">
							<div class="card-body ">
								<div class="row">
									<div class="col-5">
										<div class="icon-big text-center">
											<i class="flaticon-calendar text-primary"></i>
										</div>
									</div>
									<div class="col col-stats">
										<div class="numbers">
											<p class="card-category">재주문점</p>
											<h4 class="card-title" id="reorder_point"></h4>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-md-3">
						<div class="card card-stats card-round">
							<div class="card-body ">
								<div class="row">
									<div class="col-5">
										<div class="icon-big text-center">
											<i class="flaticon-box-2 text-danger"></i>
										</div>
									</div>
									<div class="col col-stats">
										<div class="numbers">
											<p class="card-category">주문횟수</p>
											<h4 class="card-title" id="reorder_times"></h4>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-md-3">
						<div class="card card-stats card-round">
							<div class="card-body">
								<div class="row">
									<div class="col-5">
										<div class="icon-big text-center">
											<i class="flaticon-cart-1 text-success"></i>
										</div>
									</div>
									<div class="col col-stats">
										<div class="numbers">
											<p class="card-category">주문량</p>
											<h4 class="card-title" id="reorder_quantity"></h4>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-sm-6 col-md-3">
						<div class="card card-stats card-round">
							<div class="card-body">
								<div class="row">
									<div class="col-5">
										<div class="icon-big text-center">
											<i class="flaticon-coins text-warning"></i>
										</div>
									</div>
									<div class="col col-stats">
										<div class="numbers">
											<p class="card-category">주문금액</p>
											<h4 class="card-title" id="reorder_price"></h4>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>



			<!-- Spark line chart -->
			<%-- <div class="card-body">
					<div class="d-flex justify-content-center p-3">
						<div id="lineChart">
						<p>분석 결과</p>
							<canvas width="250" height="100"
								style="display: inline-block; width: 250px; height: 100px; vertical-align: top;"></canvas>
						</div>
					</div>
				</div> --%>

		</div>
	</div>
</div>
</div>
