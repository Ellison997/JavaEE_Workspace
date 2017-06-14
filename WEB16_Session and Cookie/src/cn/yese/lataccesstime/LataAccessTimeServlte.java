package cn.yese.lataccesstime;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LataAccessTimeServlte extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 创建一个当前时间对象
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String datee = format.format(date);

		// 创建一个Cookie对象
		Cookie cookie = new Cookie("time", datee);
		cookie.setMaxAge(60 * 500);
		cookie.setPath("/web16/lataaccesstime");
		response.addCookie(cookie);

		response.setContentType("text/html;charset=utf-8");
		//获得客户端携带的Cookie数据
		Cookie[] cookies = request.getCookies();
		if (cookie != null) {
			for (Cookie cookie2 : cookies) {
				String name = cookie2.getName();
				//通过Cookie名称获得想要的cookie
				if (name.equals("time")) {
					//获得该cookie的值并打印
					response.getWriter().write(cookie2.getValue());
				}
			}
		} else {
			response.getWriter().write("哈哈，你是第一位访客o!");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}