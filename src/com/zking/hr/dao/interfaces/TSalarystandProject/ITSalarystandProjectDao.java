package com.zking.hr.dao.interfaces.TSalarystandProject;

import java.util.List;

import com.zking.hr.dao.IDao;
import com.zking.hr.pojo.TSalaryproject;
import com.zking.hr.pojo.TSalarystandProject;

public interface ITSalarystandProjectDao  extends IDao<TSalarystandProject>{
	/**
	 * 根据薪酬标准Id来查询
	 * @param standId
	 * @return
	 */
	//只有IDao,没有修改
	public List queryByStand(int standId);
	

}
