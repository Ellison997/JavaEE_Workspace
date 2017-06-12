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
		// 获得ServletContext 对象
		ServletContext context = this.getServletContext();
		String initParam = context.getInitParameter("heheda");
		System.out.println(initParam);

		// 2.1获取a.txt
		String urlA = context.getRealPath("/a.txt");
		System.out.println(urlA);
		// 2.2获取b.txt
		String urlB = context.getRealPath("WEB-INF/classes/b.txt");
		System.out.println(urlB);
		// 2.3获取c.txt
		String urlC = context.getRealPath("/WEB-INF/c.txt");
		System.out.println(urlC);
		// 2.4获取d.txt 获取不到

		// 在读取src(classes)下的资源是；可以同类加载器---专门加载classes下的文件的
		// getResource() 获取资源 参数是一个相对地址 相对classes
		String path =Servlet_Context.class.getClassLoader().getResource("b.txt").getPath();
		System.out.println(path);
		
		
		//域对象，向servletContext中存数据
		context.setAttribute("name", "你的笑，我看不见啊！");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}