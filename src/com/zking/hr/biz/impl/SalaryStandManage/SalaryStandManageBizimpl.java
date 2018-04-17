package com.zking.hr.biz.impl.SalaryStandManage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import oracle.net.aso.s;

import com.zking.hr.biz.interfaces.salaryStandManage.ISalaryStandManageBiz;
import com.zking.hr.dao.interfaces.TSalaryproject.ITSalaryprojectDao;
import com.zking.hr.dao.interfaces.TSalarystandProject.ITSalarystandProjectDao;
import com.zking.hr.dao.interfaces.TSalarystanderd.ITSalarystanderdDao;
import com.zking.hr.pojo.TSalaryproject;
import com.zking.hr.pojo.TSalarystandProject;
import com.zking.hr.pojo.TSalarystanderd;
import com.zking.hr.utils.pageUtils.PageUtils;

public class SalaryStandManageBizimpl implements ISalaryStandManageBiz{
	private ITSalarystanderdDao  salarystanderdDao;
	private ITSalarystandProjectDao salarystandProjectDao;
	private ITSalaryprojectDao spdao;
	
	public List<TSalaryproject> salarystandardregister(){
		return spdao.queryAllSp();
	}
	
	//薪水标准登记
	@SuppressWarnings("null")
	public boolean SalaryStandManageregister(TSalarystanderd t1,
			String[] salarystandProjectName, String[] salarystandProjectMoney,
			String[] salarystandProjectId) {
		Integer index= salarystanderdDao.insertStand(t1);
		List<TSalarystandProject> lst =new ArrayList<TSalarystandProject>();
		TSalarystandProject t =null;
		if(index>0){
			for(int i=0;i<salarystandProjectName.length;i++){
				if(salarystandProjectMoney[i]!=null&&salarystandProjectMoney[i]!=""){
					t = new TSalarystandProject(index, salarystandProjectName[i], Double.parseDouble(salarystandProjectMoney[i]),Integer.parseInt(salarystandProjectId[i]), "test");
//					t.setSalaryprojectName(salarystandProjectName[i]);
//					t.setSalaryprojectId(Integer.parseInt(salarystandProjectId[i]));
//					t.setSalaryprojectMoney(Double.parseDouble(salarystandProjectMoney[i]));
//					t.setSalarystanderdId(index);
//					t.setRemark("");
					lst.add(t);
				}
			}
		}
		boolean isFalg2=false;
		for(TSalarystandProject s:lst){
			isFalg2 = salarystandProjectDao.insert(s);
		}
		return isFalg2;
	}

	
	
	//薪水复核的页面查询
	public boolean salarystandardchecklist(Map<String,Object> request,int indexPage){
		List lst = salarystanderdDao.queryByStatus(indexPage);
		if(lst!=null){
			PageUtils page = (PageUtils) lst.get(lst.size()-1);
			lst.remove(lst.size()-1);
			request.put("salarystandchecklist", lst);
			request.put("salarystandchecklistsize", lst.size());
			request.put("standcheckpage", page);
			return true;
		}else{
			request.put("messageerror", "没有需要复核的数据");
			return false;
		}
	}
	

	public boolean salarystandardcheck(String standId,
			Map<String, Object> request) {
		TSalarystanderd t1 = salarystanderdDao.queryById(Integer.parseInt(standId));
		List<TSalarystandProject> lst = salarystandProjectDao.queryByStand(Integer.parseInt(standId));
		if(t1!=null){
			request.put("salarystanderd", t1);
		}
		if(lst!=null){
			request.put("standProjectlist", lst);
		}
		return true;
	}	
//复核成功
	public boolean salarystandardchecksuccess(String standId) {
		boolean isSuccess= salarystanderdDao.updateStatus(Integer.parseInt(standId));
		return isSuccess;
	}
	
	
//薪水标记查询
	public boolean salarystandardqueryresult(String salarystandcheckId,
			String startTime, String endTime, String standName,String indexPage,Map<String,Object> request){
		List lst = new ArrayList();
		if(salarystandcheckId==null||salarystandcheckId.equals("")){
			lst = salarystanderdDao.queryByIdName_Time(standName, startTime, endTime,Integer.parseInt(indexPage));
			PageUtils page = (PageUtils) lst.get(lst.size()-1);
			lst.remove(lst.remove(lst.size()-1));
			request.put("salarystandlst", lst);
			request.put("querypage", page);
			return true;
		}else{
			TSalarystanderd s = salarystanderdDao.queryById(Integer.parseInt(salarystandcheckId));
			PageUtils page = new PageUtils(5);
			page.setIndexPage(1);
			lst.add(s);
			request.put("salarystandlst", lst);
			request.put("querypage", page);
			return true;
		}
	}

	public boolean salaryproject(String salarystandcheckId,Map<String, Object> request){
		List lst = salarystandProjectDao.queryByStand(Integer.parseInt(salarystandcheckId));
		request.put("salaryprojectlst",lst);
		return true;
	}


	public boolean salaryStandManagerupdate(TSalarystanderd t1,
			String[] salarystandProjectName, String[] salarystandProjectMoney,
			String[] salarystandProjectId) {
		salarystanderdDao.updateInteger(t1);
		List<TSalarystandProject> lst =new ArrayList<TSalarystandProject>();
		TSalarystandProject t =null;
			for(int i=0;i<salarystandProjectId.length;i++){
				if(salarystandProjectMoney[i]!=null&&salarystandProjectMoney[i]!=""){
					t = new TSalarystandProject(t1.getSalarystanderdId(), salarystandProjectName[i], Double.parseDouble(salarystandProjectMoney[i]),Integer.parseInt(salarystandProjectId[i]), "test");
					lst.add(t);
				}
			}
		boolean isFalg2=false;
		for(TSalarystandProject s:lst){
			isFalg2 = salarystandProjectDao.update(s);
		}
		return isFalg2;
}

	
	/**************** get  and  set ****************/
	public ITSalarystanderdDao getSalarystanderdDao() {
		return salarystanderdDao;
	}
	public void setSalarystanderdDao(ITSalarystanderdDao salarystanderdDao) {
		this.salarystanderdDao = salarystanderdDao;
	}
	public ITSalarystandProjectDao getSalarystandProjectDao() {
		return salarystandProjectDao;
	}
	public void setSalarystandProjectDao(
			ITSalarystandProjectDao salarystandProjectDao) {
		this.salarystandProjectDao = salarystandProjectDao;
	}

	public ITSalaryprojectDao getSpdao() {
		return spdao;
	}

	public void setSpdao(ITSalaryprojectDao spdao) {
		this.spdao = spdao;
	}
	
}