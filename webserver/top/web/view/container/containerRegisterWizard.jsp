<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.3/jquery.min.js"></script>

<script>
	var table;
	var num = 0;
	function goToNext(input) {
		console.log(input);
		$('#about').removeClass('active');
		$('#' + input).addClass('active');
		$('.step a').removeClass('active');
		$('.step:eq(1) a').addClass('active');
	};

	function registerContainer(input) {

		console.log(input);
		$('#' + input).removeClass('active');
		$('#regiContainerList').addClass('active');
		$('.step a').removeClass('active');
		$('.step:eq(2) a').addClass('active');

		var list = $('#addContainerTable_' + input).DataTable().rows().data();

		console.log(list);
		console.log(list.length);
		//console.log(JSON.stringify(list));

		var array = [];
		for (var i = 0; i < list.length; i++) {
			var container = list[i];
			console.log(container);
			if (input == 'sameContainer') {
				var size = container[11];
				var ingName = container[3];
				var ingID = container[9];
				var quantity = container[5];
				var warning = container[10];
				var chainID = container[12];
			} else {
				var size = container[12];
				var ingName = container[4];
				var ingID = container[10];
				var quantity = container[6];
				var warning = container[11];
				var chainID = container[13];
				var chainName = container[1];
				console.log('chainID : ' + chainID);
				console.log('chainName : ' + chainName);
			}

			if (input == 'sameContainer') {
				chainID = 'same';
			}
			//console.log('chainlist : ' + chainlist);
			//console.log('typeof(chainlist) : ' + typeof (chainlist));
			var obj = new Object();
			obj.size = size;
			obj.ingName = ingName;
			obj.ingID = ingID;
			obj.quantity = quantity;
			obj.warning = warning;
			obj.chainID = chainID;
			obj.chainName = chainName;
			array.push(obj);
		}
		console.log(array);
		$.ajax({
			url : 'regiContainer.top',
			type : 'post',
			contentType : 'application/json; charset=utf-8',
			dataType : 'json',
			data : JSON.stringify(array),
			success : function(result) {
				alert('Container(s) Successfully Registered.');
				console.log('success return data : ' + result[0]);
				console.log(result[0]['conID']);
				console.log(result[0]['conSize']);
				showConList(result);
			},
			error : function(response) {
				alert('error : ' + response);
			}
		});

		/*
		$('#regiContainerListTable').DataTable({
			retrieve : true,
			// paging: false,
			ajax : {
				url : 'regiContainer.top',
				type : 'POST',
				data : {list : list},
				dataType : 'json'
				//dataSrc : ''
			}
		});
		 */

		/* , 
			columns: [
				{data: 'wh_ID'},
				{data: 'item_code'},
				{data: 'item_name'},
				{data: 'item_quantity'},
				{data: 'remaining'}] */

	}

	function showConList(conList) {
		$('#regiContainerListTable').DataTable();
		var num = 1;
		for (var i = 0; i < conList.length; i++) {
			var conID = conList[i]['conID'];
			var conSize = conList[i]['conSize'];
			var conMaxWeight = conList[i]['conMaxWeight'];
			var conFullWeight = conList[i]['conFullWeight'];
			var conFullQuantity = conList[i]['conFullQuantity'];
			var conWarningWeight = conList[i]['conWarningWeight'];
			var conWarningQuantity = conList[i]['conWarningQuantity'];
			var ingName = conList[i]['ingName'];
			var chainName = conList[i]['chainName'];

			//var action = ;

			$('#regiContainerListTable').dataTable().fnAddData(
					[ num, conID, conSize, conMaxWeight, conFullWeight,
							conFullQuantity, conWarningWeight,
							conWarningQuantity, ingName, chainName ]);

			num++;
		}

	}

	//********************************************//
	//
	function addContainer(input) {

		console.log('addContainer : ' + input);
		var size = $('#select_size').val();
		var max_container_weight;
		var size_name;
		var ing = $('#select_ing').val();
		var weight = $('input[name="' + ing + '_weight"]').val();
		var cnt = $('#select_cnt').val();
		var warning = $('#select_warning').val();
		var unit = $('input[name="' + ing + '_unit').val();
		var price = $('input[name="' + ing + '_price').val();
		var ingID = $('#ingID_same_' + ing).val();
		if (size == "small") {
			if ((weight * cnt) > 20) {
				swal("스몰 사이즈 컨테이너에는 20kg 이하의 물량만 담을 수 있습니다.", {
					icon : "error",
					buttons : {
						confirm : {
							className : 'btn btn-danger'
						}
					}
				});
				return;
			}
			max_container_weight = '20kg';
			size_name = "스몰";
		} else if (size == "medium") {
			if ((weight * cnt) > 100) {
				swal("미디엄 사이즈 컨테이너에는 100kg 이하의 물량만 담을 수 있습니다.", {
					icon : "error",
					buttons : {
						confirm : {
							className : 'btn btn-danger'
						}
					}
				});
				return;
			}
			max_container_weight = '100kg';
			size_name = "미디엄";
		} else if (size == "large") {
			if ((weight * cnt) > 500) {
				swal("라지 사이즈 컨테이너에는 500kg 이하의 물량만 담을 수 있습니다.", {
					icon : "error",
					buttons : {
						confirm : {
							className : 'btn btn-danger'
						}
					}
				});
				return;
			}
			max_container_weight = '500kg';
			size_name = "라지";
		} else {
			return;
		}

		console.log(size);
		console.log(ing);
		console.log('ingID : ' + ingID);
		console.log(price);
		console.log(cnt);
		console.log(unit);
		console.log(weight);
		console.log(weight * cnt);

		num += 1;
		var action = '<td> <div class=\"form-button-action\"> <button type=\"button" onclick="editRow('
				+ num
				+ ',\''
				+ size
				+ '\',\''
				+ ing
				+ '\','
				+ cnt
				+ ','
				+ warning
				+ ',\''
				+ input
				+ '\');\" data-toggle=\"modal\" data-target=\"#updateRowModal\" title="" class=\"edit btn btn-link btn-primary btn-lg\" data-original-title=\"Edit Task\"> <i class="fa fa-edit"></i> </button> <button type="button" data-toggle="tooltip" title="" class="remove btn btn-link btn-danger" data-original-title="Remove" onclick="removeRow(\''
				+ input
				+ '\');"> <i class="fa fa-times"></i> </button> </div> </td>';

		$('#addContainerTable_sameContainer').dataTable().fnAddData(
				[ num, size_name, max_container_weight, ing, weight + unit,
						cnt, (cnt * weight) + unit,
						warning + '(' + (weight * warning) + unit + ' )',
						action, ingID, warning, size, '' ]);

		table = $('#addContainerTable_sameContainer').DataTable();
		$('#addContainerTable_sameContainer tbody').on('mouseenter', 'tr',
				function() {
					console.log('entered on mouseenter');
					$(this).addClass('selected');
				});
		$('#addContainerTable_sameContainer tbody').on('mouseleave', 'tr',
				function() {
					console.log('entered on mouseleave');
					$(this).removeClass('selected');
				});
	};

	function removeRow(input) {

		console.log('removeRow()');
		console.log(input);

		var table = $('#addContainerTable_' + input).DataTable();

		table.row('.selected').on(
				'click',
				'tr button.remove',
				function() {
					$('#addContainerTable_' + input).dataTable().fnDeleteRow(
							table.row('.selected'));
				});

	};

	function editRow(num, size, ing, cnt, warning, input) {

		console.log('num : ' + num);
		console.log(size);
		console.log(ing);
		console.log(cnt);
		console.log(warning);
		console.log('input : ' + input);

		$('#select_size_modal option[value=' + size + ']').prop('selected',
				true);
		$('#select_ing_modal option[value=' + ing + ']').prop('selected', true);
		$('#select_cnt_modal option[value=' + cnt + ']').prop('selected', true);
		$('#select_warning_modal option[value=' + warning + ']').prop(
				'selected', true);
		var table = $('#addContainerTable_' + input).DataTable();
		var row = table.row('.selected').index();
		console.log('editRow row : ' + row);
		var chainName = table.row('.selected').data()[1];
		console.log('editRow chainName : ' + chainName);
		var ingID = table.row('.selected').data()[10];
		console.log('editRow ingID : ' + ingID);
		var chainID = table.row('.selected').data()[13];
		console.log('editRow chainID : ' + chainID);

		$('button[name="updateButtonModal"]').attr(
				'onclick',
				'updateRow(' + num + ',' + row + ',\'' + input + '\',\''
						+ chainName + '\',\'' + ingID + '\',' + warning + ',\''
						+ size + '\',\'' + chainID + '\')');

	};

	function updateRow(num, row, input, chainName, ingID, warning, size,
			chainID) {

		var size = $('#select_size_modal').val();
		var max_container_weight;
		var size_name;
		var ing = $('#select_ing_modal').val();
		var weight = $('input[name="' + ing + '_weight"]').val();
		var cnt = $('#select_cnt_modal').val();
		var warning = $('#select_warning_modal').val();
		var unit = $('input[name="' + ing + '_unit').val();
		var price = $('input[name="' + ing + '_price').val();
		if (size == "small") {
			if ((weight * cnt) > 20) {
				swal("스몰 사이즈 컨테이너에는 20kg 이하의 물량만 담을 수 있습니다.", {
					icon : "error",
					buttons : {
						confirm : {
							className : 'btn btn-danger'
						}
					}
				});
				return;
			}
			max_container_weight = '20kg';
			size_name = "스몰";
		} else if (size == "medium") {
			if ((weight * cnt) > 100) {
				swal("미디엄 사이즈 컨테이너에는 100kg 이하의 물량만 담을 수 있습니다.", {
					icon : "error",
					buttons : {
						confirm : {
							className : 'btn btn-danger'
						}
					}
				});
				return;
			}
			max_container_weight = '100kg';
			size_name = "미디엄";
		} else if (size == "large") {
			if ((weight * cnt) > 500) {
				swal("라지 사이즈 컨테이너에는 500kg 이하의 물량만 담을 수 있습니다.", {
					icon : "error",
					buttons : {
						confirm : {
							className : 'btn btn-danger'
						}
					}
				});
				return;
			}
			max_container_weight = '500kg';
			size_name = "라지";
		} else {
			return;
		}

		console.log('num : ' + num);
		console.log('row : ' + row);
		console.log(size);
		console.log(price);
		console.log(cnt);
		console.log(unit);
		console.log(weight);
		console.log(weight * cnt);

		var action = '<td> <div class=\"form-button-action\"> <button type=\"button" onclick="editRow('
				+ num
				+ ',\''
				+ size
				+ '\',\''
				+ ing
				+ '\','
				+ cnt
				+ ','
				+ warning
				+ ',\''
				+ input
				+ '\');\" data-toggle=\"modal\" data-target=\"#updateRowModal\" title="" class=\"edit btn btn-link btn-primary btn-lg\" data-original-title=\"Edit Task\"> <i class="fa fa-edit"></i> </button> <button type="button" data-toggle="tooltip" title="" class="remove btn btn-link btn-danger" data-original-title="Remove" onclick="removeRow(\''
				+ input
				+ '\');"> <i class="fa fa-times"></i> </button> </div> </td>';

		if (input == 'sameContainer') {
			$('#addContainerTable_sameContainer').dataTable().fnUpdate(
					[ num, size_name, max_container_weight, ing, weight + unit,
							cnt, (cnt * weight) + unit,
							warning + '(' + (weight * warning) + unit + ' )',
							action ], row); // Row
		} else {
			$('#addContainerTable_diffContainer').dataTable().fnUpdate(
					[ num, chainName, size_name, max_container_weight, ing,
							weight + unit, cnt, (cnt * weight) + unit,
							warning + '(' + (weight * warning) + unit + ' )',
							action, ingID, warning, size, chainID ], row); // Row
		}

		$('#updateRowModal').modal('hide');

	};

	//********************************************//
	var chainCnt = 0;

	function chainSelected(chainID, chainName) {
		$('#' + chainID).remove();
		$('#selectedChains ul')
				.append(
						'<li class="nav-item" id="'+ chainID + '"><a class="nav-link active" data-toggle="pill" href="#pills-home-nobd" role="tab" aria-controls="pills-home-nobd" aria-selected="true" onclick="chainCancelled(\''
								+ chainID
								+ '\',\''
								+ chainName
								+ '\');">'
								+ chainName + '</a></li>');
		/* chainArray.push(chainName); */

		++chainCnt;
		console.log(chainCnt);
	};

	function chainCancelled(chainID, chainName) {
		$('#' + chainID).remove();
		$('#unselectedChains ul')
				.append(
						'<li class="nav-item" id="'+ chainID + '"><a class="nav-link active" data-toggle="pill" href="#pills-home-nobd" role="tab" aria-controls="pills-home-nobd" aria-selected="true" onclick="chainSelected(\''
								+ chainID
								+ '\',\''
								+ chainName
								+ '\');">'
								+ chainName + '</a></li>');
		--chainCnt;
		console.log(chainCnt);

	};

	var num_2 = 1;
	function addContainer_manyChains(input) {
		var size = $('#select_size_2').val();
		var max_container_weight;
		var size_name;
		var ing = $('#select_ing_2').val();
		var weight = $('input[name="' + ing + '_weight_2"]').val();
		var cnt = $('#select_cnt_2').val();
		var warning = $('#select_warning_2').val();
		var ingID = $('#ingID_diff_' + ing).val();
		var unit = $('input[name="' + ing + '_unit_2').val();
		var price = $('input[name="' + ing + '_price_2').val();
		if (size == "small") {
			if ((weight * cnt) > 20) {
				swal("스몰 사이즈 컨테이너에는 20kg 이하의 물량만 담을 수 있습니다.", {
					icon : "error",
					buttons : {
						confirm : {
							className : 'btn btn-danger'
						}
					}
				});
				return;
			}
			max_container_weight = '20kg';
			size_name = "스몰";
		} else if (size == "medium") {
			if ((weight * cnt) > 100) {
				swal("미디엄 사이즈 컨테이너에는 100kg 이하의 물량만 담을 수 있습니다.", {
					icon : "error",
					buttons : {
						confirm : {
							className : 'btn btn-danger'
						}
					}
				});
				return;
			}
			max_container_weight = '100kg';
			size_name = "미디엄";
		} else if (size == "large") {
			if ((weight * cnt) > 500) {
				swal("라지 사이즈 컨테이너에는 500kg 이하의 물량만 담을 수 있습니다.", {
					icon : "error",
					buttons : {
						confirm : {
							className : 'btn btn-danger'
						}
					}
				});
				return;
			}
			max_container_weight = '500kg';
			size_name = "라지";
		} else {
			return;
		}

		console.log('input : ' + input);

		for (var i = 0; i < chainCnt; i++) {
			var action = '<td> <div class=\"form-button-action\"> <button type=\"button" onclick="editRow('
					+ num_2
					+ ',\''
					+ size
					+ '\',\''
					+ ing
					+ '\','
					+ cnt
					+ ','
					+ warning
					+ ',\''
					+ input
					+ '\');\" data-toggle=\"modal\" data-target=\"#updateRowModal\" title="" class=\"edit btn btn-link btn-primary btn-lg\" data-original-title=\"Edit Task\"> <i class="fa fa-edit"></i> </button> <button type="button" data-toggle="tooltip" title="" class="remove btn btn-link btn-danger" data-original-title="Remove" onclick="removeRow(\'diffContainer\');"> <i class="fa fa-times"></i> </button> </div> </td>';

			var chainName = $('#selectedChains li:eq(' + i + ') a').text();
			var chainID = $('#selectedChains li:eq(' + i + ')').prop('id');
			console.log('chainName : ' + chainName);
			console.log('chainID : ' + chainID);
			$('#addContainerTable_diffContainer').dataTable().fnAddData(
					[ num_2, chainName, size_name, max_container_weight, ing,
							weight + unit, cnt, (cnt * weight) + unit,
							warning + '(' + (weight * warning) + unit + ' )',
							action, ingID, warning, size, chainID ]);

			num_2++;

		}

		$('#addContainerTable_diffContainer tbody').on('mouseenter', 'tr',
				function() {
					console.log('entered on mouseenter');
					$(this).addClass('selected');
				});
		$('#addContainerTable_diffContainer tbody').on('mouseleave', 'tr',
				function() {
					console.log('entered on mouseleave');
					$(this).removeClass('selected');
				});

		/* $('#selectedChains li').forEach(myFunction);

		function myFunction(value, index, array) {
			console.log(value);
			 
			$('#addContainerTable').dataTable().fnAddData(
					[ num, chainName, size_name, ing, weight + unit,
							cnt, (cnt * weight) + unit,
							max_container_weight, "", action ]);
			
		} 
		;
		 */
	};
