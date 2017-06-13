package cn.yese.header;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RefererServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��������Դ�����ж�
		response.setContentType("text/html;charset=utf-8");
		String header = request.getHeader("referer");
		System.out.println(header);
		if(header!=null&&header.startsWith("http://localhost:8080")){
			response.getWriter().write("��ӭ���ʣ��й�I���˸����ƣ�");
		}else{
			response.getWriter().write("��ɵ����");
			
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}