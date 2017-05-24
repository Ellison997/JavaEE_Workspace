package com.sitcl.mvcoperation.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sitcl.mvcoperation.model.Dorms;
import com.sitcl.mvcoperation.service.DormService;
import com.sitcl.mvcoperation.service.TeachersService;

public class Dorm_DoAdd extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Dorm_DoAdd() {
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
		String did = request.getParameter("did");
		String dcollege = request.getParameter("dcollege");
		String dlocation = request.getParameter("dlocation");
		double dcharge =Double.parseDouble(request.getParameter("dcharge"));
		int dbed=Integer.parseInt(request.getParameter("dbed"));
		int dman=Integer.parseInt(request.getParameter("dman"));
		
		System.out.println(did+" "+dcollege+" "+dlocation+" "+dcharge+" "+dbed+"  "+dman);
		
		Dorms dos=new Dorms();
		dos.setDid(did);
		dos.setDbed(dbed);
		dos.setDcharge(dcharge);
		dos.setDlocation(dlocation);
		dos.setDman(dman);
		dos.setDcollege(dcollege);
		
		DormService dService=new DormService();
		boolean isSuccess = dService.addDorms(dos);
		if (isSuccess) {
			System.out.println("添加成功！");
			request.getRequestDispatcher("dorm_one.jsp").forward(request, response);
		} else {
			System.out.println("添加失败！");
			request.getRequestDispatcher("dorm_add.jsp").forward(request, response);
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
