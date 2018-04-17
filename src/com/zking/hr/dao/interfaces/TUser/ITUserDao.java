package com.zking.hr.dao.interfaces.TUser;

import java.util.List;

import com.zking.hr.dao.IDao;
import com.zking.hr.pojo.TRole;
import com.zking.hr.pojo.TUser;

public interface ITUserDao extends IDao<TUser> {
	/**
	 * �����û��� ��������в�ѯ(��¼)
	 * @param userName
	 * @param userPwd
	 * @return
	 */
	public TUser queryByNameAndPwd(String userName,String userPwd);
	/**
	 * �����û�id���в�ѯ
	 * @param tUserid
	 * @return
	 */
	public TUser queryById(Integer tUserid);
	/**
	 * �����û������޸��û���ɫ����ID
	 * @param userName
	 * @param roleName
	 * @param roleId
	 * @return boolean
	 */
	public boolean updateByUserNameAndRole(Integer userId,String roleName,int roleId);
	/**
	 * ɾ���û���ɫ
	 * @return boolean
	 */
	public boolean deleteRoleByUser(Integer userId);
	/**
	 * ���Ľ�ɫ����״̬
	 * @param userId
	 * @return
	 */
	public boolean updateRoleAddStatus(String userName);
	/**
	 * �޸��û�����״̬
	 * @param userId
	 * @return
	 */
	public boolean updateRoleRollbackStatus(Integer userId);
	/**
	 * �����û�Id��ԭ������в�ѯ
	 * @param NewuserPwd
	 * @param userPwd
	 * @param userId
	 * @return boolean
	 */
	public boolean updatePwdByUser(String NewuserPwd,String userPwd,String userId);
	
	/**
	 * �������ֲ�ѯ
	 * @param checkUserName
	 * @return boolean
	 */
	public boolean querybyName(String checkUserName);
	
	//��ѯ��ɫδ���˵��û�
	public List querybystatus(Integer indexPage);
	/**
	 * �����û���ģ��ƥ��
	 * @param userName
	 * @return
	 */
	public List<TUser> rolesetUserLike(String userName);

}
