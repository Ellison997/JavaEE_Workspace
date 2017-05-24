package com.eswork.mvcempsys.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
	static private String className = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static private String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=EMPSYS";
	static private String user = "sa";
	static private String password = "system";
	
	static private Connection dbConnection = null;
	
	//����һ�����ݿ����ӣ��޲�������
	public static Connection getDbConnection() {
		/*
		1.�ж����Ӷ����Ƿ���ڣ��������ֱ��ʹ��
		2.��������ڣ����д������������ϵͳ�����û�����ʹ��
		*/
		
		if(dbConnection != null) {
			//System.out.println("�������ݿ�ɹ��������������Ӷ���");
			return dbConnection;	
		}
		
		try {
			Class.forName(className);
			dbConnection = DriverManager.getConnection(url, user, password);
			//System.out.println("�������ݿ�ɹ��������������Ӷ���");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dbConnection;
	}
	
	//�Ͽ�����
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
