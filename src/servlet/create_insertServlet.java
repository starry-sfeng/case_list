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

import util.tableHeaderUtil;
@WebServlet("/createInsert")
public class create_insertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String insert = req.getParameter("insert");
		String tableName = req.getParameter("tableName");
		List tableHeader = tableHeaderUtil.getTableHeader(tableName);
		req.setAttribute("tableHeader", tableHeader);
		req.setAttribute("tableName", tableName);
		req.setAttribute("insert", insert);
		req.getRequestDispatcher("/insert.jsp").forward(req, resp);
	}
}
