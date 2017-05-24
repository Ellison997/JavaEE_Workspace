package cn.yese.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;

import cn.yese.jdbc.DataSource.DBCPUtils;

public class TestDBCPDataSource {
	
	
	@Test
	public void testUpdataDBCP(){
		Connection conn=null;
		PreparedStatement pstmt=null;
		conn= DBCPUtils.getConnection();
		String sql="update user set uname=? where uid=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "扶持U暗示");
			pstmt.setInt(2, 5);
			int count=pstmt.executeUpdate();
			if(count>0){
				System.out.println("修改成功！");
			}else{
				System.out.println("修改失败！");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
