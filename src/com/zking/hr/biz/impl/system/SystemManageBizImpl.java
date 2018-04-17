package com.zking.hr.biz.impl.system;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.zking.hr.biz.interfaces.system.ISystemManageBiz;
import com.zking.hr.dao.interfaces.TPermission.ITPermissionDao;
import com.zking.hr.dao.interfaces.TRole.ITRole;
import com.zking.hr.dao.interfaces.TRolePermission.ITRolePermissionDao;
import com.zking.hr.dao.interfaces.TUser.ITUserDao;
import com.zking.hr.pojo.TPermission;
import com.zking.hr.pojo.TPositiontype;
import com.zking.hr.pojo.TRole;
import com.zking.hr.pojo.TRolePermission;
import com.zking.hr.pojo.TUser;
import com.zking.hr.utils.pageUtils.PageUtils;
import com.zking.hr.view.pojo.changpassword.ChangPassword;

public class SystemManageBizImpl implements ISystemManageBiz{
	private ITUserDao userdao;
	private ITRole roledao;
	private ITRolePermissionDao rolepermissdao;
	private ITPermissionDao permissdao;

	
	public boolean checkUName(String checkUserName,HttpServletResponse response) {
		boolean isSuccess = userdao.querybyName(checkUserName);
		String s = "";
		if(isSuccess){
			try {
				s="[{id:\""+"0"+"\",name:\""+"用户名可用!"+"\"}]";
				response.getWriter().write(s);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			try {
				s="[{id:\""+"0"+"\",name:\""+"用户名已存在!"+"\"}]";
				response.getWriter().write(s);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean insertsystemuser(TUser systemUser) {
		Boolean  isSuccess = userdao.insert(systemUser);
		return isSuccess;
	}

	public boolean userquery(Integer userquesryIndexPage,Map<String,Object> request) {
		List lst = userdao.query(userquesryIndexPage);
		if(lst.size()>1){
			PageUtils page = (PageUtils) lst.get(lst.size()-1);
			lst.remove(lst.size()-1);
			request.put("systemuserlst",lst);
			request.put("userlstpage", page);
			return true;
		}else{
			request.put("systemuserlst", lst);
			return false;
		}
	}
//根据用户id查询
	public boolean userdetail(Integer systemuserId, Map<String, Object> request) {
		TUser u = userdao.queryById(systemuserId);
		if(u!=null){
			request.put("usermessage", u);
			return true;
		}
		return false;
	}
	
	//用户更新
	public boolean userupdate(TUser systemUser) {
		boolean isSuccess = userdao.update(systemUser);
		return isSuccess;
	}
	
	//用户删除
	public boolean humandelete(Integer systemuserId) {
		boolean  isSuccess = userdao.delete(systemuserId);
		return isSuccess;
	}

	//角色联动查询
	public List<TRole> rolequery(HttpServletResponse response) {
		List<TRole> lst = roledao.queryall();
		return lst;
		/*try {
		String s = toJson(lst).toString();
			response.getWriter().write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}
	
	//用户添加角色
	public boolean updateuserrole(Integer userId, Integer rolesetroleId) {
		TRole r = roledao.queryById(rolesetroleId);
		if(r!=null){
			userdao.updateByUserNameAndRole(userId, r.getRoleName(), r.getRoleId());
			return true;
		}
		return false;
	}
	
	//用户待复核角色查询
	public boolean rolesetselect(Map<String, Object> request,Integer indexPage) {
		List lst = userdao.querybystatus(indexPage);
		if(lst.size()>1){
			PageUtils page = (PageUtils) lst.get(lst.size()-1);
			lst.remove(lst.size()-1);
			request.put("rolesetselectpage", page);
			request.put("rolesetselectlst", lst);
			return true;
		}
		return false;
	}

	//用户角色删除
	public boolean rolesetdelete(Integer systemuserId) {
		userdao.deleteRoleByUser(systemuserId);
		return true;
	}

	
	//用户复核
	public boolean rolesetcheck(Integer systemuserId) {
		TUser u =userdao.queryById(systemuserId);
		userdao.updateRoleAddStatus(u.getUserName());
		return true;
	}
	
	//角色添加

	public boolean roleaddsuccess(TRole role) {
		roledao.insert(role);
		return true;
	}

	//角色查询
	public boolean rolesafeguardquery(Map<String, Object> request,
			Integer rolesafeindexPage) {
		List lst = roledao.query(rolesafeindexPage);
		if(lst.size()>1){
			PageUtils page = (PageUtils) lst.get(lst.size()-1);
			lst.remove(lst.size()-1);
			request.put("rolelst",lst);
			request.put("rolepage", page);
			return true;
		}	
		return false;
	}

	
	public boolean roleupdatasuccess(TRole role) {
		roledao.update(role);
		return true;
	}
//角色删除
	public boolean roledelete(Integer roleId) {
		roledao.delete(roleId);
		return true;
	}
	
	//角色  权限 查询
	public boolean queryroleAndpower(Map<String, Object> request) {
		List lst1 = roledao.queryall();
		//List lst2 = permissdao.querybyAll();
		request.put("rolelst", lst1);
		//request.put("permisslst", lst2);
		return true;
	}
// 角色  权限 添加
	public boolean newauthodesignaddsuccess(Integer permissId, Integer roleId) {
		TRolePermission t = new TRolePermission(0, roleId, permissId,null);
		rolepermissdao.insert(t);
		return true;
	}

	
	public boolean newauthdesignquery(Map<String, Object> request,Integer indexPage) {
		List lst = rolepermissdao.queryroleAndPremiss(indexPage);
		if(lst.size()>1){
			PageUtils page = (PageUtils) lst.get(lst.size()-1);
			lst.remove(lst.size()-1);
			request.put("rolepermisspage", page);
			request.put("rolepermisslst", lst);
			return true;
		}
		return false;
	}

	public void permissionalqueryajax(HttpServletResponse response) {
		List lst = permissdao.querybyAll();
		String s = toJson1(lst).toString();
		try {
			response.getWriter().write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
	public boolean newauthodesignupdatesuccess(TRolePermission t) {
		rolepermissdao.update(t);
		return true;
	}


	public boolean authdesigndelete(Integer rolepermissId) {
		rolepermissdao.delete(rolepermissId);
		return true;
	}
	

	public boolean changpassword(Map<String, Object> request, String newPwd,
			String userId, String checkuserPwd) {
		boolean isSuccess = userdao.updatePwdByUser(newPwd, checkuserPwd, userId);
		if(isSuccess){
			return true;
		}else{
			request.put("message", "用户名或密码错误");
			return false;
		}
	}
	public List<TUser> rolesetUserLike(String userName) {
		List<TUser> lst = userdao.rolesetUserLike(userName);
		return lst;
	}


	public List<TRole> getRoleNotPermission(Integer roleId){
			return  permissdao.getRoleNotPermission(roleId);
	}

	
	
/*************get and set*********/	
	
		
	
	public ITUserDao getUserdao() {
		return userdao;
	}

	public ITPermissionDao getPermissdao() {
	return permissdao;
}

public void setPermissdao(ITPermissionDao permissdao) {
	this.permissdao = permissdao;
}

	public void setUserdao(ITUserDao userdao) {
		this.userdao = userdao;
	}

	public ITRole getRoledao() {
		return roledao;
	}

	public void setRoledao(ITRole roledao) {
		this.roledao = roledao;
	}

	public ITRolePermissionDao getRolepermissdao() {
		return rolepermissdao;
	}

	public void setRolepermissdao(ITRolePermissionDao rolepermissdao) {
		this.rolepermissdao = rolepermissdao;
	}

	
	//json

	public StringBuilder toJson(List<TRole> lst){
		StringBuilder s=new StringBuilder();
		s.append("[");
		for (int i=0;i<lst.size();i++) {
			s.append(objectTojson(lst.get(i))+",");
		}
		s.append("]");
		return s;
	}
	
	private StringBuilder objectTojson(TRole p){
		StringBuilder s=new StringBuilder();
		s.append("{");
		s.append("id:\""+p.getRoleId()+"\",name:\""+p.getRoleName()+"\"");
		s.append("}");
		
		return s;
	
	}


	public StringBuilder toJson1(List<TPermission> lst){
		StringBuilder s=new StringBuilder();
		s.append("[");
		for (int i=0;i<lst.size();i++) {
			s.append(objectTojson2(lst.get(i))+",");
		}
		s.append("]");
		return s;
	}
	
	private StringBuilder objectTojson2(TPermission p){
		StringBuilder s=new StringBuilder();
		s.append("{");
		s.append("id:\""+p.getPermissionId()+"\",name:\""+p.getPermissionName()+"\"");
		s.append("}");
		
		return s;
	
	}

}
