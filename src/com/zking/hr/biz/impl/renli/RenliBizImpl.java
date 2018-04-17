package com.zking.hr.biz.impl.renli;

import java.util.List;
import java.util.Map;

import com.zking.hr.biz.interfaces.renli.IRenliBiz;
import com.zking.hr.dao.impl.TFiles.TFilesDaoImpl;
import com.zking.hr.dao.interfaces.TFiles.ITFilesDao;
import com.zking.hr.dao.interfaces.TOrganization.ITOrganizationDao;
import com.zking.hr.dao.interfaces.TPosition.ITPositionDao;
import com.zking.hr.dao.interfaces.TPositiontype.ITPositiontypeDao;
import com.zking.hr.dao.interfaces.TProfessional.ITProfessionalDao;
import com.zking.hr.dao.interfaces.TSalarystanderd.ITSalarystanderdDao;
import com.zking.hr.pojo.TFiles;
import com.zking.hr.pojo.TOrganization;
import com.zking.hr.pojo.TPosition;
import com.zking.hr.pojo.TPositiontype;
import com.zking.hr.pojo.TProfessional;
import com.zking.hr.pojo.TSalarystanderd;
import com.zking.hr.utils.pageUtils.PageUtils;
import com.zking.hr.view.pojo.file.QueryFiles;

public class RenliBizImpl implements IRenliBiz{
	private ITFilesDao filesdao;
	private ITOrganizationDao organDao;
	private ITPositiontypeDao postiDao;
	private ITPositionDao positionDao;
	private ITProfessionalDao proDao;
	private ITSalarystanderdDao tssstanderDao;
	
	
	public List<TOrganization> getOrainzation(int parentOrginzation) {
		List<TOrganization> list = organDao.queryAllBylevel(parentOrginzation);
		return list;
	}


	public List<TPositiontype> getPositionType() {
		return postiDao.querybyAll();
	}
	

	public List<TPosition> getPosition(int positionTypeId) {
		return positionDao.queryAll(positionTypeId);
	}
	
	public List<TProfessional> getProfessional() {
		return proDao.querybyAll();
	}
	public List<TSalarystanderd> getSalarystander() {
		return tssstanderDao.queryStanderAll();
	}

	public Integer registerFiles(TFiles file, Map<String, Object> request) {
		
		return filesdao.insertfile(file);
	}
	

	public boolean humanPicture(Integer fileId, String urlpath) {
		TFiles t = new TFiles();
		t.setFilesFilesid(fileId);
		t.setImageurl(urlpath);
		return filesdao.update(t);
	}
	

	public List<Map<String,Object>> queryFileList(QueryFiles queryFiles,Map<String,Object> request) {
		int countRow = filesdao.queryFilescountRow(queryFiles);
		PageUtils page = new PageUtils(countRow);
		if(queryFiles.getIndexPage()==null){
			queryFiles.setIndexPage(1);
		}
		page.setIndexPage(queryFiles.getIndexPage());
		page.setPageSize(5);
		queryFiles.setStartRow(page.getBeginRow());
		queryFiles.setEndRow(page.getEndRow());
		request.put("queryFiles", queryFiles);
		request.put("page",page);
		return filesdao.queryFileList(queryFiles);
		
	}
	
	public List<Map<String,Object>> queryFileListDeleted(QueryFiles queryFiles,
			Map<String, Object> request) {
		int countRow = filesdao.queryFileListDeletedcountRow(queryFiles);
		PageUtils page = new PageUtils(countRow);
		if(queryFiles.getIndexPage()==null){
			queryFiles.setIndexPage(1);
		}
		page.setIndexPage(queryFiles.getIndexPage());
		page.setPageSize(5);
		queryFiles.setStartRow(page.getBeginRow());
		queryFiles.setEndRow(page.getEndRow());
		request.put("queryFiles", queryFiles);
		request.put("page",page);
		return filesdao.queryFileListDeleted(queryFiles);
	}
	
	public Map<String,Object> queryFilesDetails(Integer fileId) {
		Map<String,Object> file = filesdao.queryFileById(fileId);
		return file;
	}


	public boolean renliFileUpdate(TFiles file) {
		return filesdao.update(file);
	}

	public boolean deleteRenliFile1(Integer fileId) {
		return filesdao.updatedeleteStatus(fileId);
	}


	public boolean recoveryRenliFile(Integer fileId) {
		filesdao.recoveryRenliFile(fileId);
		return false;
	}

	public boolean deleteForeverRenliFile(Integer fileId) {
		return	filesdao.delete(fileId);
	}

	
	
	/*---------------------------*/
	public ITFilesDao getFilesdao() {
		return filesdao;
	}
	public void setFilesdao(ITFilesDao filesdao) {
		this.filesdao = filesdao;
	}
	public ITOrganizationDao getOrganDao() {
		return organDao;
	}
	public void setOrganDao(ITOrganizationDao organDao) {
		this.organDao = organDao;
	}
	public ITPositiontypeDao getPostiDao() {
		return postiDao;
	}
	public void setPostiDao(ITPositiontypeDao postiDao) {
		this.postiDao = postiDao;
	}
	public ITPositionDao getPositionDao() {
		return positionDao;
	}
	public void setPositionDao(ITPositionDao positionDao) {
		this.positionDao = positionDao;
	}
	public ITProfessionalDao getProDao() {
		return proDao;
	}
	public void setProDao(ITProfessionalDao proDao) {
		this.proDao = proDao;
	}
	public ITSalarystanderdDao getTssstanderDao() {
		return tssstanderDao;
	}
	public void setTssstanderDao(ITSalarystanderdDao tssstanderDao) {
		this.tssstanderDao = tssstanderDao;
	}

}
