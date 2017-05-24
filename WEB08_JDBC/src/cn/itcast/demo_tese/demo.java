package cn.itcast.demo_tese;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import cn.itcast.c_jdbc_v3.copy.jdbcUtil;

public class demo {
/*
 * 模板
 * 
 */
	@Test
	public void demo00() throws SQLException{
		Connection conn=null;
		Statement st=null;
		ResultSet rs=null;
		
		//获取连接
		conn=jdbcUtil.getConnection();
		st=conn.createStatement();
		
	}
}
