package com.examp.ShoppingOnline.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.examp.ShoppingOnline.Category;
import com.examp.ShoppingOnline.Product;

/*
 * ʵ��Category��������в�ѯ����
 */
public class CategoryOperator {
	//��ȡ����Categoryʵ�������������Ϣ
	public List<Category> getCategories() {
		Session session = HibernateUtil.currentSession();
		Query query = session.createQuery("from Category");
		List list = query.list();
		return list;
	}
	
	//���
	public int saveProductAndCategoryWithCasecase() {
		Category c = new Category();
		c.setName("�Ҿ�");
		Product p = new Product();
		p.setName("ɳ��");
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
