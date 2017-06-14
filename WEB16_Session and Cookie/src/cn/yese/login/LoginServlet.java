package cn.yese.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//验证码校验
		
		request.setCharacterEncoding("utf-8");
		String check = request.getParameter("check");
		
		HttpSession session = request.getSession();
		String checkSession = (String) session.getAttribute("checkcode_session");
		if(!checkSession.equals(check)){
			request.setAttribute("loginInfo", "验证码错误！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}