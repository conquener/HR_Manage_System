package com.zking.hr.dao.impl.TSalaryPayOffAdd;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.zking.hr.dao.interfaces.TSalaryPayOffAdd.ITSalaryPayOffAdd;
import com.zking.hr.pojo.TsalarypayoffAdd;

public class TSalaryPayOffAddDaoImpl extends SqlMapClientDaoSupport implements ITSalaryPayOffAdd{

	public boolean insert(TsalarypayoffAdd t) {
		SqlMapClient client = this.getSqlMapClient();
		try {
			client.insert("insertTsalarypayoffAdd", t);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(TsalarypayoffAdd t) {
		return false;
	}

	public boolean delete(Integer id) {
		return false;
	}

	public List query(int indexPage) {
		return null;
	}

	public List queryByName(String userName) {
		SqlMapClient client  = this.getSqlMapClient();
		List lst = null;
		try {
			lst = client.queryForList("salarypaydao",userName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}

	public boolean deleteByName(String registerName) {
		SqlMapClient client  = this.getSqlMapClient();
		boolean isSuccess =false;
		try {
			int i = client.delete("salaryAdddeleteByName",registerName);
			if(i>1){
				isSuccess=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return isSuccess;
	}

}
