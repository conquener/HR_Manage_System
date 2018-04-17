package com.zking.hr.view.pojo.TStafftransfer;

public class UpdateStatus implements java.io.Serializable{
	private Integer id;
	private int status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public UpdateStatus(Integer id, int status) {
		super();
		this.id = id;
		this.status = status;
	}
	public UpdateStatus() {
		super();
	}
	
}
