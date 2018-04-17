package com.zking.hr.view.contorl.action.customization.salaryManage;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.zking.hr.biz.impl.cuntomization.salaryManage.SalaryManageBizImpl;
import com.zking.hr.pojo.TSalarypayoff;

public class salaryPayAction extends ActionSupport implements RequestAware{
	private SalaryManageBizImpl salaryManageBiz;
	private Map<String, Object> request;
	private TSalarypayoff ts;
	
	public TSalarypayoff getTs() {
		return ts;
	}


	public void setTs(TSalarypayoff ts) {
		this.ts = ts;
	}


	public SalaryManageBizImpl getSalaryManageBiz() {
		return salaryManageBiz;
	}


	public void setSalaryManageBiz(SalaryManageBizImpl salaryManageBiz) {
		this.salaryManageBiz = salaryManageBiz;
	}


	public String loadSalaryPay() throws Exception {
		salaryManageBiz.showSalaryPayoff(request);
		return SUCCESS;
	}
	public String updateLoadSalaryPay() throws Exception {
		salaryManageBiz.showSalaryPayoff(request);
		return SUCCESS;
	}
	public String updateSalaryPay(){
		ts.setSalarypayoffId(1);
		salaryManageBiz.updateSalaryPayoff(ts);
		return SUCCESS;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

}	
