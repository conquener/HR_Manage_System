package com.zking.hr.dao.interfaces.TSalaryproject;

import java.util.List;

import com.zking.hr.dao.IDao;
import com.zking.hr.pojo.TSalaryproject;

public interface ITSalaryprojectDao extends IDao<TSalaryproject> {
	/**
	 * 查询所有的薪酬项目
	 */
	public List<TSalaryproject> queryAllSp();
}
