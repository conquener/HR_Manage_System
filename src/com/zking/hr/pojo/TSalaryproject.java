package com.zking.hr.pojo;

/**
 * TSalaryproject entity. @author MyEclipse Persistence Tools
 */

public class TSalaryproject implements java.io.Serializable {

	// Fields

	private Integer salaryprojectId;
	private String salaryprojectName;
	private String remark;

	// Constructors

	/** default constructor */
	public TSalaryproject() {
	}

	/** minimal constructor */
	public TSalaryproject(Integer salaryprojectId) {
		this.salaryprojectId = salaryprojectId;
	}

	/** full constructor */
	public TSalaryproject(Integer salaryprojectId, String salaryprojectName,
			String remark) {
		this.salaryprojectId = salaryprojectId;
		this.salaryprojectName = salaryprojectName;
		this.remark = remark;
	}

	// Property accessors

	public Integer getSalaryprojectId() {
		return this.salaryprojectId;
	}

	@Override
	public String toString() {
		return "TSalaryproject [salaryprojectId=" + salaryprojectId
				+ ", salaryprojectName=" + salaryprojectName + ", remark="
				+ remark + "]";
	}

	public void setSalaryprojectId(Integer salaryprojectId) {
		this.salaryprojectId = salaryprojectId;
	}

	public String getSalaryprojectName() {
		return this.salaryprojectName;
	}

	public void setSalaryprojectName(String salaryprojectName) {
		this.salaryprojectName = salaryprojectName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}