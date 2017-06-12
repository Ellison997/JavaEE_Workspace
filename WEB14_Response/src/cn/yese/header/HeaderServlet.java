package cn.yese.header;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeaderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//…Ë÷√œÏ”¶Õ∑
		Date date=new Date();
		response.addHeader("name", "zhangshan");
		response.addDateHeader("birthday", date.getTime());
		response.addIntHeader("age", 287);
		
		response.addHeader("name", "ÃÔ¥∫¿÷");
		response.addHeader("name", "tianchunel");
		
		response.setIntHeader("age", 25);
		response.setHeader("name","nidexioa");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}