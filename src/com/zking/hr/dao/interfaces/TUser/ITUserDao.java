package com.zking.hr.dao.interfaces.TUser;

import java.util.List;

import com.zking.hr.dao.IDao;
import com.zking.hr.pojo.TRole;
import com.zking.hr.pojo.TUser;

public interface ITUserDao extends IDao<TUser> {
	/**
	 * 根据用户名 和密码进行查询(登录)
	 * @param userName
	 * @param userPwd
	 * @return
	 */
	public TUser queryByNameAndPwd(String userName,String userPwd);
	/**
	 * 根据用户id进行查询
	 * @param tUserid
	 * @return
	 */
	public TUser queryById(Integer tUserid);
	/**
	 * 根据用户名来修改用户角色名和ID
	 * @param userName
	 * @param roleName
	 * @param roleId
	 * @return boolean
	 */
	public boolean updateByUserNameAndRole(Integer userId,String roleName,int roleId);
	/**
	 * 删除用户角色
	 * @return boolean
	 */
	public boolean deleteRoleByUser(Integer userId);
	/**
	 * 更改角色赋予状态
	 * @param userId
	 * @return
	 */
	public boolean updateRoleAddStatus(String userName);
	/**
	 * 修改用户回收状态
	 * @param userId
	 * @return
	 */
	public boolean updateRoleRollbackStatus(Integer userId);
	/**
	 * 根据用户Id和原密码进行查询
	 * @param NewuserPwd
	 * @param userPwd
	 * @param userId
	 * @return boolean
	 */
	public boolean updatePwdByUser(String NewuserPwd,String userPwd,String userId);
	
	/**
	 * 根据名字查询
	 * @param checkUserName
	 * @return boolean
	 */
	public boolean querybyName(String checkUserName);
	
	//查询角色未复核的用户
	public List querybystatus(Integer indexPage);
	/**
	 * 根据用户名模糊匹配
	 * @param userName
	 * @return
	 */
	public List<TUser> rolesetUserLike(String userName);

}
