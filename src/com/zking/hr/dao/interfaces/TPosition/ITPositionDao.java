package com.zking.hr.dao.interfaces.TPosition;

import java.util.List;

import com.zking.hr.dao.IDao;
import com.zking.hr.pojo.TPosition;

public interface ITPositionDao extends IDao<TPosition> {
	/**
	 * 根据职位类型ID进行删除
	 */
	public boolean deleteByTypeId(Integer positionTypeId);
	/**
	 * 根据职位类型ID进行查询
	 * @param positionTypeId 职位类型ID
	 * @return
	 */
	public List<TPosition> queryByTypeId(Integer positionTypeId);
	/**
	 * 查询所有职位信息
	 * @return
	 */
	public List<TPosition> queryAll(int positionTypeId);
	
}
