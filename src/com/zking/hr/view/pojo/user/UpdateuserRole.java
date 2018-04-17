package com.zking.hr.view.pojo.user;

public class UpdateuserRole implements java.io.Serializable{
	private String userName;
	private String roleName;
	private Integer roleId;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public UpdateuserRole(String userName, String roleName, Integer roleId) {
		super();
		this.userName = userName;
		this.roleName = roleName;
		this.roleId = roleId;
	}
	public UpdateuserRole() {
		super();
	}
	
	
	
	
}
