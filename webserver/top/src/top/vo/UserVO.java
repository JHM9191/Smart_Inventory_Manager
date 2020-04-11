package top.vo;

import java.time.LocalDateTime;

public class UserVO {

	String userID;
	String userName;
	String userPwd;
	String userEmail;
	String userPhone;
	LocalDateTime userRegDate;
	String chainID;

	public UserVO() {

	}

	public UserVO(String userID, String userName, String userPwd, String userEmail, String userPhone,
			LocalDateTime userRegDate, String chainID) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userRegDate = userRegDate;
		this.chainID = chainID;
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

	public String getChainID() {
		return chainID;
	}

	public void setChainID(String chainID) {
		this.chainID = chainID;
	}

	@Override
	public String toString() {
		return "UserVO [userID=" + userID + ", userName=" + userName + ", userPwd=" + userPwd + ", userEmail="
				+ userEmail + ", userPhone=" + userPhone + ", userRegDate=" + userRegDate + ", chainID=" + chainID
				+ "]";
	}

}
