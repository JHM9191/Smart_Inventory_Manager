encodeURIComponent();


// register 할때 id 중복 check

$(function() {
	// 아이디 중복체크
	$('#hqid').blur(function() {
		// alert($('#u_id').val())
		$.ajax({
			type : "POST",
			url : "idCheck.top",
			data : {
				"hqid" : $('#hqid').val()
			},
			success : function(data) { // data : checkSignup에서 넘겨준 결과값
				if ($.trim(data) == "YES") {
					if ($('#hqid').val() != '') {
						alert( '사용가능한 id입니다');
						$request.abort();
					}
				} else {
					if ($('#hqid').val() != '') {
						alert( '중복되는 id입니다' );						
						$('#hqid').val('');
						$('#hqid').focus();
					}
				}
			}
		})
	})

});










