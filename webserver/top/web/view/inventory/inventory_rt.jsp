<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.3/jquery.min.js"></script>
<script>
	/* $(document).ready(function() {
		setInterval("getRealTimeData()", 1000);
		// Add Row
		$('#top10').DataTable({
			"pageLength" : 10,
		});
	}); */
	
	$(document).ready(function() {
		setInterval(() => {
			$('#top10').DataTable({
				retrieve: true,
				/* paging: false, */
				ajax: {
					url: 'getRTInventoryData.top',
					dataSrc: ''
				}, 
				columns: [
					{data: 'wh_ID'},
					{data: 'item_code'},
					{data: 'item_name'},
					{data: 'item_quantity'},
					{data: 'remaining'}]
			});
		}, 1000);
	});
	
	function getData() {
		$('#top10').DataTable({
			/* retrieve: true, */
			/* paging: false, */
			ajax: {
				url: 'getRTInventoryData.top',
				dataSrc: ''
			}, 
			columns: [
				{data: 'wh_ID'},
				{data: 'item_code'},
				{data: 'item_name'},
				{data: 'item_quantity'},
				{data: 'remaining'}]
		});
	};

	function getRealTimeData() {

		$.ajax({
			url : 'getRTInventoryData.top',
			success : function(data) {
				// console.log(data);
				$('#tbody_data_row').empty();
				for (var i = 0; i < data.length; i++) {
					// console.log(data[i]);
					$('#tbody_data_row').append(
							"<tr>" + "<td>" + data[i]['wh_ID'] + "</td>"
									+ "<td>" + data[i]['item_code'] + "</td>"
									+ "<td>" + data[i]['item_name'] + "</td>"
									+ "<td>" + data[i]['item_quantity']
									+ "</td>" + "<td>" + data[i]['remaining']
									+ "</td>" + "</tr>");
				}
			},
			error : function() {

			}
		});

	}
</script>
<div class="row">
	<div class="col-md-12">
		<div class="card">
			<div class="card-header">
				<div class="d-flex align-items-center">
					<h4 class="card-title">Real-Time Inventory Monitoring</h4>
				</div>
			</div>
			<div class="card-body">
				<div class="responsive">
					<div class="row">
						<div class="col-sm-12">
							<div class="dataTables_length" id="add-row_length">
								<label>Display each warehouse : <select
									name="add-row_length" aria-controls="" class="form-control"><option
											value="10">10</option>
										<option value="25">25</option>
										<option value="50">50</option>
										<option value="100">100</option></select>
								</label>
							</div>
						</div>
						<!-- <div class="col-sm-12 col-md-6">
						<div id="add-row_filter" class="dataTables_filter">
							<label>Search:<input type="search"
								class="form-control form-control-sm" placeholder=""
								aria-controls="add-row"></label>
						</div>
					</div> -->
					</div>
					<table id="top10"
						class="table table-head-bg-default mt-4 table-hover table-striped">
						<thead>
							<tr>
								<th>Warehouse ID</th>
								<th>Item Code</th>
								<th>Item Name</th>
								<th>Current Quantity</th>
								<th>%</th>
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