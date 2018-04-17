package com.zking.hr.dao.interfaces.TOrganization;

import java.util.List;

import com.zking.hr.dao.IDao;
import com.zking.hr.pojo.TOrganization;

public interface ITOrganizationDao  extends IDao<TOrganization>{
	/**
	 * ��ѯ��ǰ�������ӻ���
	 * @param ParentId
	 * @return
	 */
	public List<TOrganization> queryByParentId(Integer ParentId);
	/**
	 * ��ѯ��������Ļ���
	 * @param level
	 * @param indexPage
	 * @return
	 */
	public List<Object> queryBylevel(int level,int indexPage);
	
	public List queryById(Integer id);
	
	public List querySecondOra();
	/**
	 * ���ݸ����Ų�ѯ���е��Ӳ���
	 */
	public List<TOrganization> queryAllBylevel(int parentOrginzation);
	
}
