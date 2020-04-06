<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Register TEST</title>
<meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no'
	name='viewport' />
<link rel="icon" href="assets/img/icon.ico" type="image/x-icon" />

<!-- Fonts and icons -->
<script src="assets/js/plugin/webfont/webfont.min.js"></script>
<script>
	WebFont.load({
		google : {
			"families" : [ "Open+Sans:300,400,600,700" ]
		},
		custom : {
			"families" : [ "Flaticon", "Font Awesome 5 Solid",
					"Font Awesome 5 Regular", "Font Awesome 5 Brands" ],
			urls : [ 'assets/css/fonts.css' ]
		},
		active : function() {
			sessionStorage.fonts = true;
		}
	});
		var count = 1;
		function addForm() {
			var addedFormDiv = document.getElementById("inputarea");
			var str = "";
			str += '<input type="text" class="form-control" id="address'
					+ count + '" ' + 'placeholder="�ּҸ� �Է��ϱ� ���� Ŭ���ϼ���" ';
			str += 'onclick="goPopup(';
			str += count;
			str += ')" >';
			// �߰��� ��(�� �� HTML)
			var addedDiv = document.createElement("div"); // �� ����
			addedDiv.id = "added_" + count; // �� Div�� ID �� �� (������ ����)
			addedDiv.innerHTML = str; // �� Div�ȿ� HTML����
			addedFormDiv.appendChild(addedDiv); // ������ DIV�� ������ �� ����
			count++;
			document.baseForm.count.value = count;// ���� �������� �� ���� ���� �ѱ���� �����ϱ� ���� ���� ���� ī��Ʈ ����
		}
		function delForm() {
			var addedFormDiv = document.getElementById("inputarea");
			if (count > 1) { // ���� ���� �ΰ� �̻��̸�
				var addedDiv = document.getElementById("added_" + (--count));
				addedFormDiv.removeChild(addedDiv); // �� ����
			} else { // �� ���� ���� �����ִٸ�
				document.baseForm.reset(); // �� ���� ����
			}
	
	}
	document.domain = "127.0.0.1";
	
	function goPopup(num) {
		var pop = window.open("view/address/jusoPopup.jsp", "pop",
				"width=570,height=420, scrollbars=yes, resizable=yes");
	}
	function jusoCallBack(roadFullAddr, addrDetail) {
		var number = 0;
		var inputid = "address"+number+"";
		while(true){
			var inputid = "address"+number+"";
			if(document.getElementById(inputid).value.length>0){
				number+=1;
			}else{
				document.getElementById(inputid).value = roadFullAddr;		
				break;
			}	
		}
	}
</script>


<!-- CSS Files -->
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/azzara.min.css">
</head>


<body class="login">
	<div class="wrapper wrapper-login">
		<div class="container container-login animated fadeIn">
			<h3 class="text-center">Sign Up</h3>
			<div class="login-form">

				<!--  �̸�  START -->
				<div class="form-group">
					<label for="fullname" class="placeholder"><b>Fullname</b></label> <input
						id="fullname" name="fullname" type="text" class="form-control"
						required>
				</div>
				<!--  �̸�  END -->

				<!--  ID  START-->
				<div class="form-group">
					<label for="ID" class="placeholder"><b>ID</b></label> <input
						id="ID" name="fullname" type="text" class="form-control" required>
				</div>
				<!--  ID  END-->

				<!--  PWD START -->
				<div class="form-group">
					<label for="password" class="placeholder"><b>Password</b></label> <a
						href="#" class="link float-right">Forget Password ?</a>
					<div class="position-relative">
						<input id="passwordsignin" name="passwordsignin" type="password"
							class="form-control" required>
						<div class="show-password">
							<i class="flaticon-interface"></i>
						</div>
					</div>
				</div>
				<!--  PWD END -->

				<!--  PWD_CONFRIM START -->
				<div class="form-group">
					<label for="confirmpassword" class="placeholder"><b>Confirm
							Password</b></label>
					<div class="position-relative">
						<input id="confirmpassword" name="confirmpassword" type="password"
							class="form-control" required>
						<div class="show-password">
							<i class="flaticon-interface"></i>
						</div>
					</div>
				</div>

				<!--  PWD_CONFRIM END -->

				<!--  ��ȭ��ȣ START -->
				<div class="form-group">
					<label for="phonenumber" class="placeholder"><b>��ȭ��ȣ</b></label> <input
						id="phonenumber" name="phonenumber" type="text"
						class="form-control" required>
				</div>
				<!--  ��ȭ��ȣ  END -->

				<!--  �ּ��Է� START -->
				<div class="form-group">
					<label for="addr" class="placeholder"><b>address</b></label> <a
						href="#" class="link float-right">
						<button class="btn" onclick="addForm()">+</button>
						<button class="btn" onclick="delForm()">��</button>
					</a>

					<div id="addressarea">
						<input type="text" id="address0" name="u_address"
							placeholder="�ּҸ� �Է��ϱ� ���� Ŭ���ϼ���" class="form-control"
							onclick="goPopup(0)">
						<div id="inputarea"></div>
					</div>

				</div>
				<!--  �ּ��Է�  END -->

				<!--  ������ ��� �� SUBMIT ��ư START  -->
				<div class="row form-action">
					<div class="col-md-6">
						<a href="#" id="show-signin"
							class="btn btn-danger btn-link w-100 fw-bold">Cancel</a>
					</div>
					<div class="col-md-6">
						<a href="#" class="btn btn-primary w-100 fw-bold">Submit</a>
					</div>
				</div>

				<!--  ������ ��� �� SUBMIT ��ư END  -->
			</div>
		</div>
	</div>
	
	<script src="assets/js/core/jquery.3.2.1.min.js"></script>
	<script src="assets/js/plugin/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
	<script src="assets/js/core/popper.min.js"></script>
	<script src="assets/js/core/bootstrap.min.js"></script>
	<script src="assets/js/ready.js"></script>
</body>
</html>