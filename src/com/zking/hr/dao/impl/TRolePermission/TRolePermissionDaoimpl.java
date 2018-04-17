package com.zking.hr.dao.impl.TRolePermission;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.zking.hr.dao.interfaces.TRolePermission.ITRolePermissionDao;
import com.zking.hr.pojo.TRolePermission;
import com.zking.hr.utils.pageUtils.PageUtils;
import com.zking.hr.xml.ibatis.pojo.RoleIdPermissionId;

public class TRolePermissionDaoimpl extends SqlMapClientDaoSupport implements ITRolePermissionDao{

	public boolean insertByRoleAddPer(Integer RoleId, Integer permisssId) {
		return false;
	}

	public boolean delete(Integer id) {
		try {
			SqlMapClient client = this.getSqlMapClient();
			client.delete("deleterolepermiss",id);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean delete(Integer roleId,Integer permissionId){
		try {
			SqlMapClient client = this.getSqlMapClient();
			RoleIdPermissionId rpid = new RoleIdPermissionId(roleId,permissionId);
			client.delete("deleteTRolePermission",rpid);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean insert(TRolePermission t) {
		try {
			SqlMapClient client = this.getSqlMapClient();
			client.insert("insertTRolePermission",t);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List query(int indexPage) {
		List lst = new ArrayList();
		try {
			SqlMapClient client = this.getSqlMapClient();
			PageUtils page = new PageUtils((Integer) client.queryForObject("TRolePermissionRowCount"));
			page.setIndexPage(indexPage);
			lst = client.queryForList("queryTRolePermission",page);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}

	public boolean update(TRolePermission t) {
		try {
			SqlMapClient client = this.getSqlMapClient();
			client.update("updateTRolePermission",t);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List queryroleAndPremiss(Integer indexPage){
		List lst = new ArrayList();
		try {
			SqlMapClient client = this.getSqlMapClient();
			PageUtils page = new PageUtils((Integer) client.queryForObject("queryroleAndPremissCount"));
			page.setIndexPage(indexPage);
			lst = client.queryForList("queryroleAndPremiss",page);
			lst.add(page);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}
}