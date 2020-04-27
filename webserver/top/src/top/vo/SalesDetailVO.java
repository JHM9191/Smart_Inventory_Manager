package top.vo;

public class SalesDetailVO {

	String salesDetailID;
	String salesDetailRegDate;
	String salesID;
	String menuName;
	String menuPrice;
	String menuCount;
	
	public SalesDetailVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SalesDetailVO(String salesDetailID, String salesDetailRegDate, String salesID, String menuName,
			String menuPrice, String menuCount) {
		super();
		this.salesDetailID = salesDetailID;
		this.salesDetailRegDate = salesDetailRegDate;
		this.salesID = salesID;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.menuCount = menuCount;
	}

	@Override
	public String toString() {
		return "SalesDetailVO [salesDetailID=" + salesDetailID + ", salesDetailRegDate=" + salesDetailRegDate
				+ ", salesID=" + salesID + ", menuName=" + menuName + ", menuPrice=" + menuPrice + ", menuCount="
				+ menuCount + "]";
	}

	public String getSalesDetailID() {
		return salesDetailID;
	}

	public void setSalesDetailID(String salesDetailID) {
		this.salesDetailID = salesDetailID;
	}

	public String getSalesDetailRegDate() {
		return salesDetailRegDate;
	}

	public void setSalesDetailRegDate(String salesDetailRegDate) {
		this.salesDetailRegDate = salesDetailRegDate;
	}

	public String getSalesID() {
		return salesID;
	}

	public void setSalesID(String salesID) {
		this.salesID = salesID;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(String menuPrice) {
		this.menuPrice = menuPrice;
	}

	public String getMenuCount() {
		return menuCount;
	}

	public void setMenuCount(String menuCount) {
		this.menuCount = menuCount;
	}

	
}