</script>

<!-- Modal -->
<div class="modal fade" id="updateRowModal" tabindex="-1" role="dialog"
	aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header no-bd">
				<h5 class="modal-title">
					<span class="fw-mediumbold"> 컨테이너</span> <span class="fw-light">
						수정 </span>
				</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<p class="small">컨테이너를 수정합니다.</p>
				<form>
					<div class="row justify-content-center align-items-center">
						<div class="col-5 col-md-5">
							<label>사이즈</label>
							<div class="select2-input">
								<select id="select_size_modal" name="select_size"
									class="form-control select2-hidden-accessible"
									data-select2-id="basic" tabindex="-1" aria-hidden="true">
									<option value="" data-select2-id="2">&nbsp;</option>
									<optgroup label="사이즈" data-select2-id="15">
										<option value="small" data-select2-id="16">스몰 (Max:
											20kg)</option>
										<option value="medium" data-select2-id="17">미디엄 (Max:
											100kg)</option>
										<option value="large" data-select2-id="17">라지 (Max:
											500kg)</option>
									</optgroup>
								</select>
							</div>
						</div>
						<div class="col-5 col-md-5">
							<label>재료</label>
							<div class="select2-input">
								<select id="select_ing_modal" name="select_ing"
									class="form-control select2-hidden-accessible"
									data-select2-id="basic" tabindex="-1" aria-hidden="true">
									<option value="" data-select2-id="2">&nbsp;</option>
									<optgroup label="재료" data-select2-id="15">
										<c:forEach var="ing" items="${ingList }">
											<option value="${ing.ingName }" data-select2-id="16">${ing.ingName }
												${ing.ingWeight } ${ing.ingUnit } (${ing.ingPrice }원)</option>
										</c:forEach>
										<c:forEach var="ing" items="${ingList }">
											<input type="hidden" name="${ing.ingName }_weight"
												value="${ing.ingWeight }" />
											<input type="hidden" name="${ing.ingName }_unit" id="unit"
												value="${ing.ingUnit }" />
											<input type="hidden" name="${ing.ingName }_price" id="price"
												value="${ing.ingPrice }" />
											<input type="hidden" name="${ing.ingName}_ID"
												id="ingID_modal" value="${ing.ingID }" />
										</c:forEach>
									</optgroup>
								</select>
							</div>
						</div>
						<div class="col-3 col-md-3">
							<label>수량</label>
							<div class="select2-input">
								<select id="select_cnt_modal" name="select_cnt"
									class="form-control select2-hidden-accessible"
									data-select2-id="basic" tabindex="-1" aria-hidden="true">
									<option value="" data-select2-id="2">&nbsp;</option>
									<optgroup label="수량" data-select2-id="15">
										<c:forEach var="i" begin="1" end="50">
											<option value="${i }" data-select2-id="16">${i }</option>
										</c:forEach>
									</optgroup>
								</select>
							</div>
						</div>
						<div class="col-3 col-md-3">
							<label>경고 수준 설정</label>
							<div class="select2-input">
								<select id="select_warning_modal" name="select_warning"
									class="form-control select2-hidden-accessible"
									data-select2-id="basic" tabindex="-1" aria-hidden="true">
									<option value="" data-select2-id="2">&nbsp;</option>
									<optgroup label="경고 수준 설정" data-select2-id="15">
										<c:forEach var="i" begin="1" end="50">
											<option value="${i }" data-select2-id="16">${i }</option>
										</c:forEach>
									</optgroup>
								</select>
							</div>
						</div>
						<input type="hidden" value="" />
					</div>
				</form>
			</div>
			<div class="modal-footer no-bd">
				<button type="button" name="updateButtonModal"
					class="btn btn-primary">수정</button>
				<button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
			</div>
		</div>
	</div>
