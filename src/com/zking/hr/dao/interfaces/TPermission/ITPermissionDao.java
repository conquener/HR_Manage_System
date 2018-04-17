package com.zking.hr.dao.interfaces.TPermission;

import java.util.List;

import com.zking.hr.dao.IDao;
import com.zking.hr.pojo.TPermission;
import com.zking.hr.pojo.TRole;

public interface ITPermissionDao extends IDao<TPermission> {
	/**
	 * 根据权限Id进行查找
	 * @param permissionId
	 * @return
	 */
	public List queryById(Integer permissionId);
	
	/**
	 * 查找所有的权限
	 */
	public List querybyAll();
	
	/**
	 * 通过角色id获取该角色没有的权限
	 * @param roleId
	 * @return
	 */
	public List<TRole> getRoleNotPermission(Integer roleId);
}
