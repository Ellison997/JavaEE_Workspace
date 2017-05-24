package com.sitcl.mvcoperation.service;

import java.sql.SQLException;

import com.sitcl.mvcoperation.dao.UsersDAO;
import com.sitcl.mvcoperation.model.User;

public class UsersService {
	private UsersDAO uDao = new UsersDAO();
	//ǰ̨��ҳ������ʲô���������������Ҫ�ṩʲô����
	
	/**
	 * ��¼����
	 * @param uname
	 * @param upwd
	 * @return
	 */
	public User login(String uname, String upwd){
		User user = null;
		user = uDao.getUser(uname, upwd);
		System.out.println("�����ݿ��в�ѯ������û����Ƿ����");
		System.out.println(user);
		return user;
		//�������еľ��崦����ϵͳ��ҵ������ģ�����ҵ��Ҫ��ͬ������ķ���ֵ��ͬ����ô�������еĴ�����ǲ�ͬ
	}
	
	/**
	 * ע�Ṧ��
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
