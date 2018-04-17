package com.zking.hr.view.contorl.action.system;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.zking.hr.biz.interfaces.system.ISystemManageBiz;
import com.zking.hr.pojo.TRole;
import com.zking.hr.pojo.TRolePermission;
import com.zking.hr.pojo.TUser;

public class SystemManageAction extends ActionSupport implements RequestAware{
	private ISystemManageBiz systembiz;
	private TUser systemUser;
	private String checkUserName;
	private Map<String, Object> request;
	private String userquesryIndexPage;
	private String systemuserId;
	private String rolesetroleId;
	private String rolesetuserName;
	private String rolesetselectindexpage;
	private TRole role;
	private String rolesafeindexPage;
	private String roleId;
	private String permissId;
	private String queryroleAndPremissindexPage;
	private String permissionalId;
	private String rolepermissId;
	private TRolePermission rolepermiss;
	private String checkuserPwd;
	private String newPwd;
	private List<TRole> rolelst;
	//用户名称核对
	public void checkUName(){
		HttpServletResponse response = ServletActionContext.getResponse();
		systembiz.checkUName(checkUserName,response);
	}
	//用户注册
	public String systemUserRegister(){
		boolean isSuccess = systembiz.insertsystemuser(systemUser);
		if(isSuccess){
			return "success1";
		}else{
			request.put("errormessage1","注册失败!");
			return "error1";
		}
	}
	//用户维护查询
	public String userquery(){
		if(userquesryIndexPage==null||userquesryIndexPage.equals("")){
			userquesryIndexPage = "1";
		}
		systembiz.userquery(Integer.parseInt(userquesryIndexPage),request);
		return "success2";
	}
	
	//用户角色查询
	public String userdetail(){
		if(systemuserId!=null&&!systemuserId.equals("")){
			systembiz.userdetail(Integer.parseInt(systemuserId),request);
		}
		return "success3";
	}
	
	
	//用户更新查询
	public String userupdatequery(){
		if(systemuserId!=null&&!systemuserId.equals("")){
			systembiz.userdetail(Integer.parseInt(systemuserId),request);
		}
		return "success4";
	}
	
	//用户修改
	public String userupdate(){
		if(systemUser!=null){
			systembiz.userupdate(systemUser);
		}
		return "success5";
	}
	
	
	//用户删除
	public String humandelete(){
		if(systemuserId!=null&&!systemuserId.equals("")){
			systembiz.humandelete(Integer.parseInt(systemuserId));
		}
		return "success6";
	}
	
	//查询所有角色
	public String rolequery(){
		HttpServletResponse response = ServletActionContext.getResponse();
		setRolelst(systembiz.rolequery(response));
		return "success26";
	}
	
	//用户角色添加
	public String rolesetadd(){
		if(rolesetroleId!=null&&!rolesetroleId.equals("")){
			systembiz.updateuserrole(Integer.parseInt(systemuserId),Integer.parseInt(rolesetroleId));
		}
		return "success7";
	}
	

	public String rolesetselect(){
		if(rolesetselectindexpage==null||rolesetselectindexpage.equals("")){
			rolesetselectindexpage="1";
		}
		systembiz.rolesetselect(request,Integer.parseInt(rolesetselectindexpage));
		return "success8";
	}
	//需删除的用户角色进行查询
	public String rolesetdeletequery(){
		if(systemuserId!=null&&!systemuserId.equals("")){
			systembiz.userdetail(Integer.parseInt(systemuserId),request);
		}
		return "success9";
	}
	
	//删除用户角色
	public String rolesetdelete(){
		if(systemuserId!=null&&!systemuserId.equals("")){
			systembiz.rolesetdelete(Integer.parseInt(systemuserId));
		}
		return "success10";
	}
	//修改用户角色
	public String rolesetupdate(){
		if(rolesetroleId!=null&&!rolesetroleId.equals("")){
			systembiz.updateuserrole(Integer.parseInt(systemuserId),Integer.parseInt(rolesetroleId));
		}
		return "success11";
	}
	
	//角色复核查询
	public String rolesetcheckquery(){
		if(systemuserId!=null&&!systemuserId.equals("")){
			systembiz.userdetail(Integer.parseInt(systemuserId),request);
		}
		return "success12";
	}
	
	//角色复核
	public String rolesetcheck(){
		if(systemuserId!=null&&!systemuserId.equals("")){
			systembiz.rolesetcheck(Integer.parseInt(systemuserId));
		}
		return "success13";
	}
	
	//角色添加
	public String roleaddsuccess(){
		systembiz.roleaddsuccess(role);
		return "success14";
	}
	
	//角色查询
	public String rolesafeguardquery(){
		if(rolesafeindexPage==null||rolesafeindexPage.equals("")){
			rolesafeindexPage="1";
		}
		systembiz.rolesafeguardquery(request,Integer.parseInt(rolesafeindexPage));
		return "success15";
	}
	
	//角色更改
	public String roleupdatasuccess(){
		if(role!=null){
			systembiz.roleupdatasuccess(role);
		}
		return "success16";
	}
	
