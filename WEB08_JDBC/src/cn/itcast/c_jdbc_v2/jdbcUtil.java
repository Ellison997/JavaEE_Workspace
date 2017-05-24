package cn.itcast.c_jdbc_v2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.junit.Test;

public class jdbcUtil {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	/**
	 * 配置文件只需要加载一次，提供静态代码，当前类被加载到内存中执行
	 */
	static{
		//1、使用JDK提供的工具类加载properties文件
		//ResourceBundle专门用于处理properties文件的,提供getBundle()方法
		//只需要填写文件即可
		ResourceBundle rb=ResourceBundle.getBundle("db");
		//通过key获取需要的值
		driver=rb.getString("jdbc.deiver");
		url=rb.getString("jdbc.url");
		user=rb.getString("jdbc.user");
		password=rb.getString("jdbc.password");
		
	}
	
	/**
	 * 获取连接
	 */
	@Test
	public static Connection getConnection() {
		Connection conn=null;
		//注册驱动
		try {
			Class.forName(driver);
			//获取连接
			conn=DriverManager.getConnection(url,user,password);
			System.out.println(url+","+user+","+password);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	
	
}
