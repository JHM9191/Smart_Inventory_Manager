encodeURIComponent();

$(function() {
	$('#password').blur(function() {
		$.ajax({
			type : "POST",
			url : "logincheckup.top",
			data : {
				"ID" : $('#ID').val(),
				"password" : $('#password').val(),
				"radio" : $('input[name="radio"]:checked').val()
			},
			success : function(data) {
				if ($.trim(data) == "NO") {
					if ($('#ID').val() != '' && $('#password').val() != '') {
						alert("check your id or password one more time!")
						$('#ID').val('');
						$('#password').val('');
					}

				}
			}
		})
	})

});


