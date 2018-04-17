package com.zking.hr.view.pojo.user;

public class userpwd {
	private String NewuserPwd;
	private String userPwd;
	private String userName;
	private Integer userId;
	public String getNewuserPwd() {
		return NewuserPwd;
	}
	public void setNewuserPwd(String newuserPwd) {
		NewuserPwd = newuserPwd;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public userpwd(String newuserPwd, String userPwd, String userName) {
		super();
		NewuserPwd = newuserPwd;
		this.userPwd = userPwd;
		this.userName = userName;
	}
	public userpwd() {
		super();
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}
