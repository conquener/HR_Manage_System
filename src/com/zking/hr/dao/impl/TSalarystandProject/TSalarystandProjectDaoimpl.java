package com.zking.hr.dao.impl.TSalarystandProject;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.zking.hr.dao.interfaces.TSalarystandProject.ITSalarystandProjectDao;
import com.zking.hr.pojo.TSalaryproject;
import com.zking.hr.pojo.TSalarystandProject;
import com.zking.hr.utils.pageUtils.PageUtils;

public class TSalarystandProjectDaoimpl extends SqlMapClientDaoSupport implements ITSalarystandProjectDao{

	public boolean insert(TSalarystandProject t) {
			SqlMapClient client = this.getSqlMapClient();
			try {
				client.insert("insertsalaystandP",t);
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
	}

	public boolean update(TSalarystandProject t) {
		SqlMapClient client = this.getSqlMapClient();
			try {
				client.insert("updatesalaystandP",t);
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
	}

	public boolean delete(Integer id) {
		SqlMapClient client = this.getSqlMapClient();
			try {
				client.insert("deletesalaystandP",id);
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
	}

	public List query(int indexPage) {
		List lst = new ArrayList();
		SqlMapClient client = this.getSqlMapClient();
			try {
				int countrows = (Integer) client.queryForObject("countrowtssp"); 
				PageUtils page =new PageUtils(countrows);
				page.setIndexPage(indexPage);
				lst =client.queryForList("queryListtssp",page);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return lst;
	}
	
	public List queryByStand(int standId) {
		List lst = new ArrayList();
		SqlMapClient client = this.getSqlMapClient();
			try {
				lst =client.queryForList("queryListtsspStand",standId);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return lst;
	}

	
}
