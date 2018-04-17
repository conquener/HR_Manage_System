package com.zking.hr.biz.impl.transferManage;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.zking.hr.biz.interfaces.transferManage.ItransferBiz;
import com.zking.hr.dao.interfaces.TFiles.ITFilesDao;
import com.zking.hr.dao.interfaces.TPosition.ITPositionDao;
import com.zking.hr.dao.interfaces.TPositiontype.ITPositiontypeDao;
import com.zking.hr.dao.interfaces.TProfessional.ITProfessionalDao;
import com.zking.hr.dao.interfaces.TStafftransfer.ITstafftransferDao;
import com.zking.hr.pojo.TPosition;
import com.zking.hr.pojo.TPositiontype;
import com.zking.hr.pojo.TProfessional;
import com.zking.hr.pojo.TStafftransfer;
import com.zking.hr.utils.DateUtil.FormatDateUtils;
import com.zking.hr.utils.pageUtils.PageUtils;

public class TransferManageBizImpl implements ItransferBiz{
	private ITstafftransferDao transferdao;
	private ITProfessionalDao professdao;
	private ITPositiontypeDao positiontypedao;
	private ITPositionDao positiondao;
	private ITFilesDao filedao;
	//部门联动效果
	public void professionalajax(HttpServletResponse response) {
		List<TPositiontype> lst = positiontypedao.querybyAll();
		String s = toJson(lst).toString();
		try {
			response.getWriter().write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//职位联动效果
	public void positionajax(String positionId,HttpServletResponse response) {
		List<TPosition> lst = positiondao.queryByTypeId(Integer.parseInt(positionId));
		String s = toJson1(lst).toString();
		try {
			response.getWriter().write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//调动登记
	public boolean transRegister(TStafftransfer t) {
		boolean isSuccess= transferdao.insert(t);
		return isSuccess;
	}
	
	//调动人员档案查询
	public boolean removeregisterfuhequery(Map<String, Object> request, int indexPage) {
		List<Integer> lst = transferdao.queryByStatusAndId();
		PageUtils page = new PageUtils(lst.size());
		page.setIndexPage(indexPage);
		if(lst.size()>=1){
			List lst2 = new ArrayList();
			Map m = new  HashMap();
			for(int i = page.getBeginRow()-1;i<page.getEndRow();i++){
				m = filedao.queryByUserId(lst.get(i));
				if(m!=null){
					lst2.add(m);
				}
			}
			request.put("transpersonList", lst2);
			request.put("transpersonpage", page);
			return true;
		}
		request.put("transpersonpage", page);
		return false;
	}

	/**
	 *根据调动人员来查找
	 */
	public boolean queryTstafftrans(Integer staffid,Map<String, Object> request) {
		TStafftransfer t = transferdao.queryBystaffId(staffid);
		if(t!=null){
			request.put("stafftrans", t);
			return true;
		}else{
			request.put("errorStaff", "没有找到该员工的调动信息");
			return false;
		}
	}
	/**
	 * 更新复核状态
	 */
	public boolean updateviewStatus(Integer transcheckId, Integer status) {
		boolean isSuccess = transferdao.updateStatus(transcheckId, status);
		return isSuccess;
	}
	
	public boolean stafftranquery(String tranPerosonName, String begintrantime,
			String endtrantime,Integer indexPage,Map<String, Object> request) {
		Date d1 = null;
		Date d2 = null;
		if(begintrantime!=null&&!begintrantime.equals("")){
			d1=  FormatDateUtils.stringChangesql(begintrantime);
		}
		if(endtrantime!=null&&!endtrantime.equals("")){
			d2 = FormatDateUtils.stringChangesql(endtrantime);
		}
		List lst = transferdao.queryByNameAndTime(tranPerosonName,d1,d2, indexPage);
		request.put("begintrantime", begintrantime);
		request.put("tranPerosonName", tranPerosonName);
		request.put("endtrantime", endtrantime);
		if(lst.size()>1){
			PageUtils page = (PageUtils) lst.get(lst.size()-1);
			lst.remove(lst.size()-1);
			request.put("tranquerylist", lst);
			request.put("tranquerylistpage", page);
			return true;
		}
		return false;
	}
	
	public boolean querydetailsTstafftrans(Integer staffid,
			Map<String, Object> request) {
		TStafftransfer t = transferdao.queryById(staffid);
		if(t!=null){
			request.put("stafftrans", t);
			return true;
		}else{
			request.put("errorStaff", "没有找到该员工的调动信息");
			return false;
		}
	}
	
	
	/*************---json---************/

	public StringBuilder toJson(List<TPositiontype> lst){
		StringBuilder s=new StringBuilder();
		s.append("[");
		for (int i=0;i<lst.size();i++) {
			s.append(objectTojson(lst.get(i))+",");
		}
		s.append("]");
		return s;
	}
	
	private StringBuilder objectTojson(TPositiontype p){
		StringBuilder s=new StringBuilder();
		s.append("{");
		s.append("id:\""+p.getPositiontypeId()+"\",name:\""+p.getPositiontypeName()+"\"");
		s.append("}");
		
		return s;
	
	}
	public StringBuilder toJson1(List<TPosition> lst){
		StringBuilder s=new StringBuilder();
		s.append("[");
		for (int i=0;i<lst.size();i++) {
			s.append(objectTojson1(lst.get(i))+",");
		}
		s.append("]");
		return s;
	}
	
	private StringBuilder objectTojson1(TPosition p){
		StringBuilder s=new StringBuilder();
		s.append("{");
		s.append("id:\""+p.getPositionId()+"\",name:\""+p.getPositionName()+"\"");
		s.append("}");
		return s;
	}

	
	/**************** get and set **************/
	
	public ITstafftransferDao getTransferdao() {
		return transferdao;
	}

	public void setTransferdao(ITstafftransferDao transferdao) {
		this.transferdao = transferdao;
	}

	public ITProfessionalDao getProfessdao() {
		return professdao;
	}

	public void setProfessdao(ITProfessionalDao professdao) {
		this.professdao = professdao;
	}

	public ITPositiontypeDao getPositiontypedao() {
		return positiontypedao;
	}

	public void setPositiontypedao(ITPositiontypeDao positiontypedao) {
		this.positiontypedao = positiontypedao;
	}

	public ITPositionDao getPositiondao() {
		return positiondao;
	}

	public void setPositiondao(ITPositionDao positiondao) {
		this.positiondao = positiondao;
	}
	public ITFilesDao getFiledao() {
		return filedao;
	}
	public void setFiledao(ITFilesDao filedao) {
		this.filedao = filedao;
	}



	
}

