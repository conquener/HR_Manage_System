package com.zking.hr.pojo;

/**
 * TOrganization entity. @author MyEclipse Persistence Tools
 */

public class TOrganization implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 1L;
	private Integer oraganId;
	private String oraganName;
	private Integer salarypaypersonId;
	private Integer salepersonId;
	private Integer parentId;
	private String parentName;
	private String remark;

	// Constructors

	/** default constructor */
	public TOrganization() {
	}

	/** minimal constructor */
	public TOrganization(Integer oraganId) {
		this.oraganId = oraganId;
	}

	/** full constructor */
	public TOrganization(Integer oraganId, String oraganName,
			Integer salarypaypersonId, Integer salepersonId, Integer parentId,
			String parentName, String remark) {
		this.oraganId = oraganId;
		this.oraganName = oraganName;
		this.salarypaypersonId = salarypaypersonId;
		this.salepersonId = salepersonId;
		this.parentId = parentId;
		this.parentName = parentName;
		this.remark = remark;
	}

	// Property accessors

	public Integer getOraganId() {
		return this.oraganId;
	}

	public void setOraganId(Integer oraganId) {
		this.oraganId = oraganId;
	}

	public String getOraganName() {
		return this.oraganName;
	}

	public void setOraganName(String oraganName) {
		this.oraganName = oraganName;
	}

	public Integer getSalarypaypersonId() {
		return this.salarypaypersonId;
	}

	public void setSalarypaypersonId(Integer salarypaypersonId) {
		this.salarypaypersonId = salarypaypersonId;
	}

	public Integer getSalepersonId() {
		return this.salepersonId;
	}

	public void setSalepersonId(Integer salepersonId) {
		this.salepersonId = salepersonId;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getParentName() {
		return this.parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "TOrganization [oraganId=" + oraganId + ", oraganName="
				+ oraganName + ", salarypaypersonId=" + salarypaypersonId
				+ ", salepersonId=" + salepersonId + ", parentId=" + parentId
				+ ", parentName=" + parentName + ", remark=" + remark + "]";
	}
	
}