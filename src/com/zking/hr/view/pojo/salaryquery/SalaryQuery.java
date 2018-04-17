package com.zking.hr.view.pojo.salaryquery;

public class SalaryQuery {
	private String salarysendAddId;
	private String salarySendOrganName;
	private String salarysendstartTime;
	private String salarysendendTime;
	private Integer indexPage;
	private Integer beginRow;
	private Integer endRow;
	public String getSalarysendAddId() {
		return salarysendAddId;
	}
	public void setSalarysendAddId(String salarysendAddId) {
		this.salarysendAddId = salarysendAddId;
	}
	public String getSalarySendOrganName() {
		return salarySendOrganName;
	}
	public void setSalarySendOrganName(String salarySendOrganName) {
		this.salarySendOrganName = salarySendOrganName;
	}
	public String getSalarysendstartTime() {
		return salarysendstartTime;
	}
	public void setSalarysendstartTime(String salarysendstartTime) {
		this.salarysendstartTime = salarysendstartTime;
	}
	public String getSalarysendendTime() {
		return salarysendendTime;
	}
	public void setSalarysendendTime(String salarysendendTime) {
		this.salarysendendTime = salarysendendTime;
	}
	public Integer getIndexPage() {
		return indexPage;
	}
	public void setIndexPage(Integer indexPage) {
		this.indexPage = indexPage;
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
	@Override
	public String toString() {
		return "SalaryQuery [salarysendAddId=" + salarysendAddId
				+ ", salarySendOrganName=" + salarySendOrganName
				+ ", salarysendstartTime=" + salarysendstartTime
				+ ", salarysendendTime=" + salarysendendTime + ", indexPage="
				+ indexPage + ", beginRow=" + beginRow + ", endRow=" + endRow
				+ "]";
	}
	public SalaryQuery(String salarysendAddId, String salarySendOrganName,
			String salarysendstartTime, String salarysendendTime,
			Integer indexPage, Integer beginRow, Integer endRow) {
		super();
		this.salarysendAddId = salarysendAddId;
		this.salarySendOrganName = salarySendOrganName;
		this.salarysendstartTime = salarysendstartTime;
		this.salarysendendTime = salarysendendTime;
		this.indexPage = indexPage;
		this.beginRow = beginRow;
		this.endRow = endRow;
	}
	public SalaryQuery() {
		super();
	}
	
	
	
	
}
