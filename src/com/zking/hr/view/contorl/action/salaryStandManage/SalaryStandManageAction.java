package com.zking.hr.view.contorl.action.salaryStandManage;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.zking.hr.biz.interfaces.salaryStandManage.ISalaryStandManageBiz;
import com.zking.hr.pojo.TSalaryproject;
import com.zking.hr.pojo.TSalarystandProject;
import com.zking.hr.pojo.TSalarystanderd;

public class SalaryStandManageAction extends ActionSupport implements RequestAware{
	private Map<String, Object> request;
	private ISalaryStandManageBiz salaryStandManageBiz;
	private TSalarystanderd t1;
	private String[] salarystandProjectName;
	private String[] salarystandProjectMoney;
	private String[] salarystandProjectId;
	private String standcheckindexpage;
	private String salarystandcheckId;
	private String startTime;
	private String endTime;
	private String standName;
	
	public String salarystandardregister(){
		List<TSalaryproject> tp = salaryStandManageBiz.salarystandardregister();
		request.put("tp",tp);
		return "success10";
	}
	//薪水标准登记
	public String salaryStandManageregister(){
		salaryStandManageBiz.SalaryStandManageregister(t1,salarystandProjectName,salarystandProjectMoney,salarystandProjectId);
		return "success1";
	}
	
	
	public String salarystandardchecklist(){
		if(standcheckindexpage==null){
			standcheckindexpage="1";
		}
		salaryStandManageBiz.salarystandardchecklist(request, Integer.parseInt(standcheckindexpage));
		return "success2";
	}
	
	
	
	//查询需要薪酬标准复核
	public String salarystandardcheck(){
		if(salarystandcheckId!=null&&!salarystandcheckId.equals("")){
			salaryStandManageBiz.salarystandardcheck(salarystandcheckId, request);
		}else{
			request.put("errorcheckmessage", "标准不存在");
		}
		return "success3";
	}
	
	//薪水复核完成,修改状态
	public String salarystandardchecksuccess(){
		if(salarystandcheckId!=null&&!salarystandcheckId.equals("")){
			salaryStandManageBiz.salarystandardchecksuccess(salarystandcheckId);
		}
		return "success4";
	}
	
	
	//薪水标准查询
	public String salarystandardqueryresult(){
		if(standcheckindexpage==null||standcheckindexpage.equals("")){
			standcheckindexpage="1";
		}
		salaryStandManageBiz.salarystandardqueryresult(salarystandcheckId,startTime,endTime,standName,standcheckindexpage,request);
		return "success5";
	}
	
	
	//查询相应的薪酬标准的薪酬项目
	public String salaryproject(){
		if(salarystandcheckId!=null&&!salarystandcheckId.equals("")){
			salaryStandManageBiz.salaryproject(salarystandcheckId,request);
		}
		return "success6";
	}
	
	//查看薪酬标准变更
	public String salarystandardchangresult(){
		if(standcheckindexpage==null||standcheckindexpage.equals("")){
			standcheckindexpage="1";
		}
		salaryStandManageBiz.salarystandardqueryresult(salarystandcheckId,startTime,endTime,standName,standcheckindexpage,request);
		return "success7";
	}
	
	//查询需要变更薪酬标准
	public String  salarystandupdate(){
		if(salarystandcheckId!=null&&!salarystandcheckId.equals("")){
			salaryStandManageBiz.salarystandardcheck(salarystandcheckId, request);
		}else{
			request.put("errorcheckmessage", "标准不存在");
		}
		return "success8";
	}
	
	//薪酬标准变更
	public String salarystandardupdatesuccess(){
		salaryStandManageBiz.salaryStandManagerupdate(t1,salarystandProjectName, salarystandProjectMoney, salarystandProjectId);
		return "success9";
	}
	
	
	
	
	/*****************  get and  set ***************/
	
	public void setRequest(Map<String, Object> request) {
			this.request = request;
	}
	public ISalaryStandManageBiz getSalaryStandManageBiz() {
		return salaryStandManageBiz;
	}
	public void setSalaryStandManageBiz(ISalaryStandManageBiz salaryStandManageBiz) {
		this.salaryStandManageBiz = salaryStandManageBiz;
	}


	public TSalarystanderd getT1() {
		return t1;
	}


	public void setT1(TSalarystanderd t1) {
		this.t1 = t1;
	}


	public String[] getSalarystandProjectName() {
		return salarystandProjectName;
	}


	public void setSalarystandProjectName(String[] salarystandProjectName) {
		this.salarystandProjectName = salarystandProjectName;
	}


	public String[] getSalarystandProjectMoney() {
		return salarystandProjectMoney;
	}


	public void setSalarystandProjectMoney(String[] salarystandProjectMoney) {
		this.salarystandProjectMoney = salarystandProjectMoney;
	}


	public String[] getSalarystandProjectId() {
		return salarystandProjectId;
	}


	public void setSalarystandProjectId(String[] salarystandProjectId) {
		this.salarystandProjectId = salarystandProjectId;
	}


	public String getStandcheckindexpage() {
		return standcheckindexpage;
	}


	public void setStandcheckindexpage(String standcheckindexpage) {
		this.standcheckindexpage = standcheckindexpage;
	}


	public String getSalarystandcheckId() {
		return salarystandcheckId;
	}


	public void setSalarystandcheckId(String salarystandcheckId) {
		this.salarystandcheckId = salarystandcheckId;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getStandName() {
		return standName;
	}
	public void setStandName(String standName) {
		this.standName = standName;
	}
	public Map<String, Object> getRequest() {
		return request;
	}
	
	
}
