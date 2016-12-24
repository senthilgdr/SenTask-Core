package com.sen.view;

public class UserDetail {	
	private Long userId;	
	private UserType userType;
	private String name;	
	private String userName;
	private String passWord;
	private String emailId;	
	private String oprnlFlag="A";	
	private Long createdBy;

	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getOprnlFlag() {
		return oprnlFlag;
	}
	public void setOprnlFlag(String oprnlFlag) {
		this.oprnlFlag = oprnlFlag;
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	@Override
	public String toString() {
		return "UserDetail [userId=" + userId + ", userType=" + userType + ", name=" + name + ", userName=" + userName
				+ ", passWord=" + passWord + ", emailId=" + emailId + ", oprnlFlag=" + oprnlFlag + ", createdBy="
				+ createdBy + "]";
	}

}
