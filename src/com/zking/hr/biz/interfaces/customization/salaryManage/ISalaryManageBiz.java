package com.zking.hr.biz.interfaces.customization.salaryManage;

import java.util.Map;

import com.zking.hr.pojo.TOrderPerformance;
import com.zking.hr.pojo.TSalarypayoff;
import com.zking.hr.pojo.TSalaryproject;

public interface ISalaryManageBiz {
	public boolean showSalaryProject(Map<String, Object> request,int indexPage);
	public boolean salaryProjectDelete(Integer id);
	public boolean salaryProjectInsert(TSalaryproject ts);
	public boolean showSalaryPayoff(Map<String, Object> request);
	public boolean updateSalaryPayoff(TSalarypayoff ts);
	public boolean showOrderPerformance(Map<String, Object> request);
	public boolean updateOrderPerformance(TOrderPerformance to);
	public boolean queryOrderPerformance(Integer id,Map<String, Object> request);
}
