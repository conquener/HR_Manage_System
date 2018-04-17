package com.zking.hr.view.pojo.pageRow;

public class pageRow {
	private int beginRow;
	private int endRow;
	public int getBeginRow() {
		return beginRow;
	}
	public void setBeginRow(int beginRow) {
		this.beginRow = beginRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	public pageRow(int beginRow, int endRow) {
		super();
		this.beginRow = beginRow;
		this.endRow = endRow;
	}
	
	public pageRow() {
	}
}
