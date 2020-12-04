package servlet.workspace;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.daoi.IUserLoginDao;
import DAO.daoi.IWorkspaceDao;
import DAO.daoimpl.UserLoginDaoImpl;
import DAO.daoimpl.WorkspaceDaoImpl;
import DAO.pojo.UserLogin;
import DAO.pojo.Workspace;
@WebServlet("/insert_worksapce")
public class insert_workspaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IWorkspaceDao wk;
	@Override
	public void init() throws ServletException {
		wk = new WorkspaceDaoImpl();
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
		String case_id =  req.getParameter("case_id");
		String case_name = req.getParameter("case_name");
		String operation = req.getParameter("operation");
		int id = Integer.parseInt(case_id);
		
		Workspace workspace = new Workspace();
		workspace.setCase_id(id);
		workspace.setCase_name(case_name);
		workspace.setOperation(operation);
		
		wk.insert(workspace);
		resp.sendRedirect("/nextlabs/list_workpace");
	}
}
