package com.sitcl.mvcoperation.model;

public class Goods {

	private String goodsName;			//商品名
	private double price;		//价格
	private int quantity;		//库存量
	
	//方法
	public Goods() {
	
	}
	public Goods(String goodsName, double price, int quantity) {
		super();
		this.goodsName = goodsName;
		this.price = price;
		this.quantity = quantity;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
