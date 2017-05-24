package cn.iteima.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class testLogin {
	public Connection getConn() throws Exception{
		Connection conn=null;
		
		Class.forName("com.mysql.jdbc.Driver");
		String  url="jdbc:mysql://localhost:3306/web08_1";
		String user="root";
		String password="123456";
		conn=DriverManager.getConnection(url, user, password);
		
		return conn;
	}
}
