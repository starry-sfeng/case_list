package servlet.normalUserLogin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.daoi.IUserLoginDao;
import DAO.daoimpl.UserLoginDaoImpl;
import DAO.pojo.UserLogin;
@WebServlet("/update_noraml_account")
public class update_normal_accountServlet extends HttpServlet{

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
		
		String case_id = req.getParameter("case_id");
		String case_name = req.getParameter("case_name");
		String except_result = req.getParameter("except_result");
		String user_name = req.getParameter("user_name");
		String password = req.getParameter("password");
		String assertion_keyword = req.getParameter("assertion_keyword");
		String run = req.getParameter("run");
		
		UserLogin userLogin = new UserLogin(Integer.parseInt(case_id), case_name, except_result, user_name, password, assertion_keyword, run);
		user.update(userLogin);
		
		resp.sendRedirect(req.getContextPath()+"/normal_account_login");
		
	}

}
