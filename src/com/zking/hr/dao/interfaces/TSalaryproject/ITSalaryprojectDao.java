package com.zking.hr.dao.interfaces.TSalaryproject;

import java.util.List;

import com.zking.hr.dao.IDao;
import com.zking.hr.pojo.TSalaryproject;

public interface ITSalaryprojectDao extends IDao<TSalaryproject> {
	/**
	 * ��ѯ���е�н����Ŀ
	 */
	public List<TSalaryproject> queryAllSp();
}
