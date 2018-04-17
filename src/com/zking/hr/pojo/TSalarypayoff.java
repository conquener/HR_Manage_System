package com.zking.hr.pojo;

import java.sql.Date;

/**
 * TSalarypayoff entity. @author MyEclipse Persistence Tools
 */

public class TSalarypayoff implements java.io.Serializable {

	// Fields

	private Integer salarypayoffId;
	private String salarypayoffName;
	private Date salaryBegintime;
	private Date salaryEndtime;
	private String remark;

	// Constructors

	/** default constructor */
	public TSalarypayoff() {
	}

	/** minimal constructor */
	public TSalarypayoff(Integer salarypayoffId) {
		this.salarypayoffId = salarypayoffId;
	}

	/** full constructor */
	public TSalarypayoff(Integer salarypayoffId, String salarypayoffName,
			Date salaryBegintime, Date salaryEndtime, String remark) {
		this.salarypayoffId = salarypayoffId;
		this.salarypayoffName = salarypayoffName;
		this.salaryBegintime = salaryBegintime;
		this.salaryEndtime = salaryEndtime;
		this.remark = remark;
	}

	// Property accessors

	public Integer getSalarypayoffId() {
		return this.salarypayoffId;
	}

	@Override
	public String toString() {
		return "TSalarypayoff [salarypayoffId=" + salarypayoffId
				+ ", salarypayoffName=" + salarypayoffName
				+ ", salaryBegintime=" + salaryBegintime + ", salaryEndtime="
				+ salaryEndtime + ", remark=" + remark + "]";
	}

	public void setSalarypayoffId(Integer salarypayoffId) {
		this.salarypayoffId = salarypayoffId;
	}

	public String getSalarypayoffName() {
		return this.salarypayoffName;
	}

	public void setSalarypayoffName(String salarypayoffName) {
		this.salarypayoffName = salarypayoffName;
	}

	public Date getSalaryBegintime() {
		return this.salaryBegintime;
	}

	public void setSalaryBegintime(Date salaryBegintime) {
		this.salaryBegintime = salaryBegintime;
	}

	public Date getSalaryEndtime() {
		return this.salaryEndtime;
	}

	public void setSalaryEndtime(Date salaryEndtime) {
		this.salaryEndtime = salaryEndtime;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}