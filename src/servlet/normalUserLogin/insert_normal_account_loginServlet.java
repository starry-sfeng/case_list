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
@WebServlet("/insert_normal_account_login")
public class insert_normal_account_loginServlet extends HttpServlet {
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
		String case_id =  req.getParameter("case_id");
		String case_name = req.getParameter("case_name");
		String except_result = req.getParameter("except_result");
		String user_name = req.getParameter("user_name");
		String password = req.getParameter("password");
		String assertion_keyword = req.getParameter("assertion_keyword");
		String run = req.getParameter("run");
		int id = Integer.parseInt(case_id);
		
		UserLogin userLogin = new UserLogin();
		userLogin.setCase_id(id);
		userLogin.setCase_name(case_name);
		userLogin.setExcept_result(except_result);
		userLogin.setUser_name(user_name);
		userLogin.setPassword(password);
		userLogin.setAssertion_keyword(assertion_keyword);
		userLogin.setRun(run);
		user.insert(userLogin);
		resp.sendRedirect("/nextlabs/normal_account_login");
	}
}
