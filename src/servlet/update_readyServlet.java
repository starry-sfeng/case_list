package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.daoi.IUserLoginDao;
import DAO.daoimpl.UserLoginDaoImpl;
import DAO.pojo.UserLogin;
import util.tableHeaderUtil;
import util.tableValueUtil;
@WebServlet("/updateReady")
public class update_readyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
		
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ele_id = req.getParameter("id");
		String update =req.getParameter("update");
		String tableName = req.getParameter("tableName");
		int id = Integer.parseInt(ele_id);
		List tableHeader = tableHeaderUtil.getTableHeader(tableName);
		List list = tableValueUtil.getTableValue(tableName, id);
		int size = tableHeader.size();
		System.out.println("list: "+list);
		req.setAttribute("tableName", tableName);
		Object message[][] = new Object[size][2];
		for(int i = 0; i<size;i++) {
			message[i][0] = tableHeader.get(i);
			message[i][1] = list.get(i);
		}
		req.setAttribute("message", message);
		req.setAttribute("update", update);
		req.getRequestDispatcher("/update.jsp").forward(req, resp);
		

		
	}
}
