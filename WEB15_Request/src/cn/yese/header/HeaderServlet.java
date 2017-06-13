package cn.yese.header;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeaderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ���е�ͷ
		Enumeration<String> headerNames = request.getHeaderNames();
		//�������ͷ������
		while(headerNames.hasMoreElements()){
			String element = headerNames.nextElement();
			String header = request.getHeader(element);
			System.out.println(element+":"+header);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}