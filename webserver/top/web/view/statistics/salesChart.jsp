<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.3/jquery.min.js"></script>

<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>
<style>
.highcharts-figure, .highcharts-data-table table {
	min-width: 320px;
	max-width: 800px;
	margin: 1em auto;
}

#salesChartcontainer {
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
	function display(seconds, data) {
		Highcharts.chart('salesChartcontainer', {
			chart : {
				type : 'spline',
				animation : Highcharts.svg, // don't animate in old IE
				marginRight : 10,
				events : {
					load : function() {

						// set up the updating of the chart each second
						var series3 = this.series[2];
						setInterval(function() {
							var x3 = (new Date()).getTime(), // current time
							y3 = Math.random();
							series3.addPoint([ x3, y3 ], true, true);
						}, seconds);

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
							series2.addPoint([ x2, y2 ], true, true);
						}, seconds);

					}
				}
			},

			time : {
				useUTC : false
			},

			title : {
				text : '오늘 매출 실시간 현황'
			},
			accessibility : {
				announceNewData : {
					enabled : true,
					minAnnounceInterval : 15000,
					announcementFormatter : function(allSeries, newSeries,
							newPoint) {
						console.log('newPoint.y :' + newPoint.y);
						if (newPoint) {
							return 'New point added. Value: ' + newPoint.y;
						}
						return false;
					}
				}
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
				pointFormat : '{point.x:%Y-%m-%d %H:%M:%S}<br/>{point.y:.2f}'
			},

			legend : {
				enabled : false
			},

			exporting : {
				enabled : false
			},

			series : [ {
				name : 'Random data',
				data : (function() {
					// generate an array of random data
					var data = [], time = (new Date()).getTime(), i;

					for (i = -19; i <= 0; i += 1) {
						data.push({
							x : time + i * 1000,
							y : Math.random()
						});
					}
					return data;
				}())
			}, {
				name : 'Random data3',
				data : (function() {
					// generate an array of random data
					var data = [], time = (new Date()).getTime(), i;

					for (i = -19; i <= 0; i += 1) {
						data.push({
							x : time + i * 1000,
							y : 0.75
						});
					}
					return data;
				}())
			}, {
				name : 'Random data2',
				data : (function() {
					// generate an array of random data
					var data = [], time = (new Date()).getTime(), i;

					for (i = -19; i <= 0; i += 1) {
						data.push({
							x : time + i * 1000,
							y : Math.random()
						});
					}
					return data;
				}())
			} ]
		});

	}

	$(document).ready(function() {
		display(3000);
	});
</script>

<figure class="highcharts-figure">
	<div id="salesChartcontainer"></div>
</figure>



