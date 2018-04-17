package com.zking.hr.view.pojo.Salarystanderd;

public class QueryTimeName implements java.io.Serializable{
	private Integer salaryStandId;
	private String salaryStandName;
	private String begintime;
	private String endtime;
	private Integer beginRow;
	private Integer endRow;

	public QueryTimeName(Integer salaryStandId, String salaryStandName,
			String begintime, String endtime, Integer beginRow, Integer endRow) {
		super();
		this.salaryStandId = salaryStandId;
		this.salaryStandName = salaryStandName;
		this.begintime = begintime;
		this.endtime = endtime;
		this.beginRow = beginRow;
		this.endRow = endRow;
	}

	public Integer getSalaryStandId() {
		return salaryStandId;
	}

	public void setSalaryStandId(Integer salaryStandId) {
		this.salaryStandId = salaryStandId;
	}

	public String getSalaryStandName() {
		return salaryStandName;
	}

	public void setSalaryStandName(String salaryStandName) {
		this.salaryStandName = salaryStandName;
	}

	public String getBegintime() {
		return begintime;
	}

	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public Integer getBeginRow() {
		return beginRow;
	}

	public void setBeginRow(Integer beginRow) {
		this.beginRow = beginRow;
	}

	public Integer getEndRow() {
		return endRow;
	}

	public void setEndRow(Integer endRow) {
		this.endRow = endRow;
	}

	public QueryTimeName() {
		super();
	}
	
	
	
	
	
	
}
