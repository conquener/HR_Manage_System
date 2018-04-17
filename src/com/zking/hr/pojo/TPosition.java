package com.zking.hr.pojo;

/**
 * TPosition entity. @author MyEclipse Persistence Tools
 */

public class TPosition implements java.io.Serializable {

	// Fields

	private Integer positiontypeId;
	private String positiontypeName;
	private Integer positionId;
	private String positionName;
	private String remark;

	// Constructors

	/** default constructor */
	public TPosition() {
	}

	/** minimal constructor */
	public TPosition(Integer positiontypeId) {
		this.positiontypeId = positiontypeId;
	}

	/** full constructor */
	public TPosition(Integer positiontypeId, String positiontypeName,
			Integer positionId, String positionName, String remark) {
		this.positiontypeId = positiontypeId;
		this.positiontypeName = positiontypeName;
		this.positionId = positionId;
		this.positionName = positionName;
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

	public Integer getPositionId() {
		return this.positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	public String getPositionName() {
		return this.positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}