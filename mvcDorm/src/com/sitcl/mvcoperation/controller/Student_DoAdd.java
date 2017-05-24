package com.sitcl.mvcoperation.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sitcl.mvcoperation.model.Student;
import com.sitcl.mvcoperation.service.StudentService;

public class Student_DoAdd extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Student_DoAdd() {
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

		String snumber = request.getParameter("snumber");
		String sname=request.getParameter("sname");
		String ssex=request.getParameter("ssex");
		String sphone=request.getParameter("sphone");
		String saddress=request.getParameter("saddress");
		String scollege=request.getParameter("scollege");
		String sclass=request.getParameter("sclass");
		int sbed=Integer.parseInt(request.getParameter("sbed"));
		
		System.out.println(snumber+" "+sname+" "+ssex+"   "+sphone+"  "+scollege+" "+sbed+" "+saddress+" "+sclass);
		Student stu=new Student();
		stu.setSnumber(snumber);
		stu.setSname(sname);
		stu.setSaddress(saddress);
		stu.setSclass(sclass);
		stu.setScollege(scollege);
		stu.setSsex(ssex);
		stu.setSphone(sphone);
		stu.setSbed(sbed);	
		StudentService sService=new StudentService();
		boolean isSuccess = sService.addStus(stu);
		if (isSuccess) {
			System.out.println("修改成功！");
			request.getRequestDispatcher("student.jsp").forward(request, response);
		} else {
			System.out.println("修改失败！");
			request.getRequestDispatcher("student_add.jsp").forward(request, response);
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