</div>
<!-- Modal END -->



<div class="row justify-content-center align-items-center">
	<div class="card">
		<div class="card-body">
			<div class="wizard-container wizard-round">
				<div class="wizard-header text-center">
					<h3 class="wizard-title">
						<b>IoT 컨테이너</b> 등록
					</h3>
					<small>가맹점에 필요한 IoT 컨테이너를 등록하세요.</small>
				</div>
				<br> <br>
				<form novalidate="novalidate">
					<div class="wizard-body">
						<div class="row justify-content-center align-items-center">
							<div class="row">
								<ul class="wizard-menu nav nav-pills nav-primary">
									<li class="step" style="width: 33.333333333333336%;"><a
										class="nav-link active" href="#about" data-toggle="tab"
										aria-expanded="true"><i class="fa fa-user mr-0"></i> 1. 적용
											범위 선택</a></li>
									<li class="step" style="width: 33.333333333333336%;"><a
										class="nav-link" href="#account" data-toggle="tab"><i
											class="fa fa-file mr-2"></i>2. 컨테이너 선택 및 적용</a></li>
									<li class="step" style="width: 33.333333333333336%;"><a
										class="nav-link" href="#address" data-toggle="tab"><i
											class="fa fa-map-signs mr-2"></i>3. 적용된 컨테이너 확인</a></li>
									<div class="moving-tab" style="width: 300px;"></div>
								</ul>
							</div>
						</div>
						<br> <br> <br>

						<div class="tab-content">
							<!-- #1 first page : choose -->
							<div class="tab-pane active" id="about">
								<div class="row justify-content-center align-items-center">
									<div class="col-md-4 pl-md-0">
										<div class="card card-pricing">
											<div class="card-header">
												<div class="card-price">
													<span class="price text-primary">기본</span>
													<!-- <span class="text">/년</span> -->
												</div>
											</div>
											<div class="card-body">
												<ul class="specification-list">
													<li><span class="name-specification">범위</span> <span
														class="status-specification">모든 가맹점</span></li>
													<li><span class="name-specification">수정 가능 여부</span> <span
														class="status-specification">예</span></li>

												</ul>
												<h4 class="text text-primary">단 한번의 등록으로 모든 가맹점의 컨테이너
													사이즈 및 수량을 동일하게 적용시킬 수 있습니다.</h4>
											</div>
											<div class="card-footer">
												<input type="button" class="btn btn-info btn-block"
													name="sameContainer" value="선택"
													onclick="goToNext('sameContainer');" />
											</div>

										</div>
									</div>
									<div class="col-md-4 pr-md-0">
										<div class="card card-pricing">
											<div class="card-header">
												<!-- <h4 class="card-title">커스터마이즈</h4> -->
												<div class="card-price">
													<span class="price text-danger">커스터마이즈</span>
													<!-- <span class="text">/년</span> -->
												</div>
											</div>
											<div class="card-body">
												<ul class="specification-list">
													<li><span class="name-specification">범위</span> <span
														class="status-specification">각 가맹점</span></li>
													<li><span class="name-specification">수정 가능 여부</span> <span
														class="status-specification">예</span></li>
												</ul>
												<h4 class="text text-danger">각 가맹점마다 각기 다른 컨테이너 사이즈 및
													수량을 직접 지정할 수 있습니다.</h4>
											</div>
											<div class="card-footer">
												<input type="button" class="btn btn-danger btn-block"
													name="diffContainer" value="선택"
													onclick="goToNext('diffContainer');" />
											</div>
										</div>
									</div>
								</div>
							</div>

							<!-- #2 -->
							<div class="tab-pane" id="sameContainer">
								<div class="row justify-content-center align-items-center">
									<div class="col-md-4 pl-md-0">
										<div class="card card-pricing">
											<div class="card-header">
												<h4 class="card-title">스몰</h4>
												<div class="card-price">
													<span class="price">₩ 100,000</span> <span class="text">/년</span>
												</div>
											</div>
											<div class="card-body">
												<ul class="specification-list">
													<li><span class="name-specification">허용 무게</span> <span
														class="status-specification">0 ~ 20 kg</span></li>
												</ul>
											</div>

										</div>
									</div>
									<div class="col-md-4 pl-md-0">
										<div class="card card-pricing">
											<div class="card-header">
												<h4 class="card-title">미디엄</h4>
												<div class="card-price">
													<span class="price">₩ 200,000</span> <span class="text">/년</span>
												</div>
											</div>
											<div class="card-body">
												<ul class="specification-list">
													<li><span class="name-specification">허용 무게</span> <span
														class="status-specification">0 ~ 100 kg</span></li>
												</ul>
											</div>
										</div>
									</div>
									<div class="col-md-4 pr-md-0">
										<div class="card card-pricing">
											<div class="card-header">
												<h4 class="card-title">라지</h4>
												<div class="card-price">
													<span class="price">₩ 300,000</span> <span class="text">/년</span>
												</div>
											</div>
											<div class="card-body">
												<ul class="specification-list">
													<li><span class="name-specification">허용 무게</span> <span
														class="status-specification">0 ~ 500 kg</span></li>
												</ul>
											</div>
										</div>
									</div>
								</div>
								<div class="row justify-content-center align-items-center">
									<div class="col-3 col-md-3">
										<label>사이즈</label>
										<div class="select2-input">
											<select id="select_size" name="select_size"
												class="form-control select2-hidden-accessible"
												data-select2-id="basic" tabindex="-1" aria-hidden="true">
												<option value="" data-select2-id="2">&nbsp;</option>
												<optgroup label="사이즈" data-select2-id="15">
													<option value="small" data-select2-id="16">스몰
														(Max: 20kg)</option>
													<option value="medium" data-select2-id="17">미디엄
														(Max: 100kg)</option>
													<option value="large" data-select2-id="17">라지
														(Max: 500kg)</option>
												</optgroup>
											</select>
										</div>
									</div>
									<div class="col-5 col-md-5">
										<label>재료</label>
										<div class="select2-input">
											<select id="select_ing" name="select_ing"
												class="form-control select2-hidden-accessible"
												data-select2-id="basic" tabindex="-1" aria-hidden="true">
												<option value="" data-select2-id="2">&nbsp;</option>
												<optgroup label="재료" data-select2-id="15">
													<c:forEach var="ing" items="${ingList }">
														<option value="${ing.ingName }" data-select2-id="16">${ing.ingName }
															${ing.ingWeight } ${ing.ingUnit } (${ing.ingPrice }원)</option>
													</c:forEach>
													<c:forEach var="ing" items="${ingList }">
														<input type="hidden" name="${ing.ingName }_weight"
															value="${ing.ingWeight }" />
														<input type="hidden" name="${ing.ingName }_unit" id="unit"
															value="${ing.ingUnit }" />
														<input type="hidden" name="${ing.ingName }_price"
															id="price" value="${ing.ingPrice }" />
														<input type="hidden" name="${ing.ingName}_ID"
															id="ingID_same_${ing.ingName}" value="${ing.ingID }" />
													</c:forEach>
												</optgroup>
											</select>
										</div>
									</div>
									<div class="col-3 col-md-3">
										<label>수량</label>
										<div class="select2-input">
											<select id="select_cnt" name="select_cnt"
												class="form-control select2-hidden-accessible"
												data-select2-id="basic" tabindex="-1" aria-hidden="true">
												<option value="" data-select2-id="2">&nbsp;</option>
												<optgroup label="수량" data-select2-id="15">
													<c:forEach var="i" begin="1" end="50">
														<option value="${i }" data-select2-id="16">${i }</option>
													</c:forEach>
												</optgroup>
											</select>
										</div>
									</div>
									<div class="col-3 col-md-3">
										<label>경고 수준 설정</label>
										<div class="select2-input">
											<select id="select_warning" name="select_warning"
												class="form-control select2-hidden-accessible"
												data-select2-id="basic" tabindex="-1" aria-hidden="true">
												<option value="" data-select2-id="2">&nbsp;</option>
												<optgroup label="경고 수준 설정" data-select2-id="15">
													<c:forEach var="i" begin="1" end="50">
														<option value="${i }" data-select2-id="16">${i }</option>
													</c:forEach>
												</optgroup>
											</select>
										</div>
									</div>
								</div>
								<br> <br>
								<div class="row justify-content-center align-items-center">
									<div class="col-6 col-md-6">
										<input type="button" class="btn btn-danger btn-block" name=""
											value="적용" onclick="addContainer('sameContainer');" />
									</div>
								</div>
								<br> <br>
								<div class="row">
									<div class="col-md-12">
										<div class="card">
											<div class="card-header">
												<div class="d-flex align-items-center">
													<h4 class="card-title">선택된 IoT 컨테이너</h4>
												</div>
											</div>
											<!-- <button class="btn btn-primary btn-round ml-auto"
												data-toggle="modal" data-target="#addRowModal">
												<i class="fa fa-plus"></i> Add Row
											</button> -->
											<div class="card-body">
												<div class="table-responsive">
													<table id="addContainerTable_sameContainer"
														class="table table-head-bg-default mt-4 table-hover table-striped  dataTables_wrapper container-fluid dt-bootstrap4">
														<thead>
															<tr>
																<th>No.</th>
																<th>컨테이너 사이즈</th>
																<th>최고 허용 무게</th>
																<th>재료</th>
																<th>무게</th>
																<th>수량</th>
																<th>총무게</th>
																<th>경고 수량(무게)</th>
																<th style="width: 5%"></th>
															</tr>
														</thead>
														<tbody id="tbody_data_row">
														</tbody>
													</table>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="row justify-content-center align-items-center">
									<div class="col-6 col-md-6">
										<button type="button" class="btn btn-success btn-block"
											name="" value="등록하기"
											onclick="registerContainer('sameContainer');">
											<span class="btn-label"> <i class="fa fa-plus"></i>
											</span>등록하기
										</button>
									</div>
								</div>
							</div>

							<!-- #3 -->
							<div class="tab-pane" id="diffContainer">
								<div class="row justify-content-center align-items-center">
									<div class="col-md-4 pl-md-0">
										<div class="card card-pricing">
											<div class="card-header">
												<h4 class="card-title">스몰</h4>
												<div class="card-price">
													<span class="price">₩ 100,000</span> <span class="text">/년</span>
												</div>
											</div>
											<div class="card-body">
												<ul class="specification-list">
													<li><span class="name-specification">허용 무게</span> <span
														class="status-specification">0 ~ 20 kg</span></li>
												</ul>
											</div>

										</div>
									</div>
									<div class="col-md-4 pl-md-0">
										<div class="card card-pricing">
											<div class="card-header">
												<h4 class="card-title">미디엄</h4>
												<div class="card-price">
													<span class="price">₩ 200,000</span> <span class="text">/년</span>
												</div>
											</div>
											<div class="card-body">
												<ul class="specification-list">
													<li><span class="name-specification">허용 무게</span> <span
														class="status-specification">0 ~ 100 kg</span></li>
												</ul>
											</div>
										</div>
									</div>
									<div class="col-md-4 pr-md-0">
										<div class="card card-pricing">
											<div class="card-header">
												<h4 class="card-title">라지</h4>
												<div class="card-price">
													<span class="price">₩ 300,000</span> <span class="text">/년</span>
												</div>
											</div>
											<div class="card-body">
												<ul class="specification-list">
													<li><span class="name-specification">허용 무게</span> <span
														class="status-specification">0 ~ 500 kg</span></li>
												</ul>
											</div>
										</div>
									</div>
								</div>
								<div class="row justify-content-center align-items-center">
									<div class="col-3 col-md-3">
										<label>사이즈</label>
										<div class="select2-input">
											<select id="select_size_2" name="select_size"
												class="form-control select2-hidden-accessible"
												data-select2-id="basic" tabindex="-1" aria-hidden="true">
												<option value="" data-select2-id="2">&nbsp;</option>
												<optgroup label="사이즈" data-select2-id="15">
													<option value="small" data-select2-id="16">스몰
														(Max: 20kg)</option>
													<option value="medium" data-select2-id="17">미디엄
														(Max: 100kg)</option>
													<option value="large" data-select2-id="17">라지
														(Max: 500kg)</option>
												</optgroup>
											</select>
										</div>
									</div>
									<div class="col-5 col-md-5">
										<label>재료</label>
										<div class="select2-input">
											<select id="select_ing_2" name="select_ing"
												class="form-control select2-hidden-accessible"
												data-select2-id="basic" tabindex="-1" aria-hidden="true">
												<option value="" data-select2-id="2">&nbsp;</option>
												<optgroup label="재료" data-select2-id="15">
													<c:forEach var="ing" items="${ingList }">
														<option value="${ing.ingName }" data-select2-id="16">${ing.ingName }
															${ing.ingWeight } ${ing.ingUnit } (${ing.ingPrice }원)</option>
													</c:forEach>
													<c:forEach var="ing" items="${ingList }">
														<input type="hidden" name="${ing.ingName }_weight_2"
															value="${ing.ingWeight }" />
														<input type="hidden" name="${ing.ingName }_unit_2"
															value="${ing.ingUnit }" />
														<input type="hidden" name="${ing.ingName }_price_2"
															value="${ing.ingPrice }" />
														<input type="hidden" name="${ing.ingName}_ID"
															id="ingID_diff_${ing.ingName}" value="${ing.ingID }" />
													</c:forEach>
												</optgroup>
											</select>
										</div>
									</div>
									<div class="col-3 col-md-3">
										<label>수량</label>
										<div class="select2-input">
											<select id="select_cnt_2" name="select_cnt"
												class="form-control select2-hidden-accessible"
												data-select2-id="basic" tabindex="-1" aria-hidden="true">
												<option value="" data-select2-id="2">&nbsp;</option>
												<optgroup label="수량" data-select2-id="15">
													<c:forEach var="i" begin="1" end="50">
														<option value="${i }" data-select2-id="16">${i }</option>
													</c:forEach>
												</optgroup>
											</select>
										</div>
									</div>
									<div class="col-3 col-md-3">
										<label>경고 수준 설정</label>
										<div class="select2-input">
											<select id="select_warning_2" name="select_warning_2"
												class="form-control select2-hidden-accessible"
												data-select2-id="basic" tabindex="-1" aria-hidden="true">
												<option value="" data-select2-id="2">&nbsp;</option>
												<optgroup label="경고 수준 설정" data-select2-id="15">
													<c:forEach var="i" begin="1" end="50">
														<option value="${i }" data-select2-id="16">${i }</option>
													</c:forEach>
												</optgroup>
											</select>
										</div>
									</div>


									<br> <br> <br> <br> <br> <br> <br>
									<br>
									<div class="col-12 col-md-12">
										<div class="card">
											<div class="card-body">
												<div class="form-group">
													<label for="comment">선택 가능 가맹점</label>
													<div class="form-control" id="unselectedChains" rows="5">
														<ul class="nav nav-pills nav-secondary nav-pills-no-bd"
															id="pills-tab-without-border" role="tablist">
															<c:forEach var="c" items="${chainList }">
																<li class="nav-item" id="${c.chainID }"><a
																	value="${c.chainID }" class="nav-link active"
																	data-toggle="pill" href="#pills-home-nobd" role="tab"
																	aria-controls="pills-home-nobd" aria-selected="true"
																	onclick="chainSelected('${c.chainID }','${c.chainName }');">${c.chainName }</a>
																</li>
															</c:forEach>
														</ul>
													</div>
												</div>
												<div class="form-group">
													<label for="comment">선택한 가맹점</label>
													<div class="form-control" id="selectedChains" rows="5">
														<ul class="nav nav-pills nav-warning nav-pills-no-bd"
															id="pills-tab-without-border" role="tablist">
														</ul>
													</div>
												</div>
											</div>
										</div>
									</div>
									<br>
								</div>
								<div class="row justify-content-center align-items-center">
									<div class="col-6 col-md-6">
										<input type="button" class="btn btn-danger btn-block" name=""
											value="적용"
											onclick="addContainer_manyChains('diffContainer');" />
									</div>
								</div>

								<br> <br>
								<div class="row">
									<div class="col-md-12">
										<div class="card">
											<div class="card-header">
												<div class="d-flex align-items-center">
													<h4 class="card-title">선택된 IoT 컨테이너</h4>
												</div>
											</div>
											<!-- <button class="btn btn-primary btn-round ml-auto"
												data-toggle="modal" data-target="#addRowModal">
												<i class="fa fa-plus"></i> Add Row
											</button> -->
											<div class="card-body">
												<div class="table-responsive">
													<table id="addContainerTable_diffContainer"
														class="table table-head-bg-default mt-4 table-hover table-striped  dataTables_wrapper container-fluid dt-bootstrap4">
														<thead>
															<tr>
																<th>No.</th>
																<th>가맹점</th>
																<th>컨테이너 사이즈</th>
																<th>최고 허용 무게</th>
																<th>재료</th>
																<th>무게</th>
																<th>수량</th>
																<th>총무게</th>
																<th>경고 수량(무게)</th>
																<th style="width: 5%"></th>
															</tr>
														</thead>
														<tbody id="tbody_data_row">
														</tbody>
													</table>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="row justify-content-center align-items-center">
									<div class="col-6 col-md-6">
										<button type="button" class="btn btn-success btn-block"
											name="" value="등록하기"
											onclick="registerContainer('diffContainer');">
											<span class="btn-label"> <i class="fa fa-plus"></i>
											</span>등록하기
										</button>
									</div>
								</div>
							</div>
							<!-- #4 show registered container list -->

							<div class="tab-pane" id="regiContainerList">

								<div class="card-body">
									<div class="responsive">
										<table id="regiContainerListTable"
											class="table table-head-bg-default mt-4 table-hover table-striped">
											<thead>
												<tr>
													<th>No.</th>
													<th>컨테이너 ID</th>
													<th>컨테이너 사이즈</th>
													<th>컨테이너 최고 허용 무게</th>
													<th>가득찼을 때 무게</th>
													<th>가득찼을 때 수량</th>
													<th>경고 무게</th>
													<th>경고 수량</th>
													<th>재료 ID</th>
													<th>가맹점 ID</th>
												</tr>
											</thead>
											<tbody id="tbody_data_row_3">
											</tbody>
										</table>
									</div>
								</div>
							</div>

						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<script src="assets/js/plugin/sweetalert/sweetalert.min.js"></script>
<script src="assets/js/plugin/select2/select2.full.min.js"></script>
