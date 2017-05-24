package cn.yese.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import cn.yese.jdbc.DataSource.MyDataSource;

/**
 * 测试连接池
 * @author Administrator
 * @version V1.0
 */
public class TestMyDataSource{
/**
 * 添加用户，使用未改造的连接池connection
 */
	@Test
	public void testAddUser(){
		Connection conn=null;
		PreparedStatement pstmt=null;
		//获取一个连接
		MyDataSource mds=new MyDataSource();
		try {
			conn=mds.getConnection();
			String sql="insert into user(uid,uname,upassword) values (?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, 7);
			pstmt.setString(2, "田硕");
			pstmt.setString(3, "1236456");
			int count=pstmt.executeUpdate();
			if(count>0){
				System.out.println("添加成功");
			}else{
				System.out.println("添加失败");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally {
			mds.backConnection(conn);
		}
	}
}
