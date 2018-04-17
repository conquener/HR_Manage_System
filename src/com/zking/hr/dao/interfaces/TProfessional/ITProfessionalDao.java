package com.zking.hr.dao.interfaces.TProfessional;

import java.util.List;

import com.zking.hr.dao.IDao;
import com.zking.hr.pojo.TProfessional;

public interface ITProfessionalDao extends IDao<TProfessional> {
//只有IDao的实现
	public List querybyAll();
}
