package com.sitcl.mvcoperation.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sitcl.mvcoperation.model.Manage;
import com.sitcl.mvcoperation.service.TeachersService;

public class Teacher_DoUpdate extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Teacher_DoUpdate() {
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
		
		request.setCharacterEncoding("UTF-8");

		String tnumber = request.getParameter("tnumber");
		String tname=request.getParameter("tname");
		String tsex=request.getParameter("tsex");
		String tphone=request.getParameter("tphone");
		String tmanage=request.getParameter("tmanage");
		String tcollege=request.getParameter("tcollege");
		String tposition=request.getParameter("tposition");
		/*
		 * String[] habits = request.getParameterValues("habit");
		 	for (int i = 0; i < habits.length; i++) {
			System.out.println(habits[i]);
		}
		*/
		System.out.println(tnumber+" "+tname+" "+tsex+"   "+tphone+"  "+tcollege+" "+tmanage+" "+tposition);
		Manage manage=new Manage();
		manage.setTnumber(tnumber);
		manage.setTname(tname);
		manage.setTsex(tsex);
		manage.setTphone(tphone);
		manage.setTcollege(tcollege);
		manage.setTmanage(tmanage);
		manage.setTposition(tposition);
		
		TeachersService tService=new TeachersService();
		boolean isSuccess = tService.update(manage);
		if (isSuccess) {
			System.out.println("修改成功！");
			request.getRequestDispatcher("teacher.jsp").forward(request, response);
		} else {
			System.out.println("修改失败！");
			request.getRequestDispatcher("teacher_update.jsp").forward(request, response);
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
