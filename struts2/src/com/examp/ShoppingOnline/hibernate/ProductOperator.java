package com.examp.ShoppingOnline.hibernate;

import java.util.List;

import org.hibernate.Session;

import com.examp.ShoppingOnline.Product;

public class ProductOperator {
	public Product getProduct(int id) {
		Session session = HibernateUtil.currentSession();
		Product p = (Product)session.load(Product.class, id);
		return p;
	}
}
