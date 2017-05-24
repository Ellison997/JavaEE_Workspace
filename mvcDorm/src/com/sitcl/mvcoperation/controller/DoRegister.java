package com.sitcl.mvcoperation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sitcl.mvcoperation.model.Manage;
import com.sitcl.mvcoperation.service.TeachersService;

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

		String tnumber = request.getParameter("tnumber");
		String tpwd = request.getParameter("tpwd");
		String tname=request.getParameter("tname");
		String tphone=request.getParameter("tphone");
		String tcollege=request.getParameter("tcollege");
		/*
		 * String[] habits = request.getParameterValues("habit");
		 	for (int i = 0; i < habits.length; i++) {
			System.out.println(habits[i]);
		}
		*/
		System.out.println(tnumber+"   "+tname+" "+tpwd+"   "+tphone+"  "+tcollege);
		Manage manage=new Manage();
		manage.setTnumber(tnumber);
		manage.setTname(tname);
		manage.setTpwd(tpwd);
		manage.setTphone(tphone);
		manage.setTcollege(tcollege);
		manage.setTsex("");
		manage.setTmanage("");
		manage.setTposition("");
		
		TeachersService tService=new TeachersService();
		boolean isSuccess = tService.register(manage);
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