	//角色删除
	public String roledelete(){
		if(roleId!=null&&!roleId.equals("")){
			systembiz.roledelete(Integer.parseInt(roleId));
		}
		return "success17";
	}
	
	
	//进入权限设置界面
	public String newauthodesignadd(){
		systembiz.queryroleAndpower(request);
		return "success18";
	}
	//角色添加权限
	public String newauthodesignaddsuccess(){
		if(roleId!=null&&!roleId.equals("")&&permissId!=null&&!permissId.equals("")){
			systembiz.newauthodesignaddsuccess(Integer.parseInt(permissId),Integer.parseInt(roleId));
		}
		return "success19";
	}
	
	
	//
	public String newauthdesignquery(){
		if(queryroleAndPremissindexPage==null||queryroleAndPremissindexPage.equals("")){
			queryroleAndPremissindexPage="1";
		}
		systembiz.newauthdesignquery(request,Integer.parseInt(queryroleAndPremissindexPage));
		return "success20";
	}
	
	
	public void  permissionalqueryajax(){
		HttpServletResponse response = ServletActionContext.getResponse();
		systembiz.permissionalqueryajax(response);
	}
	
	public String newauthodesignupdatesuccess(){
		if(rolepermiss!=null){
			systembiz.newauthodesignupdatesuccess(rolepermiss);
		}
		return "success21";
	}
	
	public String authdesigndelete(){
		if(rolepermissId!=null&&!rolepermissId.equals("")){
			systembiz.authdesigndelete(Integer.parseInt(rolepermissId));
		}
		return "success22";
	}
	

	//修改密码
	public String changpassword(){
		if(newPwd!=null&&!newPwd.equals("")&&checkUserName!=null&&!checkUserName.equals("")&&checkuserPwd!=null&&!checkuserPwd.equals("")){
			boolean isSuccess = systembiz.changpassword(request,newPwd,systemuserId,checkuserPwd);
			if(isSuccess){
				return "success24";
			}else{
				return "success23";
			}
		}
		return "success23";
	}
	private List<TUser> userMsg;
	private String userName;
	public String rolesetUserLike(){
		setUserMsg(systembiz.rolesetUserLike(userName));
		return "success25";
	}
	public String getRoleNotPermission(){
		setRolelst(systembiz.getRoleNotPermission(Integer.parseInt(roleId)));
		return "success26";
		
	}
	
	
	/**************** get and set ******************/
	public ISystemManageBiz getSystembiz() {
		return systembiz;
	}

	public void setSystembiz(ISystemManageBiz systembiz) {
		this.systembiz = systembiz;
	}

	public String getCheckUserName() {
		return checkUserName;
	}

	public void setCheckUserName(String checkUserName) {
		this.checkUserName = checkUserName;
	}

	public TUser getSystemUser() {
		return systemUser;
	}

	public void setSystemUser(TUser systemUser) {
		this.systemUser = systemUser;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	public String getUserquesryIndexPage() {
		return userquesryIndexPage;
	}
	public void setUserquesryIndexPage(String userquesryIndexPage) {
		this.userquesryIndexPage = userquesryIndexPage;
	}
	public String getSystemuserId() {
		return systemuserId;
	}
	public void setSystemuserId(String systemuserId) {
		this.systemuserId = systemuserId;
	}
	public String getRolesetroleId() {
		return rolesetroleId;
	}
	public void setRolesetroleId(String rolesetroleId) {
		this.rolesetroleId = rolesetroleId;
	}
	public String getRolesetuserName() {
		return rolesetuserName;
	}
	public void setRolesetuserName(String rolesetuserName) {
		this.rolesetuserName = rolesetuserName;
	}
	public String getRolesetselectindexpage() {
		return rolesetselectindexpage;
	}
	public void setRolesetselectindexpage(String rolesetselectindexpage) {
		this.rolesetselectindexpage = rolesetselectindexpage;
	}
	public TRole getRole() {
		return role;
	}
	public void setRole(TRole role) {
		this.role = role;
	}
	public String getRolesafeindexPage() {
		return rolesafeindexPage;
	}
	public void setRolesafeindexPage(String rolesafeindexPage) {
		this.rolesafeindexPage = rolesafeindexPage;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getPermissId() {
		return permissId;
	}
	public void setPermissId(String permissId) {
		this.permissId = permissId;
	}
	public String getQueryroleAndPremissindexPage() {
		return queryroleAndPremissindexPage;
	}
	public void setQueryroleAndPremissindexPage(String queryroleAndPremissindexPage) {
		this.queryroleAndPremissindexPage = queryroleAndPremissindexPage;
	}
	public String getPermissionalId() {
		return permissionalId;
	}
	public void setPermissionalId(String permissionalId) {
		this.permissionalId = permissionalId;
	}
	public String getRolepermissId() {
		return rolepermissId;
	}
	public void setRolepermissId(String rolepermissId) {
		this.rolepermissId = rolepermissId;
	}
	public TRolePermission getRolepermiss() {
		return rolepermiss;
	}
	public void setRolepermiss(TRolePermission rolepermiss) {
		this.rolepermiss = rolepermiss;
	}
	public String getCheckuserPwd() {
		return checkuserPwd;
	}
	public void setCheckuserPwd(String checkuserPwd) {
		this.checkuserPwd = checkuserPwd;
	}
	public String getNewPwd() {
		return newPwd;
	}
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	public List<TUser> getUserMsg() {
		return userMsg;
	}
	public void setUserMsg(List<TUser> userMsg) {
		this.userMsg = userMsg;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		try {
			this.userName = new String(userName.getBytes("iso8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			this.userName="";
		}
	}
	public List<TRole> getRolelst() {
		return rolelst;
	}
	public void setRolelst(List<TRole> rolelst) {
		this.rolelst = rolelst;
	}
	
}
