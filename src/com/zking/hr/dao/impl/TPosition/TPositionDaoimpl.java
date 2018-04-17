package com.zking.hr.dao.impl.TPosition;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.zking.hr.dao.interfaces.TPosition.ITPositionDao;
import com.zking.hr.pojo.TPosition;
import com.zking.hr.utils.pageUtils.PageUtils;

public class TPositionDaoimpl extends SqlMapClientDaoSupport implements ITPositionDao{

	public boolean deleteByTypeId(Integer positionTypeId) {
		SqlMapClient client = this.getSqlMapClient();
		try {
			client.delete("deleteByTypeId",positionTypeId);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List queryByTypeId(Integer positionTypeId) {
		SqlMapClient client =this.getSqlMapClient();
		List lst = null;
		try {
			lst = client.queryForList("queryByTPositionTypeId",positionTypeId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}
	
	/**
	 * ¸ù¾ÝpositionIdÉ¾³ý
	 */
	public boolean delete(Integer id) {
		SqlMapClient client = this.getSqlMapClient();
		try {
			client.delete("deleteByPositionId",id);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean insert(TPosition t) {
		SqlMapClient client = this.getSqlMapClient();
		try {
			client.insert("insertTPosition",t);
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
			Integer countrows = (Integer) client.queryForObject("TPositionCountRow");
			PageUtils page = new PageUtils(countrows);
			if (((indexPage-1)*page.getPageSize())>=countrows) {
				indexPage = indexPage - 1;
			}
			page.setIndexPage(indexPage);
			lst = client.queryForList("queryByTPositionId",page);
			lst.add(page);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}

	public boolean update(TPosition t) {
		
		return false;
	}

	public List<TPosition> queryAll(int positionTypeId) {
		List<TPosition> lst = new ArrayList();
		SqlMapClient client = this.getSqlMapClient();
		try {
			lst = client.queryForList("queryAll",positionTypeId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}
	

}
