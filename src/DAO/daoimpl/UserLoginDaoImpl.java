package DAO.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.daoi.IUserLoginDao;
import DAO.pojo.UserLogin;
import util.JdbcUtil;

public class UserLoginDaoImpl implements IUserLoginDao{

	@Override
	public int insert(UserLogin user) {
		int case_id = user.getCase_id();
		String case_name = user.getCase_name();
		String except_result= user.getExcept_result();
		String user_name = user.getUser_name();
		String password = user.getPassword();
		String assert_keyword = user.getAssertion_keyword();
		String run=user.getRun();
		
		String insert_sql = "insert into normal_account_login values(DEFAULT, '"+case_name+"','"+except_result+"','"+user_name+"','"+password+"','"
				            +assert_keyword+"','"+run+"')";
		System.out.println("insert sql: "+ insert_sql);
		Connection conn = null; 
		Statement st = null;
		ResultSet rs = null;
		int line = 0;
		try {
			conn = JdbcUtil.getConnection();
			st = conn.createStatement();
			line = st.executeUpdate(insert_sql);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.print("像数据库插入数据出错");
		}finally {
			JdbcUtil.close(conn, st, rs);
		}
		
		return line;
	}

	@Override
	public int delete(int id) {
		
		String delete_sql = "delete from normal_account_login where case_id = "+id;
		System.out.println("delete sql: "+ delete_sql);
		Connection conn = null; 
		Statement st = null;
		ResultSet rs = null;
		int line = 0;
		
		try {
			
			conn = JdbcUtil.getConnection();
			st = conn.createStatement();
			line = st.executeUpdate(delete_sql);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.print("数据库插入数据出错");
		}finally {
			JdbcUtil.close(conn, st, rs);
		}
		
		return line;
	}

	@Override
	public int delete(UserLogin user) {
		int case_id = user.getCase_id();
		String case_name = user.getCase_name();
		String except_result= user.getExcept_result();
		String user_name = user.getUser_name();
		String password = user.getPassword();
		String assert_keyword = user.getAssertion_keyword();
		String run=user.getRun();
		
		String delete_sql = "delete from normal_account_login where case_id = "+case_id;
		System.out.println("delete sql: "+ delete_sql);
		Connection conn = null; 
		Statement st = null;
		ResultSet rs = null;
		int line = 0;
		
		try {
			
			conn = JdbcUtil.getConnection();
			st = conn.createStatement();
			line = st.executeUpdate(delete_sql);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.print("数据库插入数据出错");
		}finally {
			JdbcUtil.close(conn, st, rs);
		}
		
		return line;
	}

	@Override
	public int update(UserLogin user) {
		int case_id = user.getCase_id();
		String case_name = user.getCase_name();
		String except_result= user.getExcept_result();
		String user_name = user.getUser_name();
		String password = user.getPassword();
		String assert_keyword = user.getAssertion_keyword();
		String run=user.getRun();
		
		String update_sql = "update normal_account_login set case_name = '"+case_name+"', except_result = '"+except_result+"', user_name= '"+ user_name
							+ "', password='"+password+"', assertion_keyword ='"+assert_keyword+"', run='"+run+"' where case_id="+case_id ;
		System.out.println("udapte sql: "+ update_sql);
		Connection conn = null; 
		Statement st = null;
		ResultSet rs = null;
		int line = 0;
		try {
			conn = JdbcUtil.getConnection();
			st = conn.createStatement();
			line = st.executeUpdate(update_sql);
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.print("修改数据库用户信息出错");
		}finally {
			JdbcUtil.close(conn, st, rs);
		}
		return line;
	}

	@Override
	public UserLogin selectById(int id) {
		String query_sql = "select * from normal_account_login where case_id = "+id;
		System.out.println("query sql: "+query_sql);
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		UserLogin user = new UserLogin();
		try {
			conn = JdbcUtil.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query_sql);
			while(rs.next()) {
				user.setCase_id(rs.getInt("case_id"));
				user.setCase_name(rs.getString("case_name"));
				user.setExcept_result(rs.getString("except_result"));
				user.setUser_name(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setAssertion_keyword(rs.getString("assertion_keyword"));
				user.setRun(rs.getString("run"));
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.print("查找用户信息出错");
		}finally {
			JdbcUtil.close(conn, st, rs);
		}
			
		return user;
	}

	@Override
	public List<UserLogin> selectList(String table) {
		// TODO Auto-generated method stub
		List<UserLogin> list = new ArrayList<>();
		String query_sql = "select * from "+table;
		System.out.println("query sql: "+query_sql);
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query_sql);
			while(rs.next()) {
				UserLogin user = new UserLogin();
				user.setCase_id(rs.getInt("case_id"));
				user.setCase_name(rs.getString("case_name"));
				user.setExcept_result(rs.getString("except_result"));
				user.setUser_name(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setAssertion_keyword(rs.getString("assertion_keyword"));
				user.setRun(rs.getString("run"));
				list.add(user);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.print("查找用户信息出错");
		}finally {
			JdbcUtil.close(conn, st, rs);
		}
		
		
		
		return list;
	}

}
