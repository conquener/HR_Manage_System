package com.zking.hr.view.contorl.action.customization.manpowerResource;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.zking.hr.biz.impl.cuntomization.manpowerResource.ManpowerResourceBizImpl;
import com.zking.hr.pojo.TPosition;

public class positionAction extends ActionSupport implements RequestAware{
	private Map<String, Object> request;
	private ManpowerResourceBizImpl manpowerbiz;
	private int indexPage;
	private Integer positionId;
	private TPosition tp;
	
	public TPosition getTp() {
		return tp;
	}
	public void setTp(TPosition tp) {
		this.tp = tp;
	}
	public Integer getPositionId() {
		return positionId;
	}
	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}
	public void setRequest(Map<String, Object> request) {
		this.request = request;
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
	
	public String loadPosition() throws Exception {
		if (indexPage == 0) {
			indexPage=1;
		}
		manpowerbiz.showPosition(request, indexPage);
		return SUCCESS;
	}
	public String deletePosition(){
		manpowerbiz.deletePosition(positionId);
		return SUCCESS;
	}
	
	public String queryInsertPosition(){
		manpowerbiz.queryPositionTypeAll(request);
		return SUCCESS;
	}
	public String insertPosition(){
		String str = tp.getPositiontypeName();
		String[] str2 = str.split(",");
		TPosition t = new TPosition(Integer.parseInt(str2[1]), str2[0], tp.getPositionId(), tp.getPositionName(), tp.getRemark());
		manpowerbiz.insertPosition(t);
		return SUCCESS;
	}
	
}
