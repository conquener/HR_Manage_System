package com.zking.hr.pojo;

/**
 * TUser entity. @author MyEclipse Persistence Tools
 */

public class TUser implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String userReferredToAs;
	private String userName;
	private String userFile;
	private String userPassword;
	private Integer userRoleId;
	private String userRoleName;
	private int userRoleCheck;
	private String userTruename;
	private Integer roleRollbackStatus;
	private String remark;

	// Constructors

	/** default constructor */
	public TUser() {
	}

	/** minimal constructor */
	public TUser(Integer userId) {
		this.userId = userId;
	}

	/** full constructor */
	public TUser(Integer userId, String userReferredToAs, String userName,
			String userFile, String userPassword, Integer userRoleId,
			String userRoleName, int userRoleCheck, String userTruename,
			Integer roleRollbackStatus, String remark) {
		this.userId = userId;
		this.userReferredToAs = userReferredToAs;
		this.userName = userName;
		this.userFile = userFile;
		this.userPassword = userPassword;
		this.userRoleId = userRoleId;
		this.userRoleName = userRoleName;
		this.userRoleCheck = userRoleCheck;
		this.userTruename = userTruename;
		this.roleRollbackStatus = roleRollbackStatus;
		this.remark = remark;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserReferredToAs() {
		return this.userReferredToAs;
	}

	public void setUserReferredToAs(String userReferredToAs) {
		this.userReferredToAs = userReferredToAs;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserFile() {
		return this.userFile;
	}

	public void setUserFile(String userFile) {
		this.userFile = userFile;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Integer getUserRoleId() {
		return this.userRoleId;
	}

	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getUserRoleName() {
		return this.userRoleName;
	}

	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}

	public int getUserRoleCheck() {
		return this.userRoleCheck;
	}

	public void setUserRoleCheck(int userRoleCheck) {
		this.userRoleCheck = userRoleCheck;
	}

	public String getUserTruename() {
		return this.userTruename;
	}

	public void setUserTruename(String userTruename) {
		this.userTruename = userTruename;
	}

	public Integer getRoleRollbackStatus() {
		return this.roleRollbackStatus;
	}

	public void setRoleRollbackStatus(Integer roleRollbackStatus) {
		this.roleRollbackStatus = roleRollbackStatus;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "TUser [userId=" + userId + ", userReferredToAs="
				+ userReferredToAs + ", userName=" + userName + ", userFile="
				+ userFile + ", userPassword=" + userPassword + ", userRoleId="
				+ userRoleId + ", userRoleName=" + userRoleName
				+ ", userRoleCheck=" + userRoleCheck + ", userTruename="
				+ userTruename + ", roleRollbackStatus=" + roleRollbackStatus
				+ ", remark=" + remark + "]";
	}
	
	

}