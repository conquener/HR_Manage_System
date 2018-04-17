package com.zking.hr.pojo;

/**
 * TRolePermissionId entity. @author MyEclipse Persistence Tools
 */

public class TRolePermission implements java.io.Serializable {

	// Fields

	private Integer rolePermissionId;
	private Integer roleId;
	private Integer permissionId;
	private String remark;

	// Constructors

	/** default constructor */
	public TRolePermission() {
	}

	/** minimal constructor */
	public TRolePermission(Integer rolePermissionId) {
		this.rolePermissionId = rolePermissionId;
	}

	/** full constructor */
	public TRolePermission(Integer rolePermissionId, Integer roleId,
			Integer permissionId, String remark) {
		this.rolePermissionId = rolePermissionId;
		this.roleId = roleId;
		this.permissionId = permissionId;
		this.remark = remark;
	}

	// Property accessors

	public Integer getRolePermissionId() {
		return this.rolePermissionId;
	}

	public void setRolePermissionId(Integer rolePermissionId) {
		this.rolePermissionId = rolePermissionId;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getPermissionId() {
		return this.permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TRolePermission))
			return false;
		TRolePermission castOther = (TRolePermission) other;

		return ((this.getRolePermissionId() == castOther.getRolePermissionId()) || (this
				.getRolePermissionId() != null
				&& castOther.getRolePermissionId() != null && this
				.getRolePermissionId().equals(castOther.getRolePermissionId())))
				&& ((this.getRoleId() == castOther.getRoleId()) || (this
						.getRoleId() != null && castOther.getRoleId() != null && this
						.getRoleId().equals(castOther.getRoleId())))
				&& ((this.getPermissionId() == castOther.getPermissionId()) || (this
						.getPermissionId() != null
						&& castOther.getPermissionId() != null && this
						.getPermissionId().equals(castOther.getPermissionId())))
				&& ((this.getRemark() == castOther.getRemark()) || (this
						.getRemark() != null && castOther.getRemark() != null && this
						.getRemark().equals(castOther.getRemark())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getRolePermissionId() == null ? 0 : this
						.getRolePermissionId().hashCode());
		result = 37 * result
				+ (getRoleId() == null ? 0 : this.getRoleId().hashCode());
		result = 37
				* result
				+ (getPermissionId() == null ? 0 : this.getPermissionId()
						.hashCode());
		result = 37 * result
				+ (getRemark() == null ? 0 : this.getRemark().hashCode());
		return result;
	}

}