package com.zking.hr.dao.impl.TSalaryproject;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.zking.hr.dao.interfaces.TSalaryproject.ITSalaryprojectDao;
import com.zking.hr.pojo.TSalaryproject;
import com.zking.hr.utils.pageUtils.PageUtils;

public class TSalaryprojectDaoimpl extends SqlMapClientDaoSupport implements ITSalaryprojectDao{

	public boolean insert(TSalaryproject t) {
		SqlMapClient client = this.getSqlMapClient();
		try {
				client.insert("insertsalarypro",t);
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
	}

	public boolean update(TSalaryproject t) {
		SqlMapClient client = this.getSqlMapClient();
		try {
				client.update("updatesalarypro",t);
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
		}


	public boolean delete(Integer id) {
		SqlMapClient client = this.getSqlMapClient();
		try {
				client.delete("deletesalarypro",id);
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
	}


	public List query(int indexPage) {
		SqlMapClient client = this.getSqlMapClient();
		List lst = new ArrayList(); 
		try {
			TSalaryproject t = null;
				int countrows = (Integer) client.queryForObject("queryCountsalarypro");
				PageUtils page = new PageUtils(countrows);
				if (((indexPage-1)*page.getPageSize())>=countrows) {
					indexPage = indexPage - 1;
				}
				page.setIndexPage(indexPage);
				lst=client.queryForList("querysalarypro",page);
				lst.add(page);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return lst;
	}
	public List<TSalaryproject> queryAllSp() {
		List<TSalaryproject> lst = new LinkedList<TSalaryproject>();
		SqlMapClient client = this.getSqlMapClient();
			try {
				lst =client.queryForList("queryAllSp");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return lst;
	}
}
