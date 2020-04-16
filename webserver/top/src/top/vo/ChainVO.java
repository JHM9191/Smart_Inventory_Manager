package top.vo;

public class ChainVO {

	String chainID;
	String chainName;
	String chainAddress;
	String chainRegDate;
	String hqID;

	public ChainVO() {

	}

	public ChainVO(String chainID, String chainName, String chainAddress, String chainRegDate, String hqID) {
		super();
		this.chainID = chainID;
		this.chainName = chainName;
		this.chainAddress = chainAddress;
		this.chainRegDate = chainRegDate;
		this.hqID = hqID;
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

	public String getChainAddress() {
		return chainAddress;
	}

	public void setChainAddress(String chainAddress) {
		this.chainAddress = chainAddress;
	}

	public String getChainRegDate() {
		return chainRegDate;
	}

	public void setChainRegDate(String chainRegDate) {
		this.chainRegDate = chainRegDate;
	}

	public String getHqID() {
		return hqID;
	}

	public void setHqID(String hqID) {
		this.hqID = hqID;
	}

	@Override
	public String toString() {
		return "ChainVO [chainID=" + chainID + ", chainName=" + chainName + ", chainAddress=" + chainAddress
				+ ", chainRegDate=" + chainRegDate + ", hqID=" + hqID + "]";
	}

}
