package com.examp.ShoppingOnline.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.examp.ShoppingOnline.Category;
import com.examp.ShoppingOnline.Product;

/*
 * 实现Category对象的所有查询操作
 */
public class CategoryOperator {
	//获取所有Category实体的所有属性信息
	public List<Category> getCategories() {
		Session session = HibernateUtil.currentSession();
		Query query = session.createQuery("from Category");
		List list = query.list();
		return list;
	}
	
	//添加
	public int saveProductAndCategoryWithCasecase() {
		Category c = new Category();
		c.setName("家具");
		Product p = new Product();
		p.setName("沙发");
		p.setPrice(2000);
		p.setSaleprice(2000);
		p.setDescript("sofa");
		p.setSaledate("2017-3-31");
		c.getProducts().add(p);
		
		DBOperator db = new DBOperator();
		db.save(c);
		return c.getId();
	}
}
