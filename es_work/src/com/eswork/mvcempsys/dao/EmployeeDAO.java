package com.eswork.mvcempsys.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.eswork.mvcempsys.model.Employee;
import com.eswork.mvcempsys.model.Post;

public class EmployeeDAO {
	// 连接数据库
	Connection conn = BaseDAO.getDbConnection();

	/*
	 * 添加DAO
	 */

	public ArrayList<Employee> showEmployee(String postId, String name) throws SQLException{
		String sql;
		if(name==null){
			sql="select * from EMPLOYEE where POST_ID='"+postId+"'";
		}else{
			sql="select * from EMPLOYEE where NAME='"+name+"'and POST_ID='"+postId+"'";
		
		}
			
		//System.out.println(sql);
		// 创建Statement语句对象
		Statement stmt = null;
		ArrayList<Employee> list = null;
		ResultSet rs = null;
		if (conn != null) {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			list = new ArrayList<Employee>();
			if (rs != null) {
				while (rs.next()) {
					Employee emp= new Employee();
					String emId = rs.getString("ID");
					String emPostId=rs.getString("POST_ID");
					String emName = rs.getString("NAME");
					String emSex;
					String Sex=rs.getString("SEX");
					if(Sex=="1"){
						emSex="男";
					}else{
						emSex="女";
					}
					int emAge=rs.getInt("AGE");
					
					emp.setId(emId);
					emp.setPost_Id(emPostId);
					emp.setName(emName);
					emp.setSex(emSex);
					emp.setAge(emAge);
				
					list.add(emp);

				}
			}
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();

		}
		return list;
		
	}
	public ArrayList<Employee> showEmployee(String postId) throws SQLException{
		return showEmployee(postId, null);
		
	} 

}
