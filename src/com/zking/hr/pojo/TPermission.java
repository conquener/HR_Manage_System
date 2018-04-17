package com.zking.hr.pojo;

/**
 * TPermission entity. @author MyEclipse Persistence Tools
 */

public class TPermission implements java.io.Serializable {

	// Fields

	private Integer permissionId;
	private String permissionName;
	private String permissionAddress;
	private Integer parentId;
	private String remark;

	// Constructors

	/** default constructor */
	public TPermission() {
	}

	/** minimal constructor */
	public TPermission(Integer permissionId) {
		this.permissionId = permissionId;
	}

	/** full constructor */
	public TPermission(Integer permissionId, String permissionName,
			String permissionAddress, Integer parentId, String remark) {
		this.permissionId = permissionId;
		this.permissionName = permissionName;
		this.permissionAddress = permissionAddress;
		this.parentId = parentId;
		this.remark = remark;
	}

	// Property accessors

	public Integer getPermissionId() {
		return this.permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	public String getPermissionName() {
		return this.permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public String getPermissionAddress() {
		return this.permissionAddress;
	}

	public void setPermissionAddress(String permissionAddress) {
		this.permissionAddress = permissionAddress;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}