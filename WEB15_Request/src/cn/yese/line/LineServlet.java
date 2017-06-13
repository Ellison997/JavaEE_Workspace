package cn.yese.line;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LineServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取请求方式
		String method=request.getMethod();
		System.out.println(method);
		String header = request.getHeader("User-Agent");
		System.out.println(header);
		//获取请求资源的相关内容
		String requestURI = request.getRequestURI();
		System.out.println(requestURI);
		StringBuffer requestURL = request.getRequestURL();
		System.out.println(requestURL);
		//获得WEB应用的名称
		String contextPath = request.getContextPath();
		System.out.println(contextPath);
		//地址后的参数的字符串  get请求方式才有
		String queryString = request.getQueryString();
		System.out.println(queryString);
		//获得客户机的信息--获得访问者的IP
		String remoteAddr = request.getRemoteAddr();
		System.out.println(remoteAddr);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}