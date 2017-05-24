package com.examp.ShoppingOnline;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Category {
	private int id;
	private String name;
	//当需要表示category表和product表中的1：n的关系，需要增加一个属性
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
