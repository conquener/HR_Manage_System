package com.zking.hr.biz.impl.salaryIssueManage.click;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.runner.Request;

import com.zking.hr.biz.interfaces.salaryIssueManage.click.IClickSalarySendBiz;
import com.zking.hr.dao.interfaces.TFiles.ITFilesDao;
import com.zking.hr.dao.interfaces.TOrganization.ITOrganizationDao;
import com.zking.hr.dao.interfaces.TSalaryPayOffAdd.ITSalaryPayOffAdd;
import com.zking.hr.dao.interfaces.TSalarystandProject.ITSalarystandProjectDao;
import com.zking.hr.dao.interfaces.TSalarystanderd.ITSalarystanderdDao;
import com.zking.hr.pojo.TFiles;
import com.zking.hr.pojo.TSalarystandProject;
import com.zking.hr.pojo.TSalarystanderd;
import com.zking.hr.pojo.TUser;
import com.zking.hr.pojo.TsalarypayoffAdd;
import com.zking.hr.utils.pageUtils.PageUtils;
import com.zking.hr.view.pojo.salaryquery.SalaryQuery;

public class ClickSalarySendBizImpl implements IClickSalarySendBiz{
	private ITFilesDao filesdao;
	private ITOrganizationDao organdao;
	private ITSalarystanderdDao standdao;
	private ITSalarystandProjectDao standprojectdao;
	private ITSalaryPayOffAdd salarypaydao;
	//进入薪酬发放登记时的方法
	public boolean clickSalarySend(Map<String, Object> request) {
		List lst1 =  filesdao.queryBySalryStatus(1, 22, 22);
		List lst2 =  organdao.queryByParentId(0);
			if(lst1!=null){
				request.put("salarysendman", lst1);
				request.put("salaryorganlst", lst2);
					return true;
			}
		return false;
	}
	//页面查看个人的薪酬标准
		public boolean salarysendtoworkerdetails(Map<String, Object> request,
				Integer standId) {
			TSalarystanderd t = standdao.queryById(standId);
			List t1 = standprojectdao.queryByStand(standId);
			if(t!=null){
				request.put("stand", t);
				request.put("standproject", t1);
				return true;
			}
			return false;
		}
		
		//根据各级机构查询要发放的人员
		public boolean salarysendOrganparentId(Map<String, Object> request,
				Integer organid,Integer ssoplevel) {
			System.out.println(ssoplevel);
			if(ssoplevel==1){
				List lst1 = organdao.queryByParentId(organid);
				List lst2 = filesdao.queryBySalryStatus(1, organid,ssoplevel);
				List lst3 =  organdao.queryByParentId(0);
				if(lst1!=null||lst2!=null){
					if(lst1!=null){
						request.put("salaryorganlsttwo", lst1);
						request.put("salaryorganlst", lst3);
						request.put("organfristId",organid);
					}	
					if(lst2!=null){
						request.put("salarysendman", lst2);
						return true;
					}
				}
			}
			
			if(ssoplevel==2){
				String organfristId = (String) request.get("organfristId");
				List lst1 = organdao.queryByParentId(Integer.parseInt(organfristId));
				List lst2 = filesdao.queryBySalryStatus(1, organid,ssoplevel);
				List lst3 = organdao.queryByParentId(0);
				List lst4 = organdao.queryByParentId(organid);
						request.put("salaryorganlsttwo", lst1);
						request.put("salaryorganlstthree", lst4);
						request.put("salaryorganlst", lst3);
						request.put("salarysendman", lst2);
						request.put("organsecondId", organid);
						return true;
					}
			
			if(ssoplevel==3){
				String organsecondId = (String) request.get("organsecondId");
				String organfristId = (String) request.get("organfristId");
				List lst1 = organdao.queryByParentId(Integer.parseInt(organsecondId));
				List lst2 = filesdao.queryBySalryStatus(1, organid,ssoplevel);
				List lst3 = organdao.queryByParentId(0);
				List lst4 = organdao.queryByParentId(Integer.parseInt(organfristId));
				request.put("salaryorganlsttwo", lst4);
				request.put("salaryorganlstthree", lst1);
				request.put("salaryorganlst", lst3);
				request.put("salarysendman", lst2);
				request.put("organthreeId", organid);
						return true;
					}
			return false;
		}
	
	
	//薪酬发放登记
	public boolean salarysendRegister(String[] fileId,Map<String, Object> request,TsalarypayoffAdd t){
			boolean isSuccess = salarypaydao.insert(t);
		for(String f:fileId){
			isSuccess = filesdao.updateBySalaryStatus(Integer.parseInt(f),2);
			if(!isSuccess){
				request.put("errormessage", "从"+f+"以后的工资均为发放失败");
				return false;
			}
		}
		return isSuccess;
	}
	
	
	
//点击登记复核时的加载方法	
	public boolean salarysendcheck(Map<String, Object> request,Map<String,Object> session) {
			List lst = filesdao.queryBySalryStatus(2,22, 22);
			TUser u= (TUser) session.get("user");
			List lst1 = salarypaydao.queryByName(u.getUserName());
			request.put("salarypayAddlst", lst1);
			List lst3 =  organdao.queryByParentId(0);
			request.put("querysendchecklst", lst);
			request.put("salarysendman", lst1);
			request.put("salaryorganlst", lst3);
				return true;
	}

