package com.zking.hr.view.contorl.action.customization.manpowerResource;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.zking.hr.biz.impl.cuntomization.manpowerResource.ManpowerResourceBizImpl;
import com.zking.hr.pojo.TPublicproperty;

public class publicPropertyAction extends ActionSupport implements RequestAware{
	private Map<String, Object> request;
	private ManpowerResourceBizImpl manpowerbiz;
	private int indexPage;
	private Integer publicTypeId;
	private TPublicproperty tp;
	

	public TPublicproperty getTp() {
		return tp;
	}
	public void setTp(TPublicproperty tp) {
		this.tp = tp;
	}
	public Integer getPublicTypeId() {
		return publicTypeId;
	}
	public void setPublicTypeId(Integer publicTypeId) {
		this.publicTypeId = publicTypeId;
	}
	public ManpowerResourceBizImpl getManpowerbiz() {
		return manpowerbiz;
	}
	public void setManpowerbiz(ManpowerResourceBizImpl manpowerbiz) {
		this.manpowerbiz = manpowerbiz;
	}
	public int getIndexPage() {
		return indexPage;
	}
	public void setIndexPage(int indexPage) {
		this.indexPage = indexPage;
	}
	
	public String loadPublicProperty() throws Exception {
		if (indexPage==0) {
			indexPage = 1;
		}
		manpowerbiz.showPublicProperty(request, indexPage);
		return SUCCESS;
	}
	
	public String deletePublicProperty(){
		manpowerbiz.deletePublicProperty(publicTypeId);
		return SUCCESS;
	}
	public String insertPublicProperty(){
		manpowerbiz.insertPublicProperty(tp);
		return SUCCESS;
	}
	
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
}
