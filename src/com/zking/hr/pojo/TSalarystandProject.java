package com.zking.hr.pojo;

/**
 * TSalarystandProjectId entity. @author MyEclipse Persistence Tools
 */

public class TSalarystandProject implements java.io.Serializable {
	private static final long serialVersionUID = 1951525054208615541L;
	private Integer salarystanderdId;
	private String salaryprojectName;
	private Double salaryprojectMoney;
	private Integer salaryprojectId;
	private String remark;

	// Constructors

	/** default constructor */
	public TSalarystandProject() {
	}

	/** full constructor */
	public TSalarystandProject(Integer salarystanderdId,
			String salaryprojectName, Double salaryprojectMoney,
			Integer salaryprojectId, String remark) {
		this.salarystanderdId = salarystanderdId;
		this.salaryprojectName = salaryprojectName;
		this.salaryprojectMoney = salaryprojectMoney;
		this.salaryprojectId = salaryprojectId;
		this.remark = remark;
	}

	// Property accessors

	public Integer getSalarystanderdId() {
		return this.salarystanderdId;
	}

	public void setSalarystanderdId(Integer salarystanderdId) {
		this.salarystanderdId = salarystanderdId;
	}

	public String getSalaryprojectName() {
		return this.salaryprojectName;
	}

	public void setSalaryprojectName(String salaryprojectName) {
		this.salaryprojectName = salaryprojectName;
	}

	public Double getSalaryprojectMoney() {
		return this.salaryprojectMoney;
	}

	public void setSalaryprojectMoney(Double salaryprojectMoney) {
		this.salaryprojectMoney = salaryprojectMoney;
	}

	public Integer getSalaryprojectId() {
		return this.salaryprojectId;
	}

	public void setSalaryprojectId(Integer salaryprojectId) {
		this.salaryprojectId = salaryprojectId;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TSalarystandProject))
			return false;
		TSalarystandProject castOther = (TSalarystandProject) other;

		return ((this.getSalarystanderdId() == castOther.getSalarystanderdId()) || (this
				.getSalarystanderdId() != null
				&& castOther.getSalarystanderdId() != null && this
				.getSalarystanderdId().equals(castOther.getSalarystanderdId())))
				&& ((this.getSalaryprojectName() == castOther
						.getSalaryprojectName()) || (this
						.getSalaryprojectName() != null
						&& castOther.getSalaryprojectName() != null && this
						.getSalaryprojectName().equals(
								castOther.getSalaryprojectName())))
				&& ((this.getSalaryprojectMoney() == castOther
						.getSalaryprojectMoney()) || (this
						.getSalaryprojectMoney() != null
						&& castOther.getSalaryprojectMoney() != null && this
						.getSalaryprojectMoney().equals(
								castOther.getSalaryprojectMoney())))
				&& ((this.getSalaryprojectId() == castOther
						.getSalaryprojectId()) || (this.getSalaryprojectId() != null
						&& castOther.getSalaryprojectId() != null && this
						.getSalaryprojectId().equals(
								castOther.getSalaryprojectId())))
				&& ((this.getRemark() == castOther.getRemark()) || (this
						.getRemark() != null && castOther.getRemark() != null && this
						.getRemark().equals(castOther.getRemark())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getSalarystanderdId() == null ? 0 : this
						.getSalarystanderdId().hashCode());
		result = 37
				* result
				+ (getSalaryprojectName() == null ? 0 : this
						.getSalaryprojectName().hashCode());
		result = 37
				* result
				+ (getSalaryprojectMoney() == null ? 0 : this
						.getSalaryprojectMoney().hashCode());
		result = 37
				* result
				+ (getSalaryprojectId() == null ? 0 : this.getSalaryprojectId()
						.hashCode());
		result = 37 * result
				+ (getRemark() == null ? 0 : this.getRemark().hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "TSalarystandProject [salarystanderdId=" + salarystanderdId
				+ ", salaryprojectName=" + salaryprojectName
				+ ", salaryprojectMoney=" + salaryprojectMoney
				+ ", salaryprojectId=" + salaryprojectId + ", remark=" + remark
				+ "]";
	}
	
	

}