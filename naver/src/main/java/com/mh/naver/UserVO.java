package com.mh.naver;

public class UserVO {

	private String userName;
	private String userEmail;
	private String userGender;
	private String userNaver;
	
	public UserVO() {}
	
	@Override
	public String toString() {
		return "UserVO [userName=" + userName + ", userEmail=" + userEmail + ", userGender=" + userGender
				+ ", userNaver=" + userNaver + "]";
	}
	public UserVO(String userName, String userEmail, String userGender, String userNaver) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.userGender = userGender;
		this.userNaver = userNaver;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserNaver() {
		return userNaver;
	}
	public void setUserNaver(String userNaver) {
		this.userNaver = userNaver;
	}

	
}
