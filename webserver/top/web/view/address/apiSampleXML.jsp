<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/JavaScript" src="/js/jquery-1.8.3.min.js" ></script>

<script language="javascript">
function getAddr(){
	$.ajax({
		 url :"http://www.juso.go.kr/addrlink/addrLinkApiJsonp.do"  //인터넷망
		,type:"post"
		,data:$("#form").serialize()
		,dataType:"jsonp"
		,crossDomain:true
		,success:function(xmlStr){
			if(navigator.appName.indexOf("Microsoft") > -1){
				var xmlData = new ActiveXObject("Microsoft.XMLDOM");
				xmlData.loadXML(xmlStr.returnXml)
			}else{
				var xmlData = xmlStr.returnXml;
			}
			$("#list").html("");
			var errCode = $(xmlData).find("errorCode").text();
			var errDesc = $(xmlData).find("errorMessage").text();
			if(errCode != "0"){
				alert(errCode+"="+errDesc);
			}else{
				if(xmlStr != null){
					makeList(xmlData);
				}
			}
		}
	    ,error: function(xhr,status, error){
	    	alert("에러발생");
	    }
	});
}

function makeList(xmlStr){
	var htmlStr = "";
	htmlStr += "<table>";
	$(xmlStr).find("juso").each(function(){
		htmlStr += "<tr>";
		htmlStr += "<td>"+$(this).find('roadAddr').text()+"</td>";
		htmlStr += "<td>"+$(this).find('roadAddrPart1').text()+"</td>";
		htmlStr += "<td>"+$(this).find('roadAddrPart2').text()+"</td>";
		htmlStr += "<td>"+$(this).find('jibunAddr').text()+"</td>";
		htmlStr += "<td>"+$(this).find('engAddr').text()+"</td>";
		htmlStr += "<td>"+$(this).find('zipNo').text()+"</td>";
		htmlStr += "<td>"+$(this).find('admCd').text()+"</td>";
		htmlStr += "<td>"+$(this).find('rnMgtSn').text()+"</td>";
		htmlStr += "<td>"+$(this).find('bdMgtSn').text()+"</td>";
		htmlStr += "<td>"+$(this).find('detBdNmList').text()+"</td>";
		/** API 서비스 제공항목 확대 (2017.02) **/
		htmlStr += "<td>"+$(this).find('bdNm').text()+"</td>";
		htmlStr += "<td>"+$(this).find('bdKdcd').text()+"</td>";
		htmlStr += "<td>"+$(this).find('siNm').text()+"</td>";
		htmlStr += "<td>"+$(this).find('sggNm').text()+"</td>";
		htmlStr += "<td>"+$(this).find('emdNm').text()+"</td>";
		htmlStr += "<td>"+$(this).find('liNm').text()+"</td>";
		htmlStr += "<td>"+$(this).find('rn').text()+"</td>";
		htmlStr += "<td>"+$(this).find('udrtYn').text()+"</td>";
		htmlStr += "<td>"+$(this).find('buldMnnm').text()+"</td>";
		htmlStr += "<td>"+$(this).find('buldSlno').text()+"</td>";
		htmlStr += "<td>"+$(this).find('mtYn').text()+"</td>";
		htmlStr += "<td>"+$(this).find('lnbrMnnm').text()+"</td>";
		htmlStr += "<td>"+$(this).find('lnbrSlno').text()+"</td>";
		htmlStr += "<td>"+$(this).find('emdNo').text()+"</td>";
		htmlStr += "</tr>";
	});
	htmlStr += "</table>";
	$("#list").html(htmlStr);
}

function enterSearch() {
	var evt_code = (window.netscape) ? ev.which : event.keyCode;
	if (evt_code == 13) {    
		event.keyCode = 0;  
		getAddr(); //jsonp사용시 enter검색 
	} 
}
</script>
<title>Insert title here</title>
</head>
<body>
<form name="form" id="form" method="post">
	<input type="text" name="currentPage" value="1"/> <!-- 요청 변수 설정 (현재 페이지. currentPage : n > 0) -->
	<input type="text" name="countPerPage" value="10"/><!-- 요청 변수 설정 (페이지당 출력 개수. countPerPage 범위 : 0 < n <= 100) --> 
	<input type="text" name="confmKey" value="TESTJUSOGOKR"/><!-- 요청 변수 설정 (승인키) -->
	<input type="text" name="keyword" value="" onkeydown="enterSearch();"/><!-- 요청 변수 설정 (키워드) -->
	<input type="button" onClick="getAddr();" value="주소검색하기"/>
	<div id="list" ></div><!-- 검색 결과 리스트 출력 영역 -->
</form>
</body>
</html> 