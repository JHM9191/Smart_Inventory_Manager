package top.model;

import java.util.Date;

public class Container {

	String id;
	String name;
	String maxWeight;
	String maxQuantity;
	Date regDate;
	String currWeight;
	String currQuantity;

	public Container() {

	}

	public Container(String id, String name, String maxWeight, String maxQuantity, Date regDate, String currWeight,
			String currQuantity) {
		super();
		this.id = id;
		this.name = name;
		this.maxWeight = maxWeight;
		this.maxQuantity = maxQuantity;
		this.regDate = regDate;
		this.currWeight = currWeight;
		this.currQuantity = currQuantity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(String maxWeight) {
		this.maxWeight = maxWeight;
	}

	public String getMaxQuantity() {
		return maxQuantity;
	}

	public void setMaxQuantity(String maxQuantity) {
		this.maxQuantity = maxQuantity;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getCurrWeight() {
		return currWeight;
	}

	public void setCurrWeight(String currWeight) {
		this.currWeight = currWeight;
	}

	public String getCurrQuantity() {
		return currQuantity;
	}

	public void setCurrQuantity(String currQuantity) {
		this.currQuantity = currQuantity;
	}

	@Override
	public String toString() {
		return "Container [id=" + id + ", name=" + name + ", maxWeight=" + maxWeight + ", maxQuantity=" + maxQuantity
				+ ", regDate=" + regDate + ", currWeight=" + currWeight + ", currQuantity=" + currQuantity + "]";
	}

}
