package com.sitcl.mvcoperation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sitcl.mvcoperation.model.Record;
import com.sitcl.mvcoperation.service.StudentService;

public class Record_DoAdd extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Record_DoAdd() {
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
		String number = request.getParameter("number");
		String name = request.getParameter("name");
		String time = request.getParameter("time");
		String typee = request.getParameter("typee");
		String squad = request.getParameter("squad");
		Record red=new Record();
		red.setName(name);
		red.setNumber(number);
		red.setSquad(squad);
		red.setTime(time);
		red.setTypee(typee);
		
		StudentService sService=new StudentService();
		boolean isSuccess = sService.addRecord(red);
		if (isSuccess) {
			System.out.println("添加成功！");
			request.getRequestDispatcher("record.jsp").forward(request, response);
		} else {
			System.out.println("添加失败！");
			request.getRequestDispatcher("record_add.jsp").forward(request, response);
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
