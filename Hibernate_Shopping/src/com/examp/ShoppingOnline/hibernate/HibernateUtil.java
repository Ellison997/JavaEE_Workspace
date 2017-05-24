package com.examp.ShoppingOnline.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 该工具类提供了一个属性：SessionFactory sessionFactory 并创建了sessionFactory 将它设置成static
 * 这样其他程序就可以直接通过此工具类引用 提供了二个方法: 1：通过线程创建Session-->currentSession()
 * 2：关闭Session-->closeSession() 需要在主类中手动关闭sessionFactory
 */
@SuppressWarnings("deprecation")
public class HibernateUtil {
	public static final SessionFactory sessionFactory;
	// 创建sessionFactory
	static {
		 try {  
	            //根据hibernate.cfg.xml建立SessionFactory 
			 //将配置文件的信息、映射文件的信息、持久化类的信息存储在sessionFactory中
	         Configuration configuration =new Configuration();
	         configuration.configure();		//加载hibernate配置文件
	         sessionFactory=configuration.buildSessionFactory();
	        } catch (Throwable ex) {  
	            ex.printStackTrace();  
	            System.err.println("建立SessionFactory错误" + ex);  
	            throw new ExceptionInInitializerError(ex);  
	        }  
	}

	// ThreadLocal可以隔离多个线程的数据共享，因此不再需要对线程同步
	public static final ThreadLocal<Session> session = new ThreadLocal<Session>();

	// 创建Session
	public static Session currentSession() throws HibernateException {
		// 通过线程对象.get()方法安全创建Session
		Session s = session.get();
		// 如果该线程还没有Session,则创建一个新的Session
		if (s == null) {
			s = sessionFactory.openSession();
			// 将获得的Session变量存储在ThreadLocal变量session里
			session.set(s);
		}
		return s;
	}

	// 关闭Session
	public static void closeSession() throws HibernateException {
		Session s = session.get();
		if (s != null)
			s.close();
		session.set(null);
	}
}
