package top.vo;

import java.time.LocalDateTime;

public class WarehouseVO {
	String warehouse_ID;
//	String warehouse_name;
//	String warehouse_address;

	String container_id;
//	String container_name;
//	double container_maxWeight;
//	int container_maxQuantity;
//	LocalDateTime container_regDate;
//	double container_currWeight;
//	int container_currQuantity;

	String item_id;
	String item_code;
	String item_name;
	String item_category;
	String item_status;
	LocalDateTime item_regDate;
//	LocalDateTime item_expireDate;

	@Override
	public String toString() {
		return "WarehouseVO [warehouse_ID=" + warehouse_ID + ", container_id=" + container_id + ", item_id=" + item_id
				+ ", item_code=" + item_code + ", item_name=" + item_name + ", item_category=" + item_category
				+ ", item_status=" + item_status + ", item_regDate=" + item_regDate + "]";
	}

	public WarehouseVO() {
		super();
	}

	public WarehouseVO(String warehouse_ID, String container_id, String item_id, String item_code, String item_name,
			String item_category, String item_status, LocalDateTime item_regDate) {
		super();
		this.warehouse_ID = warehouse_ID;
		this.container_id = container_id;
		this.item_id = item_id;
		this.item_code = item_code;
		this.item_name = item_name;
		this.item_category = item_category;
		this.item_status = item_status;
		this.item_regDate = item_regDate;
	}

	public String getWarehouse_ID() {
		return warehouse_ID;
	}

	public void setWarehouse_ID(String warehouse_ID) {
		this.warehouse_ID = warehouse_ID;
	}

	public String getContainer_id() {
		return container_id;
	}

	public void setContainer_id(String container_id) {
		this.container_id = container_id;
	}

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public String getItem_code() {
		return item_code;
	}

	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_category() {
		return item_category;
	}

	public void setItem_category(String item_category) {
		this.item_category = item_category;
	}

	public String getItem_status() {
		return item_status;
	}

	public void setItem_status(String item_status) {
		this.item_status = item_status;
	}

	public LocalDateTime getItem_regDate() {
		return item_regDate;
	}

	public void setItem_regDate(LocalDateTime item_regDate) {
		this.item_regDate = item_regDate;
	}

}
