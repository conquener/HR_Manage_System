package com.zking.hr.dao.interfaces.TProfessional;

import java.util.List;

import com.zking.hr.dao.IDao;
import com.zking.hr.pojo.TProfessional;

public interface ITProfessionalDao extends IDao<TProfessional> {
//ֻ��IDao��ʵ��
	public List querybyAll();
}
