<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.3/jquery.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>
<style>
#container_highcharts {
	height: 400px;
}

.highcharts-figure, .highcharts-data-table table {
	min-width: 310px;
	max-width: 800px;
	margin: 1em auto;
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
	function display() {

		Highcharts
				.chart(
						'container_highcharts',
						{
							chart : {
								type : 'column'
							},
							title : {
								text : 'Today\'s Total Sales for All Chains'
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
								min : 0,
								title : {
									text : 'Total Sales(Ten thousand KRW)'
								}
							},
							legend : {
								enabled : false
							},
							tooltip : {
								pointFormat : 'Population in 2017: <b>{point.y:.1f} millions</b>'
							},
							series : [ {
								name : 'Population',
								data : [ [ 'Shanghai', 24.2 ],
										[ 'Beijing', 20.8 ],
										[ 'Karachi', 14.9 ],
										[ 'Shenzhen', 13.7 ],
										[ 'Guangzhou', 13.1 ],
										[ 'Istanbul', 12.7 ],
										[ 'Mumbai', 12.4 ], [ 'Moscow', 12.2 ],
										[ 'São Paulo', 12.0 ],
										[ 'Delhi', 11.7 ],
										[ 'Kinshasa', 11.5 ],
										[ 'Tianjin', 11.2 ],
										[ 'Lahore', 11.1 ],
										[ 'Jakarta', 10.6 ],
										[ 'Dongguan', 10.6 ],
										[ 'Lagos', 10.6 ],
										[ 'Bengaluru', 10.3 ],
										[ 'Seoul', 9.8 ], [ 'Foshan', 9.3 ],
										[ 'Tokyo', 9.3 ] ],
								dataLabels : {
									enabled : true,
									rotation : -90,
									color : '#FFFFFF',
									align : 'right',
									format : '{point.y:.1f}', // one decimal
									y : 10, // 10 pixels down from the top
									style : {
										fontSize : '13px',
										fontFamily : 'Verdana, sans-serif'
									}
								}
							} ]
						});
	};

	/* function getData() {
		$.ajax({
			url : '',
			success : function(data) {
				display(data);
			}
		});
	};
	 */
	$(document).ready(function() {
		display();
		//getData();
	});
</script>
<h1 class="page-title">Main Page</h1>
<div class="card">
	<div class="card-body">
		<div class="row">
			<div class="col-5 col-md-4">
				<div class="nav flex-column nav-pills nav-secondary"
					id="v-pills-tab" role="tablist" aria-orientation="vertical">
					<a class="nav-link active" id="v-pills-home-tab" data-toggle="pill"
						href="#v-pills-home" role="tab" 
						aria-controls="v-pills-home"
						aria-selected="true">All</a> 
					<a class="nav-link"
						id="v-pills-profile-tab" data-toggle="pill"
						href="#v-pills-profile" role="tab" 
						aria-controls="v-pills-profile"
						aria-selected="false">Chain01</a> 
					<a class="nav-link"
						id="v-pills-messages-tab" data-toggle="pill"
						href="#v-pills-messages" role="tab"
						aria-controls="v-pills-messages" aria-selected="false">Chain02</a>
				</div>
			</div>
			<div class="col-7 col-md-8">
				<div class="highcharts-figure">
					<div id="container_highcharts"></div>
				</div>
			</div>
		</div>
	</div>
</div>
<h1 class="card-sub">Chart License: Highcharts.com</h1>
