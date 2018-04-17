package com.zking.hr.biz.impl.clickMenu;

import java.util.List;
import java.util.Map;

import com.zking.hr.biz.interfaces.clickmuen.IClickMuen;
import com.zking.hr.dao.interfaces.TPermission.ITPermissionDao;
import com.zking.hr.pojo.TPermission;

public class clickMenuBizImpl implements IClickMuen{
	private ITPermissionDao clickpermissondao;
	
	public boolean clickMuen(Integer parentID, Map<String, Object> request) {
		List tp = clickpermissondao.queryById(parentID);
		request.put("menuPermission", tp);
		return false;
	}


	public ITPermissionDao getClickpermissondao() {
		return clickpermissondao;
	}


	public void setClickpermissondao(ITPermissionDao clickpermissondao) {
		this.clickpermissondao = clickpermissondao;
	}
	

}
