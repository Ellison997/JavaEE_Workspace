package cn.yese.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendCookieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建Cookie对象
		Cookie cookie=new Cookie("name", "zhangshan");
		//设置coookie在浏览器上的持久化时间 --cookie在硬盘上的保存时间
		cookie.setMaxAge(60*100);
		//设置coolie的携带路径
		cookie.setPath("/web16");
		//将cookie中存储的信息发送到客户端--头
		response.addCookie(cookie);	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}