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
		//创建属于该客户端（回话）的私有的session区域
		/*
		 * request.getSession()方法会进行内部判断，该客户端是否在服务器已经存在session
		 * 如果该客户端在此服务器不存在session那么就会创建一个新的session对象
		 * 如果该客户端已经存在session，那么就会获得存在的这个session
		 */
		HttpSession session = request.getSession();
		session.setAttribute("name", "chuntian");
		String id = session.getId();	//该session对象的id
		
		//手动创建一个存储JSESSIONID的Cookie,为该cookie设置持久化时间
		Cookie cookie=new Cookie("JSESSIONID", id);
		cookie.setPath("/web16");
		cookie.setMaxAge(60*10);
		
		response.addCookie(cookie);
		
		response.getWriter().write("JSESSIONID："+id);
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}