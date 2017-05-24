package com.examp.ShoppingOnline;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Category {
	private int id;
	private String name;
	//����Ҫ��ʾcategory���product���е�1��n�Ĺ�ϵ����Ҫ����һ������
	private Set<Product> products;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Product> getProducts() {
		if(this.products == null) {
			this.products = new HashSet();
		}
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
}
