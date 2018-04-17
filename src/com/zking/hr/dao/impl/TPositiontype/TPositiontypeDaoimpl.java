package com.zking.hr.dao.impl.TPositiontype;

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
import com.zking.hr.dao.interfaces.TPositiontype.ITPositiontypeDao;
import com.zking.hr.pojo.TPositiontype;
import com.zking.hr.utils.pageUtils.PageUtils;

public class TPositiontypeDaoimpl extends SqlMapClientDaoSupport implements ITPositiontypeDao{

	public boolean delete(Integer id) {
		SqlMapClient client = this.getSqlMapClient();
		try {
			client.delete("deleteTPosT",id);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean insert(TPositiontype t) {
		SqlMapClient client = this.getSqlMapClient();
		try {
			client.insert("insertTPositionType",t);
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
			Integer countrows = (Integer) client.queryForObject("queryTPositionTypeCountRow");
			PageUtils page = new PageUtils(countrows);
			if (((indexPage-1)*page.getPageSize())>=countrows) {
				indexPage = indexPage - 1;
			}
			page.setIndexPage(indexPage);
			lst = client.queryForList("queryTPositionType",page);
			lst.add(page);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}
	
	public List queryAll(){
		List lst = new ArrayList();
		SqlMapClient client = this.getSqlMapClient();
		try {
			lst = client.queryForList("queryPositionTypeAll");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
		
	}

	public boolean update(TPositiontype t) {
		return false;
	}

	public List<TPositiontype> querybyAll() {
		List<TPositiontype> lst = new LinkedList<TPositiontype>();
		SqlMapClient client = this.getSqlMapClient();
		try {
			lst = client.queryForList("queryPostTypeAll");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}
	
	

}
