package com.zking.hr.dao.impl.TPublicproperty;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.zking.hr.dao.interfaces.TPublicproperty.ITPublicpropertyDao;
import com.zking.hr.pojo.TPublicproperty;
import com.zking.hr.utils.pageUtils.PageUtils;

public class TPublicpropertyDaoimpl extends SqlMapClientDaoSupport implements ITPublicpropertyDao{

	public boolean insert(TPublicproperty t) {
		SqlMapClient client = this.getSqlMapClient();
		try {
			client.insert("insertTPublicproperty",t);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
//不用完成
	public boolean update(TPublicproperty t) {
		return false;
	}

	public boolean delete(Integer id) {
		SqlMapClient client = this.getSqlMapClient();
		try {
			client.delete("deleteTPublicproperty",id);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List query() {
		return null;
	}
	public List query(int indexPage) {
		List lst = new ArrayList();
		SqlMapClient client = this.getSqlMapClient();
		try {
			Integer countrows = (Integer) client.queryForObject("TPublicPropertyRowCount");
			PageUtils page = new PageUtils(countrows);
			if (((indexPage-1)*page.getPageSize())>=countrows) {
				indexPage = indexPage - 1;
			}
			page.setIndexPage(indexPage);
			lst = client.queryForList("queryTPublicProperty",page);
			lst.add(page);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}
	
	
	
}
