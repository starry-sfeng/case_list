package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	//private static String driverClassName = "com.mysql.jdbc.Driver";
	//private static String url = "jdbc:mysql://localhost:3306/nextlabs";
	//private static String user = "root";
	//private static String password = "root";
	
	private static Properties pro = new Properties();
	
	static {
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			InputStream stream = loader.getResourceAsStream("db.properties"); 
			pro.load(stream);
		}catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("读取数据库配置文件失败",e);
		}
		
	}
	
	static {
		try {
			Class.forName(pro.getProperty("driverClassName"));
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("数据库驱动加载失败");
			throw new RuntimeException("数据库驱动加载失败",e);
		}
	}
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(pro.getProperty("url"),pro.getProperty("user"), pro.getProperty("password"));
			
		}catch(Exception e) {
			
			e.printStackTrace();
			throw new RuntimeException("数据库连接失败",e);
		}
	
	}
	
	public static void close(Connection conn, Statement st, ResultSet re) {
		try {
			if(re!=null) {
				re.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(st!=null) {
					st.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(conn!=null) {
						conn.close();
					}
				}catch(Exception e) {
					e.printStackTrace();
				}				
			}
			
		}
	}

}
