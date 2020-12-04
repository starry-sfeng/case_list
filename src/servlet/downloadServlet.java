package servlet;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.JdbcSqlUtil;
@WebServlet("/download")
public class downloadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        
        String tableName = req.getParameter("tableName");
        System.out.println("tableName"+ tableName );
        List list = JdbcSqlUtil.select_table(tableName);
        String filePath = JdbcSqlUtil.createFile(tableName, list);
        resp.setHeader("Content-Disposition","attachment;filename="+tableName+".xls");
        //System.out.println(getServletContext().getMimeType(tableName+".xls"));
        resp.setContentType(getServletContext().getMimeType(tableName+".xls"));
        File srcfile = new File(filePath);
        InputStream in = new FileInputStream(srcfile);
        ServletOutputStream stream = resp.getOutputStream();
        
        byte [] buffer = new byte[1024];
        int len = -1;
        while ( (len = in.read(buffer)) !=-1) {
			stream.write(buffer,0,len);
		}
        stream.flush();
        stream.close();
        in.close();
	}
	

	

}
