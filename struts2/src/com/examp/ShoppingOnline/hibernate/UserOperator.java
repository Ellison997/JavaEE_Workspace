package com.examp.ShoppingOnline.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.examp.ShoppingOnline.CreditCardAccount;
import com.examp.ShoppingOnline.User;

public class UserOperator {
	//添加用户及账号
	public int addUserAndCardAccount() {
		DBOperator op = new DBOperator();
		CreditCardAccount account1 = new CreditCardAccount();
		account1.setCardnumber("accountnumber_1");
		User user = new User();
		user.setUsername("wyf");
		user.setPassword("wyf");
		user.setRealname("wyf");
		user.setTel("12345678");
		user.setZip("123456");
		user.setAddress("jn");
		user.setEmail("wyf@126.com");
		user.setCreditCardAccount(account1);
		account1.setUser(user);
		
		op.save(user);
		
		return user.getId();
	}
	
	//查询所有用户
	public List<User> getUsers() {
		Session session = HibernateUtil.currentSession();
		String hql = "from User";
		Query query = session.createQuery(hql);
		List<User> list = query.list();
		return list;
	}
}
