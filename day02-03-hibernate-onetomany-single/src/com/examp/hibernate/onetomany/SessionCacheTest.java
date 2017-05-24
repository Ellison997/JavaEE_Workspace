package com.examp.hibernate.onetomany;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.examp.ShoppingOnline.hibernate.HibernateUtil;
import com.examp.domain.Person;

public class SessionCacheTest {
	HibernateUtil hiber=new HibernateUtil();
	/*
	 * get�����Ѷ���ŵ���session������
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
		Person person = new Person();//��ʱ״̬
		person.setName("afdsas");
		session.save(person);//���д����person������뵽��������
		person = (Person)session.get(Person.class, person.getPid());//�ӻ����аѶ�����ȡ����
		transaction.commit();
		session.close();
	}
	
	
}
