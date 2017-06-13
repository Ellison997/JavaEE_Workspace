package cn.yese.header;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RefererServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//对新闻来源进行判断
		response.setContentType("text/html;charset=utf-8");
		String header = request.getHeader("referer");
		System.out.println(header);
		if(header!=null&&header.startsWith("http://localhost:8080")){
			response.getWriter().write("欢迎访问，中国I拿了个金牌！");
		}else{
			response.getWriter().write("别傻吊！");
			
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}