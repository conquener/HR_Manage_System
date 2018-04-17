package com.zking.hr.biz.interfaces.salaryIssueManage.click;

import java.util.List;
import java.util.Map;

import com.zking.hr.pojo.TFiles;
import com.zking.hr.pojo.TsalarypayoffAdd;

public interface IClickSalarySendBiz {
	public boolean  clickSalarySend(Map<String, Object> request);
	public boolean salarysendtoworkerdetails(Map<String, Object> request,Integer standId);
	public boolean salarysendOrganparentId(Map<String, Object> request,Integer organid,Integer level);
	public boolean salarysendRegister(String[] fileId,Map<String, Object> request,TsalarypayoffAdd t);
	public boolean salarysendchec(Map<String, Object> request,Integer status,String[]  checkfileId);
	public boolean salarysendcheck(Map<String, Object> request,Map<String,Object> session);
	public boolean salarysendcheckOrganparentId(Map<String, Object> request,Integer organid,Integer level,Map<String,Object> session);
	public boolean salarysendcheckById(String[] checkfileUserId,Map<String, Object> session);
	public boolean salarysendquery(String salarysendAddId,String salarySendOrganName,String salarysendstartTime,String salarysendendTime,Integer indexPage,Map<String,Object> request);
	/**
	 * 通过机构获取当前需要发放的人员
	 * @param map
	 * @return
	 */
	public List<TFiles> getSalarySendByOrganId(Map<String,Object> map);
}