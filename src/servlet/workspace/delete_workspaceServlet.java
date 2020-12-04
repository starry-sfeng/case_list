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

@WebServlet("/delete_workspace")
public class delete_workspaceServlet extends HttpServlet {
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
		String ele_id = req.getParameter("id");
		int id = Integer.parseInt(ele_id);
		wk.delete(id);
		resp.sendRedirect(req.getContextPath()+"/list_workpace");
		
	}

}
