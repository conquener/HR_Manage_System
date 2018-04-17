package com.zking.hr.pojo;

import java.sql.Date;

/**
 * TSalarystanderd entity. @author MyEclipse Persistence Tools
 */

public class TSalarystanderd implements java.io.Serializable {

	// Fields

	private Integer salarystanderdId;
	private String salarystanderdName;
	private Double salarySummoney;
	private String maker;
	private String register;
	private Date registertime;
	private String commissiontype;
	private int salarystandCheck;
	private String remark;

	// Constructors

	/** default constructor */
	public TSalarystanderd() {
	}

	/** minimal constructor */
	public TSalarystanderd(Integer salarystanderdId) {
		this.salarystanderdId = salarystanderdId;
	}

	/** full constructor */
	public TSalarystanderd(Integer salarystanderdId, String salarystanderdName,
			Double salarySummoney, String maker, String register,
			Date registertime, String commissiontype, int salarystandCheck,
			String remark) {
		this.salarystanderdId = salarystanderdId;
		this.salarystanderdName = salarystanderdName;
		this.salarySummoney = salarySummoney;
		this.maker = maker;
		this.register = register;
		this.registertime = registertime;
		this.commissiontype = commissiontype;
		this.salarystandCheck = salarystandCheck;
		this.remark = remark;
	}

	// Property accessors

	public Integer getSalarystanderdId() {
		return this.salarystanderdId;
	}

	public void setSalarystanderdId(Integer salarystanderdId) {
		this.salarystanderdId = salarystanderdId;
	}

	public String getSalarystanderdName() {
		return this.salarystanderdName;
	}

	public void setSalarystanderdName(String salarystanderdName) {
		this.salarystanderdName = salarystanderdName;
	}

	public Double getSalarySummoney() {
		return this.salarySummoney;
	}

	public void setSalarySummoney(Double salarySummoney) {
		this.salarySummoney = salarySummoney;
	}

	public String getMaker() {
		return this.maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getRegister() {
		return this.register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	public Date getRegistertime() {
		return this.registertime;
	}

	public void setRegistertime(Date registertime) {
		this.registertime = registertime;
	}

	public String getCommissiontype() {
		return this.commissiontype;
	}

	public void setCommissiontype(String commissiontype) {
		this.commissiontype = commissiontype;
	}

	public int getSalarystandCheck() {
		return this.salarystandCheck;
	}

	public void setSalarystandCheck(int salarystandCheck) {
		this.salarystandCheck = salarystandCheck;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "TSalarystanderd [salarystanderdId=" + salarystanderdId
				+ ", salarystanderdName=" + salarystanderdName
				+ ", salarySummoney=" + salarySummoney + ", maker=" + maker
				+ ", register=" + register + ", registertime=" + registertime
				+ ", commissiontype=" + commissiontype + ", salarystandCheck="
				+ salarystandCheck + ", remark=" + remark + "]";
	}

}