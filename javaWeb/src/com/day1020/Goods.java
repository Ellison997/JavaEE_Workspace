package com.day1020;

public class Goods {
	//属性
		private String goodsName;	//商品名称
		private double price;	//商品单价
		private int quantity;	//商品库存量
	//方法
		public Goods() {
			
		}
		
		public Goods(String goodsName, double price, int quantity) {
			this.setGoodsName(goodsName);
			this.setPrice(price);
			this.setQuantity(quantity);
		}
		
		//方法
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
