package com.zking.hr.dao.interfaces.TStafftransfer;

import java.sql.Date;
import java.util.List;

import com.zking.hr.dao.IDao;
import com.zking.hr.pojo.TStafftransfer;

public interface ITstafftransferDao  extends IDao<TStafftransfer>{
	/**
	 * 修改复核状态 1.登记完毕 2为部门复核 3为分管副总复核  4为人事行政部门复核      5为总经理复核
	 * @return boolean
	 */
	public boolean updateStatus(Integer id,int status);
	/**
	 * 根据ID查询异动的具体人员
	 * @param TransferId
	 * @return TStafftransfer
	 */
	public TStafftransfer queryById(Integer TransferId);
	/**
	 * 根据异动状态进行查询 加载数据
	 * @param status
	 * @return
	 */
	public List queryByStatus(int status,int indexPage);
	/**
	 * 根据调动的员工名和时间进行查询
	 * @param StaffName
	 * @param Transferdate
	 * @return
	 */
	public List queryByNameAndTime(String StaffName, Date beginTime,Date endTime,int indexPage);
	
	/**
	 * 根据调动状态查询员工ID
	 * @return 员工ID
	 */
	public List queryByStatusAndId();
	
	/**
	 * 根据员工Id查询
	 */
	public TStafftransfer queryBystaffId(Integer staffId);
}
