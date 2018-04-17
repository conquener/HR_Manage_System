package com.zking.hr.dao.impl.TOrderPerformance;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.zking.hr.dao.interfaces.TOrderPerformance.ITOrderPerformanceDao;
import com.zking.hr.pojo.TOrderPerformance;

public class TOrderPerformanceDaoimpl extends SqlMapClientDaoSupport implements ITOrderPerformanceDao{
	/**
	 * 没有删除
	 */
	public boolean delete(Integer id) {
		return false;
	}

	public boolean insert(TOrderPerformance t) {
//		try {
//			Reader read = Resources.getResourceAsReader("SqlMapConfig.xml");
//			SqlMapClient client = SqlMapClientBuilder.buildSqlMapClient(read);
//			client.insert("insertOrderPerFromance", t);
//			return true;
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		return false;
	}
	/**
	 * 没有分页查询
	 */
	public List query(int indexPage) {
		return null;
	}
	
	/**
	 * 查询
	 */
	public List query(){
		List lst = null ;
		SqlMapClient client = this.getSqlMapClient();
		try {
			lst = client.queryForList("queryOrderPermance");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}
	
	public boolean update(TOrderPerformance t) {
		SqlMapClient client = this.getSqlMapClient();
		try {
			client.update("updateOrderPerformance",t);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public List queryById(Integer id) {
		List lst = new ArrayList();
		SqlMapClient client = this.getSqlMapClient();
		try {
			lst = client.queryForList("queryOrderPerById",id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}

}
