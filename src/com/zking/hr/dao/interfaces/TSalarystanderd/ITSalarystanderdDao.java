package com.zking.hr.dao.interfaces.TSalarystanderd;

import java.util.List;

import com.zking.hr.dao.IDao;
import com.zking.hr.pojo.TSalarystanderd;

public interface ITSalarystanderdDao  extends IDao<TSalarystanderd>{
	/**
	 * ����н���׼ID���޸�н���׼�ĸ���״̬
	 * @param salaryStandId
	 * @return
	 */
	public boolean updateStatus(int salaryStandId);
	
	/**
	 * ����н���δ����״̬����ѯ
	 * @return
	 */
	public List queryByStatus(int indexPage);
	/**
	 * ����н���׼ID�������Լ��Ǽ�ʱ���ѯ
	 * @param salaryStandId
	 * @param salaryStandName
	 * @return
	 */
	public List queryByIdName_Time(String salaryStandName,String beginTime,String endtime,int indexPage);
	/**
	 * ����ID��ѯ
	 * @param salaryStandId
	 * @return
	 */
	public TSalarystanderd queryById(int salaryStandId);
	
	public int insertStand(TSalarystanderd t1);
	
	public Integer updateInteger(TSalarystanderd t);
	
	public List<TSalarystanderd> queryStanderAll();
}
