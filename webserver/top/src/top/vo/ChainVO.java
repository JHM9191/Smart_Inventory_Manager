package top.vo;

import java.time.LocalDateTime;

public class ChainVO {

	String chainID;
	String chainName;
	String chainAddress;
	LocalDateTime chainRegDate;
	String userID;

	public ChainVO() {

	}

	public ChainVO(String chainID, String chainName, String chainAddress, LocalDateTime chainRegDate, String userID) {
		super();
		this.chainID = chainID;
		this.chainName = chainName;
		this.chainAddress = chainAddress;
		this.chainRegDate = chainRegDate;
		this.userID = userID;
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

	public LocalDateTime getChainRegDate() {
		return chainRegDate;
	}

	public void setChainRegDate(LocalDateTime chainRegDate) {
		this.chainRegDate = chainRegDate;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	@Override
	public String toString() {
		return "ChainVO [chainID=" + chainID + ", chainName=" + chainName + ", chainAddress=" + chainAddress
				+ ", chainRegDate=" + chainRegDate + ", userID=" + userID + "]";
	}

}
