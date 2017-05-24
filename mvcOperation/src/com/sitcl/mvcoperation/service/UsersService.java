package com.sitcl.mvcoperation.service;

import java.sql.SQLException;

import com.sitcl.mvcoperation.dao.UsersDAO;
import com.sitcl.mvcoperation.model.User;

public class UsersService {
	private UsersDAO uDao = new UsersDAO();
	//前台的页面上有什么操作，你这基本就要提供什么服务
	
	/**
	 * 登录功能
	 * @param uname
	 * @param upwd
	 * @return
	 */
	public User login(String uname, String upwd){
		User user = null;
		user = uDao.getUser(uname, upwd);
		System.out.println("从数据库中查询输入的用户名是否存在");
		System.out.println(user);
		return user;
		//方法体中的具体处理是系统的业务决定的，根据业务要求不同，服务的返回值不同，那么方法体中的处理就是不同
	}
	
	/**
	 * 注册功能
	 * @param user
	 * @return
	 */
	public boolean register(User user) {
		try {
			uDao.insertUser(user);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
