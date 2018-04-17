package com.zking.hr.dao.impl.TSalarystanderd;

import java.io.IOException;
import java.io.Reader;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.zking.hr.dao.interfaces.TSalarystanderd.ITSalarystanderdDao;
import com.zking.hr.pojo.TSalarystanderd;
import com.zking.hr.utils.DateUtil.FormatDateUtils;
import com.zking.hr.utils.pageUtils.PageUtils;
import com.zking.hr.view.pojo.Salarystanderd.QueryTimeName;

public class TSalarystanderdDaoimpl extends SqlMapClientDaoSupport implements ITSalarystanderdDao{

	public boolean insert(TSalarystanderd t) {
			SqlMapClient client = this.getSqlMapClient();
			try {
				client.insert("insertsalaystand",t);
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
	}

	public Integer updateInteger(TSalarystanderd t) {
		SqlMapClient client = this.getSqlMapClient();
		Integer in = 0;
			try {
				in= client.update("updatesalaystand",t);
				return in;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return in;
	}
	public boolean  update(TSalarystanderd t) {
		return false;
	}
	
	
	public boolean delete(Integer id) {
		SqlMapClient client = this.getSqlMapClient();
			try {
				client.insert("deletesalaystand",id);
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
				int countrows = (Integer) client.queryForObject("countrowtstp"); 
				PageUtils page =new PageUtils(countrows);
				page.setIndexPage(indexPage);
				lst =client.queryForList("queryListtstp",page);
				lst.add(page);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return lst;
	}

	public boolean updateStatus(int salaryStandId) {
		SqlMapClient client = this.getSqlMapClient();
			try {
				client.insert("updatesalaystandstatus",salaryStandId);
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
	}

	public List queryByStatus(int indexPage) {
		List lst = new ArrayList();
		SqlMapClient client = this.getSqlMapClient();
			try {
				int countrows = (Integer) client.queryForObject("countrowtstpstatus"); 
				PageUtils page =new PageUtils(countrows);
				page.setIndexPage(indexPage);
				lst =client.queryForList("queryListtstpstatus",page);
				lst.add(page);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return lst;
	}

	public List queryByIdName_Time( String salaryStandName,String begintime,String endtime,int indexPage) {
		List lst = new ArrayList();
		SqlMapClient client = this.getSqlMapClient();
			try {
				QueryTimeName t = new QueryTimeName();
				t.setBegintime(begintime);
				t.setEndtime(endtime);
				t.setSalaryStandName(salaryStandName);
				int countrows = (Integer) client.queryForObject("countrowtss",t); 
				PageUtils page =new PageUtils(countrows);
				page.setIndexPage(indexPage);
				t.setBeginRow(page.getBeginRow());
				t.setEndRow(page.getEndRow());
				lst =client.queryForList("queryListtss",t);
				lst.add(page);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return lst;
	}

	public TSalarystanderd queryById(int salaryStandId) {
		TSalarystanderd t = null;
		SqlMapClient client = this.getSqlMapClient();
			try {
				t =(TSalarystanderd) client.queryForObject("queryListtstpsid",salaryStandId);			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return t;
	}

	public int insertStand(TSalarystanderd t1) {
		SqlMapClient client = this.getSqlMapClient();
		try {
			Integer i= (Integer) client.insert("insertsalaystand",t1);
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public List<TSalarystanderd> queryStanderAll() {
		SqlMapClient client = this.getSqlMapClient();
		List<TSalarystanderd> lst=null;
		try {
			lst= client.queryForList("queryStanderAll");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}
	

}
