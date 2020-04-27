package top.vo;

public class OrderDetailVO {

	String orderDetailID;
	double totWeight;
	int ingQuantity;
	String ingID;
	String ingName;
	int ingPrice;
	int ingTotPrice;
	String ingUnit;
	String orderID;
	String hqID;
	String hqName;
	String chainID;
	String chainName;
	String userID;
	String userName;
	String conID;

	public OrderDetailVO() {

	}

	public OrderDetailVO(String orderDetailID, double totWeight, int ingQuantity, String ingID, String ingName,
			int ingPrice, int ingTotPrice, String ingUnit, String orderID, String hqID, String hqName, String chainID,
			String chainName, String userID, String userName, String conID) {
		super();
		this.orderDetailID = orderDetailID;
		this.totWeight = totWeight;
		this.ingQuantity = ingQuantity;
		this.ingID = ingID;
		this.ingName = ingName;
		this.ingPrice = ingPrice;
		this.ingTotPrice = ingTotPrice;
		this.ingUnit = ingUnit;
		this.orderID = orderID;
		this.hqID = hqID;
		this.hqName = hqName;
		this.chainID = chainID;
		this.chainName = chainName;
		this.userID = userID;
		this.userName = userName;
		this.conID = conID;
	}

	public OrderDetailVO(double totWeight, int ingQuantity, String ingID, String ingName, int ingPrice, int ingTotPrice,
			String ingUnit, String orderID, String hqID, String hqName, String chainID, String chainName,
			String conID) {
		super();
		this.totWeight = totWeight;
		this.ingQuantity = ingQuantity;
		this.ingID = ingID;
		this.ingName = ingName;
		this.ingPrice = ingPrice;
		this.ingTotPrice = ingTotPrice;
		this.ingUnit = ingUnit;
		this.orderID = orderID;
		this.hqID = hqID;
		this.hqName = hqName;
		this.chainID = chainID;
		this.chainName = chainName;
		this.conID = conID;
	}

	public String getOrderDetailID() {
		return orderDetailID;
	}

	public void setOrderDetailID(String orderDetailID) {
		this.orderDetailID = orderDetailID;
	}

	public double getTotWeight() {
		return totWeight;
	}

	public void setTotWeight(double totWeight) {
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

	public String getIngName() {
		return ingName;
	}

	public void setIngName(String ingName) {
		this.ingName = ingName;
	}

	public int getIngPrice() {
		return ingPrice;
	}

	public void setIngPrice(int ingPrice) {
		this.ingPrice = ingPrice;
	}

	public int getIngTotPrice() {
		return ingTotPrice;
	}

	public void setIngTotPrice(int ingTotPrice) {
		this.ingTotPrice = ingTotPrice;
	}

	public String getIngUnit() {
		return ingUnit;
	}

	public void setIngUnit(String ingUnit) {
		this.ingUnit = ingUnit;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
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

	public String getConID() {
		return conID;
	}

	public void setConID(String conID) {
		this.conID = conID;
	}

	@Override
	public String toString() {
		return "OrderDetailVO [orderDetailID=" + orderDetailID + ", totWeight=" + totWeight + ", ingQuantity="
				+ ingQuantity + ", ingID=" + ingID + ", ingName=" + ingName + ", ingPrice=" + ingPrice
				+ ", ingTotPrice=" + ingTotPrice + ", ingUnit=" + ingUnit + ", orderID=" + orderID + ", hqID=" + hqID
				+ ", hqName=" + hqName + ", chainID=" + chainID + ", chainName=" + chainName + ", userID=" + userID
				+ ", userName=" + userName + ", conID=" + conID + "]";
	}

}
