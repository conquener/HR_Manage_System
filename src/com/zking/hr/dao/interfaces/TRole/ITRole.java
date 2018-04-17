package com.zking.hr.dao.interfaces.TRole;

import java.util.List;

import com.zking.hr.dao.IDao;
import com.zking.hr.pojo.TRole;

public interface ITRole  extends IDao<TRole>{
	/**
	 * ���ݽ�ɫId���в�ѯ
	 * @param roleId
	 * @return
	 */
	public TRole queryById(Integer roleId);
	/**
	 * ��ѯ
	 * @return List
	 */
	public List queryall();
	
}
