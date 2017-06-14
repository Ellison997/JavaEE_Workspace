package cn.yese.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveCookieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//清除cookie
		//创建一个Cookie对象
		Cookie cookie=new Cookie("name","");
		//设置cookie持久化存在的时间为0
		cookie.setMaxAge(0);
		//将path设置为要删除的cookie的path一致
		cookie.setPath("/web16");
		response.addCookie(cookie);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}