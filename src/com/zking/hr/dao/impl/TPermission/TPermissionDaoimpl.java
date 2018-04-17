package com.zking.hr.dao.impl.TPermission;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.zking.hr.dao.interfaces.TPermission.ITPermissionDao;
import com.zking.hr.pojo.TPermission;
import com.zking.hr.pojo.TRole;

public class TPermissionDaoimpl extends SqlMapClientDaoSupport implements ITPermissionDao{
	
	public List queryById(Integer permissionId) {
		SqlMapClient client = this.getSqlMapClient();
		List lst = null;
		try {
			lst = client.queryForList("parentIdPermission",permissionId);
			System.out.println(lst.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lst;
	}

	public boolean delete(Integer id) {
		SqlMapClient client = this.getSqlMapClient();
		try {
			client.delete("deleteTPerm",id);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean insert(TPermission t) {
		SqlMapClient client = this.getSqlMapClient();
		try {
			client.delete("insertTPermission",t);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 根据角色Id查询
	 */
	public List<TPermission> query(int roleId){
		List<TPermission> lst = new ArrayList<TPermission>();
			SqlMapClient client = this.getSqlMapClient();
			try {
				lst = client.queryForList("queryTPermission",roleId);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return lst;
	}

	public boolean update(TPermission t) {
		SqlMapClient client = this.getSqlMapClient();
		
		try {
			client.update("updateTPermission",t);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List querybyAll() {
		List lst = new ArrayList();
		SqlMapClient client = this.getSqlMapClient();
		
		try {
			lst = client.queryForList("queryTPermissionAll");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
		}
	
	public List<TRole> getRoleNotPermission(Integer roleId) {
		SqlMapClient client = this.getSqlMapClient();
		try {
			return client.queryForList("getRoleNotPermission",roleId);
		} catch (SQLException e) {
			return null;
		}
	}
	
	}