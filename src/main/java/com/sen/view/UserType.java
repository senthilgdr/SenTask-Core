package com.sen.view;

public class UserType {
	private Long userTypeId;
	private String userType;
	private String oprtnlFlag="A";
	
	public Long getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(Long userTypeId) {
		this.userTypeId = userTypeId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getOprtnlFlag() {
		return oprtnlFlag;
	}

	public void setOprtnlFlag(String oprtnlFlag) {
		this.oprtnlFlag = oprtnlFlag;
	}


	
	@Override
	public String toString() {
		return "UserType [userTypeId=" + userTypeId + ", userType=" + userType + ", oprtnlFlag=" + oprtnlFlag + "]";
	}
	
	
}
