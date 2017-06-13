package cn.yese.line;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LineServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ����ʽ
		String method=request.getMethod();
		System.out.println(method);
		String header = request.getHeader("User-Agent");
		System.out.println(header);
		//��ȡ������Դ���������
		String requestURI = request.getRequestURI();
		System.out.println(requestURI);
		StringBuffer requestURL = request.getRequestURL();
		System.out.println(requestURL);
		//���WEBӦ�õ�����
		String contextPath = request.getContextPath();
		System.out.println(contextPath);
		//��ַ��Ĳ������ַ���  get����ʽ����
		String queryString = request.getQueryString();
		System.out.println(queryString);
		//��ÿͻ�������Ϣ--��÷����ߵ�IP
		String remoteAddr = request.getRemoteAddr();
		System.out.println(remoteAddr);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}