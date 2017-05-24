package cn.yese.jdbc.test;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import cn.yese.jdbc.DataSource.C3P0Utils;
/**
 * ����DBUtils������
 * @author Administrator
 * @version V1.0
 */
public class TestDBUtils {
	/**
	 * ����û�
	 */
	@Test
	public void testAddUser(){
		try {
			//����������
			QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());			
			//��дSql���
			String sql="insert into user(uid,uname,upassword) values (?,?,?)";
			//Ϊռλ������ֵ
			Object[] params={10,"���Ц","456789"};
			
			int rows=qr.update(sql,params);
			if(rows>0){
				System.out.println("��ӳɹ���");
			}else{
				System.out.println("���ʧ�ܣ�");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * �޸��û�
	 */
	@Test
	public void testUpdateUserById(){
		try {
			//����������
			QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());			
			//��дSql���
			String sql="update user set uname=?,upassword=? where uid=?";
			//Ϊռλ������ֵ
			Object[] params={"XXX","120857888",10};
			
			int rows=qr.update(sql,params);
			if(rows>0){
				System.out.println("�޸ĳɹ���");
			}else{
				System.out.println("�޸�ʧ�ܣ�");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * ɾ���û�
	 */
	@Test
	public void testDeleteUser(){
		try {
			//����������
			QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());			
			//��дSql���
			String sql="delete from user where uid=? ";
			//Ϊռλ������ֵ
			Object[] params={8};
			
			int rows=qr.update(sql,params);
			if(rows>0){
				System.out.println("ɾ���ɹ���");
			}else{
				System.out.println("ɾ��ʧ�ܣ�");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
