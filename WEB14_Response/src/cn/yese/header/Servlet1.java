package cn.yese.header;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//û����Ӧ�����������ȥ�ض���servlet2
		//����״̬��302		�ֶ�����http��Ӧ���е�״̬��
		//response.setStatus(302);
		//������ӦͷLocation
		//response.setHeader("Location", "/WEB14_Response/Servlet2");
		
		//��װ��һ���ض���ķ���
		response.sendRedirect("/WEB14_Response/Servlet2");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}