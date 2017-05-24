package cn.yese.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import cn.yese.jdbc.DataSource.C3P0Utils;
import cn.yese.jdbc.DataSource.MyDataSource;
import cn.yese.jdbc.utils.JDBCUtils_V3;

/**
 * ����C3P0���ӳ� ��ɾ�Ĳ���
 * @author Administrator
 * @version V1.0
 */
public class TestC3P0DataSource{
/**
 * ����û�
 */
	@Test
	public void testAddUser(){
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=C3P0Utils.getConnection();
			String sql="insert into user(uid,uname,upassword) values (?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, 8);
			pstmt.setString(2, "��˶");
			pstmt.setString(3, "1236456");
			int count=pstmt.executeUpdate();
			if(count>0){
				System.out.println("��ӳɹ�");
			}else{
				System.out.println("���ʧ��");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally {
			JDBCUtils_V3.rslease2(conn, pstmt, null);
		}
	}
}
