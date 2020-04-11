package top.vo;

import java.time.LocalDateTime;

public class SalesDetailVO {

	String salDetailID;
	LocalDateTime salDetailRegDate;
	String menuName;
	int menuPrice;
	String salesID;

	public SalesDetailVO(String salDetailID, LocalDateTime salDetailRegDate, String menuName, int menuPrice,
			String salesID) {
		super();
		this.salDetailID = salDetailID;
		this.salDetailRegDate = salDetailRegDate;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.salesID = salesID;
	}

	public String getSalDetailID() {
		return salDetailID;
	}

	public void setSalDetailID(String salDetailID) {
		this.salDetailID = salDetailID;
	}

	public LocalDateTime getSalDetailRegDate() {
		return salDetailRegDate;
	}

	public void setSalDetailRegDate(LocalDateTime salDetailRegDate) {
		this.salDetailRegDate = salDetailRegDate;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}

	public String getSalesID() {
		return salesID;
	}

	public void setSalesID(String salesID) {
		this.salesID = salesID;
	}

	@Override
	public String toString() {
		return "SalesDetail [salDetailID=" + salDetailID + ", salDetailRegDate=" + salDetailRegDate + ", menuName="
				+ menuName + ", menuPrice=" + menuPrice + ", salesID=" + salesID + "]";
	}

}
