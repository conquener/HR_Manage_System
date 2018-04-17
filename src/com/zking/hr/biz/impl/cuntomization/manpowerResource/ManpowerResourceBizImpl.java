package com.zking.hr.biz.impl.cuntomization.manpowerResource;

import java.util.List;
import java.util.Map;

import com.zking.hr.biz.interfaces.customization.manpowerResource.IManpowerResourceBiz;
import com.zking.hr.dao.impl.TOrganization.TOrganizationDaoimpl;
import com.zking.hr.dao.impl.TPosition.TPositionDaoimpl;
import com.zking.hr.dao.impl.TPositiontype.TPositiontypeDaoimpl;
import com.zking.hr.dao.impl.TProfessional.TProfessionalDaoimpl;
import com.zking.hr.dao.impl.TPublicproperty.TPublicpropertyDaoimpl;
import com.zking.hr.dao.interfaces.TFiles.ITFilesDao;
import com.zking.hr.pojo.TFiles;
import com.zking.hr.pojo.TOrganization;
import com.zking.hr.pojo.TPosition;
import com.zking.hr.pojo.TPositiontype;
import com.zking.hr.pojo.TProfessional;
import com.zking.hr.pojo.TPublicproperty;

public class ManpowerResourceBizImpl implements IManpowerResourceBiz{
	private TOrganizationDaoimpl organDao;
	
	private TProfessionalDaoimpl professionDao;
	
	private TPositiontypeDaoimpl positionTDao;
	
	private TPositionDaoimpl positionDao;
	
	private TPublicpropertyDaoimpl publicDao;
	
	private ITFilesDao filesdao;
	
	public List<Map<String, Object>> getFileUserName(String inputUserName){
		return filesdao.getFileUserName(inputUserName);
	}


	

	public boolean deleteOrgan(Integer organizationID) {
		organDao.delete(organizationID);
		return true;
	}

	public boolean deleteProfessional(Integer professionalID) {
		professionDao.delete(professionalID);
		return true;
	}

	public boolean insertOrgan(TOrganization o) {
		organDao.insert(o);
		return true;
	}

	public boolean insertProfessional(TProfessional o) {
		professionDao.insert(o);
		return true;
	}

	public boolean showOrganization(Map<String, Object> request, int level,
			int indexPage) {
		List lst = organDao.queryBylevel(level, indexPage);
		request.put("Organization", lst);
		if(lst.size()>1){
			request.put("OrganizationSize", lst.size());
		}
		if (lst != null) {
			return true;
		}
		return false;
	}

	public boolean showProfessional(Map<String, Object> request,int indexPage) {
		List lst = professionDao.query(indexPage);
		request.put("profeesion", lst);
		request.put("professionSize", lst.size());
		return true;
	}

	public boolean updateOrgan(TOrganization o) {
		organDao.update(o);
		return true;
	}

	public boolean updateProfessional(TProfessional p) {
		return false;
	}

	public boolean showPositiontype(Map<String, Object> request, int indexPage) {
		List lst = positionTDao.query(indexPage);
		request.put("positionType", lst);
		request.put("positionTypeSize", lst.size());
		return true;
	}

	public boolean showPosition(Map<String, Object> request, int indexPage) {
		List lst = positionDao.query(indexPage);
		request.put("position", lst);
		request.put("positionSize", lst.size());
		return true;
	}

	public boolean showPublicProperty(Map<String, Object> request, int indexPage) {
		List lst = publicDao.query(indexPage);
		request.put("publicProperty", lst);
		request.put("publicPropertySize", lst.size());
		return true;
	}

	public boolean queryOraganById(Integer id,Map<String, Object> request) {
		List lst = organDao.queryById(id);
		request.put("organ", lst);
		return true;
	}

	public boolean queryByParentId(Integer id,Map<String, Object> request) {
		List lst = organDao.queryByParentId(id);
		request.put("oragan", lst);
		return true;
	}

	public boolean querySecondOra(Map<String, Object> request) {
		List lst = organDao.querySecondOra();
		request.put("oragan", lst);
		return true;
	}

	public boolean deletePositionType(int id) {
		positionTDao.delete(id);
		return true;
	}

	public boolean insertPositionType(TPositiontype tp) {
		positionTDao.insert(tp);
		return true;
	}

	public boolean deletePosition(Integer id) {
		positionDao.delete(id);
		return true;
	}

	public boolean insertPosition(TPosition t) {
		positionDao.insert(t);
		return false;
	}

	public boolean queryPositionTypeAll(Map<String, Object> request) {
		List lst = positionTDao.queryAll();
		request.put("PType",lst);
		return false;
	}

	public boolean deletePublicProperty(Integer id) {
		publicDao.delete(id);
		return false;
	}

	public boolean insertPublicProperty(TPublicproperty tp) {
		publicDao.insert(tp);
		return false;
	}

	public ITFilesDao getFilesdao() {
		return filesdao;
	}

	public void setFilesdao(ITFilesDao filesdao) {
		this.filesdao = filesdao;
	}
	public TPublicpropertyDaoimpl getPublicDao() {
		return publicDao;
	}

	public void setPublicDao(TPublicpropertyDaoimpl publicDao) {
		this.publicDao = publicDao;
	}

	public TPositionDaoimpl getPositionDao() {
		return positionDao;
	}

	public void setPositionDao(TPositionDaoimpl positionDao) {
		this.positionDao = positionDao;
	}

	public TPositiontypeDaoimpl getPositionTDao() {
		return positionTDao;
	}

	public void setPositionTDao(TPositiontypeDaoimpl positionTDao) {
		this.positionTDao = positionTDao;
	}

	public TProfessionalDaoimpl getProfessionDao() {
		return professionDao;
	}

	public void setProfessionDao(TProfessionalDaoimpl professionDao) {
		this.professionDao = professionDao;
	}

	public TOrganizationDaoimpl getOrganDao() {
		return organDao;
	}

	public void setOrganDao(TOrganizationDaoimpl organDao) {
		this.organDao = organDao;
	}
	
	
	

}
