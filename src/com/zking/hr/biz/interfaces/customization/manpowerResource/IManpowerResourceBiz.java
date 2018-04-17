package com.zking.hr.biz.interfaces.customization.manpowerResource;

import java.util.List;
import java.util.Map;

import javax.swing.text.Position;

import com.zking.hr.pojo.TOrganization;
import com.zking.hr.pojo.TPosition;
import com.zking.hr.pojo.TPositiontype;
import com.zking.hr.pojo.TProfessional;
import com.zking.hr.pojo.TPublicproperty;

public interface IManpowerResourceBiz {
	public boolean showOrganization(Map<String, Object> request,int level,int indexPage);
	public boolean updateOrgan(TOrganization o);
	public boolean deleteOrgan(Integer organizationID);
	public boolean insertOrgan(TOrganization o);
	public boolean updateProfessional(TProfessional p);
	public boolean deleteProfessional(Integer professionalID);
	public boolean insertProfessional(TProfessional o);
	public boolean showProfessional(Map<String, Object> request,int indexPage);
	public boolean showPositiontype(Map<String, Object> request,int indexPage);
	public boolean deletePositionType(int id);
	public boolean insertPositionType(TPositiontype tp);
	public boolean queryPositionTypeAll(Map<String, Object> request);
	public boolean showPosition(Map<String, Object> request,int indexPage);
	public boolean deletePosition(Integer id);
	public boolean insertPosition(TPosition t);
	public boolean showPublicProperty(Map<String, Object> request,int indexPage);
	public boolean deletePublicProperty(Integer id);
	public boolean insertPublicProperty(TPublicproperty tp);
	public boolean queryOraganById(Integer id,Map<String, Object> request);
	public boolean queryByParentId(Integer id,Map<String, Object> request);
	public boolean querySecondOra(Map<String, Object> request);
	public List<Map<String,Object>> getFileUserName(String inputUserName);
	
}
