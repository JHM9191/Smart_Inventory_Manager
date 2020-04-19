<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.3/jquery.min.js"></script>

<script>
	var num = 1;
	function goToNext(input) {
		console.log(input);
		$('#about').removeClass('active');
		$('#' + input).addClass('active');
		$('.step a').removeClass('active');
		$('.step:eq(1) a').addClass('active');
	};

	function addContainer() {

		var size = $('#select_size').val();
		var max_container_weight;
		var size_name;
		var ing = $('#select_ing').val();
		var weight = $('input[name="' + ing + '_weight"]').val();
		var cnt = $('#select_cnt').val();
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

		console.log(size);
		console.log(price);
		console.log(cnt);
		console.log(unit);
		console.log(weight);
		console.log(weight * cnt);

		/*
		 $.ajax({
		 url : "insertContainer.top?size=" + size + "&ing=" + ing + "&cnt="
		 + cnt,
		 success : function(data) {
		 console.log(data);
		 }
		 });
		
		 */

		var action = '<td> <div class="form-button-action"> <button type="button" data-toggle="tooltip" title="" class="btn btn-link btn-primary btn-lg" data-original-title="Edit Task"> <i class="fa fa-edit"></i> </button> <button type="button" data-toggle="tooltip" title="" class="btn btn-link btn-danger" data-original-title="Remove" onclick="removeRow();"> <i class="fa fa-times"></i> </button> </div> </td>';

		$('#addContainerTable').dataTable()
				.fnAddData(
						[ num, size_name, ing, weight + unit, cnt,
								(cnt * weight) + unit, max_container_weight,
								"", action ]);

		num += 1;
	};

	function removeRow() {
		var table = $('#addContainerTable').DataTable();

		var rows = table.rows('.selected').remove().draw();

	}
