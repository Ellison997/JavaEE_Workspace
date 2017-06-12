package cn.yese.loginServlet;

import java.io.IOException;

import javax.naming.Context;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet_Context extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���ServletContext ����
		ServletContext context = this.getServletContext();
		String initParam = context.getInitParameter("heheda");
		System.out.println(initParam);

		// 2.1��ȡa.txt
		String urlA = context.getRealPath("/a.txt");
		System.out.println(urlA);
		// 2.2��ȡb.txt
		String urlB = context.getRealPath("WEB-INF/classes/b.txt");
		System.out.println(urlB);
		// 2.3��ȡc.txt
		String urlC = context.getRealPath("/WEB-INF/c.txt");
		System.out.println(urlC);
		// 2.4��ȡd.txt ��ȡ����

		// �ڶ�ȡsrc(classes)�µ���Դ�ǣ�����ͬ�������---ר�ż���classes�µ��ļ���
		// getResource() ��ȡ��Դ ������һ����Ե�ַ ���classes
		String path =Servlet_Context.class.getClassLoader().getResource("b.txt").getPath();
		System.out.println(path);
		
		
		//�������servletContext�д�����
		context.setAttribute("name", "���Ц���ҿ���������");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}