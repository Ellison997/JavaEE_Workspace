package com.sitcl.mvcoperation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sitcl.mvcoperation.model.Manage;

public class TeachersDAO {
	// 连接数据库
	Connection conn = BaseDAO.getDbConnection();

	/**
	 * 根据用户名和密码获取用户信息
	 * 
	 * @param uname
	 * @param uPwd
	 * @return
	 */
	public Manage getManage(String tname, String tpwd) {
		Manage manage = null;
		if (conn != null) {
			Statement stmt = null;
			ResultSet rs = null;
			try {
				rs = null;
				stmt = conn.createStatement();
				String sql = "select * from teacher where tNumber='" + tname
						+ "' and tPwd='" + tpwd + "' and tposition='值班教师'";
				System.out.println(sql);
				rs = stmt.executeQuery(sql);
				System.out.println(rs);
				if (rs != null && rs.next()) {
					manage = new Manage();
					manage.setTnumber(rs.getString("tnumber"));
					manage.setTname(rs.getString("tname"));
					manage.setTphone(rs.getString("tphone"));
					manage.setTpwd(rs.getString("tpwd"));
					manage.setTmanage(rs.getString("tmanage"));
					manage.setTposition(rs.getString("tposition"));
					manage.setTcollege(rs.getString("tcollege"));
					manage.setTsex(rs.getString("tsex"));
					
//					if (rs.getInt("tsex")==0) {
//						manage.setTsex("男");
//					} else {
//						manage.setTsex("女");
//					}
					System.out.println("查询到了用户信息！");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (stmt != null)
						stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return manage;
	}
/*
 * 注册DAO
 */
	public void insert(Manage manage) throws SQLException {
		if (conn != null) {
			PreparedStatement pstem = null;
			int rows = -1;

			String sql = "insert into teacher values(?,?,?,?,?,?,?,?)";
			pstem = conn.prepareStatement(sql);
			pstem.setString(1, manage.getTnumber());
			pstem.setString(2, manage.getTname());
			pstem.setString(3, manage.getTsex());
			pstem.setString(4, manage.getTphone());
			pstem.setString(5, manage.getTpwd());
			pstem.setString(6, manage.getTmanage());
			pstem.setString(7, "值班教师");
			pstem.setString(8, manage.getTcollege());
			
			rows = pstem.executeUpdate();
			System.out.println(rows);
			if (pstem != null)
				pstem.close();

		}
	}
	
	/*
	 * 添加DAO
	 */
	public void addTeacher(Manage manage) throws SQLException {
		if (conn != null) {
			PreparedStatement pstem = null;
			int rows = -1;

			String sql = "insert into teacher" +
					"(tnumber,tname,tsex,tphone,tmanage,tposition,tcollege) " +
					"values(?,?,?,?,?,?,?)";
			pstem = conn.prepareStatement(sql);
			pstem.setString(1, manage.getTnumber());
			pstem.setString(2, manage.getTname());
			pstem.setString(3, manage.getTsex());
			pstem.setString(4, manage.getTphone());
			pstem.setString(5, manage.getTmanage());
			pstem.setString(6, manage.getTposition());
			pstem.setString(7, manage.getTcollege());
			
			rows = pstem.executeUpdate();
			System.out.println(rows);
			if (pstem != null)
				pstem.close();

		}
	}

	public boolean updata(Manage manage) throws SQLException {
		if (conn != null) {
			PreparedStatement pstmt = null;
			String sql = "UPDATE teacher SET tname =?,tsex=?,tphone=?,tmanage=?,tposition=?,tcollege=? WHERE tnumber =?";
			System.out.println(sql);
			
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, manage.getTname());
			pstmt.setString(2, manage.getTsex());
			pstmt.setString(3, manage.getTphone());
			pstmt.setString(4,manage.getTmanage() );
			pstmt.setString(5,manage.getTposition() );
			pstmt.setString(6, manage.getTcollege());
			pstmt.setString(7, manage.getTnumber());
			pstmt.executeUpdate();

			if (pstmt != null)
				pstmt.close();
			return true;
		}
		return false;
	}

	// 查询所有的信息
	public ArrayList<Manage> selectAll() {
		String sql = "select * from teacher";
		// 创建Statement语句对象
		Statement stmt = null;
		ArrayList<Manage> list = null;
		ResultSet rs = null;
		if (conn != null) {
			try {
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				list = new ArrayList<Manage>();
				if (rs != null) {
					while (rs.next()) {

						Manage manage = new Manage();
						String tNumber = rs.getString("tnumber");
						String tName = rs.getString("tname");
						//int tSex = rs.getInt("tsex");
						String tSex=rs.getString("tsex");
						String tPhone = rs.getString("tphone");
						// String tPwd=rs.getString("tPwd");
						String tManage = rs.getString("tmanage");
						String tPosition=rs.getString("tposition");
						String tCollege=rs.getString("tcollege");
						manage.setTnumber(tNumber);
						manage.setTname(tName);
						manage.setTsex(tSex);
//						if(tSex==0){
//							manage.setTsex("男");
//						}else{
//							manage.setTsex("女");
//						}
//						
						manage.setTphone(tPhone);
						manage.setTmanage(tManage);
						manage.setTposition(tPosition);
						manage.setTcollege(tCollege);
						list.add(manage);
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

	public boolean delete(String tnum) throws SQLException {
		if (conn != null) {
			PreparedStatement pstmt = null;
			String sql = "DELETE FROM teacher WHERE tnumber =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tnum);
			pstmt.executeUpdate();
			if (pstmt != null) {
				pstmt.close();
			}
			return true;
		}
		return false;
	}
}