	//薪水复核机构查询
	public boolean salarysendcheckOrganparentId(Map<String, Object> request,
			Integer organid,Integer ssoplevel,Map<String,Object> session) {
		TUser u= (TUser) session.get("user");
		List lst5 = salarypaydao.queryByName(u.getUserName());
		request.put("salarypayAddlst", lst5);
		if(ssoplevel==1){
			List lst1 = organdao.queryByParentId(organid);
			List lst2 = filesdao.queryBySalryStatus(2, organid,ssoplevel);
			List lst3 =  organdao.queryByParentId(0);
			if(lst1!=null||lst2!=null){
				if(lst1!=null){
					request.put("salaryorganlsttwo", lst1);
					request.put("salaryorganlst", lst3);
					request.put("organfristId",organid);
				}	
				if(lst2!=null){
					request.put("salarysendman", lst2);
					return true;
				}
			}
		}
		
		if(ssoplevel==2){
			String organfristId = (String) request.get("organfristId");
			List lst1 = organdao.queryByParentId(Integer.parseInt(organfristId));
			List lst2 = filesdao.queryBySalryStatus(2, organid,ssoplevel);
			List lst3 = organdao.queryByParentId(0);
			List lst4 = organdao.queryByParentId(organid);
					request.put("salaryorganlsttwo", lst1);
					request.put("salaryorganlstthree", lst4);
					request.put("salaryorganlst", lst3);
					request.put("salarysendman", lst2);
					request.put("organsecondId", organid);
					return true;
				}
		
		if(ssoplevel==3){
			String organsecondId = (String) request.get("organsecondId");
			String organfristId = (String) request.get("organfristId");
			List lst1 = organdao.queryByParentId(Integer.parseInt(organsecondId));
			List lst2 = filesdao.queryBySalryStatus(2, organid,ssoplevel);
			List lst3 = organdao.queryByParentId(0);
			List lst4 = organdao.queryByParentId(Integer.parseInt(organfristId));
			request.put("salaryorganlsttwo", lst4);
			request.put("salaryorganlstthree", lst1);
			request.put("salaryorganlst", lst3);
			request.put("salarysendman", lst2);
			request.put("organthreeId", organid);
					return true;
				}
		return false;
	}
	
	public boolean salarysendcheckById(String[] checkfileUserId,Map<String, Object> session) {
		for(String check:checkfileUserId){
			boolean isSuccess = filesdao.updateBySalaryStatus(Integer.parseInt(check), 3);
			if(!isSuccess){
				return false;
			}
		}
		TUser u =  (TUser) session.get("user");
		salarypaydao.deleteByName(u.getUserName());
		return true;
	}

	public boolean salarysendquery(String salarysendAddId,
			String salarySendOrganName, String salarysendstartTime,
			String salarysendendTime,Integer indexPage, Map<String, Object> request) {
		SalaryQuery q = new SalaryQuery();
		if(salarysendAddId!=null&&!salarysendAddId.equals("")){
			q.setSalarysendAddId(salarysendAddId);
		}
		if(salarysendendTime!=null&&!salarysendendTime.equals("")){
			q.setSalarysendendTime(salarysendendTime);
		}
		if(salarySendOrganName!=null&&!salarySendOrganName.equals("")){
			q.setSalarySendOrganName(salarySendOrganName);
		}
		if(salarysendstartTime!=null&&!salarysendstartTime.equals("")){
			q.setSalarysendstartTime(salarysendstartTime);
		}
		int countrows = filesdao.salarysendqueryCount(q);
		PageUtils page = new PageUtils(countrows);
		page.setIndexPage(indexPage);
		page.setPageSize(5);
		q.setBeginRow(page.getBeginRow());
		q.setEndRow(page.getEndRow());
		List lst = new ArrayList(); 
		lst= filesdao.salarysendquery(q);
		
		int count=0;
		for (Object object : lst) {
			String[] s = object.toString().split("=");
			String s1 = String.valueOf(s[3].charAt(0));
			List stand = standprojectdao.queryByStand(Integer.parseInt(s1));
			request.put("stand"+(count++),stand);
		}
		request.put("salarysendquerymap", lst);
		request.put("page",page);
		request.put("salaryQuery", q);
		return false;
	}
	public List<TFiles> getSalarySendByOrganId(Map<String, Object> map) {
		List<TFiles> filelst = filesdao.queryByOrganAndSend(map);
		return filelst;
	}
	
	
	
	
	/***************get and set**************/
	public ITFilesDao getFilesdao() {
		return filesdao;
	}
	public void setFilesdao(ITFilesDao filesdao) {
		this.filesdao = filesdao;
	}
	public ITOrganizationDao getOrgandao() {
		return organdao;
	}
	public void setOrgandao(ITOrganizationDao organdao) {
		this.organdao = organdao;
	}
	public ITSalarystanderdDao getStanddao() {
		return standdao;
	}
	public void setStanddao(ITSalarystanderdDao standdao) {
		this.standdao = standdao;
	}
	public ITSalarystandProjectDao getStandprojectdao() {
		return standprojectdao;
	}
	public void setStandprojectdao(ITSalarystandProjectDao standprojectdao) {
		this.standprojectdao = standprojectdao;
	}

	public boolean salarysendchec(Map<String, Object> request, Integer status,
			String[] checkfileId) {
		return false;
	}
	public ITSalaryPayOffAdd getSalarypaydao() {
		return salarypaydao;
	}
	public void setSalarypaydao(ITSalaryPayOffAdd salarypaydao) {
		this.salarypaydao = salarypaydao;
	}
}
