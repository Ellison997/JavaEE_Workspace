package cn.yese.loginServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.yese.DataSource.C3P0Utils;
import cn.yese.domain.User;

public class logins extends HttpServlet {
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		int count=0;
		this.getServletContext().setAttribute("count", count);
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		String userName=request.getParameter("username");
		String userPwd=request.getParameter("userpassword");
		QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
		String sql="select * from users where uname=? and upassword=?";
		User user=null;
		try {
			//使用QueryRunner.query的时候javaBean中不能有有参构造只能有set,get方法
			user=(User)qr.query(sql, new BeanHandler<User>(User.class), userName,userPwd);
			//用户登录成功
			if(user!=null){
				ServletContext context = this.getServletContext();
				Integer count=(Integer) context.getAttribute("count");
				++count;
				response.getWriter().write(user.toString()+"你是第几位登录者："+count);
				context.setAttribute("count",count);
			}else{
				response.getWriter().write("请检测程序！");
				System.out.println("戳了");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}