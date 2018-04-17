package com.zking.hr.dao.interfaces.TSalarystanderd;

import java.util.List;

import com.zking.hr.dao.IDao;
import com.zking.hr.pojo.TSalarystanderd;

public interface ITSalarystanderdDao  extends IDao<TSalarystanderd>{
	/**
	 * 根据薪酬标准ID来修改薪酬标准的复核状态
	 * @param salaryStandId
	 * @return
	 */
	public boolean updateStatus(int salaryStandId);
	
	/**
	 * 根据薪酬的未复核状态来查询
	 * @return
	 */
	public List queryByStatus(int indexPage);
	/**
	 * 根据薪酬标准ID和姓名以及登记时间查询
	 * @param salaryStandId
	 * @param salaryStandName
	 * @return
	 */
	public List queryByIdName_Time(String salaryStandName,String beginTime,String endtime,int indexPage);
	/**
	 * 根据ID查询
	 * @param salaryStandId
	 * @return
	 */
	public TSalarystanderd queryById(int salaryStandId);
	
	public int insertStand(TSalarystanderd t1);
	
	public Integer updateInteger(TSalarystanderd t);
	
	public List<TSalarystanderd> queryStanderAll();
}
