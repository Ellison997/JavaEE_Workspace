package com.sitcl.mvcoperation.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sitcl.mvcoperation.dao.TeachersDAO;
import com.sitcl.mvcoperation.model.Manage;

public class TeachersService {
	TeachersDAO tdao = new TeachersDAO();

	/**
	 * ��¼����
	 * 
	 * @param uname
	 * @param upwd
	 * @return
	 */
	public Manage login(String tname, String tpwd) {
		Manage manage = null;
		manage = tdao.getManage(tname, tpwd);
		System.out.println("�����ݿ��в�ѯ������û����Ƿ����");
		System.out.println(manage);
		return manage;
		// �������еľ��崦����ϵͳ��ҵ������ģ�����ҵ��Ҫ��ͬ������ķ���ֵ��ͬ����ô�������еĴ�����ǲ�ͬ
	}

	/**
	 * ע�Ṧ��
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
	 * ��ӽ�ʦ����
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
	 * �޸Ľ�ʦ����
	 */
	public boolean update(Manage manage) {
		boolean ifupd = false;
		try {
			ifupd = tdao.updata(manage);
			System.out.println("�޸ĳɹ���");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ifupd;

	}

	/*
	 * ��ѯ��ʦ��Ϣ
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
