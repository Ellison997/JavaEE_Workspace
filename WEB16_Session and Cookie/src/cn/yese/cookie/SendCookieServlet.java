package cn.yese.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendCookieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����Cookie����
		Cookie cookie=new Cookie("name", "zhangshan");
		//����coookie��������ϵĳ־û�ʱ�� --cookie��Ӳ���ϵı���ʱ��
		cookie.setMaxAge(60*100);
		//����coolie��Я��·��
		cookie.setPath("/web16");
		//��cookie�д洢����Ϣ���͵��ͻ���--ͷ
		response.addCookie(cookie);	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}