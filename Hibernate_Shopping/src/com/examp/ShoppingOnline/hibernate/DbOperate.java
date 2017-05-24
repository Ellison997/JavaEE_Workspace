package com.examp.ShoppingOnline.hibernate;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.examp.ShoppingOnline.User;

public class DbOperate {
	//�����û����õ���Ա����
	public User getUser(String userName){
		Session session = HibernateUtil.currentSession();
		User user =null;
		Transaction tx=null;
		try{
		//����һ��������Ϊhibernate���������Զ��ύ�ģ�����Ҫ�ֶ��ύ
		tx=session.beginTransaction();
		//������ѯ����
		Query query=session.createQuery("from User where username=:userName");
		
		query.setParameter("userName",userName);
		List list=query.list();
		if(!list.isEmpty())
			user =(User) list.get(0);	//��ȡ��ѯ����ĵ�һ��Ԫ��
			
		tx.commit();	//�����ύ
		}catch (HibernateException e) {	//������ܳ��ֵ��쳣
			// TODO: handle exception
			if(tx!=null)
				tx.rollback();		//�ع����ֵĲ���
			throw e;
		}			
		session.close();
		return user;
	}
	
	
	//�õ����з�����������Ʒ����
	
	public List getMatchProducts(int sortId,String keyword) {
		Session session=HibernateUtil.currentSession();
		Transaction tx=session.beginTransaction();
		List list=null;
		String strSql;
try {
	
	if (sortId==-1) 
		//����һ����ѯ��䣬���ؼ��ֲ�ѯ
		strSql="from Product where name like '%"+keyword+"%'";
		else
			strSql="from Product where sortid'"+sortId+"'";
	Query query=session.createQuery(strSql);		//������ѯ����
	list=query.list();	//�����ݿ��ж�ȡ���ݣ����Զ���װ��list������
	tx.commit();
	
} catch (HibernateException e) {
	// TODO: handle exception
	if(tx!=null)
		tx.rollback();
	throw e;
}

HibernateUtil.closeSession();	//�رջػ�
return list;
		
		
	}
	
	//�õ����е���Ʒ������
	@Test
	public void getCategories(){
		Session session=HibernateUtil.currentSession();
		Transaction tx=session.beginTransaction();
		List list=null;
		try {
			Query query=session.createQuery("from Category");
			//������ѯ����
			list=query.list();
			tx.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			if(tx!=null)
			tx.rollback();
			throw e;
		
		}
		
		HibernateUtil.closeSession();
		
	}
	
	
	
	
	/**
	 * @param obj
	 *            ����ʵ���������Ӧ�ļ�¼
	 * @return
	 */
	public static void save(Object obj) {
		Session session = null;
		Transaction tran = null;

		session = HibernateUtil.currentSession();

		if (obj != null) {
			try {
				tran = session.beginTransaction();
				session.save(obj);
				tran.commit();
			} catch (HibernateException e) {
				if (tran != null)
					// ����ع�
					tran.rollback();
				throw e;

			}
		}
		// �ر�session
		session.close();
	}

	/**
	 * @return �޸�ʵ���������Ӧ�ļ�¼
	 */
	public static void update(Object obj) {
		Session session = null;
		Transaction tran = null;

		session = HibernateUtil.currentSession();

		if (obj != null) {
			try {
				tran = session.beginTransaction();
				session.update(obj);
				tran.commit();
			} catch (HibernateException e) {
				if (tran != null)
					// ����ع�
					tran.rollback();
				throw e;

			}
		}
		// �ر�session
		session.close();
	}

	/**
	 * @param c
	 * @param id
	 *            ��ѯһ�����ݸ���������id��
	 * @return
	 */
	public static Object get(Class c, int id) {
		Session session = null;
		Object object = null;
		try {
			session = HibernateUtil.currentSession();
			object = session.get(c, id);
		} catch (Exception e) {
		} finally {
			if (session != null) {
				// �ر�session
				session.close();
			}
		}
		return object;
	}

	/**
	 * @param obj
	 * @return ɾ����������Ӧ�ļ�¼
	 */
	public static void delete(Object obj) {
		Session session = null;
		Transaction tran = null;
		try {
			session = HibernateUtil.currentSession();
			tran = session.beginTransaction();
			
			session.delete(obj);
			tran.commit();
		} catch (Exception e) {
			if (tran != null) {
				// ����ع�
				tran.rollback();
			}
		} finally {
			if (session != null) {
				// �ر�session
				session.close();
			}
		}
	}

	/**
	 * @param <T>
	 *            ��ѯ������¼
	 * @param sql
	 *            sql���
	 * @param param
	 *            ��������
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> query(String sql, String[] param) {

		List<T> list = new ArrayList<T>();
		Session session = null;
		try {
			session = HibernateUtil.currentSession();
			Query query = session.createQuery(sql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					query.setString(i, param[i]);
				}
			}
			list = query.list();
		} catch (Exception e) {
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	/**
	 * @param sql
	 * @param param
	 *            ��ѯ������¼
	 * @return
	 */
	public static Object queryOne(String sql, String[] param) {
		Object object = null;
		Session session = null;
		try {
			session = HibernateUtil.currentSession();
			Query query = session.createQuery(sql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					query.setString(0, param[i]);
				}
				object = query.uniqueResult();
			}
		} catch (Exception e) {
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return object;
	}

	/**
	 * @param <T>
	 * @param sql
	 * @param param
	 * @param page
	 * @param size
	 * @return ʵ�ַ�ҳ��ѯ
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> queryByPage(String sql, String[] param, int page,
			int size) {
		List<T> list = new ArrayList<T>();
		Session session = null;
		try {
			session = HibernateUtil.currentSession();
			Query query = session.createQuery(sql);
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					query.setString(i, param[i]);
				}
			}
			// ɸѡ����
			query.setFirstResult((page - 1) * size);
			query.setMaxResults(size);
			list = query.list();
		} catch (Exception e) {
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	/**
	 * @param hql
	 * @return�������ݸ���
	 */
	public static int getCount(String hql, String[] pras) {
		int resu = 0;
		Session s = null;
		try {
			s = HibernateUtil.currentSession();
			Query q = s.createQuery(hql);
			if (pras != null) {
				for (int i = 0; i < pras.length; i++) {
					q.setString(i, pras[i]);
				}
			}
			resu = Integer.valueOf(q.iterate().next().toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (s != null)
				s.close();
		}
		return resu;
	}

}
