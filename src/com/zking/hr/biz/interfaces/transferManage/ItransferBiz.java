package com.zking.hr.biz.interfaces.transferManage;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.zking.hr.pojo.TStafftransfer;

public interface ItransferBiz {
	public void professionalajax(HttpServletResponse response);
	public void positionajax(String positionId,HttpServletResponse response);
	public boolean  transRegister(TStafftransfer t);
	public boolean removeregisterfuhequery(Map<String, Object> request,int indexPge);
	public boolean queryTstafftrans(Integer staffid,Map<String, Object> request);
	public boolean updateviewStatus(Integer transcheckId,Integer status);
	public boolean stafftranquery(String tranPerosonName,String begintrantime,String endtrantime,Integer indexPage,Map<String, Object> request);
	public boolean querydetailsTstafftrans(Integer staffid,Map<String, Object> request);
	
}
