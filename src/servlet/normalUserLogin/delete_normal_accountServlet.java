package servlet.normalUserLogin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.daoi.IUserLoginDao;
import DAO.daoimpl.UserLoginDaoImpl;

@WebServlet("/delete_normal_account")
public class delete_normal_accountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUserLoginDao user;
	@Override
	public void init() throws ServletException {
		user = new UserLoginDaoImpl();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
		String ele_id = req.getParameter("id");
		int id = Integer.parseInt(ele_id);
		user.delete(id);
		resp.sendRedirect(req.getContextPath()+"/normal_account_login");
		
	}

}
