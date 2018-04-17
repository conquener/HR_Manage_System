package com.zking.hr.view.pojo.changpassword;

public class ChangPassword {
	private String newPwd;
	private String checkUserName;
	private String checkuserPwd;
	public String getNewPwd() {
		return newPwd;
	}
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	public String getCheckUserName() {
		return checkUserName;
	}
	public void setCheckUserName(String checkUserName) {
		this.checkUserName = checkUserName;
	}
	public String getCheckuserPwd() {
		return checkuserPwd;
	}
	public void setCheckuserPwd(String checkuserPwd) {
		this.checkuserPwd = checkuserPwd;
	}
	public ChangPassword(String newPwd, String checkUserName,
			String checkuserPwd) {
		super();
		this.newPwd = newPwd;
		this.checkUserName = checkUserName;
		this.checkuserPwd = checkuserPwd;
	}
	public ChangPassword() {
		super();
	}
	
	
	
	

}
