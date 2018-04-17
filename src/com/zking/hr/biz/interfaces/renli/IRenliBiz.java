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
 * ��������biz�ӿ�
 * @author HuangPeng
 * @dateTime 2015-444
 * @version 1.0
 */
public interface IRenliBiz {
	/**
	 * ͨ�����Ÿ�Id��ȡ�Ӳ���
	 * @param parentOrginzation
	 * @return
	 */
	public List<TOrganization> getOrainzation(int parentOrginzation);
	/**
	 * ��ȡְλ����
	 * @return
	 */
	public List<TPositiontype> getPositionType();
	/**
	 * ����ְλ���ͻ�ȡְλ��Ϣ
	 * @return
	 */
	public List<TPosition> getPosition(int positionTypeId);
	/**
	 *��ȡְ����Ϣ 
	 * @return
	 */
	public List<TProfessional> getProfessional();
	/**
	 * ��ȡн���׼
	 * @return
	 */
	public List<TSalarystanderd> getSalarystander();
	/**
	 *�ĵ����� 
	 */
	public Integer registerFiles(TFiles file,Map<String,Object> request);
	/**
	 * ����ĵ���Ƭ
	 * @return
	 */
	public boolean humanPicture(Integer fileId,String urlpath);
	
	public List<Map<String,Object>> queryFileList(QueryFiles queryFiles,Map<String,Object> request);
	/**
	 * ͨ���ĵ�id����ȡ�����ĵ�
	 * @param fileId
	 * @return
	 */
	public Map<String,Object> queryFilesDetails(Integer fileId);
	/**
	 * �޸��û��ĵ�
	 * @param file
	 * @return
	 */
	public boolean renliFileUpdate(TFiles file);
	/**
	 * ��һ��ɾ��
	 * @param fileId
	 * @return
	 */
	public boolean deleteRenliFile1(Integer fileId);
	/**
	 * ��ѯһɾ�����ĵ�
	 * @param queryFiles
	 * @param request
	 * @return
	 */
	public List<Map<String,Object>>  queryFileListDeleted(QueryFiles queryFiles,Map<String,Object> request);
	/**
	 * �ָ�������ɾ��״̬
	 */
	public boolean recoveryRenliFile(Integer fileId);
	
	public boolean deleteForeverRenliFile(Integer fileId);
}
