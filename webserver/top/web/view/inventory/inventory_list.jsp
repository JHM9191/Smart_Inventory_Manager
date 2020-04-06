<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	$(document).ready(function() {
		// Add Row
		$('#add-row').DataTable({
			"pageLength" : 10,
		});

	});
</script>
<div class="row">
	<div class="col-md-12">
		<div class="card">
			<div class="card-header">
				<div class="d-flex align-items-center">
					<h4 class="card-title">Inventory Data</h4>
				</div>
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table id="add-row" class="display table table-head-bg-default table-striped table-hover">
						<thead>
							<tr>
								<th>Warehouse ID</th>
								<th>Container ID</th>
								<th>Item ID</th>
								<th>Item Code</th>
								<th>Item Name</th>
								<th>Category</th>
								<th>Status</th>
								<th>Production Date</th>
								<th style="width: 10%"></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="i" items="${inventory_list_data }">
								<tr>
									<td>${i.warehouse_ID }</td>
									<td>${i.container_id }</td>
									<td>${i.item_id }</td>
									<td>${i.item_code }</td>
									<td>${i.item_name }</td>
									<td>${i.item_category }</td>
									<td>${i.item_status }</td>
									<td>${i.item_regDate }</td>
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
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>