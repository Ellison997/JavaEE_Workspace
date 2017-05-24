package com.sitcl.mvcoperation.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sitcl.mvcoperation.dao.DormDAO;
import com.sitcl.mvcoperation.model.Dorms;
import com.sitcl.mvcoperation.model.Student;

public class DormService {
DormDAO doDao=new DormDAO();
	
	/*
 * ��ѯ������Ϣ
 */
	public ArrayList<Dorms> selectDorm(int x){
		ArrayList<Dorms> list=doDao.select(x);		
		return list;
				
	}
	
	
	/**
	 * ���������Ϣ����
	 */

	public boolean addDorms(Dorms dos) {
		try {
			doDao.addDorm(dos);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		

	}
}
