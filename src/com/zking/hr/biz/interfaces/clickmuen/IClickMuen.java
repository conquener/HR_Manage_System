package com.zking.hr.biz.interfaces.clickmuen;

import java.util.Map;

public interface IClickMuen {
	/**
	 * ������һ��Ȩ������ѯ,ʵ�ֵ������
	 * @param parentID
	 * @param session
	 * @return
	 */
	public boolean clickMuen(Integer parentID,Map<String, Object> request);
	
}
