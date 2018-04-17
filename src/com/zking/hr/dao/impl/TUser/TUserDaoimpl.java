package com.zking.hr.dao.impl.TUser;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.zking.hr.dao.interfaces.TUser.ITUserDao;
import com.zking.hr.pojo.TRole;
import com.zking.hr.pojo.TUser;
import com.zking.hr.utils.pageUtils.PageUtils;
import com.zking.hr.view.pojo.user.Login;
import com.zking.hr.view.pojo.user.UpdateuserRole;
import com.zking.hr.view.pojo.user.UserRole;
import com.zking.hr.view.pojo.user.userpwd;

public class TUserDaoimpl extends SqlMapClientDaoSupport implements ITUserDao{

	public boolean insert(TUser t) {
		SqlMapClient client = this.getSqlMapClient();
		try {
			client.insert("insertUser",t);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(TUser t) {
		SqlMapClient client = this.getSqlMapClient();
			try {
				client.update("updateUser",t);
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
	}

//buyongxie
	public List query() {
		
		return null;
	}

	public TUser queryByNameAndPwd(String userName, String userPwd) {
			Login login = new Login(userName, userPwd);
			TUser u =null;
			SqlMapClient client = this.getSqlMapClient();
			try{
				u = (TUser) client.queryForObject("selectUser",login);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return u;
	}

	public boolean delete(Integer id) {
		SqlMapClient client = this.getSqlMapClient();
			try {
				client.delete("deleteUser",id);
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
	}

	public TUser queryById(Integer tUserid) {
		TUser u=null;
		SqlMapClient client = this.getSqlMapClient();
			try {
				u = (TUser) client.queryForObject("selectUserById",tUserid);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return u;
	}

	public boolean updateByUserNameAndRole(String userName, String roleName,
			Integer roleId) {
			SqlMapClient client = this.getSqlMapClient();
			UpdateuserRole u = new UpdateuserRole(userName, roleName, roleId);
			try {
				client.update("updatebyrole",u);
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
	}

	public boolean deleteRoleByUser(Integer userId) {
		SqlMapClient client = this.getSqlMapClient();
			try {
				client.delete("deleteUserRole",userId);
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
	}

	public boolean updateRoleAddStatus(String userName) {
		SqlMapClient client = this.getSqlMapClient();
			try {
				client.update("updateUserRole",userName);
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
	}

	public boolean updateRoleRollbackStatus(Integer userId) {
		SqlMapClient client = this.getSqlMapClient();
			try {
				client.update("updateUserRolerollback",userId);
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
	}

	public boolean updatePwdByUser(String newuserPwd, String userPwd,
			String userId) {
		SqlMapClient client = this.getSqlMapClient();
			try {
				userpwd u = new userpwd();
				u.setNewuserPwd(newuserPwd);
				u.setUserPwd(userPwd);
				u.setUserId(Integer.parseInt(userId));
				Integer i = client.update("updatebynameAndPwd",u);
				if(i>0){
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
	}

	
	public boolean updateByUserNameAndRole(Integer userId, String roleName,
			int roleId) {
		SqlMapClient client = this.getSqlMapClient();
			try {
				UserRole u = new UserRole();
				u.setUserId(userId);
				u.setRoleId(roleId);
				u.setRoleName(roleName);
				client.update("updatebyrole",u);
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
	}

	public List query(int indexPage){
		List lst = new ArrayList();
		SqlMapClient client = this.getSqlMapClient();
			try {
				int countrows = (Integer) client.queryForObject("Usercountrow"); 
				PageUtils page =new PageUtils(countrows);
				page.setIndexPage(indexPage);
				lst =client.queryForList("queryindex",page);
				lst.add(page);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return lst;
	}

	public boolean querybyName(String checkUserName) {
		SqlMapClient client = this.getSqlMapClient();
		try {
			int countrows = (Integer) client.queryForObject("queryBycheckUserName",checkUserName); 
			if(countrows<=0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List querybystatus(Integer indexPage) {
		List lst = new ArrayList();
		SqlMapClient client = this.getSqlMapClient();
			try {
				int countrows = (Integer) client.queryForObject("roleselectquerycount"); 
				PageUtils page =new PageUtils(countrows);
				page.setIndexPage(indexPage);
				lst =client.queryForList("roleselectquery",page);
				lst.add(page);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return lst;
	}

	public List<TUser> rolesetUserLike(String userName) {
		List lst = new ArrayList();
		SqlMapClient client = this.getSqlMapClient();
			try {
				lst =client.queryForList("rolesetUserLike",userName);
			} catch (SQLException e) {
			}
			return lst;
	}

}
