package com.zking.hr.dao.interfaces.TPermission;

import java.util.List;

import com.zking.hr.dao.IDao;
import com.zking.hr.pojo.TPermission;
import com.zking.hr.pojo.TRole;

public interface ITPermissionDao extends IDao<TPermission> {
	/**
	 * ����Ȩ��Id���в���
	 * @param permissionId
	 * @return
	 */
	public List queryById(Integer permissionId);
	
	/**
	 * �������е�Ȩ��
	 */
	public List querybyAll();
	
	/**
	 * ͨ����ɫid��ȡ�ý�ɫû�е�Ȩ��
	 * @param roleId
	 * @return
	 */
	public List<TRole> getRoleNotPermission(Integer roleId);
}
