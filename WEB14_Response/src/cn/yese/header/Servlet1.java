package cn.yese.header;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//没有相应，告诉浏览器去重定向到servlet2
		//设置状态码302		手动设置http响应行中的状态码
		//response.setStatus(302);
		//设置相应头Location
		//response.setHeader("Location", "/WEB14_Response/Servlet2");
		
		//封装的一个重定向的方法
		response.sendRedirect("/WEB14_Response/Servlet2");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}