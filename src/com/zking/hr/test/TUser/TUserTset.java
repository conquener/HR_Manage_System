package com.zking.hr.test.TUser;

import static org.junit.Assert.*;

import org.junit.Test;

import com.zking.hr.dao.impl.TUser.TUserDaoimpl;
import com.zking.hr.pojo.TUser;

public class TUserTset {

	@Test
	public void testInsert() {
		TUserDaoimpl udao = new TUserDaoimpl();
		TUser u= new TUser(1, null, null, null, null, 1, null, 1, null, 1, null);
		System.out.println(udao.insert(u));
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testQuery() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryByNameAndPwd() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryById() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateByUserNameAndRole() {
		TUserDaoimpl udao = new TUserDaoimpl();
		TUser u = udao.queryByNameAndPwd("", "");
		System.out.println(u.getUserName());
	}

	@Test
	public void testDeleteRoleByUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateRoleAddStatus() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateRoleRollbackStatus() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdatePwdByUser() {
		fail("Not yet implemented");
	}

}
