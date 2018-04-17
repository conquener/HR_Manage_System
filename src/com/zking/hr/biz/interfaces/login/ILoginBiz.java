package com.zking.hr.biz.interfaces.login;

import java.util.Map;

public interface ILoginBiz {
	public boolean login(Map<String, Object> session,Map<String, Object> application,Map<String, Object> request,String userName,String userPwd,String inputcode);
	
}
