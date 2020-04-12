<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	$(document).ready(function() {
		// Add Row
		$('#add-ingredient').DataTable({
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
					<table id="add-ingredient"
						class="display table table-head-bg-default table-striped table-hover">
						<thead>
							<tr>
								<th>ingredient ID</th>
								<th>ingredient Category</th>
								<th>ingredient Name</th>
								<th>ingredient Price</th>
								<th>ingredient Unit</th>
								<th>ingredient Brand</th>
								<th>ingredient Type</th>
								<th>ingredient Weight</th>
								<th>ingredient Register Date</th>
								<th>ingredient Purchase Link</th>
								<th>ingredient Purchase Count</th>
								<th>ingredient Image Name</th>
								<th style="width: 10%"></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="i" items="${ingredientListData }">
								<tr>
									<td>${i.ingID }</td>
									<td>${i.ingCategory }</td>
									<td>${i.ingName }</td>
									<td>${i.ingPrice }</td>
									<td>${i.ingUnit }</td>
									<td>${i.ingBrand }</td>
									<td>${i.ingType }</td>
									<td>${i.ingWeight }</td>
									<td>${i.ingRegDate }</td>
									<td><a href="${i.ingLink }">${i.ingName }
											구매하기</a></td>
									<td>${i.ingLinkCount }</td>
									<td>${i.ingImgName }</td>
									<td>
										<div class="form-button-action">
											<button type="button" data-toggle="tooltip" title="수정"
												class="btn btn-link btn-primary btn-lg"
												data-original-title="Edit Task">
												<i class="far fa-edit"></i>
											</button>
											<button onclick="editIngredient();" type="button" data-toggle="tooltip" title="삭제"
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