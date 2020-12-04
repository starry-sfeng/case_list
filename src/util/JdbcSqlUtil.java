package util;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class JdbcSqlUtil {
	public static List select_table(String tableName) {
		String query_sql = "select * from "+tableName;
		System.out.println("query sql: "+query_sql);
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		List list = new ArrayList();
		try {
			conn = JdbcUtil.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(query_sql);	
			
			
					
			List tableHeader = tableHeaderUtil.getTableHeader(tableName);
			int length = tableHeader.size();
			
			list.add(tableHeader);
			while(rs.next()) {
				List list2 = new ArrayList();
				for(int i=1; i<=length;i++) {
					list2.add(rs.getObject(i));
				}
				list.add(list2);
					
			}
			
				
		}catch(Exception e) {
			e.printStackTrace();
			System.out.print("返回查询结果集错误");
		}finally {
			JdbcUtil.close(conn, st, rs);
		}
		
		return list;
	}
	
	
	public static String createFile(String tableName, List list) {
		List list2 = (List) list.get(0);
		System.out.println(list2);
		
		File file = new File("C:/RMSDownload");
		file.mkdir();
		String filePath ="C:/RMSDownload/"+tableName+".xls";
		file = new File(filePath);	
		try {
			if (file.exists()) {
				file.delete();
			}
			file.createNewFile();
			WritableWorkbook workbook = Workbook.createWorkbook(file);
			WritableSheet sheet = workbook.createSheet("sheet", 0);
			Label label = null;
			
			for (int i = 0; i<list2.size(); i++) {
                label = new Label(i,0,(String) list2.get(i));
                sheet.addCell(label);   
            }            
            //获取数据源
            for (int i = 1; i < list.size(); i++) {
            	List temp = (List) list.get(i);
                for(int j = 0 ; j<temp.size();j++  ) {
                
                	String value= "" +temp.get(j);
                	
                	label = new Label(j,i,value);
                	sheet.addCell(label);
                }
            }
            workbook.write();    //写入数据        
            workbook.close();  //关闭连接

		} catch (Exception e) {
			e.printStackTrace();
		}
		return filePath;
	}
}
