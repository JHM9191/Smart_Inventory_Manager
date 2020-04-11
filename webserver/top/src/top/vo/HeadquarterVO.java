package top.vo;

public class HeadquarterVO {

	String hqID;
	String hqName;
	String hqPwd;
	String hqEmail;
	String hqPhone;
	String hqRegDate;
	String hqAddress;
	String chainCount;

	public HeadquarterVO(String hqID, String hqName, String hqPwd, String hqEmail, String hqPhone, String hqRegDate,
			String hqAddress, String chainCount) {
		super();
		this.hqID = hqID;
		this.hqName = hqName;
		this.hqPwd = hqPwd;
		this.hqEmail = hqEmail;
		this.hqPhone = hqPhone;
		this.hqRegDate = hqRegDate;
		this.hqAddress = hqAddress;
		this.chainCount = chainCount;
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

	public String getHqPwd() {
		return hqPwd;
	}

	public void setHqPwd(String hqPwd) {
		this.hqPwd = hqPwd;
	}

	public String getHqEmail() {
		return hqEmail;
	}

	public void setHqEmail(String hqEmail) {
		this.hqEmail = hqEmail;
	}

	public String getHqPhone() {
		return hqPhone;
	}

	public void setHqPhone(String hqPhone) {
		this.hqPhone = hqPhone;
	}

	public String getHqRegDate() {
		return hqRegDate;
	}

	public void setHqRegDate(String hqRegDate) {
		this.hqRegDate = hqRegDate;
	}

	public String getHqAddress() {
		return hqAddress;
	}

	public void setHqAddress(String hqAddress) {
		this.hqAddress = hqAddress;
	}

	public String getChainCount() {
		return chainCount;
	}

	public void setChainCount(String chainCount) {
		this.chainCount = chainCount;
	}

	@Override
	public String toString() {
		return "Headquarter [hqID=" + hqID + ", hqName=" + hqName + ", hqPwd=" + hqPwd + ", hqEmail=" + hqEmail
				+ ", hqPhone=" + hqPhone + ", hqRegDate=" + hqRegDate + ", hqAddress=" + hqAddress + ", chainCount="
				+ chainCount + "]";
	}

}
