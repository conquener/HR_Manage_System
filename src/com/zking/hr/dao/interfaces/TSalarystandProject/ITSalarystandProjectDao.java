package com.zking.hr.dao.interfaces.TSalarystandProject;

import java.util.List;

import com.zking.hr.dao.IDao;
import com.zking.hr.pojo.TSalaryproject;
import com.zking.hr.pojo.TSalarystandProject;

public interface ITSalarystandProjectDao  extends IDao<TSalarystandProject>{
	/**
	 * ����н���׼Id����ѯ
	 * @param standId
	 * @return
	 */
	//ֻ��IDao,û���޸�
	public List queryByStand(int standId);
	

}
