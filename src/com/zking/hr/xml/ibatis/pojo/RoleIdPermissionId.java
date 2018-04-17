package com.zking.hr.xml.ibatis.pojo;

public class RoleIdPermissionId {
	private Integer RoleId;
	
	private Integer PermissionId;

	public Integer getRoleId() {
		return RoleId;
	}

	public void setRoleId(Integer roleId) {
		RoleId = roleId;
	}

	public Integer getPermissionId() {
		return PermissionId;
	}

	public void setPermissionId(Integer permissionId) {
		PermissionId = permissionId;
	}

	public RoleIdPermissionId(Integer roleId, Integer permissionId) {
		super();
		RoleId = roleId;
		PermissionId = permissionId;
	}
	
	public RoleIdPermissionId() {
	}
}
