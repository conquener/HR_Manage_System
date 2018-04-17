package com.zking.hr.view.pagepojo;

public class IndexPage implements java.io.Serializable{
	private int endRow;
	private int beginRow;
	public IndexPage(int endRow, int beginRow) {
		super();
		this.endRow = endRow;
		this.beginRow = beginRow;
	}
	public IndexPage() {
		super();
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
	
}
