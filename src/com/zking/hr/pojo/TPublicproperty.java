package com.zking.hr.pojo;

/**
 * TPublicproperty entity. @author MyEclipse Persistence Tools
 */

public class TPublicproperty implements java.io.Serializable {

	// Fields

	private Integer publicpropertytypeId;
	private String propertytypeName;
	private String publcipropertyName;
	private Integer propertyId;
	private String remark;

	// Constructors

	/** default constructor */
	public TPublicproperty() {
	}

	/** minimal constructor */
	public TPublicproperty(Integer publicpropertytypeId) {
		this.publicpropertytypeId = publicpropertytypeId;
	}

	/** full constructor */
	public TPublicproperty(Integer publicpropertytypeId,
			String propertytypeName, String publcipropertyName,
			Integer propertyId, String remark) {
		this.publicpropertytypeId = publicpropertytypeId;
		this.propertytypeName = propertytypeName;
		this.publcipropertyName = publcipropertyName;
		this.propertyId = propertyId;
		this.remark = remark;
	}

	// Property accessors

	public Integer getPublicpropertytypeId() {
		return this.publicpropertytypeId;
	}

	public void setPublicpropertytypeId(Integer publicpropertytypeId) {
		this.publicpropertytypeId = publicpropertytypeId;
	}

	public String getPropertytypeName() {
		return this.propertytypeName;
	}

	public void setPropertytypeName(String propertytypeName) {
		this.propertytypeName = propertytypeName;
	}

	public String getPublcipropertyName() {
		return this.publcipropertyName;
	}

	public void setPublcipropertyName(String publcipropertyName) {
		this.publcipropertyName = publcipropertyName;
	}

	public Integer getPropertyId() {
		return this.propertyId;
	}

	public void setPropertyId(Integer propertyId) {
		this.propertyId = propertyId;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}