</script>
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
											class="fa fa-file mr-2"></i> 컨테이너 선택</a></li>
									<li class="step" style="width: 33.333333333333336%;"><a
										class="nav-link" href="#address" data-toggle="tab"><i
											class="fa fa-map-signs mr-2"></i> 확인 및 적용</a></li>
									<div class="moving-tab" style="width: 300px;"></div>
								</ul>
							</div>
						</div>
						<br> <br> <br>

						<div class="tab-content">

							<!-- #1 -->
							<div class="tab-pane active" id="about">
								<div class="row justify-content-center align-items-center">
									<div class="col-4 pl-md-0">
										<div class="card card-pricing">
											<div class="card-header">
												<div class="card-price">
													<span class="price">기본</span>
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
												<h4 class="text">단 한번의 등록으로 모든 가맹점의 컨테이너 사이즈 및 수량을 동일하게
													적용시킬 수 있습니다.</h4>
											</div>
											<div class="card-footer">
												<input type="button" class="btn btn-danger btn-block"
													name="sameContainer" value="선택"
													onclick="goToNext('sameContainer');" />
											</div>

										</div>
									</div>
									<div class="col-4 pl-md-0 pr-md-0">
										<div class="card card-pricing">
											<div class="card-header">
												<!-- <h4 class="card-title">커스터마이즈</h4> -->
												<div class="card-price">
													<span class="price">커스터마이즈</span>
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
												<h4 class="text">각 가맹점마다 각기 다른 컨테이너 사이즈 및 수량을 직접 지정할 수
													있습니다.</h4>
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
													<c:forEach var="i" begin="1" end="10">
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
											value="선택" onclick="addContainer();" />
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
												<div class="responsive">
													<table id="addContainerTable"
														class="table table-head-bg-default mt-4 table-hover table-striped">
														<thead>
															<tr>
																<th>No.</th>
																<th>컨테이너 사이즈</th>
																<th>재료</th>
																<th>무게</th>
																<th>수량</th>
																<th>총무게</th>
																<th>최고 허용 무게</th>
																<th>경고 무게</th>
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
													<c:forEach var="i" begin="1" end="10">
														<option value="${i }" data-select2-id="16">${i }</option>
													</c:forEach>
												</optgroup>
											</select>
										</div>
									</div>

									<div class="col-md-4">
										<div class="form-group">
											<label>Multiple States</label>
											<div class="select2-input select2-warning">
												<select id="multiple" name="multiple2[]"
													class="form-control select2-hidden-accessible" multiple=""
													data-select2-id="multiple-states" tabindex="-1"
													aria-hidden="true">
													<option value="">&nbsp;</option>
													<optgroup label="Alaskan/Hawaiian Time Zone">
														<option value="AK">Alaska</option>
														<option value="HI">Hawaii</option>
													</optgroup>
													<optgroup label="Pacific Time Zone">
														<option value="CA">California</option>
														<option value="NV">Nevada</option>
														<option value="OR">Oregon</option>
														<option value="WA">Washington</option>
													</optgroup>
													<optgroup label="Mountain Time Zone">
														<option value="AZ">Arizona</option>
														<option value="CO">Colorado</option>
														<option value="ID">Idaho</option>
														<option value="MT">Montana</option>
														<option value="NE">Nebraska</option>
														<option value="NM">New Mexico</option>
														<option value="ND">North Dakota</option>
														<option value="UT">Utah</option>
														<option value="WY">Wyoming</option>
													</optgroup>
													<optgroup label="Central Time Zone">
														<option value="AL">Alabama</option>
														<option value="AR">Arkansas</option>
														<option value="IL">Illinois</option>
														<option value="IA">Iowa</option>
														<option value="KS">Kansas</option>
														<option value="KY">Kentucky</option>
														<option value="LA">Louisiana</option>
														<option value="MN">Minnesota</option>
														<option value="MS">Mississippi</option>
														<option value="MO">Missouri</option>
														<option value="OK">Oklahoma</option>
														<option value="SD">South Dakota</option>
														<option value="TX">Texas</option>
														<option value="TN">Tennessee</option>
														<option value="WI">Wisconsin</option>
													</optgroup>
													<optgroup label="Eastern Time Zone">
														<option value="CT">Connecticut</option>
														<option value="DE">Delaware</option>
														<option value="FL">Florida</option>
														<option value="GA">Georgia</option>
														<option value="IN">Indiana</option>
														<option value="ME">Maine</option>
														<option value="MD">Maryland</option>
														<option value="MA">Massachusetts</option>
														<option value="MI">Michigan</option>
														<option value="NH">New Hampshire</option>
														<option value="NJ">New Jersey</option>
														<option value="NY">New York</option>
														<option value="NC">North Carolina</option>
														<option value="OH">Ohio</option>
														<option value="PA">Pennsylvania</option>
														<option value="RI">Rhode Island</option>
														<option value="SC">South Carolina</option>
														<option value="VT">Vermont</option>
														<option value="VA">Virginia</option>
														<option value="WV">West Virginia</option>
													</optgroup>
												</select><span
													class="select2 select2-container select2-container--bootstrap"
													dir="ltr" data-select2-id="4" style="width: 206.328125px;"><span
													class="selection"><span
														class="select2-selection select2-selection--multiple"
														role="combobox" aria-haspopup="true" aria-expanded="false"
														tabindex="-1"><ul
																class="select2-selection__rendered">
																<li class="select2-search select2-search--inline"><input
																	class="select2-search__field" type="search"
																	tabindex="0" autocomplete="off" autocorrect="off"
																	autocapitalize="none" spellcheck="false" role="textbox"
																	aria-autocomplete="list" placeholder=""
																	style="width: 0.75em;"></li>
															</ul></span></span><span class="dropdown-wrapper" aria-hidden="true"></span></span>
											</div>
										</div>
									</div>


								</div>
								<br> <br>
								<div class="row justify-content-center align-items-center">
									<div class="col-6 col-md-6">
										<input type="button" class="btn btn-danger btn-block" name=""
											value="선택" onclick="addContainer();" />
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
												<div class="responsive">
													<table id="addContainerTable"
														class="table table-head-bg-default mt-4 table-hover table-striped">
														<thead>
															<tr>
																<th>No.</th>
																<th>컨테이너 사이즈</th>
																<th>재료</th>
																<th>무게</th>
																<th>수량</th>
																<th>총무게</th>
																<th>최고 허용 무게</th>
																<th>경고 무게</th>
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
<script
	src="assets/js/plugin/bootstrap-tagsinput/bootstrap-tagsinput.min.js"></script>