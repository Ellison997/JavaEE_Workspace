package cn.yese.jdbc.test;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import cn.yese.jdbc.DataSource.C3P0Utils;
/**
 * 测试DBUtils工具类
 * @author Administrator
 * @version V1.0
 */
public class TestDBUtils {
	/**
	 * 添加用户
	 */
	@Test
	public void testAddUser(){
		try {
			//创建核心类
			QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());			
			//编写Sql语句
			String sql="insert into user(uid,uname,upassword) values (?,?,?)";
			//为占位符设置值
			Object[] params={10,"你的笑","456789"};
			
			int rows=qr.update(sql,params);
			if(rows>0){
				System.out.println("添加成功！");
			}else{
				System.out.println("添加失败！");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 修改用户
	 */
	@Test
	public void testUpdateUserById(){
		try {
			//创建核心类
			QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());			
			//编写Sql语句
			String sql="update user set uname=?,upassword=? where uid=?";
			//为占位符设置值
			Object[] params={"XXX","120857888",10};
			
			int rows=qr.update(sql,params);
			if(rows>0){
				System.out.println("修改成功！");
			}else{
				System.out.println("修改失败！");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 删除用户
	 */
	@Test
	public void testDeleteUser(){
		try {
			//创建核心类
			QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());			
			//编写Sql语句
			String sql="delete from user where uid=? ";
			//为占位符设置值
			Object[] params={8};
			
			int rows=qr.update(sql,params);
			if(rows>0){
				System.out.println("删除成功！");
			}else{
				System.out.println("删除失败！");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
