package com.zking.hr.biz.impl.register;

import com.zking.hr.biz.interfaces.register.IRegisterBiz;
import com.zking.hr.dao.impl.TUser.TUserDaoimpl;
import com.zking.hr.dao.interfaces.TUser.ITUserDao;
import com.zking.hr.pojo.TUser;

public class registerBizImpl implements IRegisterBiz{
	private ITUserDao registerdao;
	
	

	public ITUserDao getRegisterdao() {
		return registerdao;
	}



	public void setRegisterdao(ITUserDao registerdao) {
		this.registerdao = registerdao;
	}



	public boolean register(TUser u) {
		return registerdao.insert(u);
	}
	
}
