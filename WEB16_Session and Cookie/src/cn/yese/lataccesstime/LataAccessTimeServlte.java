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
		// ����һ����ǰʱ�����
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String datee = format.format(date);

		// ����һ��Cookie����
		Cookie cookie = new Cookie("time", datee);
		cookie.setMaxAge(60 * 500);
		cookie.setPath("/web16/lataaccesstime");
		response.addCookie(cookie);

		response.setContentType("text/html;charset=utf-8");
		//��ÿͻ���Я����Cookie����
		Cookie[] cookies = request.getCookies();
		if (cookie != null) {
			for (Cookie cookie2 : cookies) {
				String name = cookie2.getName();
				//ͨ��Cookie���ƻ����Ҫ��cookie
				if (name.equals("time")) {
					//��ø�cookie��ֵ����ӡ
					response.getWriter().write(cookie2.getValue());
				}
			}
		} else {
			response.getWriter().write("���������ǵ�һλ�ÿ�o!");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}