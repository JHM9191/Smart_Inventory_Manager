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
<div class="row">
	<div class="col-md-12">
		<div class="card">
			<div class="card-header">
				<div class="d-flex align-items-center">
					<h4 class="card-title">Inventory Current Status</h4>
					
				</div>
			</div>
			<div class="card-body">
			
				<div class="table-responsive">
					<table id="add-row" class="display table table-striped table-hover">
						<thead>
							<tr>
								<th>Warehouse ID</th>
								<th>Item Code</th>
								<th>Item Name</th>
								<th>Container ID</th>
								<th>Quantity Remaining</th>
								<th>Status</th>
								<th style="width: 10%"></th>
							</tr>
						</thead>
						
						<tbody>
							<tr>
								<td>Test</td>
								<td>Test</td>
								<td>Test</td>
								<td>Test</td>
								<td>Test</td>
								<td>Test</td>
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