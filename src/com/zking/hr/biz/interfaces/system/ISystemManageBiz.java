package com.zking.hr.biz.interfaces.system;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.zking.hr.pojo.TRole;
import com.zking.hr.pojo.TRolePermission;
import com.zking.hr.pojo.TUser;

public interface ISystemManageBiz {
	public boolean checkUName(String checkUserName,HttpServletResponse response);
	public boolean insertsystemuser(TUser systemUser);
	public boolean userquery(Integer userquesryIndexPage,Map<String,Object> reqeust);
	public boolean userdetail(Integer systemuserId,Map<String,Object> request);
	public boolean userupdate(TUser systemUser);
	public boolean humandelete(Integer systemuserId);
	/**
	 * 获取角色信息
	 * @param response
	 * @return
	 */
	public List rolequery(HttpServletResponse response);
	public boolean updateuserrole(Integer userId,Integer rolesetroleId);
	public boolean rolesetselect(Map<String, Object> request,Integer indexPage);
	public boolean rolesetdelete(Integer systemuserId);
	public boolean rolesetcheck(Integer systemuserId);
	public boolean roleaddsuccess(TRole role);
	public boolean rolesafeguardquery(Map<String, Object> request,Integer rolesafeindexPage);
	public boolean roleupdatasuccess(TRole role);
	public boolean roledelete(Integer roleId);
	public boolean queryroleAndpower(Map<String, Object> request);
	public boolean newauthodesignaddsuccess(Integer permissId,Integer roleId);
	public boolean newauthdesignquery(Map<String, Object> request,Integer indexPage);
	public void permissionalqueryajax(HttpServletResponse response);
	public boolean newauthodesignupdatesuccess(TRolePermission rolepermiss);
	public boolean authdesigndelete(Integer rolepermissId);
	public boolean changpassword(Map<String, Object> request,String newPwd,String userId,String checkuserPwd);
	/**
	 * 根据用户名模糊搜索用户
	 * @param userName
	 * @return
	 */
	public List<TUser> rolesetUserLike(String userName);
	
	public List<TRole> getRoleNotPermission(Integer roleId);
	 
	
	
}
