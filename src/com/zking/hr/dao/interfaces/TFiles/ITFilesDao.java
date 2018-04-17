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
	 * �����ļ���ID�����µ����ĸ���״̬
	 * @param fileId
	 * @return
	 */
	public boolean updateAddStatus(Integer fileId);
	
	/**
	 * �����ļ���ID�����µ�����ɾ��״̬
	 * @param fileId
	 * @return
	 */
	public boolean updatedeleteStatus(Integer fileId);
	/**
	 * ���ݵ���ID����ѯ����
	 * @param fileId
	 * @return
	 */
	public TFiles queryById(Integer fileId);
	/**
	 * ���ݸ��˵�״̬����ѯ
	 * @param status
	 * @return
	 */
	public List queryAddStatus(int indexPage);
	/**
	 * ����������ѯ
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
	 * ����organization��id���в�ѯ
	 * @param OrganId
	 * @return
	 */
	public List queryByOrganId(Integer OrganId);
	/**
	 * �����ĵ�ID���޸�нˮ����״̬
	 * @param fileId
	 * @return
	 */
	public boolean updateBySalaryStatus(int fileId,int status);
	/**
	 * ����нˮ����״̬���в�ѯ
	 * @param salaryStatus
	 * @return
	 */
	public List queryBySalryStatus(int Status,int oraganization,int level);
	
	
	/**
	 * ��ѯнˮ������Ա��Ϣ
	 */
	public List salarysendquery(SalaryQuery q);
	
	/**
	 * ����Ա��ID��ѯԱ������
	 * @return Map
	 */
	public Map queryByUserId(Integer userID);
	/**
	 * �����ĵ�
	 * @param file
	 * @return
	 */
	public int insertfile(TFiles file);
	
	public List<Map<String,Object>> queryFileList(QueryFiles queryFiles);
	/**
	 * ��ѯ������
	 * @param queryFiles
	 * @return
	 */
	public int queryFilescountRow(QueryFiles queryFiles);
	
	public Map<String,Object> queryFileById(Integer fileId);
	/**
	 * ��ѯ��ɾ����������
	 * @return
	 */
	public int queryFileListDeletedcountRow(QueryFiles queryFiles);
	/**
	 *��ѯ��һ��ɾ�����ĵ�
	 */
	public List<Map<String,Object>> queryFileListDeleted(QueryFiles queryFiles);
	/**
	 * �ָ���һ��ɾ�����ĵ�
	 * @return
	 */
	public boolean recoveryRenliFile(Integer fileId);
	/**
	 * ����Ա����н�귢��״̬
	 * @return
	 */
	public int updateFilesEmpSalaryStatus();
	/**
	 * ���ݻ�����нˮ����״̬
	 * @param map
	 * @return
	 */
	public List<TFiles> queryByOrganAndSend(Map<String,Object> map);
	/**
	 * ���ݻ�����нˮ����״̬��ѯ����
	 */
	public int salarysendqueryCount(SalaryQuery q);
	/**
	 * ��������ģ������
	 * @param inputUserName
	 * @return
	 */
	public List<Map<String, Object>> getFileUserName(String inputUserName);
	
}
