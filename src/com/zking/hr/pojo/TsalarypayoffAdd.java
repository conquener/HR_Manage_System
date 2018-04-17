package com.zking.hr.pojo;

import java.sql.Date;

/**
 * TsalarypayoffId entity. @author MyEclipse Persistence Tools
 */

public class TsalarypayoffAdd implements java.io.Serializable {

	// Fields
	private Integer salarypayoffId;
	private String registerman;
	private Date registertime;
	private Double payofftotalmoney;
	private Integer payofftotalpersonnum;
	public Integer getSalarypayoffId() {
		return salarypayoffId;
	}
	public void setSalarypayoffId(Integer salarypayoffId) {
		this.salarypayoffId = salarypayoffId;
	}
	public String getRegisterman() {
		return registerman;
	}
	public void setRegisterman(String registerman) {
		this.registerman = registerman;
	}
	public Date getRegistertime() {
		return registertime;
	}
	public void setRegistertime(Date registertime) {
		this.registertime = registertime;
	}
	public Double getPayofftotalmoney() {
		return payofftotalmoney;
	}
	public void setPayofftotalmoney(Double payofftotalmoney) {
		this.payofftotalmoney = payofftotalmoney;
	}
	public Integer getPayofftotalpersonnum() {
		return payofftotalpersonnum;
	}
	public void setPayofftotalpersonnum(Integer payofftotalpersonnum) {
		this.payofftotalpersonnum = payofftotalpersonnum;
	}
	public TsalarypayoffAdd(Integer salarypayoffId, String registerman,
			Date registertime, Double payofftotalmoney,
			Integer payofftotalpersonnum) {
		super();
		this.salarypayoffId = salarypayoffId;
		this.registerman = registerman;
		this.registertime = registertime;
		this.payofftotalmoney = payofftotalmoney;
		this.payofftotalpersonnum = payofftotalpersonnum;
	}
	public TsalarypayoffAdd() {
		super();
	}
	public String toString() {
		return "Tsalarypayoff [salarypayoffId=" + salarypayoffId
				+ ", registerman=" + registerman + ", registertime="
				+ registertime + ", payofftotalmoney=" + payofftotalmoney
				+ ", payofftotalpersonnum=" + payofftotalpersonnum + "]";
	}

	
}