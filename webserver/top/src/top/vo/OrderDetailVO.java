package top.vo;

public class OrderDetailVO {

	String orderDetailID;
	Double totWeight;
	int ingQuantity;
	String ingID;
	String orderID;

	public OrderDetailVO(String orderDetailID, Double totWeight, int ingQuantity, String ingID, String orderID) {
		super();
		this.orderDetailID = orderDetailID;
		this.totWeight = totWeight;
		this.ingQuantity = ingQuantity;
		this.ingID = ingID;
		this.orderID = orderID;
	}

	public String getOrderDetailID() {
		return orderDetailID;
	}

	public void setOrderDetailID(String orderDetailID) {
		this.orderDetailID = orderDetailID;
	}

	public Double getTotWeight() {
		return totWeight;
	}

	public void setTotWeight(Double totWeight) {
		this.totWeight = totWeight;
	}

	public int getIngQuantity() {
		return ingQuantity;
	}

	public void setIngQuantity(int ingQuantity) {
		this.ingQuantity = ingQuantity;
	}

	public String getIngID() {
		return ingID;
	}

	public void setIngID(String ingID) {
		this.ingID = ingID;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	@Override
	public String toString() {
		return "OrderDetailVO [orderDetailID=" + orderDetailID + ", totWeight=" + totWeight + ", ingQuantity="
				+ ingQuantity + ", ingID=" + ingID + ", orderID=" + orderID + "]";
	}

}
