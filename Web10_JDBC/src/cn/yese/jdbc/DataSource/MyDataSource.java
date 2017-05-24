package cn.yese.jdbc.DataSource;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.sql.DataSource;

import cn.yese.jdbc.utils.JDBCUtils_V3;
import cn.yese.jdbc.utils.MyConnection;
/**
 * 创建一个连接池  自定义连接池
 * @author Administrator
 * @version V1.0
 */
public class MyDataSource implements DataSource {
	//创建一个容器用于存储Connection对象
	private static LinkedList<Connection> pool=new LinkedList<Connection>();
	private static MyConnection myConn=null;
	//创建5个连接放到容器里
	static{
		for (int i = 0; i <5; i++) {
			Connection conn=JDBCUtils_V3.getConnection();
			myConn=new MyConnection(conn,pool);
			pool.add(myConn);
		}
	}
	/**
	 * 重写获取连接的方法
	 */
	@Override
	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn=null;
		//使用前先判断，如果没有连接对象就再创建一些
		if(pool.size()==0){
			for (int i = 0; i <5; i++) {
				conn=JDBCUtils_V3.getConnection();
				myConn=new MyConnection(conn,pool);
				pool.add(myConn);
			}	
		}
		//从池子里获取一个连接对象
		conn=pool.remove(0);
		return conn;
	}
	/**
	 * 归还连接对象到连接池中
	 */
	public void backConnection(Connection conn) {
			try {
				myConn.close();
				System.out.println(pool.size());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
