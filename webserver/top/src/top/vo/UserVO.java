package top.vo;

import java.time.LocalDateTime;

public class UserVO {

	String userID;
	String userName;
	String userPwd;
	String userEmail;
	String userPhone;
	LocalDateTime userRegDate;
	String userCompanyName;
	String userCompanyAddress;

	public UserVO() {

	}

	public UserVO(String userID, String userName, String userPwd, String userEmail, String userPhone,
			LocalDateTime userRegDate, String userCompanyName, String userCompanyAddress) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userRegDate = userRegDate;
		this.userCompanyName = userCompanyName;
		this.userCompanyAddress = userCompanyAddress;
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

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public LocalDateTime getUserRegDate() {
		return userRegDate;
	}

	public void setUserRegDate(LocalDateTime userRegDate) {
		this.userRegDate = userRegDate;
	}

	public String getUserCompanyName() {
		return userCompanyName;
	}

	public void setUserCompanyName(String userCompanyName) {
		this.userCompanyName = userCompanyName;
	}

	public String getUserCompanyAddress() {
		return userCompanyAddress;
	}

	public void setUserCompanyAddress(String userCompanyAddress) {
		this.userCompanyAddress = userCompanyAddress;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", userPwd=" + userPwd + ", userEmail=" + userEmail
				+ ", userPhone=" + userPhone + ", userRegDate=" + userRegDate + ", userCompanyName=" + userCompanyName
				+ ", userCompanyAddress=" + userCompanyAddress + "]";
	}

}
