package com.sitcl.mvcoperation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sitcl.mvcoperation.model.User;
import com.sitcl.mvcoperation.service.UsersService;

public class DoRegister extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DoRegister() {
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
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");

		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		String address = request.getParameter("address");
		String strSex = request.getParameter("sex");
		int sex = 0;
		if (strSex != null && !strSex.equals("")) {
			sex = Integer.parseInt(strSex);
		}

		String[] habits = request.getParameterValues("habit");
		for (int i = 0; i < habits.length; i++) {
			System.out.println(habits[i]);
		}

		User user = new User();
		user.setUname(uname);
		user.setUpwd(upwd);
		user.setAddress(address);
		user.setSex(sex);
		UsersService uService=new UsersService();
		boolean isSuccess = uService.register(user);
		if (isSuccess) {
			System.out.println("×¢²á³É¹¦£¡");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			System.out.println("×¢²áÊ§°Ü£¡");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
