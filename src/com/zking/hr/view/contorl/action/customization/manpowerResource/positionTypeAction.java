package com.zking.hr.view.contorl.action.customization.manpowerResource;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.zking.hr.biz.impl.cuntomization.manpowerResource.ManpowerResourceBizImpl;
import com.zking.hr.pojo.TPositiontype;

public class positionTypeAction extends ActionSupport implements RequestAware{
	private Map<String, Object> request;
	private ManpowerResourceBizImpl manpowerbiz;
	private int indexPage;
	private Integer positiontypeId;
	private TPositiontype tp;
	
	
	
	public TPositiontype getTp() {
		return tp;
	}


	public void setTp(TPositiontype tp) {
		this.tp = tp;
	}


	public Integer getPositiontypeId() {
		return positiontypeId;
	}


	public void setPositiontypeId(Integer positiontypeId) {
		this.positiontypeId = positiontypeId;
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


	public String loadPositionType() throws Exception {
		if (indexPage == 0) {
			indexPage = 1;
		}
		manpowerbiz.showPositiontype(request, indexPage);
		return SUCCESS;
	}
	public String deletePositionType(){
		manpowerbiz.deletePositionType(positiontypeId);
		return SUCCESS;
	}
	
	public String insertPositionType(){
		manpowerbiz.insertPositionType(tp);
		return SUCCESS;
	}


	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
}
