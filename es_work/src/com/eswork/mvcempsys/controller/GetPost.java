package com.eswork.mvcempsys.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eswork.mvcempsys.dao.PostDAO;
import com.eswork.mvcempsys.model.Post;
import com.eswork.mvcempsys.service.PostService;

public class GetPost extends HttpServlet {

	public GetPost() {
		super();
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PostService psService =new PostService();
		ArrayList<Post> list = null;
		try {
			list = psService.getPost();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//把数据传递给对应的页面
		HttpSession session = request.getSession();
		session.setAttribute("posts", list);
		request.getRequestDispatcher("employeeSearch.jsp").forward(request, response);
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
