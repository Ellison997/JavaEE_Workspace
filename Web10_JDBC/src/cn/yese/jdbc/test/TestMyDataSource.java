package cn.yese.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import cn.yese.jdbc.DataSource.MyDataSource;

/**
 * �������ӳ�
 * @author Administrator
 * @version V1.0
 */
public class TestMyDataSource{
/**
 * ����û���ʹ��δ��������ӳ�connection
 */
	@Test
	public void testAddUser(){
		Connection conn=null;
		PreparedStatement pstmt=null;
		//��ȡһ������
		MyDataSource mds=new MyDataSource();
		try {
			conn=mds.getConnection();
			String sql="insert into user(uid,uname,upassword) values (?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, 7);
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
			mds.backConnection(conn);
		}
	}
}
