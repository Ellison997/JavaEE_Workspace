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
			pstmt.setString(1, "����U��ʾ");
			pstmt.setInt(2, 5);
			int count=pstmt.executeUpdate();
			if(count>0){
				System.out.println("�޸ĳɹ���");
			}else{
				System.out.println("�޸�ʧ�ܣ�");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
