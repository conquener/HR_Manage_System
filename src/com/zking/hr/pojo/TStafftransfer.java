package com.zking.hr.pojo;

import java.sql.Date;

/**
 * TStafftransfer entity. @author MyEclipse Persistence Tools
 */

public class TStafftransfer implements java.io.Serializable {

	// Fields

	private Integer transferid;
	private Integer staffid;
	private Date registerdate;
	private Date transferdate;
	private String transactionnature;
	private String beforeTransactionDepartment;
	private String laterTransactionDepartment;
	private String beforeTransactionPost;
	private String laterTransactionPost;
	private Double beforeSalary;
	private Double laterSalary;
	private String beforeWork;
	private String lsterWork;
	private int viewsStatus;
	private String departmentViews;
	private String deputymanagerViews;
	private String personneldepartmentViews;
	private Date dotransferdate;
	private String presidentViews;
	private String remark;

	// Constructors

	/** default constructor */
	public TStafftransfer() {
	}

	/** minimal constructor */
	public TStafftransfer(Integer transferid) {
		this.transferid = transferid;
	}

	/** full constructor */
	public TStafftransfer(Integer transferid, Integer staffid,
			Date registerdate, Date transferdate, String transactionnature,
			String beforeTransactionDepartment,
			String laterTransactionDepartment, String beforeTransactionPost,
			String laterTransactionPost, Double beforeSalary,
			Double laterSalary, String beforeWork, String lsterWork,
			int viewsStatus, String departmentViews,
			String deputymanagerViews, String personneldepartmentViews,
			Date dotransferdate, String presidentViews, String remark) {
		this.transferid = transferid;
		this.staffid = staffid;
		this.registerdate = registerdate;
		this.transferdate = transferdate;
		this.transactionnature = transactionnature;
		this.beforeTransactionDepartment = beforeTransactionDepartment;
		this.laterTransactionDepartment = laterTransactionDepartment;
		this.beforeTransactionPost = beforeTransactionPost;
		this.laterTransactionPost = laterTransactionPost;
		this.beforeSalary = beforeSalary;
		this.laterSalary = laterSalary;
		this.beforeWork = beforeWork;
		this.lsterWork = lsterWork;
		this.viewsStatus = viewsStatus;
		this.departmentViews = departmentViews;
		this.deputymanagerViews = deputymanagerViews;
		this.personneldepartmentViews = personneldepartmentViews;
		this.dotransferdate = dotransferdate;
		this.presidentViews = presidentViews;
		this.remark = remark;
	}

	// Property accessors

	public Integer getTransferid() {
		return this.transferid;
	}

	public void setTransferid(Integer transferid) {
		this.transferid = transferid;
	}

	public Integer getStaffid() {
		return this.staffid;
	}

	public void setStaffid(Integer staffid) {
		this.staffid = staffid;
	}

	public Date getRegisterdate() {
		return this.registerdate;
	}

	public void setRegisterdate(Date registerdate) {
		this.registerdate = registerdate;
	}

	public Date getTransferdate() {
		return this.transferdate;
	}

	public void setTransferdate(Date transferdate) {
		this.transferdate = transferdate;
	}

	public String getTransactionnature() {
		return this.transactionnature;
	}

	public void setTransactionnature(String transactionnature) {
		this.transactionnature = transactionnature;
	}

	public String getBeforeTransactionDepartment() {
		return this.beforeTransactionDepartment;
	}

	public void setBeforeTransactionDepartment(
			String beforeTransactionDepartment) {
		this.beforeTransactionDepartment = beforeTransactionDepartment;
	}

	public String getLaterTransactionDepartment() {
		return this.laterTransactionDepartment;
	}

	public void setLaterTransactionDepartment(String laterTransactionDepartment) {
		this.laterTransactionDepartment = laterTransactionDepartment;
	}

	public String getBeforeTransactionPost() {
		return this.beforeTransactionPost;
	}

	public void setBeforeTransactionPost(String beforeTransactionPost) {
		this.beforeTransactionPost = beforeTransactionPost;
	}

	public String getLaterTransactionPost() {
		return this.laterTransactionPost;
	}

	public void setLaterTransactionPost(String laterTransactionPost) {
		this.laterTransactionPost = laterTransactionPost;
	}

	public Double getBeforeSalary() {
		return this.beforeSalary;
	}

	public void setBeforeSalary(Double beforeSalary) {
		this.beforeSalary = beforeSalary;
	}

	public Double getLaterSalary() {
		return this.laterSalary;
	}

	public void setLaterSalary(Double laterSalary) {
		this.laterSalary = laterSalary;
	}

	public String getBeforeWork() {
		return this.beforeWork;
	}

	public void setBeforeWork(String beforeWork) {
		this.beforeWork = beforeWork;
	}

	public String getLsterWork() {
		return this.lsterWork;
	}

	public void setLsterWork(String lsterWork) {
		this.lsterWork = lsterWork;
	}

	public int getViewsStatus() {
		return this.viewsStatus;
	}

	public void setViewsStatus(int viewsStatus) {
		this.viewsStatus = viewsStatus;
	}

	public String getDepartmentViews() {
		return this.departmentViews;
	}

	public void setDepartmentViews(String departmentViews) {
		this.departmentViews = departmentViews;
	}

	public String getDeputymanagerViews() {
		return this.deputymanagerViews;
	}

	public void setDeputymanagerViews(String deputymanagerViews) {
		this.deputymanagerViews = deputymanagerViews;
	}

	public String getPersonneldepartmentViews() {
		return this.personneldepartmentViews;
	}

	public void setPersonneldepartmentViews(String personneldepartmentViews) {
		this.personneldepartmentViews = personneldepartmentViews;
	}

	public Date getDotransferdate() {
		return this.dotransferdate;
	}

	public void setDotransferdate(Date dotransferdate) {
		this.dotransferdate = dotransferdate;
	}

	public String getPresidentViews() {
		return this.presidentViews;
	}

	public void setPresidentViews(String presidentViews) {
		this.presidentViews = presidentViews;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "TStafftransfer [transferid=" + transferid + ", staffid="
				+ staffid + ", registerdate=" + registerdate
				+ ", transferdate=" + transferdate + ", transactionnature="
				+ transactionnature + ", beforeTransactionDepartment="
				+ beforeTransactionDepartment + ", laterTransactionDepartment="
				+ laterTransactionDepartment + ", beforeTransactionPost="
				+ beforeTransactionPost + ", laterTransactionPost="
				+ laterTransactionPost + ", beforeSalary=" + beforeSalary
				+ ", laterSalary=" + laterSalary + ", beforeWork=" + beforeWork
				+ ", lsterWork=" + lsterWork + ", viewsStatus=" + viewsStatus
				+ ", departmentViews=" + departmentViews
				+ ", deputymanagerViews=" + deputymanagerViews
				+ ", personneldepartmentViews=" + personneldepartmentViews
				+ ", dotransferdate=" + dotransferdate + ", presidentViews="
				+ presidentViews + ", remark=" + remark + "]";
	}

}