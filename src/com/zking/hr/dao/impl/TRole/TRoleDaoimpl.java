package com.zking.hr.dao.impl.TRole;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.zking.hr.dao.interfaces.TRole.ITRole;
import com.zking.hr.pojo.TRole;
import com.zking.hr.utils.pageUtils.PageUtils;

public class TRoleDaoimpl extends SqlMapClientDaoSupport implements ITRole{

	public boolean insert(TRole t) {
		try {
			SqlMapClient client = this.getSqlMapClient();
			client.insert("insertTRole",t);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(TRole t) {
		try {
			SqlMapClient client = this.getSqlMapClient();
			client.update("updateTRole",t);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(Integer id) {
		try {
			SqlMapClient client = this.getSqlMapClient();
			client.delete("deleteTRole",id);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public TRole queryById(Integer roleId) {
		TRole role = null;
		try {
			SqlMapClient client = this.getSqlMapClient();
			role = (TRole) client.queryForObject("queryByRoleId",roleId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return role;
	}
	
	public List query(int indexPage) {
		List lst = new ArrayList();
		SqlMapClient client = this.getSqlMapClient();
		try{
			PageUtils page = new PageUtils((Integer) client.queryForObject("TRoleRowCount"));
			page.setIndexPage(indexPage);
			lst = client.queryForList("queryTrole",page);
			lst.add(page);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}

	public List<TRole> queryall() {
		List<TRole> lst = new ArrayList<TRole>();
		SqlMapClient client = this.getSqlMapClient();
		try{
			lst = client.queryForList("queryTroleall");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;		
	}

	

}
