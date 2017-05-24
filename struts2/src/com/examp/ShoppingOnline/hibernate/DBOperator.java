package com.examp.ShoppingOnline.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.examp.ShoppingOnline.User;

/*
 * 完成所有对象的增、删、改操作
 */
public class DBOperator {
	//根据用户名得到会员对象
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
				user = (User)list.get(0);	//获取查询结果的第一个记录
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
	
	//插入实体对象所对应的记录
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
	
	//修改实体对象所对应的记录
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
	
	//删除对象所对应的对象
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
