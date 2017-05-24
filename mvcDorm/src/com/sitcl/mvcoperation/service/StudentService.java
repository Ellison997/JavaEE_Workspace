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
	 * 查询学生信息
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
	 * 添加学生信息功能
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
	 * 添加违纪信息功能
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
 * 修改学生信息功能
 */
	public boolean update(Student stu) {
		boolean ifupd = false;
		try {
			ifupd = sdao.updata(stu);
			System.out.println("修改成功！");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ifupd;

	}
	
	
	/*
	 * 查询违纪信息
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
