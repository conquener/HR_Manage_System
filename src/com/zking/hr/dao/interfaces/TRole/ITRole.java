package com.zking.hr.dao.interfaces.TRole;

import java.util.List;

import com.zking.hr.dao.IDao;
import com.zking.hr.pojo.TRole;

public interface ITRole  extends IDao<TRole>{
	/**
	 * 根据角色Id进行查询
	 * @param roleId
	 * @return
	 */
	public TRole queryById(Integer roleId);
	/**
	 * 查询
	 * @return List
	 */
	public List queryall();
	
}
