package cn.yese.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�������ڸÿͻ��ˣ��ػ�����˽�е�session����
		/*
		 * request.getSession()����������ڲ��жϣ��ÿͻ����Ƿ��ڷ������Ѿ�����session
		 * ����ÿͻ����ڴ˷�����������session��ô�ͻᴴ��һ���µ�session����
		 * ����ÿͻ����Ѿ�����session����ô�ͻ��ô��ڵ����session
		 */
		HttpSession session = request.getSession();
		session.setAttribute("name", "chuntian");
		String id = session.getId();	//��session�����id
		
		//�ֶ�����һ���洢JSESSIONID��Cookie,Ϊ��cookie���ó־û�ʱ��
		Cookie cookie=new Cookie("JSESSIONID", id);
		cookie.setPath("/web16");
		cookie.setMaxAge(60*10);
		
		response.addCookie(cookie);
		
		response.getWriter().write("JSESSIONID��"+id);
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}