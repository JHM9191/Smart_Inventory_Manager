package reference;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Container {

	String id;
	String name;
	double maxWeight;
	int maxQuantity;
	LocalDateTime regDate;
	double currWeight;
	int currQuantity;
	ArrayList<Item> itemList;

	public Container() {

	}

	public Container(String id, String name, double maxWeight, int maxQuantity, LocalDateTime regDate, double currWeight,
			int currQuantity, ArrayList<Item> itemList) {
		super();
		this.id = id;
		this.name = name;
		this.maxWeight = maxWeight;
		this.maxQuantity = maxQuantity;
		this.regDate = regDate;
		this.currWeight = currWeight;
		this.currQuantity = currQuantity;
		this.itemList = itemList;
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

	public double getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(double maxWeight) {
		this.maxWeight = maxWeight;
	}

	public int getMaxQuantity() {
		return maxQuantity;
	}

	public void setMaxQuantity(int maxQuantity) {
		this.maxQuantity = maxQuantity;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	public double getCurrWeight() {
		return currWeight;
	}

	public void setCurrWeight(double currWeight) {
		this.currWeight = currWeight;
	}

	public int getCurrQuantity() {
		return currQuantity;
	}

	public void setCurrQuantity(int currQuantity) {
		this.currQuantity = currQuantity;
	}

	public ArrayList<Item> getItemList() {
		return itemList;
	}

	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
	}

	@Override
	public String toString() {
		return "Container [id=" + id + ", name=" + name + ", maxWeight=" + maxWeight + ", maxQuantity=" + maxQuantity
				+ ", regDate=" + regDate + ", currWeight=" + currWeight + ", currQuantity=" + currQuantity
				+ ", itemList=" + itemList + "]";
	}

}
