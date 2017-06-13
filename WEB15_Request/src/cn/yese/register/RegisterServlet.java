package cn.yese.register;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;

import cn.yese.utils.C3P0Utils;
public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置request的编码方式，只适合POTS编码
		request.setCharacterEncoding("utf-8");
		
		//使用BeanUtils进行自动映射封装
		//BeanUtils工作原理：将map中的数据根据key与实体的属性的对应关系封装只要key的名字与实体类的属性的名字一样就自动封装到实体中
		Map<String, String[]> properties = request.getParameterMap();
		User user = new User();
		try {
			BeanUtils.populate(user, properties);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		//现在这个User对象已经填充好了
		//还有uid是空的，手动封住uid--uuid--随机不重复的字符串32位--java代码生成后36位
		user.setUid(UUID.randomUUID().toString());
		//将参数传递给一个业务操作方法
		int register = register(user);
		if(register>0){
			//注册成功跳转到登录页面,转发的方式，效率比较高，但是地址栏不变
			//request.getRequestDispatcher("/login.jsp").forward(request, response);
			
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}
		
	}
	//注册的方法
	public int register(User user){
		//操作数据库
		int count=0;
		QueryRunner runner=new QueryRunner(C3P0Utils.getDataSource());
		String sql = "insert into user(uid,username,password,name,email,birthday,sex) values (?,?,?,?,?,?,?)";
		Object[] object={user.getUid(),user.getUsername(),user.getPassword(),user.getName(),
				user.getEmail(),user.getBirthday(),user.getSex()};
		try {
			count=runner.update(sql,object);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}