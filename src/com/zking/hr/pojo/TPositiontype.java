package com.zking.hr.pojo;

/**
 * TPositiontype entity. @author MyEclipse Persistence Tools
 */

public class TPositiontype implements java.io.Serializable {

	// Fields

	private Integer positiontypeId;
	private String positiontypeName;
	private String remark;

	// Constructors

	/** default constructor */
	public TPositiontype() {
	}

	/** minimal constructor */
	public TPositiontype(Integer positiontypeId) {
		this.positiontypeId = positiontypeId;
	}

	/** full constructor */
	public TPositiontype(Integer positiontypeId, String positiontypeName,
			String remark) {
		this.positiontypeId = positiontypeId;
		this.positiontypeName = positiontypeName;
		this.remark = remark;
	}

	// Property accessors

	public Integer getPositiontypeId() {
		return this.positiontypeId;
	}

	public void setPositiontypeId(Integer positiontypeId) {
		this.positiontypeId = positiontypeId;
	}

	public String getPositiontypeName() {
		return this.positiontypeName;
	}

	public void setPositiontypeName(String positiontypeName) {
		this.positiontypeName = positiontypeName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}