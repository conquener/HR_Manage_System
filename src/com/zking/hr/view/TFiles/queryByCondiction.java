package com.zking.hr.view.TFiles;
public class queryByCondiction {
	private String firstOName;
	private String secondOname;
	private String thirdOName;
	private String positionTypeName;
	private String positionName;
	private String beginTime;
	private String endTime;
	private Integer beginRow;
	private Integer endRow;
	public String getFirstOName() {
		return firstOName;
	}
	public void setFirstOName(String firstOName) {
		this.firstOName = firstOName;
	}
	public String getSecondOname() {
		return secondOname;
	}
	public void setSecondOname(String secondOname) {
		this.secondOname = secondOname;
	}
	public String getThirdOName() {
		return thirdOName;
	}
	public void setThirdOName(String thirdOName) {
		this.thirdOName = thirdOName;
	}
	public String getPositionTypeName() {
		return positionTypeName;
	}
	public void setPositionTypeName(String positionTypeName) {
		this.positionTypeName = positionTypeName;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
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
	public queryByCondiction(String firstOName, String secondOname,
			String thirdOName, String positionTypeName, String positionName,
			String beginTime, String endTime, Integer beginRow, Integer endRow) {
		super();
		this.firstOName = firstOName;
		this.secondOname = secondOname;
		this.thirdOName = thirdOName;
		this.positionTypeName = positionTypeName;
		this.positionName = positionName;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.beginRow = beginRow;
		this.endRow = endRow;
	}
	public queryByCondiction() {
	}
}
