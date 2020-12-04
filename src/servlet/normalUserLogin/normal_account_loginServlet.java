package servlet.normalUserLogin;

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

@WebServlet("/normal_account_login")
public class normal_account_loginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IUserLoginDao user;
	
	private String tableName =  "normal_account_login";
	private List tableHeader = tableHeaderUtil.getTableHeader(tableName);
	@Override
	public void init() throws ServletException {
		user = new UserLoginDaoImpl();
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {					
			this.list(req, resp);
			
	}
	protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
		List<UserLogin> list = user.selectList("normal_account_login");
		int size = list.size();
		int number = tableHeader.size();
		
		Object allUser[][] = new Object[size][number];
		for(int i=0;i<size;i++) {
			UserLogin user = list.get(i);
			allUser[i][0] = user.getCase_id();
			allUser[i][1] = user.getCase_name();
			allUser[i][2] = user.getExcept_result();
			allUser[i][3] = user.getUser_name();
			allUser[i][4] = user.getPassword();
			allUser[i][5] = user.getAssertion_keyword();
			allUser[i][6] = user.getRun();
			
		}
		req.setAttribute("tableName", tableName);
		req.setAttribute("tableHeader", tableHeader);
		req.setAttribute("user", allUser);
		req.setAttribute("delete", "/delete_normal_account");
		req.setAttribute("update", "/update_noraml_account");
		req.setAttribute("insert", "/insert_normal_account_login");
		
		req.getRequestDispatcher("/list.jsp").forward(req, resp);
	}


}
