package com.examp.ShoppingOnline.test;

import com.examp.ShoppingOnline.User;
import com.examp.ShoppingOnline.hibernate.DbOperate;

public class TestAddUser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User user=new User();	
		user.setUsername("�ﴺ��");
		user.setPassword("system");
		user.setRealname("����");
		user.setEmail("1215722711@qq.com");
		user.setAddress("ɽ��ʡ������������");
		user.setTel("8052344");
		user.setZip("100083");
		DbOperate operator=new DbOperate();
		operator.save(user);
		
	}

}
