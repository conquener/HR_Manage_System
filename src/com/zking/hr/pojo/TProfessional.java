package com.zking.hr.pojo;

/**
 * TProfessional entity. @author MyEclipse Persistence Tools
 */

public class TProfessional implements java.io.Serializable {

	// Fields

	private Integer professionalId;
	private String professionalName;
	private String remark;

	// Constructors

	/** default constructor */
	public TProfessional() {
	}

	/** minimal constructor */
	public TProfessional(Integer professionalId) {
		this.professionalId = professionalId;
	}

	/** full constructor */
	public TProfessional(Integer professionalId, String professionalName,
			String remark) {
		this.professionalId = professionalId;
		this.professionalName = professionalName;
		this.remark = remark;
	}

	// Property accessors

	public Integer getProfessionalId() {
		return this.professionalId;
	}

	public void setProfessionalId(Integer professionalId) {
		this.professionalId = professionalId;
	}

	public String getProfessionalName() {
		return this.professionalName;
	}

	public void setProfessionalName(String professionalName) {
		this.professionalName = professionalName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}