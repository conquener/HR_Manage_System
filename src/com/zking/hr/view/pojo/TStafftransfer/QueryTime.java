package com.zking.hr.view.pojo.TStafftransfer;


public class QueryTime implements java.io.Serializable{

	private static final long serialVersionUID = -7789058859516358904L;
	private String sName;
	private String beginTime;
	private String endTime;
	private int indexPage;
	private int endRow;
	private int beginRow;
	
	public QueryTime(String sName, String beginTime, String endTime, int indexPage,
			int endRow, int beginRow) {
		super();
		this.sName = sName;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.indexPage = indexPage;
		this.endRow = endRow;
		this.beginRow = beginRow;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getIndexPage() {
		return indexPage;
	}
	public void setIndexPage(int indexPage) {
		this.indexPage = indexPage;
	}

	public int getEndRow() {
		return endRow;
	}




	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}




	public int getBeginRow() {
		return beginRow;
	}




	public void setBeginRow(int beginRow) {
		this.beginRow = beginRow;
	}




	public QueryTime() {
		super();
	}
	
	
	
}
