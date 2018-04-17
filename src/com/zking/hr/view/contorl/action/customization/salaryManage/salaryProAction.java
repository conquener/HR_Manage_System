package com.zking.hr.view.contorl.action.customization.salaryManage;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.zking.hr.biz.impl.cuntomization.salaryManage.SalaryManageBizImpl;
import com.zking.hr.pojo.TSalaryproject;

public class salaryProAction extends ActionSupport implements RequestAware{
	private SalaryManageBizImpl salaryManageBiz;
	private Map<String, Object> request;
	private int indexPage;
	private Integer saProId;
	private TSalaryproject ts;
	

	public TSalaryproject getTs() {
		return ts;
	}
	public void setTs(TSalaryproject ts) {
		this.ts = ts;
	}
	public Integer getSaProId() {
		return saProId;
	}
	public void setSaProId(Integer saProId) {
		this.saProId = saProId;
	}
	public SalaryManageBizImpl getSalaryManageBiz() {
		return salaryManageBiz;
	}
	public void setSalaryManageBiz(SalaryManageBizImpl salaryManageBiz) {
		this.salaryManageBiz = salaryManageBiz;
	}
	public int getIndexPage() {
		return indexPage;
	}
	public void setIndexPage(int indexPage) {
		this.indexPage = indexPage;
	}
	
	public String loadSalaryPro() throws Exception {
		salaryManageBiz.showSalaryProject(request, indexPage);
		return SUCCESS;
	}
	public String deleteSalaryPro(){
		salaryManageBiz.salaryProjectDelete(saProId);
		return SUCCESS;
	}
	public String insertSalaryPro(){
		salaryManageBiz.salaryProjectInsert(ts);
		return SUCCESS;
	}
	
	public void setRequest(Map<String, Object> request) {
		this.request = request;
		
	}
}
