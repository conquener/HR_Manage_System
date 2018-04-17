package com.zking.hr.view.contorl.action.register;

import com.opensymphony.xwork2.ActionSupport;
import com.zking.hr.biz.impl.register.registerBizImpl;
import com.zking.hr.biz.interfaces.register.IRegisterBiz;
import com.zking.hr.pojo.TUser;

public class registerAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;

	private TUser user;
	
	private IRegisterBiz registerbiz;
	
	
	


	public TUser getUser() {
		return user;
	}





	public void setUser(TUser user) {
		this.user = user;
	}





	public IRegisterBiz getRegisterbiz() {
		return registerbiz;
	}





	public void setRegisterbiz(IRegisterBiz registerbiz) {
		this.registerbiz = registerbiz;
	}


	public String execute() throws Exception {
		registerbiz.register(user);
		return SUCCESS;
	}
}
