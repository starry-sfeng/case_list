package servlet.workspace;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.daoi.IWorkspaceDao;
import DAO.daoimpl.WorkspaceDaoImpl;
import DAO.pojo.Workspace;
import util.tableHeaderUtil;

@WebServlet("/list_workpace")
public class List_workspaceServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IWorkspaceDao wk;
	
	private String tableName =  "workspace";
	private List tableHeader = tableHeaderUtil.getTableHeader(tableName);
	@Override
	public void init() throws ServletException {
		wk = new WorkspaceDaoImpl();
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {					
			this.list(req, resp);
			
	}
	protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
		List<Workspace> list = wk.selectList(tableName);
		int size = list.size();
		int number = tableHeader.size();
		
		Object allUser[][] = new Object[size][number];
		for(int i=0;i<size;i++) {
			Workspace workspace = list.get(i);
			allUser[i][0] = workspace.getCase_id();
			allUser[i][1] = workspace.getCase_name();
			allUser[i][2] = workspace.getOperation();		
		}
		req.setAttribute("tableName", tableName);
		req.setAttribute("tableHeader", tableHeader);
		req.setAttribute("user", allUser);
		req.setAttribute("delete", "/delete_workspace");
		req.setAttribute("update", "/update_workspace");
		req.setAttribute("insert", "/insert_worksapce");
		
		req.getRequestDispatcher("/list.jsp").forward(req, resp);
	}


}
