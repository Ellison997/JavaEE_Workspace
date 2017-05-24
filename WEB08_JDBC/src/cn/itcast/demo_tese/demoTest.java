package cn.itcast.demo_tese;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import cn.itcast.c_jdbc_v3.copy.jdbcUtil;

public class demoTest {
/*
 * 妯℃澘
 * 
 */
	@Test
	public void addCategory() throws SQLException{
		Connection conn=null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		
		try{
			//获取连接
		conn=jdbcUtil.getConnection();
		
		String sql="insert into category(cid,cname) values(?,?)";
		ps=conn.prepareStatement(sql);
		ps.setString(1, "c006");
		ps.setString(2, "安抚");
		int count=ps.executeUpdate();
		System.out.println(count);
		System.out.println("hahah");
		}catch(Exception e){
			System.out.println("有毛病！");
		}finally {
			jdbcUtil.rslease2(conn, ps, rs);
			
		}
	}
}
