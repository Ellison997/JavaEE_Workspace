package com.day1020;

import java.sql.*;

import java.util.ArrayList;

public class CusDAO {
	public ArrayList<Customers> selectAll() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = null;
		String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=market";
		String user = "sa";
		String password = "system";
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Statement stmt = null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResultSet rs = null;
		String sql = "select * from customers";
		try {
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//5.
		ArrayList list = null;
		try {
			if(rs != null) {
				//1.
				list = new ArrayList();
				while(rs.next()) {
					//2.
					Customers customers = new Customers();
					int id=rs.getInt("id");
					String cusName=rs.getString("cusName");
					String address=rs.getString("address");
					customers.setID(id);
					customers.setCusName(cusName);
					customers.setAddress(address);
					list.add(customers);
					//System.out.println(goodsName + "\t" + price + "\t" + quantity);
				}
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		if(stmt != null)
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		try {
			if(con != null && !con.isClosed())
				con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
}
