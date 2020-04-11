package top.vo;

import java.time.LocalDateTime;

public class OrderVO {

	String orderID;
	int payment;
	LocalDateTime deliveryDate;
	String deliveryState;
	String orderPerson;
	String orderState;
	String hqID;
	String chainID;
	String userID;

	public OrderVO(String orderID, int payment, LocalDateTime deliveryDate, String deliveryState, String orderPerson,
			String orderState, String hqID, String chainID, String userID) {
		super();
		this.orderID = orderID;
		this.payment = payment;
		this.deliveryDate = deliveryDate;
		this.deliveryState = deliveryState;
		this.orderPerson = orderPerson;
		this.orderState = orderState;
		this.hqID = hqID;
		this.chainID = chainID;
		this.userID = userID;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public LocalDateTime getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDateTime deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getDeliveryState() {
		return deliveryState;
	}

	public void setDeliveryState(String deliveryState) {
		this.deliveryState = deliveryState;
	}

	public String getOrderPerson() {
		return orderPerson;
	}

	public void setOrderPerson(String orderPerson) {
		this.orderPerson = orderPerson;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public String getHqID() {
		return hqID;
	}

	public void setHqID(String hqID) {
		this.hqID = hqID;
	}

	public String getChainID() {
		return chainID;
	}

	public void setChainID(String chainID) {
		this.chainID = chainID;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	@Override
	public String toString() {
		return "OrderVO [orderID=" + orderID + ", payment=" + payment + ", deliveryDate=" + deliveryDate
				+ ", deliveryState=" + deliveryState + ", orderPerson=" + orderPerson + ", orderState=" + orderState
				+ ", hqID=" + hqID + ", chainID=" + chainID + ", userID=" + userID + "]";
	}

}
