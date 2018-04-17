package com.zking.hr.dao.interfaces.TStafftransfer;

import java.sql.Date;
import java.util.List;

import com.zking.hr.dao.IDao;
import com.zking.hr.pojo.TStafftransfer;

public interface ITstafftransferDao  extends IDao<TStafftransfer>{
	/**
	 * �޸ĸ���״̬ 1.�Ǽ���� 2Ϊ���Ÿ��� 3Ϊ�ֹܸ��ܸ���  4Ϊ�����������Ÿ���      5Ϊ�ܾ�����
	 * @return boolean
	 */
	public boolean updateStatus(Integer id,int status);
	/**
	 * ����ID��ѯ�춯�ľ�����Ա
	 * @param TransferId
	 * @return TStafftransfer
	 */
	public TStafftransfer queryById(Integer TransferId);
	/**
	 * �����춯״̬���в�ѯ ��������
	 * @param status
	 * @return
	 */
	public List queryByStatus(int status,int indexPage);
	/**
	 * ���ݵ�����Ա������ʱ����в�ѯ
	 * @param StaffName
	 * @param Transferdate
	 * @return
	 */
	public List queryByNameAndTime(String StaffName, Date beginTime,Date endTime,int indexPage);
	
	/**
	 * ���ݵ���״̬��ѯԱ��ID
	 * @return Ա��ID
	 */
	public List queryByStatusAndId();
	
	/**
	 * ����Ա��Id��ѯ
	 */
	public TStafftransfer queryBystaffId(Integer staffId);
}
