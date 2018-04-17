package com.zking.hr.dao.interfaces.TPosition;

import java.util.List;

import com.zking.hr.dao.IDao;
import com.zking.hr.pojo.TPosition;

public interface ITPositionDao extends IDao<TPosition> {
	/**
	 * ����ְλ����ID����ɾ��
	 */
	public boolean deleteByTypeId(Integer positionTypeId);
	/**
	 * ����ְλ����ID���в�ѯ
	 * @param positionTypeId ְλ����ID
	 * @return
	 */
	public List<TPosition> queryByTypeId(Integer positionTypeId);
	/**
	 * ��ѯ����ְλ��Ϣ
	 * @return
	 */
	public List<TPosition> queryAll(int positionTypeId);
	
}
