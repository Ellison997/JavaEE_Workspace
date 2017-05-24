package cn.yese.jdbc.DataSource;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBCPUtils {
	private static DataSource dataSource;
	
	static{
		InputStream is=DBCPUtils.class.getClassLoader().getResourceAsStream("db.properties");
		Properties ppt=new Properties();
		try {
			ppt.load(is);
			dataSource=BasicDataSourceFactory.createDataSource(ppt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} 
	}
	public static Connection getConnection(){
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	public static DataSource getDataSource(){
		return dataSource;
	}
}
