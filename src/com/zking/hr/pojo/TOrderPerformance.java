package com.zking.hr.pojo;

/**
 * TOrderPerformanceId entity. @author MyEclipse Persistence Tools
 */

public class TOrderPerformance implements java.io.Serializable {

	// Fields

	private Integer opPerformanceid;
	private Double opGoalMoney;
	private Double opDrawapercent;
	private String opDrawtype;
	private String remark;

	// Constructors

	/** default constructor */
	public TOrderPerformance() {
	}

	/** full constructor */
	public TOrderPerformance(Integer opPerformanceid, Double opGoalMoney,
			Double opDrawapercent, String opDrawtype, String remark) {
		this.opPerformanceid = opPerformanceid;
		this.opGoalMoney = opGoalMoney;
		this.opDrawapercent = opDrawapercent;
		this.opDrawtype = opDrawtype;
		this.remark = remark;
	}

	// Property accessors

	public Integer getOpPerformanceid() {
		return this.opPerformanceid;
	}

	public void setOpPerformanceid(Integer opPerformanceid) {
		this.opPerformanceid = opPerformanceid;
	}

	public Double getOpGoalMoney() {
		return this.opGoalMoney;
	}

	public void setOpGoalMoney(Double opGoalMoney) {
		this.opGoalMoney = opGoalMoney;
	}

	public Double getOpDrawapercent() {
		return this.opDrawapercent;
	}

	public void setOpDrawapercent(Double opDrawapercent) {
		this.opDrawapercent = opDrawapercent;
	}

	public String getOpDrawtype() {
		return this.opDrawtype;
	}

	public void setOpDrawtype(String opDrawtype) {
		this.opDrawtype = opDrawtype;
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
		if (!(other instanceof TOrderPerformance))
			return false;
		TOrderPerformance castOther = (TOrderPerformance) other;

		return ((this.getOpPerformanceid() == castOther.getOpPerformanceid()) || (this
				.getOpPerformanceid() != null
				&& castOther.getOpPerformanceid() != null && this
				.getOpPerformanceid().equals(castOther.getOpPerformanceid())))
				&& ((this.getOpGoalMoney() == castOther.getOpGoalMoney()) || (this
						.getOpGoalMoney() != null
						&& castOther.getOpGoalMoney() != null && this
						.getOpGoalMoney().equals(castOther.getOpGoalMoney())))
				&& ((this.getOpDrawapercent() == castOther.getOpDrawapercent()) || (this
						.getOpDrawapercent() != null
						&& castOther.getOpDrawapercent() != null && this
						.getOpDrawapercent().equals(
								castOther.getOpDrawapercent())))
				&& ((this.getOpDrawtype() == castOther.getOpDrawtype()) || (this
						.getOpDrawtype() != null
						&& castOther.getOpDrawtype() != null && this
						.getOpDrawtype().equals(castOther.getOpDrawtype())))
				&& ((this.getRemark() == castOther.getRemark()) || (this
						.getRemark() != null && castOther.getRemark() != null && this
						.getRemark().equals(castOther.getRemark())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getOpPerformanceid() == null ? 0 : this.getOpPerformanceid()
						.hashCode());
		result = 37
				* result
				+ (getOpGoalMoney() == null ? 0 : this.getOpGoalMoney()
						.hashCode());
		result = 37
				* result
				+ (getOpDrawapercent() == null ? 0 : this.getOpDrawapercent()
						.hashCode());
		result = 37
				* result
				+ (getOpDrawtype() == null ? 0 : this.getOpDrawtype()
						.hashCode());
		result = 37 * result
				+ (getRemark() == null ? 0 : this.getRemark().hashCode());
		return result;
	}

}