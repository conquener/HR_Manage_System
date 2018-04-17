package com.zking.hr.view.contorl.action.customization.salaryManage;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.zking.hr.biz.impl.cuntomization.salaryManage.SalaryManageBizImpl;
import com.zking.hr.pojo.TOrderPerformance;

public class orderPerAction extends ActionSupport implements RequestAware{
	private SalaryManageBizImpl salaryManageBiz;
	private Map<String, Object> request;
	private TOrderPerformance to;
	private Integer orderId;
	
	

	public Integer getOrderId() {
		return orderId;
	}



	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}



	public TOrderPerformance getTo() {
		return to;
	}



	public void setTo(TOrderPerformance to) {
		this.to = to;
	}



	public SalaryManageBizImpl getSalaryManageBiz() {
		return salaryManageBiz;
	}



	public void setSalaryManageBiz(SalaryManageBizImpl salaryManageBiz) {
		this.salaryManageBiz = salaryManageBiz;
	}



	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}



	public String loadOrderPer() throws Exception {
		salaryManageBiz.showOrderPerformance(request);
		return SUCCESS;
	}
	public String updateOrderPer(){
		salaryManageBiz.updateOrderPerformance(to);
		return SUCCESS;
	}
	public String queryOrderPer(){
		salaryManageBiz.queryOrderPerformance(orderId, request);
		return SUCCESS;
	}
	
}
