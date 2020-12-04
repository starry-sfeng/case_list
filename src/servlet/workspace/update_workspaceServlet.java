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
@WebServlet("/update_workspace")
public class update_workspaceServlet extends HttpServlet{

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
		String case_id = req.getParameter("case_id");
		String case_name = req.getParameter("case_name");
		String operation = req.getParameter("operation");
		
		Workspace workspace = new Workspace(Integer.parseInt(case_id), case_name, operation);
		wk.update(workspace);
		
		resp.sendRedirect(req.getContextPath()+"/list_workpace");
		
	}

}
