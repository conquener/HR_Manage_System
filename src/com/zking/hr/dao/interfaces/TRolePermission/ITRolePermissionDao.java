package com.zking.hr.dao.interfaces.TRolePermission;

import java.util.List;

import com.zking.hr.dao.IDao;
import com.zking.hr.pojo.TRolePermission;

public interface ITRolePermissionDao extends IDao<TRolePermission> {
	/**
	 * ���ӽ�ɫȨ��
	 * @param RoleId
	 * @param permisssId
	 * @return
	 */
	public boolean insertByRoleAddPer(Integer RoleId,Integer permisssId);
	
	/**
	 * ��������Ȩ��
	 * @return List
	 */
	public List queryroleAndPremiss(Integer indexPage);
	
}
