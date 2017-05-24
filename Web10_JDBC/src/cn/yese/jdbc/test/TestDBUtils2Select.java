package cn.yese.jdbc.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import cn.yese.domain.User;
import cn.yese.jdbc.DataSource.C3P0Utils;

/**
 * 测试DBUtils查询操作
 * 
 * @date 创建时间：2017年5月22日下午6:36:15
 * @author Administrator
 * @version V1.0
 */
public class TestDBUtils2Select {
	/**
	 * 查询所有信息
	 */
	@Test
	public void testQueryAll() {
		try {
			//获取核心类QueryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			// 编写SQL语句
			String sql = "select * from user";
			// 执行查询
			List<User> list = qr.query(sql, new BeanListHandler<User>(User.class));
			for (User u : list) {
				System.out.println(u.getUid() + "  " + u.getUname() + "  " + u.getUpassword());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/**
	 * 根据ID查询信息
	 */
	@Test
	public void testQueryById() {
		try {
			//获取核心类QueryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			// 编写SQL语句
			String sql = "select * from user where uid=?";
			Object[] parms={6};
			// 执行查询
			List<User> list = qr.query(sql,new BeanListHandler<User>(User.class),parms);
			for (User u : list) {
				System.out.println(u.getUid() + "  " + u.getUname() + "  " + u.getUpassword());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/**
	 * 查询所有用户的总个数
	 */
	@Test
	public void testQueryCount() {
		try {
			//获取核心类QueryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			// 编写SQL语句
			String sql = "select count(*) from user";
			// 执行查询
			long count = (long) qr.query(sql, new ScalarHandler());
			System.out.println(count);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * 查询所有信息 MapListHandler()
	 */
	@Test
	public void testQueryAllMap() {
		try {
			//获取核心类QueryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			// 编写SQL语句
			String sql = "select * from user";
			// 执行查询
			List<Map<String,Object>> list = qr.query(sql, new MapListHandler());
			for (Map<String, Object> map : list) {
				System.out.println(map);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * 查询所有信息 ColumnListHandler("uname")
	 */
	@Test
	public void testQueryAllColum() {
		try {
			//获取核心类QueryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			// 编写SQL语句
			String sql = "select * from user";
			// 执行查询
			List<Object> list=qr.query(sql, new ColumnListHandler("uname"));
			for (Object o : list) {
				System.out.println(o);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

