package com.zking.hr.dao.impl.TFiles;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.Resource;
import org.springframework.orm.ibatis.SqlMapClientFactoryBean;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.zking.hr.dao.interfaces.TFiles.ITFilesDao;
import com.zking.hr.pojo.TFiles;
import com.zking.hr.utils.pageUtils.PageUtils;
import com.zking.hr.view.TFiles.queryByCondiction;
import com.zking.hr.view.TFiles.querySalaryStatus;
import com.zking.hr.view.TFiles.updateSalaryStatus;
import com.zking.hr.view.pojo.file.QueryFiles;
import com.zking.hr.view.pojo.pageRow.pageRow;
import com.zking.hr.view.pojo.salaryquery.SalaryQuery;

public class TFilesDaoImpl extends SqlMapClientDaoSupport implements ITFilesDao{

	public int insertfile(TFiles t) {
			SqlMapClient client = this.getSqlMapClient();
		try{
			return (Integer)client.insert("insertTFiles", t);
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public boolean update(TFiles t) {
		try {
			SqlMapClient client = this.getSqlMapClient();
			int isSuccess = client.update("updateTFiles", t);
			if (isSuccess >= 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public int updateFilesEmpSalaryStatus(){
		try {
			SqlMapClient client = this.getSqlMapClient();
			int isSuccess = client.update("updateFilesEmpSalaryStatus");
			return isSuccess;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * 永久删除档案
	 */
	public boolean delete(Integer id) {
		try {
			SqlMapClient client = this.getSqlMapClient();
			client.delete("deleteTFiles",id);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 不用写
	 * @return
	 */
	public List query() {
		return null;
	}

	public boolean updateAddStatus(Integer fileId) {
		try {
			SqlMapClient client = this.getSqlMapClient();
			client.update("updateTFAddStatus", fileId);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updatedeleteStatus(Integer fileId) {
		try {
			SqlMapClient client = this.getSqlMapClient();
			client.update("updatedelTFStatus",fileId);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public TFiles queryById(Integer fileId) {
		TFiles tf = null;
		try {
			SqlMapClient client = this.getSqlMapClient();
			tf = (TFiles)client.queryForObject("queryByTFilesId",fileId);
			return tf;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tf;
	}
	
	public List queryAddStatus(int indexPage) {
		List lst = null;
		try {
			SqlMapClient client = this.getSqlMapClient();
			PageUtils page = new PageUtils(client.queryForList("CountAddPage",indexPage).size());
			page.setIndexPage(indexPage);
			pageRow pr = new pageRow(page.getBeginRow(), page.getEndRow());
			lst = client.queryForList("queryAddStatus",pr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}

	public List queryBycondition(String firstName, String SecondName, String ThirdName,
			String positionTypeName, String positionName, String beginTime,String endTime, int indexPage) {
		List lst = null;
		try {
			SqlMapClient client = this.getSqlMapClient();
			queryByCondiction qbc= new queryByCondiction(firstName, SecondName, ThirdName, positionTypeName, positionName,beginTime, endTime,null,null);
			PageUtils page = new PageUtils((Integer) client.queryForObject("CountConditionPage",qbc));
			page.setIndexPage(indexPage);
//			queryByCondiction qbc2= new queryByCondiction(firstName, SecondName, ThirdName, positionTypeName, positionName,beginTime.toString(), endTime.toString(), page.getBeginRow(),page.getEndRow());
			qbc.setBeginRow(page.getBeginRow());
			qbc.setEndRow(page.getEndRow());
			lst = client.queryForList("queryByCondition",qbc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}

	public List queryByOrganId(Integer organId){
		List lst = null;
//		try {
//			SqlMapClient client = this.getSqlMapClient();
//			lst = client.queryForList("queryByOrganId",organId);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		return lst;
	}
	public boolean updateBySalaryStatus(int fileId,int status) {
		try {
			SqlMapClient client = this.getSqlMapClient();
			updateSalaryStatus uss = new updateSalaryStatus(fileId, status);
			client.update("updateBySalaryStatus",uss);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<TFiles> queryBySalryStatus(int status,int oraganizationId,int level) {
		List<TFiles> lst = null;
		SqlMapClient client = this.getSqlMapClient();
		querySalaryStatus qss = new querySalaryStatus(status,oraganizationId,level);
		try {
			lst = client.queryForList("querySalaryStatus",qss);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}
	
	/**
	 * 不用写
	 */
	public List query(int indexPage) {
		return null;
	}

	

	public List salarysendquery(SalaryQuery q) {
		List lst = null;
		SqlMapClient client = this.getSqlMapClient();
		try {
			lst = client.queryForList("salarysendqueryes",q);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}

	public Map queryByUserId(Integer userId) {
		Map m = new HashMap();
		SqlMapClient client = this.getSqlMapClient();
		try {
			m = (Map) client.queryForObject("queryByUesrId",userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return m;
	}

	public boolean insert(TFiles t) {
		
		return false;
	}

	public List<Map<String,Object>> queryFileList(QueryFiles queryFiles) {
		List<Map<String,Object>> lst = null;
		SqlMapClient client = this.getSqlMapClient();
		try {
			lst = client.queryForList("queryFiles",queryFiles);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}

	public int queryFilescountRow(QueryFiles queryFiles) {
		SqlMapClient client = this.getSqlMapClient();
		try {
			return (Integer) client.queryForObject("queryFilescountRow",queryFiles);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int queryFileListDeletedcountRow(QueryFiles queryFiles) {
		SqlMapClient client = this.getSqlMapClient();
		try {
			return (Integer) client.queryForObject("queryFileListDeletedcountRow",queryFiles);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public List<Map<String,Object>> queryFileListDeleted(QueryFiles queryFiles) {
		List<Map<String,Object>> lst = null;
		SqlMapClient client = this.getSqlMapClient();
		try {
			lst = client.queryForList("queryFileListDeleted",queryFiles);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}
	
	public Map<String, Object> queryFileById(Integer fileId) {
		SqlMapClient client = this.getSqlMapClient();
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			map =  (Map<String, Object>) client.queryForObject("queryFileById",fileId);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return map;
	}

	public boolean recoveryRenliFile(Integer fileId) {
		try {
			SqlMapClient client = this.getSqlMapClient();
			client.update("updatedelTFStatusDeleted",fileId);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<TFiles> queryByOrganAndSend(Map<String, Object> map) {
		try {
			SqlMapClient client = this.getSqlMapClient();
			List<TFiles> filelst= client.queryForList("queryByOrganAndSend",map);
			return filelst;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public int salarysendqueryCount(SalaryQuery q) {
		
		try {
			SqlMapClient client = this.getSqlMapClient();
			return	(Integer) client.queryForObject("salarysendqueryCount",q);
		} catch (SQLException e) {
			return 0;
		}
	}

	public List<Map<String, Object>> getFileUserName(String inputUserName) {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		try {
			SqlMapClient client = this.getSqlMapClient();
			list = client.queryForList("getFileUserName",inputUserName);
			return list;
		} catch (SQLException e) {
			return null;
		}
	}

}
