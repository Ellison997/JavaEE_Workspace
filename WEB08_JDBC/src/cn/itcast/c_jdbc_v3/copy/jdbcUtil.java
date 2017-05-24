package cn.itcast.c_jdbc_v3.copy;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
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
	static {
		// 加载properties 文件，获得流InputStream
		/*
		 * 1、方式一、使用类加载ClassLoader加载src资源（固定的写法） 获得Classloader固定写法
		 * 当前类.getClassLoader()
		 */
		try {
			InputStream is = jdbcUtil.class.getResourceAsStream("db.properties");
			/*
			 * 加载当前类同包下的资源，如果需要从src开始必须填写/
			 */
			InputStream is2 = jdbcUtil.class.getResourceAsStream("/db.properties");
			// is2加载的是src下的资源

			// 使用Properties处理流
			Properties ppt = new Properties();
			ppt.load(is2);
			driver = ppt.getProperty("jdbc.deiver");
			url = ppt.getProperty("jdbc.url");
			user = ppt.getProperty("jdbc.user");
			password = ppt.getProperty("jdbc.password");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 获取连接
	 */
	public static Connection getConnection() {
		Connection conn = null;
		// 注册驱动
		try {
			Class.forName(driver);
			// 获取连接
			conn = DriverManager.getConnection(url, user, password);
			System.out.println(url + "," + user + "," + password);
			System.out.println(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 释放资源，多个try-catch并列，catch块中不能抛出异常，否则将阻止程序继续执行
	 */

	public static void release(Connection conn, Statement st, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			if (st != null) {
				st.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/**
	 * try catch finally 嵌套，资源释放时如果出错，将通知调用者
	 */

	public static void rslease2(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception e2) {
				throw new RuntimeException(e2);
			} finally {

				try {
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					throw new RuntimeException(e);
				}
			}
		}
	}

}
