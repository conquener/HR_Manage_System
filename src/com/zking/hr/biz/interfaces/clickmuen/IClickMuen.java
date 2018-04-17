package com.zking.hr.biz.interfaces.clickmuen;

import java.util.Map;

public interface IClickMuen {
	/**
	 * 根据上一级权限来查询,实现点击功能
	 * @param parentID
	 * @param session
	 * @return
	 */
	public boolean clickMuen(Integer parentID,Map<String, Object> request);
	
}
