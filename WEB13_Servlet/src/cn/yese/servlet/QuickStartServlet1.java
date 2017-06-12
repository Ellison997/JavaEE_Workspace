package cn.yese.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class QuickStartServlet1 implements Servlet{
	/**
	 * Servlet 的任务有：
	 * 1、获取请求数据
	 * 2、处理请求
	 * 3、完成响应
	 * 
	 * 生命周期：就是一个对象从创建到销毁的过程
	 * Servlet的生命周期：Servlet从创建到销毁的过程
	 * 何时创建：用户第一次访问Servlet创建Servlet实例（单实例）
	 * 何时销毁：当项目从服务器中移除的或关闭服务器的时候
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("服务器关闭，或者项目移除：destory()方法");
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
		System.out.println("我初始化了！");
		System.out.println("第一次调用，将执行初始化方法：init(ServletConfig)");
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("每一次调用，都将执行service(ServletRequest,ServletReponse)方法");
	}

}
