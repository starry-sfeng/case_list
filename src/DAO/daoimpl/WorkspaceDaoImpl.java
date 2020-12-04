package DAO.daoimpl;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.daoi.IWorkspaceDao;
import DAO.pojo.Workspace;

import util.JdbcUtil;
public class WorkspaceDaoImpl implements IWorkspaceDao {
	private String tableName = "workspace";
	@Override
	public int insert(Workspace wk) {
		int case_id = wk.getCase_id();
		String case_name = wk.getCase_name();
		String operation= wk.getOperation();
		
		
		String insert_sql = "insert into " +tableName+ " values(DEFAULT, '"+case_name+"','"+operation+"')";
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
		String delete_sql = "delete from "+ tableName +" where case_id = "+id;
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
	public int update(Workspace wk) {
		int case_id = wk.getCase_id();
		String case_name = wk.getCase_name();
		String operation= wk.getOperation();
	
		String update_sql = "update " +tableName +" set case_name = '"+case_name+"', operation = '"+operation+"' where case_id="+case_id ;
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
	public Workspace selectById(int id) {
		String query_sql = "select * from "+ tableName +" where case_id = "+id;
		System.out.println("query sql: "+query_sql);
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		Workspace wk = new Workspace();
		try {
			conn = JdbcUtil.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query_sql);
			while(rs.next()) {
				wk.setCase_id(rs.getInt("case_id"));
				wk.setCase_name(rs.getString("case_name"));
				wk.setOperation(rs.getString("operation"));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.print("查找用户信息出错");
		}finally {
			JdbcUtil.close(conn, st, rs);
		}
			
		return wk;
	}

	@Override
	public List<Workspace> selectList(String table) {
		List<Workspace> list = new ArrayList<>();
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
				Workspace wk = new Workspace();
				wk.setCase_id(rs.getInt("case_id"));
				wk.setCase_name(rs.getString("case_name"));
				wk.setOperation(rs.getString("operation"));	
				list.add(wk);
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