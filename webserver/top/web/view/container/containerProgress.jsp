<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.3/jquery.min.js"></script>

<script>
	// 컨테이너 리스트 show 스크립트 //
	window.onload = function() {
		setInterval("getData('${chainID}')", 3000);
	}

	function getData(chainID) {
		console.log('chainID : ' + chainID);

		$.ajax({
			url : 'getRealTimeContainerData.top?chainID=' + chainID,
			success : function(data) {
				console.log(data);

				//setChart(data);
				makeProgressBar(data);
			}
		});

	};

	function makeProgressBar(data) {

		$('#showContainerList').html('');
		for (var i = 0; i < data.length; i++) {
			var result = '';
			result += "<div class='top_progressbar col-12 col-md-4'>"
			result += "<div class='card'>"
			result += "<div class='card-header'>"
			result += "<div class='card-title'><p class=\"h1\"><b>"
					+ data[i]['ingName']
					+ "</b></p><p class=\"text-info\">(컨테이너 ID : "
					+ data[i]['conID'] + ")</p></div>";
			result += '<div id="task-complete" class="chart-circle mt-4 mb-3">';
			result += '<div class="circles-wrp" style="position: relative; display: inline-block;">';
			result += '<svg xmlns="http://www.w3.org/2000/svg" width="150" height="150">';
			result += '<path fill="transparent" stroke="#eee" stroke-width="8" d="M 74.98553920253764 4.000001472638488 A 71 71 0 1 1 74.90138242439691 4.000068488950063 Z" class="circles-maxValueStroke"></path>';
			result += '<path fill="transparent" stroke="#1D62F0" stroke-width="8" d="M 74.98553920253764 4.000001472638488 A 71 71 0 1 1 7.458509176231658 53.11057293342702 " class="circles-valueStroke"></path></svg>';
			result += '<div class="circles-text" style="position: absolute; top: 0px; left: 0px; text-align: center; width: 100%; font-size: 52.5px; height: 150px; line-height: 150px;">';
			result += ((data[i]['conCurrWeight'] / data[i]['conFullWeight']) * 100)
					.toFixed(2)
					+ '%';
			result += '</div></div></div></div></div></div>';
			$('#showContainerList').append(result);
		}

	}
	/* 
	 function setChart(data) {
	 var cnt = 1;
	 var chartname = "doughnutChart";
	 $('#showContainerList').html('');
	 for (var i = 0; i < data.length; i++) {
	 var results = '';
	 results += "<div class='top_progressbar col-12 col-md-4'>"
	 results += "<div class='card'>"
	 results += "<div class='card-header'>"
	 results += "<div class='card-title'><p><b>" + data[i]['ingName']
	 + "</b></p>컨테이너" + cnt + ":" + data[i]['conID'] + "</div>"
	 results += "<div class='chart-container'>"
	 results += "<canvas id ='" + (chartname + cnt)
	 + "'> style = 'width: 33%; height: 33%'></canvas>"
	 results += "</div></div></div></div></div>"
	 $('#showContainerList').append(results);

	 var maxWeight = data[i]['conFullWeight'];
	 var currWeight = data[i]['conCurrWeight'];
	 var warningWeight = data[i]['conWarningWeight'];

	 if (warningWeight >= currWeight) {
	 var warningList = '';
	 warningList += "컨테이너 아이디 : data[i]['conID'] ,"
	 warningList += "경고무게 :  " + warningWeight + ".0kg,  현재무게:  "
	 + currWeight + ".0kg <br>"
	 // $('#warningContainerList').append(warningList);
	 }

	 makeChart(chartname, cnt, maxWeight, currWeight, warningWeight);
	 cnt++;
	 }
	 }
	 */
	/*
	function showConList() {
		alert('${containervo}');
		var i = 1;
		var chartname = "doughnutChart";
		<c:forEach var = "u" items = "${containervo }">
		var results = '';
		results += "<div class='top_progressbar'>"
		results += "<div class='card'>"
		results += "<div class='card-header'>"
		results += "<div class='card-title'>컨테이너" + i + ":${u.conID} </div>"
		results += "<div class='chart-container'>"
		results += "<canvas id ='" + (chartname + i)
				+ "'> style = 'width: 33%; height: 33%'></canvas>"
		results += "</div></div></div></div></div>"
		$('#showContainerList').append(results);

		var maxWeight = ${u.conMaxWeight};
		var currWeight = ${u.conCurrWeight};
		var warningWeight = ${u.conWarningWeight};

		if (warningWeight >= currWeight) {
			var warningList = '';
			warningList += "컨테이너 아이디 : ${u.conID} ,"
			warningList += "경고무게 :  " + warningWeight + ".0kg,  현재무게:  "
					+ currWeight + ".0kg <br>"
			$('#warningContainerList').append(warningList);
		}

		makeChart(chartname, i, maxWeight, currWeight, warningWeight);
		i++;
		</c:forEach>
	}
	
	 */

	/* function makeChart(chartname, i, maxWeight, currWeight, warningWeight) {
		var doughnutChart = document.getElementById((chartname + i))
				.getContext('2d');
		var myDoughnutchart = new Chart((chartname + i), {
			type : 'doughnut',
			data : {
				datasets : [ {
					data : [ currWeight, maxWeight - currWeight ],
					backgroundColor : [ '#A6E1B1', '#DF6979' ]
				} ],

				labels : [ '현재재고량', '사용한재고량' ]
			},
			options : {
				responsive : true,
				maintainAspectRatio : false,
				legend : {
					position : 'bottom'
				},
				layout : {
					padding : {
						left : 10,
						right : 10,
						top : 10,
						bottom : 10
					}
				}
			/*,
			animiation : {
				animateRotate : false
			}*/
			}
		});

	} */
</script>

<h4 class="page-title">재고현황('${chainID }')</h4>
<div class="row">
	<div class="col-12 col-md-8">
		<div class="page-category">
			<h3>현재 재고가 경고 수준인 물품 목록</h3>
			<div id="warningContainerList"></div>
		</div>
	</div>
	<div class="col-sm-3 col-md-3">
		<div class="card card-stats card-round">
			<div class="card-body ">
				<div class="row">
					<div class="col-5">
						<div class="icon-big text-center">
							<i class="flaticon-coins text-success"></i>
						</div>
					</div>
					<div class="col col-stats">
						<div class="numbers">
							<p class="card-category">총매출</p>
							<h4 class="card-title">${totSale}&nbsp;만원</h4>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!--  임시로 여기다 containerList 넣기  -->
<div class="temp">
	<div id="showContainerList"></div>
</div>


