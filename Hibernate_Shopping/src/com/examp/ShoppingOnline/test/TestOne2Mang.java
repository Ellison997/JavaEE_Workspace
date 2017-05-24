package com.examp.ShoppingOnline.test;

import com.examp.ShoppingOnline.Order;
import com.examp.ShoppingOnline.User;
import com.examp.ShoppingOnline.hibernate.DbOperate;

public class TestOne2Mang {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	//该方法用于向user和Orders表中存储一条数据
	public int addUserAndOrder(){
		User use=new User();
		use.setUsername("userOne");
		
		//创建3个Order对象
		Order o1=new Order();
		o1.setOrderno("order1_20080103");
		Order o2=new Order();
		o2.setOrderno("order2_20080103");
		Order o3=new Order();
		o3.setOrderno("order3_20080103");		
		
		o1.setUser(use);
		o2.setUser(use);
		o3.setUser(use);
		//保存user对象和三个order对象
		DbOperate obo=new DbOperate();
		obo.save(use);
		obo.save(o1);
		obo.save(o2);
		obo.save(o3);
		return 1;
	}
	
	
	
}
