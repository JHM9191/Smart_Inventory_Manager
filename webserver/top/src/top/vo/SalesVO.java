package top.vo;

import java.time.LocalDateTime;

public class SalesVO {

	String salesID;
	LocalDateTime salesRegDate;
	int totSales;
	String chainID;

	public SalesVO(String salesID, LocalDateTime salesRegDate, int totSales, String chainID) {
		super();
		this.salesID = salesID;
		this.salesRegDate = salesRegDate;
		this.totSales = totSales;
		this.chainID = chainID;
	}

	public String getSalesID() {
		return salesID;
	}

	public void setSalesID(String salesID) {
		this.salesID = salesID;
	}

	public LocalDateTime getSalesRegDate() {
		return salesRegDate;
	}

	public void setSalesRegDate(LocalDateTime salesRegDate) {
		this.salesRegDate = salesRegDate;
	}

	public int getTotSales() {
		return totSales;
	}

	public void setTotSales(int totSales) {
		this.totSales = totSales;
	}

	public String getChainID() {
		return chainID;
	}

	public void setChainID(String chainID) {
		this.chainID = chainID;
	}

	@Override
	public String toString() {
		return "Sales [salesID=" + salesID + ", salesRegDate=" + salesRegDate + ", totSales=" + totSales + ", chainID="
				+ chainID + "]";
	}

}
