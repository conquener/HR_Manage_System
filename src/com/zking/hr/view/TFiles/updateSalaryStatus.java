package com.zking.hr.view.TFiles;

public class updateSalaryStatus {
	private int fileId;
	
	private int status;

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public updateSalaryStatus(int fileId, int status) {
		super();
		this.fileId = fileId;
		this.status = status;
	}
	
	public updateSalaryStatus() {
		// TODO Auto-generated constructor stub
	}
}
