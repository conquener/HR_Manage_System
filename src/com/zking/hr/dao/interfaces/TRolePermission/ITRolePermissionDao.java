package com.zking.hr.dao.interfaces.TRolePermission;

import java.util.List;

import com.zking.hr.dao.IDao;
import com.zking.hr.pojo.TRolePermission;

public interface ITRolePermissionDao extends IDao<TRolePermission> {
	/**
	 * 增加角色权限
	 * @param RoleId
	 * @param permisssId
	 * @return
	 */
	public boolean insertByRoleAddPer(Integer RoleId,Integer permisssId);
	
	/**
	 * 查找所有权限
	 * @return List
	 */
	public List queryroleAndPremiss(Integer indexPage);
	
}
