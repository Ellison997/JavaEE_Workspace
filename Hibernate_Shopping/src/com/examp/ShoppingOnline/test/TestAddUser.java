package com.examp.ShoppingOnline.test;

import com.examp.ShoppingOnline.User;
import com.examp.ShoppingOnline.hibernate.DbOperate;

public class TestAddUser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User user=new User();	
		user.setUsername("田春乐");
		user.setPassword("system");
		user.setRealname("哈哈");
		user.setEmail("1215722711@qq.com");
		user.setAddress("山东省金乡县马庙镇");
		user.setTel("8052344");
		user.setZip("100083");
		DbOperate operator=new DbOperate();
		operator.save(user);
		
	}

}
