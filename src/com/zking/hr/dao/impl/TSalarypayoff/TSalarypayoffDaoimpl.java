package com.zking.hr.dao.impl.TSalarypayoff;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.zking.hr.dao.interfaces.TSalarypayoff.ITSalarypayoffDao;
import com.zking.hr.pojo.TSalarypayoff;

public class TSalarypayoffDaoimpl extends SqlMapClientDaoSupport implements ITSalarypayoffDao{

	public boolean insert(TSalarypayoff t) {
//		Reader read;
//		try {
//			read = Resources.getResourceAsReader("SqlMapConfig.xml");
//			SqlMapClient client = SqlMapClientBuilder.buildSqlMapClient(read);
//			try {
//				client.insert("inserttspayoff",t);
//				return true;
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		return false;
	}

	public boolean update(TSalarypayoff t) {
		SqlMapClient client = this.getSqlMapClient();
		try {
				client.update("updatetspayoff",t);
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
		}

	public boolean delete(Integer id) {
//		Reader read;
//		try {
//			read = Resources.getResourceAsReader("SqlMapConfig.xml");
//			SqlMapClient client = SqlMapClientBuilder.buildSqlMapClient(read);
//			try {
//				client.delete("deletetsspayoff",id);
//				return true;
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		return false;
	}

	public List query(int indexPage) {
//		Reader read;
//		List lst = new ArrayList(); 
//		try {
//			read = Resources.getResourceAsReader("SqlMapConfig.xml");
//			SqlMapClient client = SqlMapClientBuilder.buildSqlMapClient(read);
//			TSalarypayoff t = null;
//			try {
//				int countrows = (Integer) client.queryForObject("countrowtsspayoff");
//				System.out.println(countrows);
//				PageUtils page = new PageUtils(countrows);
//				page.setIndexPage(indexPage);
//				lst=client.queryForList("queryListtsspayoff",page);
//				read.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return lst;
		return null;
	}
	
	public List<TSalarypayoff> query(){
		List<TSalarypayoff> lst = new ArrayList<TSalarypayoff>(); 
		SqlMapClient client = this.getSqlMapClient();
		try {
			lst=client.queryForList("querypayoff");
			} catch (SQLException e) {
				e.printStackTrace();
		}
		return lst;
	}
	
}
