package com.zking.hr.view.contorl.action.salaryIssueMange;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.zking.hr.biz.interfaces.salaryIssueManage.click.IClickSalarySendBiz;
import com.zking.hr.pojo.TsalarypayoffAdd;

public class SalaryIssueMangeAction extends ActionSupport implements RequestAware,SessionAware{

	private static final long serialVersionUID = 3916994617125509145L;
	private Map<String, Object> request;
	private Map<String,Object> session;
	private IClickSalarySendBiz clicksendBiz;
	private String standId;
	private String userName;
	private String organId;
	private String ssoplevel;
	private String[] salarychecked;
	private String[]  checkfileId;
	private TsalarypayoffAdd tpayoffadd;
	private String organfristId;
	private String organsecondId;
	private String organthreeId;
	private String[] checkfileUserId;
	private Integer indexPage;
	private String salarysendAddId;
	private String salarySendOrganName;
	private String salarysendstartTime;
	private String salarysendendTime;
	
	//进入薪水发放登记
	public String clicksalarysend(){
		boolean isSuccess =clicksendBiz.clickSalarySend(request);
		if(isSuccess){
			return "success";
		}
		return "success";
	}
	//点击查看个人的薪水标准
	public String salarysendtoworkerdetails(){
		boolean isSuccess=false;
		if(standId!=null){
			isSuccess= clicksendBiz.salarysendtoworkerdetails(request, Integer.parseInt(standId));
		}
		if(isSuccess){
			return "success1";
		}
		return "success1";
	}
	
	//根据机构查询
	public String salarysendOrganId(){
		if(organId.trim().equals("-1")){
			return "success9";
		}
		boolean isSuccess=false;
		isSuccess= clicksendBiz.salarysendOrganparentId(request, Integer.parseInt(organId),Integer.parseInt(ssoplevel));
		if(isSuccess){
			return "success2";
		}
		return "success2";
	}
	
	//提交薪水登记
	public String salarysendRegister(){
		if(salarychecked!=null){
			 clicksendBiz.salarysendRegister(salarychecked,request,tpayoffadd);
			return "success3";
		}else{
			return "success3";
		}
	}
	//薪水复核内容加载
	public String salarysendcheck(){
		clicksendBiz.salarysendcheck(request,session);	
		return "success4";
	}
	
	//薪水复核
	public String checksendstatus(){
		clicksendBiz.salarysendcheckById(checkfileUserId,session);
		
		return "success7";
	}
	
	//薪水复核机构查询
	public String salarysendcheckOragan(){
		boolean isSuccess=false;
		isSuccess= clicksendBiz.salarysendcheckOrganparentId(request, Integer.parseInt(organId),Integer.parseInt(ssoplevel),session);
		if(isSuccess){
			return "success6";
		}
		return "success6";

	}
	
	//查看薪水标准
	public String salarysendcheckwokrerdetails(){
		boolean isSuccess=false;
		if(standId!=null){
			isSuccess= clicksendBiz.salarysendtoworkerdetails(request, Integer.parseInt(standId));
		}
		if(isSuccess){
			return "success5";
		}
		return "success5";
	}
	
	
	
	//查看薪水发放和复核完成的人员
	public String salarysendqueryresult(){
		if(indexPage==null||indexPage==0){
			indexPage=1;
		}
		clicksendBiz.salarysendquery(salarysendAddId,salarySendOrganName,salarysendstartTime,salarysendendTime,indexPage,request);
		return "success8";
	}
	
	
	public void getSalarySendByOrganId(){
		Map<String, Object> map = new HashMap<String, Object>();
		if(organfristId!=null && organfristId.equals("")){
			map.put("organfristId", Integer.parseInt(organfristId));
		}
		if(organsecondId!=null && organsecondId.equals("")){
			map.put("organsecondId", Integer.parseInt(organsecondId));
		}
		if(organthreeId!=null && organthreeId.equals("")){
			map.put("organthreeId", Integer.parseInt(organthreeId));
		}
		request.put("salarysendman", clicksendBiz.getSalarySendByOrganId(map));
	}
	
	
	
	
	
	
	public String getSsoplevel() {
		return ssoplevel;
	}

	public void setSsoplevel(String ssoplevel) {
		this.ssoplevel = ssoplevel;
	}


	
	public void setRequest(Map<String, Object> request) {
		 this.request= request;
	}


	public IClickSalarySendBiz getClicksendBiz() {
		return clicksendBiz;
	}


	public void setClicksendBiz(IClickSalarySendBiz clicksendBiz) {
		this.clicksendBiz = clicksendBiz;
	}

	public String getStandId() {
		return standId;
	}

	public void setStandId(String standId) {
		this.standId = standId;
	}

	public String getUserName() {
		return userName;
	}

	public String getOrganId() {
		return organId;
	}

	public void setOrganId(String organId) {
		this.organId = organId;
	}

	public void setUserName(String userName) {
		try {
			this.userName = new String(userName.getBytes("iso8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			this.userName="";
		}
	}

	public String[] getSalarychecked() {
		return salarychecked;
	}

	public void setSalarychecked(String[] salarychecked) {
		this.salarychecked = salarychecked;
	}

	public String[] getCheckfileId() {
		return checkfileId;
	}

	public void setCheckfileId(String[] checkfileId) {
		this.checkfileId = checkfileId;
	}

	public TsalarypayoffAdd getTpayoffadd() {
		return tpayoffadd;
	}

	public void setTpayoffadd(TsalarypayoffAdd tpayoffadd) {
		this.tpayoffadd = tpayoffadd;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public String getOrganfristId() {
		return organfristId;
	}
	public void setOrganfristId(String organfristId) {
		this.organfristId = organfristId;
	}
	public String getOrgansecondId() {
		return organsecondId;
	}
	public void setOrgansecondId(String organsecondId) {
		this.organsecondId = organsecondId;
	}
	public String getOrganthreeId() {
		return organthreeId;
	}
	public void setOrganthreeId(String organthreeId) {
		this.organthreeId = organthreeId;
	}
	public String[] getCheckfileUserId() {
		return checkfileUserId;
	}
	public void setCheckfileUserId(String[] checkfileUserId) {
		this.checkfileUserId = checkfileUserId;
	}
	public String getSalarysendAddId() {
		return salarysendAddId;
	}
	public void setSalarysendAddId(String salarysendAddId) {
		this.salarysendAddId = salarysendAddId;
	}
	public String getSalarySendOrganName() {
		return salarySendOrganName;
	}
	public void setSalarySendOrganName(String salarySendOrganName) {
		this.salarySendOrganName = salarySendOrganName;
	}
	public String getSalarysendstartTime() {
		return salarysendstartTime;
	}
	public void setSalarysendstartTime(String salarysendstartTime) {
		this.salarysendstartTime = salarysendstartTime;
	}
	public String getSalarysendendTime() {
		return salarysendendTime;
	}
	public void setSalarysendendTime(String salarysendendTime) {
		this.salarysendendTime = salarysendendTime;
	}
	public Integer getIndexPage() {
		return indexPage;
	}
	public void setIndexPage(Integer indexPage) {
		this.indexPage = indexPage;
	}
	
}
