<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<!--   Core JS Files   -->
<script src="../assets/js/core/jquery.3.2.1.min.js"></script>
<script src="../assets/js/core/popper.min.js"></script>
<script src="../assets/js/core/bootstrap.min.js"></script>
<!-- jQuery UI -->
<script
	src="../assets/js/plugin/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>
<script
	src="../assets/js/plugin/jquery-ui-touch-punch/jquery.ui.touch-punch.min.js"></script>
<!-- Bootstrap Toggle -->
<script
	src="../assets/js/plugin/bootstrap-toggle/bootstrap-toggle.min.js"></script>
<!-- jQuery Scrollbar -->
<script
	src="../assets/js/plugin/jquery-scrollbar/jquery.scrollbar.min.js"></script>
<!-- Datatables -->
<script src="../assets/js/plugin/datatables/datatables.min.js"></script>
<!-- Azzara JS -->
<script src="../assets/js/ready.min.js"></script>
<!-- Azzara DEMO methods, don't include it in your project! -->
<script src="../assets/js/setting-demo.js"></script>
<script>
	$(document)
			.ready(
					function() {
						// Add Row
						$('#add-row').DataTable({
							"pageLength" : 10,
						});

						var action = '<td> <div class="form-button-action"> <button type="button" data-toggle="tooltip" title="" class="btn btn-link btn-primary btn-lg" data-original-title="Edit Task"> <i class="fa fa-edit"></i> </button> <button type="button" data-toggle="tooltip" title="" class="btn btn-link btn-danger" data-original-title="Remove"> <i class="fa fa-times"></i> </button> </div> </td>';

						$('#addRowButton').click(
								function() {
									$('#add-row').dataTable().fnAddData(
											[ $("#addName").val(),
													$("#addPosition").val(),
													$("#addOffice").val(),
													action ]);
									$('#addRowModal').modal('hide');

								});
					});
