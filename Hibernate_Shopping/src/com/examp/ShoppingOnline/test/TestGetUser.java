package com.examp.ShoppingOnline.test;

import com.examp.ShoppingOnline.User;
import com.examp.ShoppingOnline.hibernate.DbOperate;

public class TestGetUser {
public static void main(String[] args) {
	String userName="�ﴺ��";
	User user=null;
	DbOperate operator=new DbOperate();
	
	user =operator.getUser(userName);		//����userName ��ѯ�û�
	System.out.println(user.getUsername()+"   "+user.getRealname());
}
}
