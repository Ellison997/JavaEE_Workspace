package com.sitcl.mvcoperation.service;
import java.sql.SQLException;
import java.util.ArrayList;
import com.sitcl.mvcoperation.dao.StudentDAO;
import com.sitcl.mvcoperation.model.Manage;
import com.sitcl.mvcoperation.model.Record;
import com.sitcl.mvcoperation.model.Student;

public class StudentService {
StudentDAO sdao=new StudentDAO();
	/*
	 * ��ѯѧ����Ϣ
	 */
	public ArrayList<Student> selectStudent(){
		ArrayList<Student> list=sdao.selectAll();
		return list;
		
	}
	
	public ArrayList<Student> studentDorm(String c){
		ArrayList<Student> list=sdao.select(c);
		return list;
		
	}
	
	/**
	 * ���ѧ����Ϣ����
	 */

	public boolean addStus(Student stu) {
		try {
			sdao.addStudent(stu);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		

	}
	
	/**
	 * ���Υ����Ϣ����
	 */

	public boolean addRecord(Record red) {
		try {
			sdao.addRecord(red);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		

	}
/*
 * �޸�ѧ����Ϣ����
 */
	public boolean update(Student stu) {
		boolean ifupd = false;
		try {
			ifupd = sdao.updata(stu);
			System.out.println("�޸ĳɹ���");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ifupd;

	}
	
	
	/*
	 * ��ѯΥ����Ϣ
	 */
	public ArrayList<Record> selectSrecord(){
		ArrayList<Record> list=sdao.selectSrecord();
		return list;
		
	}
	
	public boolean delStu(String snum) throws SQLException{
		boolean isb=sdao.delete(snum);
		return isb;
	}
	
	public boolean delRed(String num) throws SQLException{
		boolean isb=sdao.deleteRed(num);
		return isb;
	}
	
	
}
