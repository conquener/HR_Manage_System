package com.zking.hr.biz.interfaces.renli;

import java.util.List;
import java.util.Map;

import com.zking.hr.pojo.TFiles;
import com.zking.hr.pojo.TOrganization;
import com.zking.hr.pojo.TPosition;
import com.zking.hr.pojo.TPositiontype;
import com.zking.hr.pojo.TProfessional;
import com.zking.hr.pojo.TSalarystanderd;
import com.zking.hr.view.pojo.file.QueryFiles;
/**
 * 人力管理biz接口
 * @author HuangPeng
 * @dateTime 2015-444
 * @version 1.0
 */
public interface IRenliBiz {
	/**
	 * 通过部门父Id获取子部门
	 * @param parentOrginzation
	 * @return
	 */
	public List<TOrganization> getOrainzation(int parentOrginzation);
	/**
	 * 获取职位类型
	 * @return
	 */
	public List<TPositiontype> getPositionType();
	/**
	 * 根据职位类型获取职位信息
	 * @return
	 */
	public List<TPosition> getPosition(int positionTypeId);
	/**
	 *获取职称信息 
	 * @return
	 */
	public List<TProfessional> getProfessional();
	/**
	 * 获取薪酬标准
	 * @return
	 */
	public List<TSalarystanderd> getSalarystander();
	/**
	 *文档新增 
	 */
	public Integer registerFiles(TFiles file,Map<String,Object> request);
	/**
	 * 添加文档照片
	 * @return
	 */
	public boolean humanPicture(Integer fileId,String urlpath);
	
	public List<Map<String,Object>> queryFileList(QueryFiles queryFiles,Map<String,Object> request);
	/**
	 * 通过文档id来获取个人文档
	 * @param fileId
	 * @return
	 */
	public Map<String,Object> queryFilesDetails(Integer fileId);
	/**
	 * 修改用户文档
	 * @param file
	 * @return
	 */
	public boolean renliFileUpdate(TFiles file);
	/**
	 * 第一次删除
	 * @param fileId
	 * @return
	 */
	public boolean deleteRenliFile1(Integer fileId);
	/**
	 * 查询一删除的文档
	 * @param queryFiles
	 * @param request
	 * @return
	 */
	public List<Map<String,Object>>  queryFileListDeleted(QueryFiles queryFiles,Map<String,Object> request);
	/**
	 * 恢复档案的删除状态
	 */
	public boolean recoveryRenliFile(Integer fileId);
	
	public boolean deleteForeverRenliFile(Integer fileId);
}
