package com.zking.hr.dao.impl.TProfessional;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.zking.hr.dao.interfaces.TProfessional.ITProfessionalDao;
import com.zking.hr.pojo.TProfessional;
import com.zking.hr.utils.pageUtils.PageUtils;

public class TProfessionalDaoimpl extends SqlMapClientDaoSupport implements ITProfessionalDao{

	public boolean delete(Integer id) {
		SqlMapClient client = this.getSqlMapClient();
			try {
				client.delete("deleteTProfessional",id);
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
	}

	public boolean insert(TProfessional t) {
		SqlMapClient client = this.getSqlMapClient();
		try {
			client.insert("insertTProfessional",t);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List query(int indexPage){
		List lst = null;
		SqlMapClient client = this.getSqlMapClient();
		try {
			Integer countrows = (Integer) client.queryForObject("TProfessionalRowCount");
			PageUtils page = new PageUtils(countrows);
			if (((indexPage-1)*page.getPageSize())>=countrows) {
				indexPage = indexPage - 1;
			}
			page.setIndexPage(indexPage);
			lst = client.queryForList("queryTProfessional",page);
			lst.add(page);
			return lst;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}
	
	
	/**
	 * Ã»ÓÐÐÞ¸Ä
	 */
	public boolean update(TProfessional t) {
		return false;
	}

	public List<TProfessional> querybyAll() {
		List<TProfessional> lst = null;
		SqlMapClient client = this.getSqlMapClient();
		try {
			lst = client.queryForList("queryTProfessionalall");
			return lst;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
		
	}
	
	
}
