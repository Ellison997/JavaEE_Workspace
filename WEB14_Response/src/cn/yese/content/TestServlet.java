package cn.yese.content;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����response��ѯ�����
		//response.setCharacterEncoding("utf-8");
		//��֪�ͻ���Ҫʹ���������
		//response.setHeader("Content-Type", "text/html;charset=utf-8");
		
		//�����������÷�װ�ķ������
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.write("�Ҳ������ַ����룡");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}