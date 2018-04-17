package com.zking.hr.biz.interfaces.customization;

import java.util.Map;

import com.zking.hr.pojo.TOrganization;
import com.zking.hr.pojo.TProfessional;

public interface ICustomization {
	
	public boolean showOrganization(Map<String, Object> request,int level,int indexPage);
	public boolean updateOrgan(TOrganization o);
	public boolean deleteOrgan(String organizationID);
	public boolean insertOrgan(TOrganization o);
	public boolean updateProfessional(TProfessional p);
	public boolean deleteProfessional(String professionalID);
	public boolean insertProfessional(TOrganization o);
	public boolean showProfessional(Map<String, Object> request);
	
	
	
}
