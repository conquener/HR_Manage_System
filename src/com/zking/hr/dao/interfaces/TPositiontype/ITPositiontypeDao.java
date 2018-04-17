package com.zking.hr.dao.interfaces.TPositiontype;

import java.util.List;

import com.zking.hr.dao.IDao;
import com.zking.hr.pojo.TPositiontype;

public interface ITPositiontypeDao  extends IDao<TPositiontype>{
//只有IDao的增删改查	
	public List querybyAll();
	
}
