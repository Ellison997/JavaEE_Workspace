package com.examp.ShoppingOnline.test;

import com.examp.ShoppingOnline.User;
import com.examp.ShoppingOnline.hibernate.DbOperate;

public class TestGetUser {
public static void main(String[] args) {
	String userName="田春乐";
	User user=null;
	DbOperate operator=new DbOperate();
	
	user =operator.getUser(userName);		//根据userName 查询用户
	System.out.println(user.getUsername()+"   "+user.getRealname());
}
}
