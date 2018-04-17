package com.zking.hr.view.contorl.action.customization.manpowerResource;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.zking.hr.biz.impl.cuntomization.manpowerResource.ManpowerResourceBizImpl;
import com.zking.hr.biz.interfaces.customization.manpowerResource.IManpowerResourceBiz;
import com.zking.hr.pojo.TOrganization;

public class manpowerResourceAction extends ActionSupport implements RequestAware{
	private static final long serialVersionUID = 1L;
	private Map<String, Object> request;
	private IManpowerResourceBiz manpowerbiz;
	private int indexPage=0;
	private int level;
	private int oraganId;
	private TOrganization oragan;
	private String inputUserName;
	private List<Map<String,Object>> fileName;
	
	public String getFileUserName(){
		setFileName(manpowerbiz.getFileUserName(inputUserName));
		return "userName";
	}
	
	
	

	public String loadOragan1() throws Exception {
		if (indexPage == 0) {
			indexPage = 1;
		}
		manpowerbiz.showOrganization(request, level, indexPage);
		if (level==1) {
			return SUCCESS;
		}else if (level == 2) {
			return "oragan2";
		}else {
			return "oragan3";
		}
	}
	

	public String deleteOrgan1(){
		manpowerbiz.deleteOrgan(oraganId);
		return "deleteORSuccess";
	}
	public String deleteOrgan2(){
		manpowerbiz.deleteOrgan(oraganId);
		return "deleteORSuccess";
	}
	public String deleteOrgan3(){
		manpowerbiz.deleteOrgan(oraganId);
		return "deleteORSuccess";
	}
	
	
	public String insertOrgan1(){
		manpowerbiz.insertOrgan(oragan);
		return "insertORSuccess";
	}
	
	
	public String insertOrgan2(){
		String str = oragan.getParentName();
		String[] str2 = str.split(",");
		TOrganization o = new TOrganization(oragan.getOraganId(),oragan.getOraganName(),oragan.getSalarypaypersonId(),oragan.getSalepersonId(),Integer.parseInt(str2[1]),str2[0],oragan.getRemark());
		manpowerbiz.insertOrgan(o);
		return "insertORSuccess";
	}
	public String insertOrgan3(){
		String str = oragan.getParentName();
		String[] str2 = str.split(",");
		TOrganization o = new TOrganization(oragan.getOraganId(),oragan.getOraganName(),oragan.getSalarypaypersonId(),oragan.getSalepersonId(),Integer.parseInt(str2[1]),str2[0],oragan.getRemark());
		manpowerbiz.insertOrgan(o);
		return "insertORSuccess";
	}
	
	public String updateOrgan(){
		manpowerbiz.updateOrgan(oragan);
		return "updateORSuccess";
	}
	
	public String queryByParentId(){
		manpowerbiz.queryByParentId(0, request);
		return SUCCESS;
	}
	
	public String querySecondOra(){
		manpowerbiz.querySecondOra(request);
		return SUCCESS;
	}
	
	public String queryOraganById1(){
		manpowerbiz.queryOraganById(oraganId,request);
		return SUCCESS;
	}
	public String queryOraganById2(){
		manpowerbiz.queryOraganById(oraganId,request);
		return SUCCESS;
	}
	
	public String queryOraganById3(){
		manpowerbiz.queryOraganById(oraganId, request);
		return SUCCESS;
	}

	public String updateOragan1(){
		manpowerbiz.updateOrgan(oragan);
		return SUCCESS;
	}
	public String updateOragan2(){
		manpowerbiz.updateOrgan(oragan);
		return SUCCESS;
	}
	public String updateOragan3(){
		manpowerbiz.updateOrgan(oragan);
		return SUCCESS;
	}
	
	
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}


	public String getInputUserName() {
		return inputUserName;
	}


	public void setInputUserName(String inputUserName) {
		try {
			this.inputUserName = new String(inputUserName.getBytes("iso8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			this.inputUserName="";
		}
	}


	public List<Map<String,Object>> getFileName() {
		return fileName;
	}


	public void setFileName(List<Map<String,Object>> fileName) {
		this.fileName = fileName;
	}
	public TOrganization getOragan() {
		return oragan;
	}

	public void setOragan(TOrganization oragan) {
		this.oragan = oragan;
	}

	public int getOraganId() {
		return oraganId;
	}

	public void setOraganId(int oraganId) {
		this.oraganId = oraganId;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getIndexPage() {
		return indexPage;
	}

	public void setIndexPage(int indexPage) {
		this.indexPage = indexPage;
	}

	public IManpowerResourceBiz getManpowerbiz() {
		return manpowerbiz;
	}

	public void setManpowerbiz(IManpowerResourceBiz manpowerbiz) {
		this.manpowerbiz = manpowerbiz;
	}

}
