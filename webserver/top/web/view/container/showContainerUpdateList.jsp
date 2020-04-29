<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>


<script>
	function showConList() {
		$('#containerUpdateListTable').DataTable();
		var num = 1;

		<c:forEach var="c" items="${conList}" >
		var conID = '${c.conID }';
		var conSize = '${c.conSize }';
		var conMaxWeight = '${c.conMaxWeight }';
		var conFullWeight = '${c.conFullWeight }';
		var conFullQuantity = '${c.conFullQuantity }';
		var conWarningWeight = '${c.conWarningWeight }';
		var conWarningQuantity = '${c.conWarningQuantity }';
		var ingID = '${c.ingID }';
		var ingName = '${c.ingName }';
		var ingWeight = '${c.ingWeight }';
		var chainID = '${c.chainID }';
		var chainName = '${c.chainName }';

		var action = '<td> <div class=\"form-button-action\"> <button type=\"button" onclick="editRow('
				+ num
				+ ',\''
				+ conSize
				+ '\',\''
				+ ingName
				+ '\','
				+ conFullQuantity
				+ ','
				+ conWarningQuantity
				+ ');\" data-toggle=\"modal\" data-target=\"#updateRowModal\" title="" class=\"edit btn btn-link btn-primary btn-lg\" data-original-title=\"Edit Task\"> <i class="fa fa-edit"></i> </button> <button type="button" data-toggle="tooltip" title="" class="remove btn btn-link btn-danger" data-original-title="Remove" onclick="removeRow();"> <i class="fa fa-times"></i> </button> </div> </td>';

		$('#containerUpdateListTable').dataTable()
				.fnAddData(
						[ num, conID, conSize, conMaxWeight, conFullWeight,
								conFullQuantity, conWarningWeight,
								conWarningQuantity, ingName, chainName, action,
								ingID, chainID, ingWeight ]);
		num++;
		</c:forEach>
		$('#containerUpdateListTable tbody').on('mouseenter', 'tr', function() {
			console.log('entered on mouseenter');
			$(this).addClass('selected');
		});
		$('#containerUpdateListTable tbody').on('mouseleave', 'tr', function() {
			console.log('entered on mouseleave');
			$(this).removeClass('selected');
		});

	};

	function removeRow() {
		console.log('removeRow()');
		var table = $('#containerUpdateListTable').DataTable();

		var conID = table.row('.selected').data()[1];
		console.log('conID : ' + conID);

		$.ajax({
			url : 'containerRemoveImpl.top?conID=' + conID,
			success : function() {
				console.log('Deleted Successfully!');
			}

		});

		table.row('.selected').on(
				'click',
				'tr button.remove',
				function() {
					$('#containerUpdateListTable').dataTable().fnDeleteRow(
							table.row('.selected'));
				});
	};

	function editRow(num, conSize, ingName, conFullQuantity, conWarningQuantity) {
		console.log('num : ' + num);
		console.log(conSize);
		console.log(ingName);
		console.log(conFullQuantity);
		console.log(conWarningQuantity);

		// change modal select option to row selected data
		$('#select_size_modal option[value=' + conSize + ']').prop('selected',
				true);
		$('#select_ing_modal option[value=' + ingName + ']').prop('selected',
				true);
		$('#select_cnt_modal option[value=' + conFullQuantity + ']').prop(
				'selected', true);
		$('#select_warning_modal option[value=' + conWarningQuantity + ']')
				.prop('selected', true);

		var row_index = $('#containerUpdateListTable').DataTable().row(
				'.selected').index();
		var conID = $('#containerUpdateListTable').DataTable().row('.selected')
				.data()[1];

		$('button[name="updateButtonModal"]').attr('onclick',
				'updateRow(' + row_index + ',\'' + conID + '\')');

	};

	function updateRow(row_index, conID) {
		var row = $('#containerUpdateListTable').DataTable().row(row_index)
				.data();

		// get selected option data
		var ingName = $('#select_ing_modal').val();
		console.log(ingName);
		var ingID = $('#ingID_modal_' + ingName).val();
		var conFullQuantity = $('#select_cnt_modal').val();
		var conWarningQuantity = $('#select_warning_modal').val();

		var obj = new Object();
		obj.conID = conID;
		obj.ingID = ingID;
		obj.conFullQuantity = conFullQuantity;
		obj.conWarningQuantity = conWarningQuantity;

		var num = row[0];
		$
				.ajax({
					url : 'containerUpdateImpl.top',
					type : 'post',
					contentType : 'application/json; charset=utf-8',
					dataType : 'json',
					data : JSON.stringify(obj),
					success : function(data) {
						console.log(data);
						console.log(data.ingID);
						console.log(data.ingName);

						var action = '<td> <div class=\"form-button-action\"> <button type=\"button" onclick="editRow('
								+ num
								+ ',\''
								+ data.conSize
								+ '\',\''
								+ data.ingName
								+ '\','
								+ data.conFullQuantity
								+ ','
								+ data.conWarningQuantity
								+ ');\" data-toggle=\"modal\" data-target=\"#updateRowModal\" title="" class=\"edit btn btn-link btn-primary btn-lg\" data-original-title=\"Edit Task\"> <i class="fa fa-edit"></i> </button> <button type="button" data-toggle="tooltip" title="" class="remove btn btn-link btn-danger" data-original-title="Remove" onclick="removeRow();"> <i class="fa fa-times"></i> </button> </div> </td>';

						$('#containerUpdateListTable').dataTable().fnUpdate(
								[ num, data.conID, data.conSize,
										data.conMaxWeight, data.conFullWeight,
										data.conFullQuantity,
										data.conWarningWeight,
										data.conWarningQuantity, data.ingName,
										data.chainName, action, data.ingID,
										data.chainID, data.ingWeight ],
								row_index); // Row
						$('#updateRowModal').modal('hide');

					}
				});

	}

	$(document).ready(function() {
		showConList();
	});
</script>

<div class="tab-pane" id="containerUpdateList">
	<div class="card-body">
		<div class="table-responsive">
			<table id="containerUpdateListTable"
				class="table table-head-bg-default mt-4 table-hover table-striped dataTables_wrapper container-fluid dt-bootstrap4">
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
						<th style="width: 5%"></th>
					</tr>
				</thead>
				<tbody id="tbody_data_row_4">
				</tbody>
			</table>
		</div>
	</div>
</div>


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
						<!-- <div class="col-5 col-md-5">
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
						</div> -->
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
												id="ingID_modal_${ing.ingName }" value="${ing.ingID }" />
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

