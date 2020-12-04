package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/loginPage")
public class PageLoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("UTF-8");
		ServletContext context = this.getServletContext();
		
		String userErrorMsg ="";
		String passwordErrorMsg="";
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if(username!=null && !username.equals("admin")) {
			userErrorMsg = "username not exist";
			req.setAttribute("userErrorMsg", userErrorMsg);
			System.out.println(userErrorMsg);
			req.getRequestDispatcher("/LoginAdmin.jsp").forward(req, resp);
			return;
		}
		if(password!=null && !password.equals("123blue!")) {
			passwordErrorMsg = "password not exist";
			req.setAttribute("passwordErrorMsg", passwordErrorMsg);
			req.getRequestDispatcher("/LoginAdmin.jsp").forward(req, resp);
			System.out.println(passwordErrorMsg);
			return;
		}
		Cookie cookie = new Cookie("accurentUser", username);
		resp.addCookie(cookie);
		System.out.println("ok");
		resp.sendRedirect(context.getContextPath()+"/menu.jsp");
		
		
	}

}
