package com.sitcl.mvcoperation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
	static private String className = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static private String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=market";
	static private String user = "sa";
	static private String password = "system";
	
	static private Connection dbConnection = null;
	
	//创建一个数据库连接，无参数传递
	public static Connection getDbConnection() {
		/*
		1.判断链接对象是否存在，如果存在直接使用
		2.如果不存在，进行创建，创建后该系统所有用户都能使用
		*/
		
		if(dbConnection != null) {
			//System.out.println("连接数据库成功，并返回了连接对象！");
			return dbConnection;	
		}
		
		try {
			Class.forName(className);
			dbConnection = DriverManager.getConnection(url, user, password);
			System.out.println("连接数据库成功，并返回了连接对象！");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dbConnection;
	}
	
	//断开链接
	public static void disconnectDatabase() {
		try {
			if(dbConnection != null && !dbConnection.isClosed()) {
				dbConnection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
