package cn.yese.cotnet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决请求接收数据的乱码，只适合POST方式
		request.setCharacterEncoding("utf-8");
		
		//获得单个表单的值
		String name = request.getParameter("name");
		System.out.println(name);
		String pwd = request.getParameter("pwd");
		System.out.println(pwd);
		//获得多个表单的值
		String[] checkValues = request.getParameterValues("check");
		for (String string : checkValues) {
			System.out.println(string);
		}
		//获得多个请求参数的名称
		Enumeration<String> parameterNames = request.getParameterNames();
		while(parameterNames.hasMoreElements()){
			String elementNmaes = parameterNames.nextElement();
			System.out.println(elementNmaes);
		}
		
		System.out.println("------------");
		//获得说有的参数，参数封装到一个Map<String,String[]>中
		Map<String, String[]> parameterMap = request.getParameterMap();
		//获取所有的键值对
		for(Map.Entry<String, String[]> entry:parameterMap.entrySet()){
			System.out.println(entry.getKey());
			//遍历出所有的值并打印出来
			for(String s:entry.getValue()){
				System.out.println(s);
			}
			System.out.println("------------------");
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}