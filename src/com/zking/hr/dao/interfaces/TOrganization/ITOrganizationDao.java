package com.zking.hr.dao.interfaces.TOrganization;

import java.util.List;

import com.zking.hr.dao.IDao;
import com.zking.hr.pojo.TOrganization;

public interface ITOrganizationDao  extends IDao<TOrganization>{
	/**
	 * 查询当前机构的子机构
	 * @param ParentId
	 * @return
	 */
	public List<TOrganization> queryByParentId(Integer ParentId);
	/**
	 * 查询各个级别的机构
	 * @param level
	 * @param indexPage
	 * @return
	 */
	public List<Object> queryBylevel(int level,int indexPage);
	
	public List queryById(Integer id);
	
	public List querySecondOra();
	/**
	 * 根据父部门查询所有的子部门
	 */
	public List<TOrganization> queryAllBylevel(int parentOrginzation);
	
}
