package com.zking.hr.dao.impl.TOrganization;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.zking.hr.dao.interfaces.TOrganization.ITOrganizationDao;
import com.zking.hr.pojo.TOrganization;
import com.zking.hr.utils.pageUtils.PageUtils;
import com.zking.hr.view.pojo.level.Level;

public class TOrganizationDaoimpl extends SqlMapClientDaoSupport implements ITOrganizationDao{

	public boolean insert(TOrganization t) {
		SqlMapClient client = this.getSqlMapClient();
		try {
			client.insert("insertOrganization",t);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(TOrganization t) {
		SqlMapClient client = this.getSqlMapClient();
		try {
				client.update("updateOrganization",t);
				return true;
			} catch (SQLException e) {
			e.printStackTrace();
			}
		return false;	
	}

	public boolean delete(Integer id) {
		SqlMapClient client = getSqlMapClient();
		try {
			client.delete("deleteOrganization",id);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public List query(int indexPage) {
		SqlMapClient client = getSqlMapClient();
		try {
				int countrows = (Integer) client.queryForObject("countrows");
				PageUtils page = new PageUtils(countrows);
				if (((indexPage-1)*page.getPageSize())>=countrows) {
					indexPage = indexPage - 1;
				}
				page.setIndexPage(indexPage);
				List lst = client.queryForList("queryOrganizationlist",page);
				lst.add(page);
				return lst;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}
	public List<TOrganization> queryByParentId(Integer ParentId) {
		SqlMapClient client = this.getSqlMapClient();
		List lst = new ArrayList();
		try {	
			lst=client.queryForList("queryOrganizationid",ParentId);
			return lst;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return lst;
	}

	public List<Object> queryBylevel(int level, int indexPage) {
		SqlMapClient client = getSqlMapClient();
		List lst=null;
		try {
				Level l = new Level();
				l.setLevel(level);
				int countrows=(Integer) client.queryForObject("countrowLevel",l);
				PageUtils page = new PageUtils(countrows);
				page.setIndexPage(indexPage);
				l.setBeginPage(page.getBeginRow());
				l.setEndPage(page.getEndRow());
				lst = client.queryForList("queryBylevel",l);
				lst.add(page);
				return lst;	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}
	/**
	 * 根据等级查询所有机构
	 */
	public List<TOrganization> queryAllBylevel(int parentOrginzation) {
		SqlMapClient client = getSqlMapClient();
		List lst=null;
		try {
				lst = client.queryForList("queryAllBylevel",parentOrginzation);
				return lst;	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}
	
	public List queryById(Integer id) {
		SqlMapClient client = this.getSqlMapClient();
		List lst = new ArrayList();
		try {	
			lst=client.queryForList("queryByOraganId",id);
			return lst;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return lst;
	}
	
	public List querySecondOra(){
		SqlMapClient client = this.getSqlMapClient();
		List lst = new ArrayList();
		try {	
			lst=client.queryForList("querySecondOra");
			return lst;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return lst;
	}

}
