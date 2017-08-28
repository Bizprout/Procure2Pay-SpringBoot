package com.bizprout.procure2pay.dto;

import javax.validation.constraints.NotNull;

public class UserDTO {
	
	@NotNull
	private String userId;
	@NotNull
	private String userName;
	private String userEmail;
	private String userMobile;
	private String userType;
	private String userAltEmail;
	private String userStatus;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserAltEmail() {
		return userAltEmail;
	}
	public void setUserAltEmail(String userAltEmail) {
		this.userAltEmail = userAltEmail;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	
	

}
