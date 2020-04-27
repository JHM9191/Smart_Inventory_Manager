package top.vo;

public class NotiVO {

	String notiID;
	String chainID;
	String userID;
	String applyCnt;
	String regDate;
	String refresh;

	public NotiVO() {
		super();
	}

	public NotiVO(String notiID, String chainID, String userID, String applyCnt, String regDate, String refresh) {
		super();
		this.notiID = notiID;
		this.chainID = chainID;
		this.userID = userID;
		this.applyCnt = applyCnt;
		this.regDate = regDate;
		this.refresh = refresh;
	}

	public String getNotiID() {
		return notiID;
	}

	public void setNotiID(String notiID) {
		this.notiID = notiID;
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

	public String getApplyCnt() {
		return applyCnt;
	}

	public void setApplyCnt(String applyCnt) {
		this.applyCnt = applyCnt;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getRefresh() {
		return refresh;
	}

	public void setRefresh(String refresh) {
		this.refresh = refresh;
	}

	@Override
	public String toString() {
		return "NotiVO [notiID=" + notiID + ", chainID=" + chainID + ", userID=" + userID + ", applyCnt=" + applyCnt
				+ ", regDate=" + regDate + ", refresh=" + refresh + "]";
	}

}
