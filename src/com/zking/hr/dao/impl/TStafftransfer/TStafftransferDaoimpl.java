package com.zking.hr.dao.impl.TStafftransfer;

import java.io.IOException;
import java.io.Reader;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.zking.hr.dao.interfaces.TStafftransfer.ITstafftransferDao;
import com.zking.hr.pojo.TStafftransfer;
import com.zking.hr.utils.DateUtil.FormatDateUtils;
import com.zking.hr.utils.pageUtils.PageUtils;
import com.zking.hr.view.pojo.TStafftransfer.UpdateStatus;
import com.zking.hr.view.pojo.TStafftransfer.QueryTime;

public class TStafftransferDaoimpl extends SqlMapClientDaoSupport implements ITstafftransferDao{

	public boolean insert(TStafftransfer t) {
			SqlMapClient client = this.getSqlMapClient();
			try {
				client.insert("insertTstaff",t);
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
	}

	public boolean update(TStafftransfer t) {
		SqlMapClient client = this.getSqlMapClient();
			try {
				client.insert("updateTstaff",t);
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
	}

	public boolean delete(Integer id) {
		SqlMapClient client = this.getSqlMapClient();
			try {
				client.insert("deleteTstaff",id);
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
				int countrows = (Integer) client.queryForObject("countrowstaff"); 
				PageUtils page =new PageUtils(countrows);
				System.out.println(countrows);
				page.setIndexPage(indexPage);
				lst =client.queryForList("queryListStaff",page);
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return lst;
	}	

	public boolean updateStatus(Integer id,int status) {
			SqlMapClient client = this.getSqlMapClient();
			UpdateStatus s = new UpdateStatus(id,status);
			try {
				client.insert("updateTstaffstatus",s);
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
	}

	public TStafftransfer queryById(Integer TransferId) {
		TStafftransfer t =null;
		SqlMapClient client = this.getSqlMapClient();
			try {
				t =(TStafftransfer) client.queryForObject("queryStaffId",TransferId);
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return t;
	}

	public List queryByStatus(int status,int indexPage) {
		List lst = new ArrayList();
		SqlMapClient client = this.getSqlMapClient();
			try {
				int countrows = (Integer) client.queryForObject("countrowstaffStatu"); 
				PageUtils page =new PageUtils(countrows);
				page.setIndexPage(indexPage);
				if(status==1){
					lst =client.queryForList("queryListStaffstatu",page);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return lst;
	}

	public List queryByNameAndTime(String staffName, Date beginTime,Date endTime,int indexPage) {
		List lst = new ArrayList();
		SqlMapClient client = this.getSqlMapClient();
			try {
				QueryTime qt = new QueryTime();
				qt.setsName(staffName);
				if(beginTime!=null){
					qt.setBeginTime(beginTime.toString());
				}
				if(endTime!=null){
					qt.setEndTime(endTime.toString());
				}
				qt.setIndexPage(indexPage);
				int countrows = (Integer) client.queryForObject("countrowstaffName",qt); 
				PageUtils page =new PageUtils(countrows);
				page.setIndexPage(indexPage);
				qt.setBeginRow(page.getBeginRow());
				qt.setEndRow(page.getEndRow());
				lst =client.queryForList("queryListStaffName",qt);
				lst.add(page);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return lst;
	}

	public List queryByStatusAndId() {
		List<Integer> staffid =new ArrayList<Integer>();
		SqlMapClient client = this.getSqlMapClient();
			try {
				staffid = client.queryForList("queryListStaffid");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return staffid;
	}

	public TStafftransfer queryBystaffId(Integer staffId) {
		TStafftransfer t = new TStafftransfer();
		SqlMapClient client = this.getSqlMapClient();
			try {
					t= (TStafftransfer)client.queryForObject("querybystaffid",staffId);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return t;
	}
}