</script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<div class="col-md-12">
			<div class="card">
				<div class="card-header">
					<div class="d-flex align-items-center">
						<h4 class="card-title">Add Row</h4>
						<button class="btn btn-primary btn-round ml-auto"
							data-toggle="modal" data-target="#addRowModal">
							<i class="fa fa-plus"></i> Add Row
						</button>
					</div>
				</div>
				<div class="card-body">
					<!-- Modal -->
					<div class="modal fade" id="addRowModal" tabindex="-1"
						role="dialog" aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header no-bd">
									<h5 class="modal-title">
										<span class="fw-mediumbold"> New</span> <span class="fw-light">
											Row </span>
									</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">
									<p class="small">Create a new row using this form, make
										sure you fill them all</p>
									<form>
										<div class="row">
											<div class="col-sm-12">
												<div class="form-group form-group-default">
													<label>Name</label> <input id="addName" type="text"
														class="form-control" placeholder="fill name">
												</div>
											</div>
											<div class="col-md-6 pr-0">
												<div class="form-group form-group-default">
													<label>Position</label> <input id="addPosition" type="text"
														class="form-control" placeholder="fill position">
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group form-group-default">
													<label>Office</label> <input id="addOffice" type="text"
														class="form-control" placeholder="fill office">
												</div>
											</div>
										</div>
									</form>
								</div>
								<div class="modal-footer no-bd">
									<button type="button" id="addRowButton" class="btn btn-primary">Add</button>
									<button type="button" class="btn btn-danger"
										data-dismiss="modal">Close</button>
								</div>
							</div>
						</div>
					</div>

					<div class="table-responsive">
						<table id="add-row"
							class="display table table-striped table-hover">
							<thead>
								<tr>
									<th>Name</th>
									<th>Position</th>
									<th>Office</th>
									<th style="width: 10%">Action</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th>Name</th>
									<th>Position</th>
									<th>Office</th>
									<th>Action</th>
								</tr>
							</tfoot>
							<tbody>
								<tr>
									<td>Tiger Nixon</td>
									<td>System Architect</td>
									<td>Edinburgh</td>
									<td>
										<div class="form-button-action">
											<button type="button" data-toggle="tooltip" title=""
												class="btn btn-link btn-primary btn-lg"
												data-original-title="Edit Task">
												<i class="fa fa-edit"></i>
											</button>
											<button type="button" data-toggle="tooltip" title=""
												class="btn btn-link btn-danger" data-original-title="Remove">
												<i class="fa fa-times"></i>
											</button>
										</div>
									</td>
								</tr>
								<tr>
									<td>Garrett Winters</td>
									<td>Accountant</td>
									<td>Tokyo</td>
									<td>
										<div class="form-button-action">
											<button type="button" data-toggle="tooltip" title=""
												class="btn btn-link btn-primary btn-lg"
												data-original-title="Edit Task">
												<i class="fa fa-edit"></i>
											</button>
											<button type="button" data-toggle="tooltip" title=""
												class="btn btn-link btn-danger" data-original-title="Remove">
												<i class="fa fa-times"></i>
											</button>
										</div>
									</td>
								</tr>
								<tr>
									<td>Ashton Cox</td>
									<td>Junior Technical Author</td>
									<td>San Francisco</td>
									<td>
										<div class="form-button-action">
											<button type="button" data-toggle="tooltip" title=""
												class="btn btn-link btn-primary btn-lg"
												data-original-title="Edit Task">
												<i class="fa fa-edit"></i>
											</button>
											<button type="button" data-toggle="tooltip" title=""
												class="btn btn-link btn-danger" data-original-title="Remove">
												<i class="fa fa-times"></i>
											</button>
										</div>
									</td>
								</tr>
								<tr>
									<td>Cedric Kelly</td>
									<td>Senior Javascript Developer</td>
									<td>Edinburgh</td>
									<td>
										<div class="form-button-action">
											<button type="button" data-toggle="tooltip" title=""
												class="btn btn-link btn-primary btn-lg"
												data-original-title="Edit Task">
												<i class="fa fa-edit"></i>
											</button>
											<button type="button" data-toggle="tooltip" title=""
												class="btn btn-link btn-danger" data-original-title="Remove">
												<i class="fa fa-times"></i>
											</button>
										</div>
									</td>
								</tr>
								<tr>
									<td>Airi Satou</td>
									<td>Accountant</td>
									<td>Tokyo</td>
									<td>
										<div class="form-button-action">
											<button type="button" data-toggle="tooltip" title=""
												class="btn btn-link btn-primary btn-lg"
												data-original-title="Edit Task">
												<i class="fa fa-edit"></i>
											</button>
											<button type="button" data-toggle="tooltip" title=""
												class="btn btn-link btn-danger" data-original-title="Remove">
												<i class="fa fa-times"></i>
											</button>
										</div>
									</td>
								</tr>
								<tr>
									<td>Brielle Williamson</td>
									<td>Integration Specialist</td>
									<td>New York</td>
									<td>
										<div class="form-button-action">
											<button type="button" data-toggle="tooltip" title=""
												class="btn btn-link btn-primary btn-lg"
												data-original-title="Edit Task">
												<i class="fa fa-edit"></i>
											</button>
											<button type="button" data-toggle="tooltip" title=""
												class="btn btn-link btn-danger" data-original-title="Remove">
												<i class="fa fa-times"></i>
											</button>
										</div>
									</td>
								</tr>
								<tr>
									<td>Herrod Chandler</td>
									<td>Sales Assistant</td>
									<td>San Francisco</td>
									<td>
										<div class="form-button-action">
											<button type="button" data-toggle="tooltip" title=""
												class="btn btn-link btn-primary btn-lg"
												data-original-title="Edit Task">
												<i class="fa fa-edit"></i>
											</button>
											<button type="button" data-toggle="tooltip" title=""
												class="btn btn-link btn-danger" data-original-title="Remove">
												<i class="fa fa-times"></i>
											</button>
										</div>
									</td>
								</tr>
								<tr>
									<td>Rhona Davidson</td>
									<td>Integration Specialist</td>
									<td>Tokyo</td>
									<td>
										<div class="form-button-action">
											<button type="button" data-toggle="tooltip" title=""
												class="btn btn-link btn-primary btn-lg"
												data-original-title="Edit Task">
												<i class="fa fa-edit"></i>
											</button>
											<button type="button" data-toggle="tooltip" title=""
												class="btn btn-link btn-danger" data-original-title="Remove">
												<i class="fa fa-times"></i>
											</button>
										</div>
									</td>
								</tr>
								<tr>
									<td>Colleen Hurst</td>
									<td>Javascript Developer</td>
									<td>San Francisco</td>
									<td>
										<div class="form-button-action">
											<button type="button" data-toggle="tooltip" title=""
												class="btn btn-link btn-primary btn-lg"
												data-original-title="Edit Task">
												<i class="fa fa-edit"></i>
											</button>
											<button type="button" data-toggle="tooltip" title=""
												class="btn btn-link btn-danger" data-original-title="Remove">
												<i class="fa fa-times"></i>
											</button>
										</div>
									</td>
								</tr>
								<tr>
									<td>Sonya Frost</td>
									<td>Software Engineer</td>
									<td>Edinburgh</td>
									<td>
										<div class="form-button-action">
											<button type="button" data-toggle="tooltip" title=""
												class="btn btn-link btn-primary btn-lg"
												data-original-title="Edit Task">
												<i class="fa fa-edit"></i>
											</button>
											<button type="button" data-toggle="tooltip" title=""
												class="btn btn-link btn-danger" data-original-title="Remove">
												<i class="fa fa-times"></i>
											</button>
										</div>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Custom template | don't include it in your project! -->
	<!-- <div class="custom-template">
		<div class="title">Settings</div>
		<div class="custom-content">
			<div class="switcher">
				<div class="switch-block">
					<h4>Topbar</h4>
					<div class="btnSwitch">
						<button type="button" class="changeMainHeaderColor"
							data-color="blue"></button>
						<button type="button" class="selected changeMainHeaderColor"
							data-color="purple"></button>
						<button type="button" class="changeMainHeaderColor"
							data-color="light-blue"></button>
						<button type="button" class="changeMainHeaderColor"
							data-color="green"></button>
						<button type="button" class="changeMainHeaderColor"
							data-color="orange"></button>
						<button type="button" class="changeMainHeaderColor"
							data-color="red"></button>
					</div>
				</div>
				<div class="switch-block">
					<h4>Background</h4>
					<div class="btnSwitch">
						<button type="button" class="changeBackgroundColor"
							data-color="bg2"></button>
						<button type="button" class="changeBackgroundColor selected"
							data-color="bg1"></button>
						<button type="button" class="changeBackgroundColor"
							data-color="bg3"></button>
					</div>
				</div>
			</div>
		</div>
		<div class="custom-toggle">
			<i class="flaticon-settings"></i>
		</div>
	</div> -->
	<!-- End Custom template -->

</body>

</html>