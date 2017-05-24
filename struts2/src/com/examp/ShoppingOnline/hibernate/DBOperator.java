package com.examp.ShoppingOnline.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.examp.ShoppingOnline.User;

/*
 * ������ж��������ɾ���Ĳ���
 */
public class DBOperator {
	//�����û����õ���Ա����
	public User getUser(String userName) throws HibernateException {
		Session session = HibernateUtil.currentSession();
		User user = null;
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			
			Query query = session.createQuery("from User where username=:userName");
			query.setParameter("userName", userName);
			List<User> list = query.list();
			if(!list.isEmpty())
				user = (User)list.get(0);	//��ȡ��ѯ����ĵ�һ����¼
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			if(tx != null)
				tx.rollback();
			throw e;
		}
		session.close();
		return user;
	}
	
	public List getMatchProducts(int sortId, String keyword) throws HibernateException {
		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		List list = null;
		String strSql;
		
		try {
			if(sortId == -1) {
				strSql = "from Product where name like '%" + keyword + "%'";
			} else {
				strSql = "from Product where sortid='" + sortId + "'";
			}
			Query query = session.createQuery(strSql);
			list = query.list();
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			if(tx != null)
				tx.rollback();
			throw e;
		}
		HibernateUtil.closeSession();
		return list;
	}
	
	//����ʵ���������Ӧ�ļ�¼
	public void save(Object obj) throws HibernateException {
		Session session = HibernateUtil.currentSession();
		if(obj != null) {
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				session.save(obj);
				tx.commit();
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				if(tx != null)
					tx.rollback();
				throw e;
			}
		}
		session.close();
	}
	
	//�޸�ʵ���������Ӧ�ļ�¼
	public void update(Object obj) throws HibernateException {
		Session session = HibernateUtil.currentSession();
		if(obj != null) {
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				session.update(obj);
				tx.commit();
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				if(tx != null)
					tx.rollback();
				throw e;
			}
		}
		session.close();
	}
	
	//ɾ����������Ӧ�Ķ���
	public void delete(Object obj) throws HibernateException {
		Session session = HibernateUtil.currentSession();
		if(obj != null) {
			Transaction tx = null;
			try {
				tx = session.beginTransaction();
				session.delete(obj);
				tx.commit();
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				if(tx != null)
					tx.rollback();
				throw e;
			}
		}
		session.close();
	}
}
