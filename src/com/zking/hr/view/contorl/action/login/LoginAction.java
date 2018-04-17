package com.zking.hr.view.contorl.action.login;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.zking.hr.biz.interfaces.login.ILoginBiz;
import com.zking.hr.pojo.TUser;

public class LoginAction extends ActionSupport implements RequestAware,SessionAware,ApplicationAware{

	private Map<String, Object> request;
	private Map<String, Object> session;
	private Map<String, Object> application;
	private ILoginBiz loginbiz;
	private String userName;
	private String userPwd;
	private String inputcode;
	
	public String backSystemaction(){
		session.remove("user");
		return "backSystem";
	}
	
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserPwd() {
		return userPwd;
	}


	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}


	public String execute(){
		boolean isSuccess =  loginbiz.login(session, application, request, userName, userPwd,inputcode);
			if(isSuccess){
				return "success";
			}
			return "error";
}
	
	
	public ILoginBiz getLoginbiz() {
		return loginbiz;
	}


	public void setLoginbiz(ILoginBiz loginbiz) {
		this.loginbiz = loginbiz;
	}


	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}


	public String getInputcode() {
		return inputcode;
	}


	public void setInputcode(String inputcode) {
		this.inputcode = inputcode;
	}
	
	
	
}
