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
		//�������������ݵ����룬ֻ�ʺ�POST��ʽ
		request.setCharacterEncoding("utf-8");
		
		//��õ�������ֵ
		String name = request.getParameter("name");
		System.out.println(name);
		String pwd = request.getParameter("pwd");
		System.out.println(pwd);
		//��ö������ֵ
		String[] checkValues = request.getParameterValues("check");
		for (String string : checkValues) {
			System.out.println(string);
		}
		//��ö���������������
		Enumeration<String> parameterNames = request.getParameterNames();
		while(parameterNames.hasMoreElements()){
			String elementNmaes = parameterNames.nextElement();
			System.out.println(elementNmaes);
		}
		
		System.out.println("------------");
		//���˵�еĲ�����������װ��һ��Map<String,String[]>��
		Map<String, String[]> parameterMap = request.getParameterMap();
		//��ȡ���еļ�ֵ��
		for(Map.Entry<String, String[]> entry:parameterMap.entrySet()){
			System.out.println(entry.getKey());
			//���������е�ֵ����ӡ����
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