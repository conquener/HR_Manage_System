package com.zking.hr.view.pojo.file;

public class QueryFiles implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private Integer fristorganization;
	private Integer twoorganization;
	private Integer threeorganization;
	private Integer postClass;
	private Integer postion;
	private String 	startTime;
	private String 	endTime;
	private Integer indexPage;
	private Integer startRow;
	private Integer endRow;
	public Integer getFristorganization() {
		return fristorganization;
	}
	public void setFristorganization(Integer fristorganization) {
		if(fristorganization!=null&&fristorganization>-1){
			this.fristorganization = fristorganization;
		}
	}
	public Integer getTwoorganization() {
		return twoorganization;
	}
	public void setTwoorganization(Integer twoorganization) {
		if(twoorganization!=null&&twoorganization>-1){
			this.twoorganization = twoorganization;
		}
	}
	public Integer getThreeorganization() {
		return threeorganization;
	}
	public void setThreeorganization(Integer threeorganization) {
		if(threeorganization!=null&&threeorganization>-1){
			this.threeorganization = threeorganization;
		}
	}
	public Integer getPostClass() {
		return postClass;
	}
	public void setPostClass(Integer postClass) {
		this.postClass = postClass;
	}
	public Integer getPostion() {
		return postion;
	}
	public void setPostion(Integer postion) {
		this.postion = postion;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Integer getIndexPage() {
		return indexPage;
	}
	public void setIndexPage(Integer indexPage) {
		this.indexPage = indexPage;
	}
	public Integer getStartRow() {
		return startRow;
	}
	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}
	public Integer getEndRow() {
		return endRow;
	}
	public void setEndRow(Integer endRow) {
		this.endRow = endRow;
	}
	@Override
	public String toString() {
		return "QueryFiles [fristorganization=" + fristorganization
				+ ", twoorganization=" + twoorganization
				+ ", threeorganization=" + threeorganization + ", postClass="
				+ postClass + ", postion=" + postion + ", startTime="
				+ startTime + ", endTime=" + endTime + ", indexPage="
				+ indexPage + ", startRow=" + startRow + ", endRow=" + endRow
				+ "]";
	}
	
	
}
