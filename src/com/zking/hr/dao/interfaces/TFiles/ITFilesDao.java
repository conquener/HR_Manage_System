package com.zking.hr.dao.interfaces.TFiles;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.zking.hr.dao.IDao;
import com.zking.hr.pojo.TFiles;
import com.zking.hr.view.pojo.file.QueryFiles;
import com.zking.hr.view.pojo.salaryquery.SalaryQuery;

public interface ITFilesDao extends IDao<TFiles>{
	/**
	 * 根据文件的ID来更新档案的复核状态
	 * @param fileId
	 * @return
	 */
	public boolean updateAddStatus(Integer fileId);
	
	/**
	 * 根据文件的ID来更新档案的删除状态
	 * @param fileId
	 * @return
	 */
	public boolean updatedeleteStatus(Integer fileId);
	/**
	 * 根据档案ID来查询档案
	 * @param fileId
	 * @return
	 */
	public TFiles queryById(Integer fileId);
	/**
	 * 根据复核的状态来查询
	 * @param status
	 * @return
	 */
	public List queryAddStatus(int indexPage);
	/**
	 * 根据条件查询
	 * @param firstID
	 * @param SecondId
	 * @param ThirdId
	 * @param positionTypeId
	 * @param positionName
	 * @param time
	 * @return
	 */
	public List queryBycondition(String firstName, String SecondName, String ThirdName,
			String positionTypeName, String positionName, String beginTime,String endTime, int indexPage);
	/**
	 * 根据organization的id进行查询
	 * @param OrganId
	 * @return
	 */
	public List queryByOrganId(Integer OrganId);
	/**
	 * 根据文档ID来修改薪水发放状态
	 * @param fileId
	 * @return
	 */
	public boolean updateBySalaryStatus(int fileId,int status);
	/**
	 * 根据薪水发放状态进行查询
	 * @param salaryStatus
	 * @return
	 */
	public List queryBySalryStatus(int Status,int oraganization,int level);
	
	
	/**
	 * 查询薪水发放人员信息
	 */
	public List salarysendquery(SalaryQuery q);
	
	/**
	 * 根据员工ID查询员工档案
	 * @return Map
	 */
	public Map queryByUserId(Integer userID);
	/**
	 * 插入文挡
	 * @param file
	 * @return
	 */
	public int insertfile(TFiles file);
	
	public List<Map<String,Object>> queryFileList(QueryFiles queryFiles);
	/**
	 * 查询总行数
	 * @param queryFiles
	 * @return
	 */
	public int queryFilescountRow(QueryFiles queryFiles);
	
	public Map<String,Object> queryFileById(Integer fileId);
	/**
	 * 查询已删除的总行数
	 * @return
	 */
	public int queryFileListDeletedcountRow(QueryFiles queryFiles);
	/**
	 *查询第一次删除的文档
	 */
	public List<Map<String,Object>> queryFileListDeleted(QueryFiles queryFiles);
	/**
	 * 恢复第一次删除的文挡
	 * @return
	 */
	public boolean recoveryRenliFile(Integer fileId);
	/**
	 * 更改员工的薪酬发放状态
	 * @return
	 */
	public int updateFilesEmpSalaryStatus();
	/**
	 * 根据机构和薪水发放状态
	 * @param map
	 * @return
	 */
	public List<TFiles> queryByOrganAndSend(Map<String,Object> map);
	/**
	 * 根据机构和薪水发放状态查询总数
	 */
	public int salarysendqueryCount(SalaryQuery q);
	/**
	 * 根据姓名模糊搜索
	 * @param inputUserName
	 * @return
	 */
	public List<Map<String, Object>> getFileUserName(String inputUserName);
	
}
