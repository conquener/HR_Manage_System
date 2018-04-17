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
	 * �������ۼ�Ч���ݼ���
	 */
	public boolean showOrderPerformance(Map<String, Object> request) {
		List lst = orderPerDao.query();
		request.put("orderP", lst);
		request.put("orderPSize", lst.size());
		return true;
	}
	
	/**
	 * н�귢�ŷ�ʽ���ݼ���
	 */
	public boolean showSalaryPayoff(Map<String, Object> request) {
		List lst = salaryPayDao.query();
		request.put("salaryPay", lst);
		return true;
	}
	
	/**
	 * н����Ŀ���ݼ���
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
	 * ����н����ĿId����ɾ��
	 */
	public boolean salaryProjectDelete(Integer id) {
		salaryProDao.delete(id);
		return true;
	}
	
	/**
	 * н����Ŀ�������
	 */
	public boolean salaryProjectInsert(TSalaryproject ts) {
		salaryProDao.insert(ts);
		return true;
	}
	
	/**
	 * �������ۼ�Ч�޸�
	 */
	public boolean updateOrderPerformance(TOrderPerformance to) {
		orderPerDao.update(to);
		return true;
	}
	/**
	 * �������ۼ�Ч�޸����ݼ���
	 */
	public boolean queryOrderPerformance(Integer id,Map<String, Object> request) {
		List lst = orderPerDao.queryById(id);
		request.put("OrderPer", lst);
		return false;
	}
	/**
	 * н�귢�ŷ�ʽ�޸�
	 */
	public boolean updateSalaryPayoff(TSalarypayoff ts) {
		salaryPayDao.update(ts);
		return false;
	}
	

	
	

}
