package com.zking.hr.view.contorl.action.clickMenu;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.zking.hr.biz.interfaces.clickmuen.IClickMuen;

public class ClickMenuAction extends ActionSupport implements RequestAware{
	private Map<String, Object> request;
	private IClickMuen clickMenubiz;
	private String  parentID;
	
	
	public String execute(){
		
		boolean isSuccess = clickMenubiz.clickMuen(Integer.parseInt(parentID), request);
		return "success";
	}
	
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public IClickMuen getClickMenubiz() {
		return clickMenubiz;
	}
	public void setClickMenubiz(IClickMuen clickMenubiz) {
		this.clickMenubiz = clickMenubiz;
	}

	public String getParentID() {
		return parentID;
	}

	public void setParentID(String parentID) {
		this.parentID = parentID;
	}
	
	
}
