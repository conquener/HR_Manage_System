package com.zking.hr.biz.interfaces.salaryStandManage;

import java.util.List;
import java.util.Map;

import com.zking.hr.pojo.TSalaryproject;
import com.zking.hr.pojo.TSalarystanderd;

public interface ISalaryStandManageBiz {
	public boolean SalaryStandManageregister(TSalarystanderd t1,String[] salarystandProjectName,String[] salarystandProjectMoney,String[] salarystandProjectId);
	public boolean salarystandardchecklist(Map<String,Object> request,int indexPage);
	public boolean salarystandardcheck(String standId,Map<String,Object> request);
	public boolean salarystandardchecksuccess(String standId);
	public boolean salarystandardqueryresult(String salarystandcheckId,String startTime,String endTime,String standName,String indexPage,Map<String, Object> request);
	public boolean salaryproject(String salarystandcheckId,Map<String, Object> request);
	public boolean salaryStandManagerupdate(TSalarystanderd t1,String[] salarystandProjectName,String[] salarystandProjectMoney,String[] salarystandProjectId);
	/**
	 * 进入薪酬标准界面查询薪酬项目
	 * @return
	 */
	public List<TSalaryproject> salarystandardregister();
	
}
