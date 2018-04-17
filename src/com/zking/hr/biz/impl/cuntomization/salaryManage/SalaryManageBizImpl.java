package com.zking.hr.biz.impl.cuntomization.salaryManage;

import java.util.List;
import java.util.Map;

import com.zking.hr.biz.interfaces.customization.salaryManage.ISalaryManageBiz;
import com.zking.hr.dao.impl.TOrderPerformance.TOrderPerformanceDaoimpl;
import com.zking.hr.dao.impl.TSalarypayoff.TSalarypayoffDaoimpl;
import com.zking.hr.dao.impl.TSalaryproject.TSalaryprojectDaoimpl;
import com.zking.hr.dao.impl.TSalarystandProject.TSalarystandProjectDaoimpl;
import com.zking.hr.pojo.TOrderPerformance;
import com.zking.hr.pojo.TSalarypayoff;
import com.zking.hr.pojo.TSalaryproject;
import com.zking.hr.utils.pageUtils.PageUtils;

public class SalaryManageBizImpl implements ISalaryManageBiz{
	private TOrderPerformanceDaoimpl orderPerDao;
	
	private TSalarypayoffDaoimpl salaryPayDao;
	
	private TSalaryprojectDaoimpl salaryProDao;
	
	public TOrderPerformanceDaoimpl getOrderPerDao() {
		return orderPerDao;
	}

	public void setOrderPerDao(TOrderPerformanceDaoimpl orderPerDao) {
		this.orderPerDao = orderPerDao;
	}

	public TSalarypayoffDaoimpl getSalaryPayDao() {
		return salaryPayDao;
	}

	public void setSalaryPayDao(TSalarypayoffDaoimpl salaryPayDao) {
		this.salaryPayDao = salaryPayDao;
	}

	

	public TSalaryprojectDaoimpl getSalaryProDao() {
		return salaryProDao;
	}

	public void setSalaryProDao(TSalaryprojectDaoimpl salaryProDao) {
		this.salaryProDao = salaryProDao;
	}
	/**
	 * 订单销售绩效数据加载
	 */
	public boolean showOrderPerformance(Map<String, Object> request) {
		List lst = orderPerDao.query();
		request.put("orderP", lst);
		request.put("orderPSize", lst.size());
		return true;
	}
	
	/**
	 * 薪酬发放方式数据加载
	 */
	public boolean showSalaryPayoff(Map<String, Object> request) {
		List lst = salaryPayDao.query();
		request.put("salaryPay", lst);
		return true;
	}
	
	/**
	 * 薪酬项目数据加载
	 */
	public boolean showSalaryProject(Map<String, Object> request, int indexPage) {
		if (indexPage == 0) {
			indexPage = 1;
		}
		List lst = salaryProDao.query(indexPage);
		PageUtils page = (PageUtils) lst.get(lst.size()-1);
		request.put("salaryPro", lst);
		request.put("salaryProSize", lst.size());
		return true;
	}
	
	/**
	 * 根据薪酬项目Id进行删除
	 */
	public boolean salaryProjectDelete(Integer id) {
		salaryProDao.delete(id);
		return true;
	}
	
	/**
	 * 薪酬项目数据添加
	 */
	public boolean salaryProjectInsert(TSalaryproject ts) {
		salaryProDao.insert(ts);
		return true;
	}
	
	/**
	 * 订单销售绩效修改
	 */
	public boolean updateOrderPerformance(TOrderPerformance to) {
		orderPerDao.update(to);
		return true;
	}
	/**
	 * 订单销售绩效修改数据加载
	 */
	public boolean queryOrderPerformance(Integer id,Map<String, Object> request) {
		List lst = orderPerDao.queryById(id);
		request.put("OrderPer", lst);
		return false;
	}
	/**
	 * 薪酬发放方式修改
	 */
	public boolean updateSalaryPayoff(TSalarypayoff ts) {
		salaryPayDao.update(ts);
		return false;
	}
	

	
	

}
