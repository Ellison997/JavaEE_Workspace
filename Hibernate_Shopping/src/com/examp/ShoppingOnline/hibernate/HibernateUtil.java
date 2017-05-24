package com.examp.ShoppingOnline.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * �ù������ṩ��һ�����ԣ�SessionFactory sessionFactory ��������sessionFactory �������ó�static
 * ������������Ϳ���ֱ��ͨ���˹��������� �ṩ�˶�������: 1��ͨ���̴߳���Session-->currentSession()
 * 2���ر�Session-->closeSession() ��Ҫ���������ֶ��ر�sessionFactory
 */
@SuppressWarnings("deprecation")
public class HibernateUtil {
	public static final SessionFactory sessionFactory;
	// ����sessionFactory
	static {
		 try {  
	            //����hibernate.cfg.xml����SessionFactory 
			 //�������ļ�����Ϣ��ӳ���ļ�����Ϣ���־û������Ϣ�洢��sessionFactory��
	         Configuration configuration =new Configuration();
	         configuration.configure();		//����hibernate�����ļ�
	         sessionFactory=configuration.buildSessionFactory();
	        } catch (Throwable ex) {  
	            ex.printStackTrace();  
	            System.err.println("����SessionFactory����" + ex);  
	            throw new ExceptionInInitializerError(ex);  
	        }  
	}

	// ThreadLocal���Ը������̵߳����ݹ�����˲�����Ҫ���߳�ͬ��
	public static final ThreadLocal<Session> session = new ThreadLocal<Session>();

	// ����Session
	public static Session currentSession() throws HibernateException {
		// ͨ���̶߳���.get()������ȫ����Session
		Session s = session.get();
		// ������̻߳�û��Session,�򴴽�һ���µ�Session
		if (s == null) {
			s = sessionFactory.openSession();
			// ����õ�Session�����洢��ThreadLocal����session��
			session.set(s);
		}
		return s;
	}

	// �ر�Session
	public static void closeSession() throws HibernateException {
		Session s = session.get();
		if (s != null)
			s.close();
		session.set(null);
	}
}
