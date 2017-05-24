package com.examp.hibernate.onetomany;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.examp.ShoppingOnline.hibernate.HibernateUtil;
import com.examp.domain.Person;

public class SessionCacheTest {
	HibernateUtil hiber=new HibernateUtil();
	/*
	 * get方法把对象放到了session缓存中
	 */
	
	@Test
	public void testGet(){
		Session session=hiber.currentSession();
		Person person=(Person) session.get(Person.class, 1L);
		person=(Person) session.get(Person.class, 1L);
		session.close();
	}
	
	/**
	 * save
	 */
	@Test
	public void testSave(){
		Session session=hiber.currentSession();
		Transaction transaction = session.beginTransaction();
		Person person = new Person();//临时状态
		person.setName("afdsas");
		session.save(person);//该行代码把person对象放入到缓存中了
		person = (Person)session.get(Person.class, person.getPid());//从缓存中把对象提取出来
		transaction.commit();
		session.close();
	}
	
	
}
