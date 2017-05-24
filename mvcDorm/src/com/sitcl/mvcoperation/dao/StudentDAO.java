package com.sitcl.mvcoperation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sitcl.mvcoperation.model.Manage;
import com.sitcl.mvcoperation.model.Record;
import com.sitcl.mvcoperation.model.Student;

public class StudentDAO {
	// 连接数据库
	Connection conn = BaseDAO.getDbConnection();

	/*
	 * 添加DAO
	 */
	public void addStudent(Student stu) throws SQLException {
		if (conn != null) {
			PreparedStatement pstem = null;
			int rows = -1;

			String sql = "insert into student"
					+ "(snumber,sname,ssex,sphone,sclass,sbed,scollege,saddress)"
					+ "values(?,?,?,?,?,?,?,?)";
			pstem = conn.prepareStatement(sql);
			pstem.setString(1, stu.getSnumber());
			pstem.setString(2, stu.getSname());
			pstem.setString(3, stu.getSsex());
			pstem.setString(4, stu.getSphone());
			pstem.setString(5, stu.getSclass());
			pstem.setInt(6, stu.getSbed());
			pstem.setString(7, stu.getScollege());
			pstem.setString(8, stu.getSaddress());

			rows = pstem.executeUpdate();
			System.out.println(rows);
			if (pstem != null)
				pstem.close();

		}
	}

	public boolean updata(Student stu) throws SQLException {
		if (conn != null) {
			PreparedStatement pstmt = null;
			String sql = "UPDATE student SET sname =?,ssex=?,sphone=?,sclass=?,sbed=?,scollege=?,saddress=? WHERE snumber =?";
			System.out.println(sql);

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, stu.getSname());
			pstmt.setString(2, stu.getSsex());
			pstmt.setString(3, stu.getSphone());
			pstmt.setString(4, stu.getSclass());
			pstmt.setInt(5, stu.getSbed());
			pstmt.setString(6, stu.getScollege());
			pstmt.setString(7, stu.getSaddress());
			pstmt.setString(8, stu.getSnumber());

			pstmt.executeUpdate();

			if (pstmt != null)
				pstmt.close();
			return true;
		}
		return false;
	}

	// 查询所有的信息
	public ArrayList<Student> selectAll() {
		String sql = "select * from student";
		// 创建Statement语句对象
		Statement stmt = null;
		ArrayList<Student> list = null;
		ResultSet rs = null;
		if (conn != null) {
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				list = new ArrayList<Student>();
				if (rs != null) {
					while (rs.next()) {

						Student stu = new Student();
						String snumber = rs.getString("snumber");
						int sbed = rs.getInt("sbed");
						String sname = rs.getString("sname");
						String ssex = rs.getString("ssex");
						String sclass = rs.getString("sclass");
						String sphone = rs.getString("sphone");
						String scollege = rs.getString("scollege");
						String saddress = rs.getString("saddress");
						String simg = rs.getString("simg");

						stu.setSnumber(snumber);
						stu.setSbed(sbed);
						stu.setSsex(ssex);
						stu.setSphone(sphone);
						stu.setSclass(sclass);
						stu.setSaddress(saddress);
						stu.setSname(sname);
						stu.setScollege(scollege);
						stu.setSimg(simg);

						list.add(stu);

					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (rs != null)
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				if (stmt != null)
					try {
						stmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			}
		}
		return list;

	}

	// 查询某宿舍学生信息
	public ArrayList<Student> select(String c) {
		String sql = "select * from student where sclass='" + c + "'";
		// 创建Statement语句对象
		Statement stmt = null;
		ArrayList<Student> list = null;
		ResultSet rs = null;
		if (conn != null) {
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				list = new ArrayList<Student>();
				if (rs != null) {
					while (rs.next()) {

						Student stu = new Student();
						String snumber = rs.getString("snumber");
						int sbed = rs.getInt("sbed");
						String sname = rs.getString("sname");
						String ssex = rs.getString("ssex");
						String sclass = rs.getString("sclass");
						String sphone = rs.getString("sphone");
						String scollege = rs.getString("scollege");
						String saddress = rs.getString("saddress");
						String simg = rs.getString("simg");

						stu.setSnumber(snumber);
						stu.setSbed(sbed);
						stu.setSsex(ssex);
						stu.setSphone(sphone);
						stu.setSclass(sclass);
						stu.setSaddress(saddress);
						stu.setSname(sname);
						stu.setScollege(scollege);
						stu.setSimg(simg);

						list.add(stu);

					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (rs != null)
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				if (stmt != null)
					try {
						stmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			}
		}
		return list;

	}

	// 查询学生违纪信息
	public ArrayList<Record> selectSrecord() {
		String sql = "select * from absenteeism";
		// 创建Statement语句对象
		Statement stmt = null;
		ArrayList<Record> list = null;
		ResultSet rs = null;
		if (conn != null) {
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				list = new ArrayList<Record>();
				if (rs != null) {
					while (rs.next()) {
						Record red = new Record();
						int id = rs.getInt("ID");
						String number = rs.getString("number");
						String name = rs.getString("name");
						String time = rs.getString("time");
						String typee = rs.getString("typee");
						String squad = rs.getString("squad");
						red.setID(id);
						red.setNumber(number);
						red.setName(name);
						red.setTime(time);
						red.setTypee(typee);
						red.setSquad(squad);

						list.add(red);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (rs != null)
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				if (stmt != null)
					try {
						stmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			}
		}
		return list;

	}
	
	/*
	 * 添加违纪信息
	 */
	public void addRecord(Record red) throws SQLException {
		if (conn != null) {
			PreparedStatement pstem = null;
			int rows = -1;

			String sql = "insert into absenteeism"
					+ "(number,name,time,typee,squad)"
					+ "values(?,?,?,?,?)";
			pstem = conn.prepareStatement(sql);
			pstem.setString(1, red.getNumber());
			pstem.setString(2, red.getName());
			pstem.setString(3, red.getTime());
			pstem.setString(4, red.getTypee());
			pstem.setString(5, red.getSquad());
			

			rows = pstem.executeUpdate();
			System.out.println(rows);
			if (pstem != null)
				pstem.close();

		}
	}


	public boolean delete(String name) throws SQLException {
		if (conn != null) {
			PreparedStatement pstmt = null;
			String sql = "DELETE FROM student WHERE snumber =?";
			System.out.println(sql+"   "+name);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.executeUpdate();
			if (pstmt != null) {
				pstmt.close();
			}
			return true;
		}
		return false;
	}
	public boolean deleteRed(String number) throws SQLException {
		if (conn != null) {
			PreparedStatement pstmt = null;
			String sql = "DELETE FROM absenteeism WHERE number =?";
			System.out.println(sql+"   "+number);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, number);
			pstmt.executeUpdate();
			if (pstmt != null) {
				pstmt.close();
			}
			return true;
		}
		return false;
	}

}
