package top.vo;

public class OrderVO {

	String orderID;
	int payment;
	String deliveryDate;
	String deliveryState;
	String orderPerson;
	String orderState;
	String hqID;
	String hqName;
	String chainID;
	String chainName;
	String userID;
	String userName;

	public OrderVO() {

	}

	public OrderVO(String orderID, int payment, String deliveryDate, String deliveryState, String orderPerson,
			String orderState, String hqID, String hqName, String chainID, String chainName, String userID,
			String userName) {
		super();
		this.orderID = orderID;
		this.payment = payment;
		this.deliveryDate = deliveryDate;
		this.deliveryState = deliveryState;
		this.orderPerson = orderPerson;
		this.orderState = orderState;
		this.hqID = hqID;
		this.hqName = hqName;
		this.chainID = chainID;
		this.chainName = chainName;
		this.userID = userID;
		this.userName = userName;
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

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
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

	public String getHqName() {
		return hqName;
	}

	public void setHqName(String hqName) {
		this.hqName = hqName;
	}

	public String getChainID() {
		return chainID;
	}

	public void setChainID(String chainID) {
		this.chainID = chainID;
	}

	public String getChainName() {
		return chainName;
	}

	public void setChainName(String chainName) {
		this.chainName = chainName;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "OrderVO [orderID=" + orderID + ", payment=" + payment + ", deliveryDate=" + deliveryDate
				+ ", deliveryState=" + deliveryState + ", orderPerson=" + orderPerson + ", orderState=" + orderState
				+ ", hqID=" + hqID + ", hqName=" + hqName + ", chainID=" + chainID + ", chainName=" + chainName
				+ ", userID=" + userID + ", userName=" + userName + "]";
	}

}
