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
 * ����DBUtils��ѯ����
 * 
 * @date ����ʱ�䣺2017��5��22������6:36:15
 * @author Administrator
 * @version V1.0
 */
public class TestDBUtils2Select {
	/**
	 * ��ѯ������Ϣ
	 */
	@Test
	public void testQueryAll() {
		try {
			//��ȡ������QueryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			// ��дSQL���
			String sql = "select * from user";
			// ִ�в�ѯ
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
	 * ����ID��ѯ��Ϣ
	 */
	@Test
	public void testQueryById() {
		try {
			//��ȡ������QueryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			// ��дSQL���
			String sql = "select * from user where uid=?";
			Object[] parms={6};
			// ִ�в�ѯ
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
	 * ��ѯ�����û����ܸ���
	 */
	@Test
	public void testQueryCount() {
		try {
			//��ȡ������QueryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			// ��дSQL���
			String sql = "select count(*) from user";
			// ִ�в�ѯ
			long count = (long) qr.query(sql, new ScalarHandler());
			System.out.println(count);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	/**
	 * ��ѯ������Ϣ MapListHandler()
	 */
	@Test
	public void testQueryAllMap() {
		try {
			//��ȡ������QueryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			// ��дSQL���
			String sql = "select * from user";
			// ִ�в�ѯ
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
	 * ��ѯ������Ϣ ColumnListHandler("uname")
	 */
	@Test
	public void testQueryAllColum() {
		try {
			//��ȡ������QueryRunner
			QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
			// ��дSQL���
			String sql = "select * from user";
			// ִ�в�ѯ
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

