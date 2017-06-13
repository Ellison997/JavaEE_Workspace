package cn.yese.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.yese.register.User;
import cn.yese.utils.C3P0Utils;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����û���������
		request.setCharacterEncoding("utf-8");
		String uname = request.getParameter("username");
		String upwd = request.getParameter("password");
		System.out.println(uname+"     "+upwd);
		//����һ��ҵ������и��û���ѯ
		User login=null;
		login=login(uname, upwd);
		
		if(login!=null){
			//�û�����������ȷ����ת����ҳ
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}else{
			//�û������������
			//ת��login.jsp
			
			//��request���д��������Ϣ
			request.setAttribute("loginInfo", "�û������������");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			
		}
	}
	public User login(String username,String password){
		QueryRunner runner=new QueryRunner(C3P0Utils.getDataSource());
		String sql="select * from user where username=? and password=?";
		User user=null;
		try {
			user = runner.query(sql,new BeanHandler<User>(User.class), username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}