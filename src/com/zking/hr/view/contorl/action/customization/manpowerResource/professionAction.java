package com.zking.hr.view.contorl.action.customization.manpowerResource;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.zking.hr.biz.impl.cuntomization.manpowerResource.ManpowerResourceBizImpl;
import com.zking.hr.pojo.TProfessional;

public class professionAction extends ActionSupport implements RequestAware {

	private Map<String, Object> request;
	private ManpowerResourceBizImpl manpowerbiz;
	private int indexPage;
	private Integer professionId;
	private TProfessional profes;

	public TProfessional getProfes() {
		return profes;
	}

	public void setProfes(TProfessional profes) {
		this.profes = profes;
	}

	public Integer getProfessionId() {
		return professionId;
	}

	public void setProfessionId(Integer professionId) {
		this.professionId = professionId;
	}

	public int getIndexPage() {
		return indexPage;
	}

	public void setIndexPage(int indexPage) {
		this.indexPage = indexPage;
	}

	public ManpowerResourceBizImpl getManpowerbiz() {
		return manpowerbiz;
	}

	public void setManpowerbiz(ManpowerResourceBizImpl manpowerbiz) {
		this.manpowerbiz = manpowerbiz;
	}

	public String loadProfession() throws Exception {
		if (indexPage == 0) {
			indexPage = 1;
		}
		boolean isSuccess = manpowerbiz.showProfessional(request, indexPage);
		if (isSuccess) {
			return SUCCESS;
		} else {
			return SUCCESS;
		}
	}

	public String deleteProfessionById() {
		manpowerbiz.deleteProfessional(professionId);
		return SUCCESS;
	}

	public String insertProfession() {
		manpowerbiz.insertProfessional(profes);
		return SUCCESS;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

}
