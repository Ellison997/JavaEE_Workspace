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
	//根据用户名得到会员对象
	public User getUser(String userName){
		Session session = HibernateUtil.currentSession();
		User user =null;
		Transaction tx=null;
		try{
		//开启一个事务，因为hibernate的事务不是自动提交的，所以要手动提交
		tx=session.beginTransaction();
		//创建查询对象
		Query query=session.createQuery("from User where username=:userName");
		
		query.setParameter("userName",userName);
		List list=query.list();
		if(!list.isEmpty())
			user =(User) list.get(0);	//获取查询结果的第一个元素
			
		tx.commit();	//事务提交
		}catch (HibernateException e) {	//捕获可能出现的异常
			// TODO: handle exception
			if(tx!=null)
				tx.rollback();		//回滚出现的操作
			throw e;
		}			
		session.close();
		return user;
	}
	
	
	//得到所有符合条件的商品对象
	
	public List getMatchProducts(int sortId,String keyword) {
		Session session=HibernateUtil.currentSession();
		Transaction tx=session.beginTransaction();
		List list=null;
		String strSql;
try {
	
	if (sortId==-1) 
		//创建一个查询语句，按关键字查询
		strSql="from Product where name like '%"+keyword+"%'";
		else
			strSql="from Product where sortid'"+sortId+"'";
	Query query=session.createQuery(strSql);		//创建查询对象
	list=query.list();	//从数据库中读取数据，并自动封装到list集合中
	tx.commit();
	
} catch (HibernateException e) {
	// TODO: handle exception
	if(tx!=null)
		tx.rollback();
	throw e;
}

HibernateUtil.closeSession();	//关闭回话
return list;
		
		
	}
	
	//得到所有的商品类别对象
	@Test
	public void getCategories(){
		Session session=HibernateUtil.currentSession();
		Transaction tx=session.beginTransaction();
		List list=null;
		try {
			Query query=session.createQuery("from Category");
			//创建查询对象
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
	 *            插入实体对象所对应的记录
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
					// 事务回滚
					tran.rollback();
				throw e;

			}
		}
		// 关闭session
		session.close();
	}

	/**
	 * @return 修改实体对象所对应的记录
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
					// 事务回滚
					tran.rollback();
				throw e;

			}
		}
		// 关闭session
		session.close();
	}

	/**
	 * @param c
	 * @param id
	 *            查询一条数据根据主键的id号
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
				// 关闭session
				session.close();
			}
		}
		return object;
	}

	/**
	 * @param obj
	 * @return 删除对象所对应的记录
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
				// 事物回滚
				tran.rollback();
			}
		} finally {
			if (session != null) {
				// 关闭session
				session.close();
			}
		}
	}

	/**
	 * @param <T>
	 *            查询多条记录
	 * @param sql
	 *            sql语句
	 * @param param
	 *            参数数组
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
	 *            查询单条记录
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
	 * @return 实现分页查询
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
			// 筛选条数
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
	 * @return返回数据个数
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
