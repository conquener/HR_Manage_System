package com.zking.hr.view.TFiles;

public class querySalaryStatus {
	private Integer status;
	private Integer oraganizationId;
	private Integer level;
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getOraganizationId() {
		return oraganizationId;
	}
	public void setOraganizationId(Integer oraganizationId) {
		this.oraganizationId = oraganizationId;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public querySalaryStatus(Integer status, Integer oraganizationId,
			Integer level) {
		super();
		this.status = status;
		this.oraganizationId = oraganizationId;
		this.level = level;
	}
	public querySalaryStatus() {
		super();
	}
	@Override
	public String toString() {
		return "querySalaryStatus [status=" + status + ", oraganizationId="
				+ oraganizationId + ", level=" + level + "]";
	}
	
	
	
	
	
}
