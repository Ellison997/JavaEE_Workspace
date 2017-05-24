package com.examp.ShoppingOnline;

import java.util.HashSet;
import java.util.Set;

public class Product {
	private int id;
	//可以通过category属性获得数据表中对应该产品类型的信息
	private Set<Category> categories;
	private String name;
	private double price;
	private double saleprice;
	private String descript;
	private String contents;
	private String saledate;
	private int salecount;
	private String image;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Set<Category> getCategories() {
		if(categories == null) {
			this.categories = new HashSet();
		}
		return categories;
	}
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getSaleprice() {
		return saleprice;
	}
	public void setSaleprice(double saleprice) {
		this.saleprice = saleprice;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getSaledate() {
		return saledate;
	}
	public void setSaledate(String saledate) {
		this.saledate = saledate;
	}
	public int getSalecount() {
		return salecount;
	}
	public void setSalecount(int salecount) {
		this.salecount = salecount;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
