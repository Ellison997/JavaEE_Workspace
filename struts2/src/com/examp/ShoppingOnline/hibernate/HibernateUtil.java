package com.examp.ShoppingOnline.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	//private static Log log = LogFactory.getLog(HibernateUtil.class;)
	private static final SessionFactory sessionFactory;
	
	static {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static final ThreadLocal session = new ThreadLocal();
	
	public static Session currentSession() throws HibernateException {
		Session s = (Session)session.get();
		//如果当前线程中还没有session对象，就创建一个
		if(s == null || !s.isOpen()) {
			s = sessionFactory.openSession();
			session.set(s);
		}
		return s;
	}
	
	public static void closeSession() throws HibernateException {
		Session s = (Session)session.get();
		session.set(null);
		if(s != null)
			s.close();
	}
}
