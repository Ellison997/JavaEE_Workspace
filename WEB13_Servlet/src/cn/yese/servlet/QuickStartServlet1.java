package cn.yese.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class QuickStartServlet1 implements Servlet{
	/**
	 * Servlet �������У�
	 * 1����ȡ��������
	 * 2����������
	 * 3�������Ӧ
	 * 
	 * �������ڣ�����һ������Ӵ��������ٵĹ���
	 * Servlet���������ڣ�Servlet�Ӵ��������ٵĹ���
	 * ��ʱ�������û���һ�η���Servlet����Servletʵ������ʵ����
	 * ��ʱ���٣�����Ŀ�ӷ��������Ƴ��Ļ�رշ�������ʱ��
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("�������رգ�������Ŀ�Ƴ���destory()����");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("�ҳ�ʼ���ˣ�");
		System.out.println("��һ�ε��ã���ִ�г�ʼ��������init(ServletConfig)");
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("ÿһ�ε��ã�����ִ��service(ServletRequest,ServletReponse)����");
	}

}
