package com.zking.hr.biz.impl.login;

import java.util.List;
import java.util.Map;

import com.zking.hr.biz.interfaces.login.ILoginBiz;
import com.zking.hr.dao.interfaces.TPermission.ITPermissionDao;
import com.zking.hr.dao.interfaces.TUser.ITUserDao;
import com.zking.hr.pojo.TUser;
public class LoginBizImpl implements ILoginBiz{
	private ITUserDao logindao;
	private ITPermissionDao loginpermissiondao;

		public boolean login(Map<String, Object> session,
				Map<String, Object> application, Map<String, Object> request,
				String userName, String userPwd,String inputcode) {
		String code = (String) session.get("key");
		TUser u = logindao.queryByNameAndPwd(userName, userPwd);
		int countuser = 1;
		if(inputcode.equalsIgnoreCase(code)){
			if(u!=null){
				if(session.get("user")==null){
					session.put("user", u);
					List lst =  loginpermissiondao.query(u.getUserRoleId());
					if(lst!=null){
						session.put("permissionUser", lst);
					}else{
						request.put("loginerrormessage", "您没有进入管理系统的权限!");
						return false;
					}
					if(application.get("countuser")==null){
						application.put("countuser", countuser);
					}else{
						countuser = (Integer) application.get("countuser")+1;
						application.put("countuser", countuser);
					}
					return true;
				}else{
					TUser loginuser =  (TUser) session.get("user");
					if(!loginuser.getUserName().equals(userName)){
						session.remove("user");
						session.put("user", u);
						List lst =  loginpermissiondao.query(u.getUserRoleId());
						if(lst!=null){
							session.put("permissionUser", lst);
						}else{
							request.put("loginerrormessage", "您没有进入管理系统的权限!");
							return false;
						}
						if(application.get("countuser")==null){
							application.put("countuser", countuser);
						}else{
							countuser = (Integer) application.get("countuser")+1;
							application.put("countuser", countuser);
						}
						return true;
					}else{
						request.put("loginerrormessage", "用户重复登录!");				
					}
					return false;
				}
				
			}else{
				request.put("loginerrormessage", "用户名或密码错误!");
				return false;
			}
		}else{
			request.put("loginerrormessage", "验证码不对!");
			return false;
		}
	}
	
	
	
	public ITPermissionDao getLoginpermissiondao() {
		return loginpermissiondao;
	}
	public void setLoginpermissiondao(ITPermissionDao loginpermissiondao) {
		this.loginpermissiondao = loginpermissiondao;
	}
	public ITUserDao getLogindao() {
		return logindao;
	}
	public void setLogindao(ITUserDao logindao) {
		this.logindao = logindao;
	}
}
