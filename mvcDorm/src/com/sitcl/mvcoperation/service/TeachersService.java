package com.sitcl.mvcoperation.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sitcl.mvcoperation.dao.TeachersDAO;
import com.sitcl.mvcoperation.model.Manage;

public class TeachersService {
	TeachersDAO tdao = new TeachersDAO();

	/**
	 * 登录功能
	 * 
	 * @param uname
	 * @param upwd
	 * @return
	 */
	public Manage login(String tname, String tpwd) {
		Manage manage = null;
		manage = tdao.getManage(tname, tpwd);
		System.out.println("从数据库中查询输入的用户名是否存在");
		System.out.println(manage);
		return manage;
		// 方法体中的具体处理是系统的业务决定的，根据业务要求不同，服务的返回值不同，那么方法体中的处理就是不同
	}

	/**
	 * 注册功能
	 * 
	 * @param user
	 * @return
	 */
	public boolean register(Manage manage) {
		try {
			tdao.insert(manage);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 添加教师功能
	 */

	public boolean addTeachers(Manage manage) {
		try {
			tdao.addTeacher(manage);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * 修改教师功能
	 */
	public boolean update(Manage manage) {
		boolean ifupd = false;
		try {
			ifupd = tdao.updata(manage);
			System.out.println("修改成功！");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ifupd;

	}

	/*
	 * 查询教师信息
	 */
	public ArrayList<Manage> selectTeachers() {

		ArrayList<Manage> list = tdao.selectAll();
		return list;

	}

	public boolean delTea(String tnum) throws SQLException {
		boolean isb = tdao.delete(tnum);
		return isb;
	}
}
