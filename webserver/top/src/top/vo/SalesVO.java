package top.vo;

public class SalesVO {

	String salesID;
	String salesRegDate;
	int totSales;
	String chainID;

	public SalesVO() {

	}

	public SalesVO(String salesRegDate, int totSales, String chainID) {
		super();
		this.salesRegDate = salesRegDate;
		this.totSales = totSales;
		this.chainID = chainID;
	}

	public SalesVO(String salesID, String salesRegDate, int totSales, String chainID) {
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

	public String getSalesRegDate() {
		return salesRegDate;
	}

	public void setSalesRegDate(String salesRegDate) {
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
		return "SalesVO [salesID=" + salesID + ", salesRegDate=" + salesRegDate + ", totSales=" + totSales
				+ ", chainID=" + chainID + "]";
	}

}
