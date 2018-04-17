package com.zking.hr.view.contorl.action.transmanage;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.zking.hr.biz.interfaces.transferManage.ItransferBiz;
import com.zking.hr.pojo.TStafftransfer;

public class TransferManageAction extends ActionSupport implements RequestAware{
	private ItransferBiz tranbiz;
	private String positionid;
	private TStafftransfer stafftransfer;
	private String[] transactionnature;
	private Map<String, Object> request;
	private String fuhequeryIndexPage;
	private String staffUserid;
	private String checkSelect;
	private String transcheckId;
	private String tranPerosonName;
	private String begintrantime;
	private String endtrantime;
	private String queryindexPage;
	private String stafftransId;

	public void professionalajax(){
		HttpServletResponse response = ServletActionContext.getResponse();
		tranbiz.professionalajax(response);
	}
	
	public void positionajax(){
		HttpServletResponse response = ServletActionContext.getResponse();
		tranbiz.positionajax(positionid, response);
		
	}
	
	public String transRegister(){
		String transaction = "";
		if(transactionnature!=null||!transactionnature.equals("")){
			for(int i=0;i<transactionnature.length;i++){
				transaction+=transactionnature[i];
				if(i>=transactionnature.length){
					transaction+=",";
				}
			}
			stafftransfer.setTransactionnature(transaction);
		}
			stafftransfer.setViewsStatus(1);
		tranbiz.transRegister(stafftransfer);
		return "success1";
	}
	
	public String removeregisterfuhequery(){
		if(fuhequeryIndexPage==null||fuhequeryIndexPage.equals("")){
			fuhequeryIndexPage="1";
		}
		tranbiz.removeregisterfuhequery(request,Integer.parseInt(fuhequeryIndexPage));
		return "success2";
	}
	
	//调动人员具体复核情况查询
	public String removecheckregister2(){
		if(staffUserid!=null||!staffUserid.equals("")){
			tranbiz.queryTstafftrans(Integer.parseInt(staffUserid),request);
		}
		return "success3";
	}
	//复核
	public String stafftranscheck(){
		if(transcheckId!=null&&!transcheckId.equals("")){
		if(checkSelect.equals("1")){
			tranbiz.updateviewStatus(Integer.parseInt(transcheckId),2);
			return "success4";
		}else{
			tranbiz.updateviewStatus(Integer.parseInt(transcheckId),0);
			return "success5";
		}
		}
		return "success4";
	}
	
	public String stafftranquery(){
		if(queryindexPage==null||queryindexPage.equals("")){
			queryindexPage="1";
		}
		System.out.println("tranPerosonName:"+tranPerosonName+",begintrantime:"+begintrantime+",endtrantime:"+endtrantime);
		tranbiz.stafftranquery(tranPerosonName,begintrantime,endtrantime,Integer.parseInt(queryindexPage),request);
		return "success6";
	}
	
	public String removequerydetails(){
		if(stafftransId!=null||!stafftransId.equals("")){
			tranbiz.querydetailsTstafftrans(Integer.parseInt(stafftransId),request);
		}
		return "success7";
	}
	
	
	public ItransferBiz getTranbiz() {
		return tranbiz;
	}

	public void setTranbiz(ItransferBiz tranbiz) {
		this.tranbiz = tranbiz;
	}

	public String getPositionid() {
		return positionid;
	}

	public void setPositionid(String positionid) {
		this.positionid = positionid;
	}

	public TStafftransfer getStafftransfer() {
		return stafftransfer;
	}

	public void setStafftransfer(TStafftransfer stafftransfer) {
		this.stafftransfer = stafftransfer;
	}

	public String[] getTransactionnature() {
		return transactionnature;
	}

	public void setTransactionnature(String[] transactionnature) {
		this.transactionnature = transactionnature;
	}

	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public String getFuhequeryIndexPage() {
		return fuhequeryIndexPage;
	}

	public void setFuhequeryIndexPage(String fuhequeryIndexPage) {
		this.fuhequeryIndexPage = fuhequeryIndexPage;
	}

	public String getStaffUserid() {
		return staffUserid;
	}

	public void setStaffUserid(String staffUserid) {
		this.staffUserid = staffUserid;
	}

	public String getCheckSelect() {
		return checkSelect;
	}

	public void setCheckSelect(String checkSelect) {
		this.checkSelect = checkSelect;
	}

	public String getTranscheckId() {
		return transcheckId;
	}

	public void setTranscheckId(String transcheckId) {
		this.transcheckId = transcheckId;
	}

	public String getTranPerosonName() {
		return tranPerosonName;
	}

	public void setTranPerosonName(String tranPerosonName) {
		this.tranPerosonName = tranPerosonName;
	}

	public String getEndtrantime() {
		return endtrantime;
	}

	public void setEndtrantime(String endtrantime) {
		this.endtrantime = endtrantime;
	}

	public String getBegintrantime() {
		return begintrantime;
	}

	public void setBegintrantime(String begintrantime) {
		this.begintrantime = begintrantime;
	}

	public String getQueryindexPage() {
		return queryindexPage;
	}

	public void setQueryindexPage(String queryindexPage) {
		this.queryindexPage = queryindexPage;
	}

	public String getStafftransId() {
		return stafftransId;
	}

	public void setStafftransId(String stafftransId) {
		this.stafftransId = stafftransId;
	}
	
	
}
