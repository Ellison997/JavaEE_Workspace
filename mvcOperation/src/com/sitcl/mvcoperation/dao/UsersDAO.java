package com.sitcl.mvcoperation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sitcl.mvcoperation.dao.BaseDAO;
import com.sitcl.mvcoperation.model.User;

public class UsersDAO {
private Connection con = BaseDAO.getDbConnection();
	
	/**
	 * �����û����������ȡ�û���Ϣ
	 * @param uname
	 * @param uPwd
	 * @return
	 */
	public User getUser(String uname, String uPwd) {
		User user = null;
		if(con != null) {
			Statement stmt = null;
			ResultSet rs = null;
			try {
				rs = null;
				stmt = con.createStatement();
				String sql = "select * from users where uname='" + uname + "' and upwd='" + uPwd + "'";
				System.out.println("��ѯ�����û���Ϣ��");
				rs = stmt.executeQuery(sql);
				System.out.println(rs);
				if(rs != null && rs.next()) {
					user = new User();
					user.setUid(rs.getInt("uid"));
					user.setUname(rs.getString("uname"));
					user.setUpwd(rs.getString("upwd"));
					user.setAddress(rs.getString("address"));
					if(rs.getBoolean("sex")) {
						user.setSex(1);
					} else {
						user.setSex(0);
					}
					System.out.println("��ѯ�����û���Ϣ��");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if(rs != null)
						rs.close();
					if(stmt != null)
						stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return user;
	}
	
	/**
	 * �����û���Ż�ȡ�û���Ϣ
	 * @param id
	 * @return
	 */
	public User getUser(int id) {
		User user = null;
		if(con != null) {
			Statement stmt = null;
			ResultSet rs = null;
			try {
				stmt = con.createStatement();
				String sql = "select * from users where uid=" + id;
				rs = stmt.executeQuery(sql);
				if(rs != null && rs.next()) {
					user = new User();
					user.setUid(rs.getInt("uid"));
					user.setUname(rs.getString("uname"));
					user.setUpwd(rs.getString("upwd"));
					user.setAddress(rs.getString("address"));
					if(rs.getBoolean("sex")) {
						user.setSex(1);
					} else {
						user.setSex(0);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if(rs != null)
						rs.close();
					if(stmt != null)
						stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return user;
	}
	
	/**
	 * ������е��û�
	 * @return
	 */
	public ArrayList<User> getUsers(){
		ArrayList<User> list = null;
		if(con != null) {
			Statement stmt = null;
			ResultSet rs = null;
			try {
				stmt = con.createStatement();
				String sql = "select * from users";
				rs = stmt.executeQuery(sql);
				if(rs != null) {
					list = new ArrayList<User>();
					while(rs.next()) {
						User user = new User();
						user.setUid(rs.getInt("uid"));
						user.setUname(rs.getString("uname"));
						user.setUpwd(rs.getString("upwd"));
						user.setAddress(rs.getString("address"));
						if(rs.getBoolean("sex")) {
							user.setSex(1);
						} else {
							user.setSex(0);
						}
						list.add(user);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if(rs != null)
						rs.close();
					if(stmt != null)
						stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	/**
	 * ��ȡ���ݱ�Users���ж��ٸ��û�
	 * @return
	 */
	public int getCount(){
		ArrayList<User> list = this.getUsers();
		if(list != null) {
			return list.size();
		} else {
			return 0;
		}
	}
	
	
	/**
	 * ���һ���û���Ϣ
	 * @param user
	 * @throws SQLException
	 */
	public void insertUser(User user) throws SQLException {
		if(con != null) {
			PreparedStatement pstmt = null;
			String sql = "insert into users(uname, upwd, address, sex) values(?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
							
			pstmt.setString(1, user.getUname());
			pstmt.setString(2, user.getUpwd());
			pstmt.setString(3, user.getAddress());
			pstmt.setInt(4, user.getSex());
			pstmt.executeUpdate();
			if(pstmt != null)
				pstmt.close();
		}
	}
	
	/**
	 * �����û�����޸��û���Ϣ
	 * @param user
	 * @throws SQLException
	 */
	public void updateUser(User user) throws SQLException {
		if(con != null) {
			PreparedStatement pstmt = null;
			String sql = "update users set uname=?, upwd=?, address=?, sex=? where uid=?";
			pstmt = con.prepareStatement(sql);
							
			pstmt.setString(1, user.getUname());
			pstmt.setString(2, user.getUpwd());
			pstmt.setString(3, user.getAddress());
			pstmt.setInt(4, user.getSex());
			pstmt.setInt(5, user.getUid());
			pstmt.executeUpdate();
			if(pstmt != null)
				pstmt.close();
		}
	}
	
	/**
	 * �����û����ɾ���û�
	 * @param id
	 * @throws SQLException
	 */
	public void deleteUser(int id) throws SQLException {
		if(con != null) {
			PreparedStatement pstmt = null;
			String sql = "delete from users where uid=?";
			pstmt = con.prepareStatement(sql);
							
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			if(pstmt != null)
				pstmt.close();
		}
	}
}
