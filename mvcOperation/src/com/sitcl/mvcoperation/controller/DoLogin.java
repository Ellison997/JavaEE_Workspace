package com.sitcl.mvcoperation.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.sitcl.mvcoperation.model.User;
import com.sitcl.mvcoperation.service.UsersService;


public class DoLogin extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DoLogin() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String uname=null;
		String upwd=null;
		uname = request.getParameter("uname");
		upwd = request.getParameter("upwd");
		System.out.println(uname+" ... "+upwd);
		if(uname != null && upwd != null) {
			UsersService uService = new UsersService();
			User user = uService.login(uname, upwd);
			if(user != null) {
				//权限
				System.out.println("存在用户信息！");
				session.setAttribute("user", user.getUname());
				//进入主界面
				response.sendRedirect("index.jsp");
			} else {
				request.setAttribute("error", "用户名或密码错误");
				//重新登录
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("error", "用户名和密码均不能为空");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
