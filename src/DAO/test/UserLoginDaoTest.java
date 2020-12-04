package DAO.test;

import java.util.List;

import org.junit.Test;

import DAO.daoimpl.UserLoginDaoImpl;
import DAO.pojo.UserLogin;
public class UserLoginDaoTest {
	UserLoginDaoImpl dao = new UserLoginDaoImpl();
	
	@Test
	public void testQuery() {
		List<UserLogin> list = dao.selectList("normal_account_login");
		System.out.print(list);
		
	}
	@Test
	public void testUpdate() {
		UserLogin user = new UserLogin();
		user.setCase_id(1);
		user.setCase_name("normal_account_login");
		user.setExcept_result("success");
		user.setUser_name("starry.feng@nextlabs.com");
		user.setPassword("123blue!");
		user.setAssertion_keyword("35345345");
		user.setRun("yes");
		int line = dao.update(user);
		System.out.println("update "+ line +" line data, user message: "+ user.toString());
	}
	@Test
	public void testInsert() {
		UserLogin user = new UserLogin();
		user.setCase_id(1);
		user.setCase_name("normal_account_login");
		user.setExcept_result("success");
		user.setUser_name("starry.feng@nextlabs.com");
		user.setPassword("123blue!");
		user.setAssertion_keyword("35345345");
		user.setRun("yes");
		
		int line = dao.insert(user);
		System.out.println("insert "+ line +" line data, user message: "+ user.toString());
		
	}
	@Test
	public void testDelete() {
		UserLogin user = new UserLogin();
		user.setCase_id(8);
		user.setCase_name("normal_account_login");
		user.setExcept_result("success");
		user.setUser_name("starry.feng@nextlabs.com");
		user.setPassword("123blue!");
		user.setAssertion_keyword("35345345");
		user.setRun("yes");
		
		int line = dao.delete(user);
		System.out.println("delete "+ line +" line data, user message: "+ user.toString());
		
		
	}
}
