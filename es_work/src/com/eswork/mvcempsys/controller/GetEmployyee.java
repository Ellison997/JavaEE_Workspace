package com.eswork.mvcempsys.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eswork.mvcempsys.model.Employee;
import com.eswork.mvcempsys.service.EmpService;

public class GetEmployyee extends HttpServlet {

	public GetEmployyee() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		String emName = request.getParameter("em_name");
		String psName = request.getParameter("ps_name");
		//System.out.println(emName + "     " + psName);
		EmpService eService = new EmpService();
		ArrayList<Employee> list = null;
		try {
			if (emName.equals("")||emName.equals(null)) {
				list = eService.getEmployee(psName);
			} else {
				list = eService.getEmployee(psName, emName);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 把数据传递给对应的页面
		HttpSession session = request.getSession();
		session.setAttribute("emp", list);
		request.getRequestDispatcher("employeeShow.jsp").forward(request,
				response);

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

	public void init() throws ServletException {
		// Put your code here
	}

}
