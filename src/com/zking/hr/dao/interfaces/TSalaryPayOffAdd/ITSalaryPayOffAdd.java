package com.zking.hr.dao.interfaces.TSalaryPayOffAdd;

import java.util.List;

import com.zking.hr.dao.IDao;
import com.zking.hr.pojo.TsalarypayoffAdd;

public interface ITSalaryPayOffAdd extends IDao<TsalarypayoffAdd>{
	public List queryByName(String userName);
	public boolean deleteByName(String registerName);
}
