package com.day1020;

public class Goods {
	//����
		private String goodsName;	//��Ʒ����
		private double price;	//��Ʒ����
		private int quantity;	//��Ʒ�����
	//����
		public Goods() {
			
		}
		
		public Goods(String goodsName, double price, int quantity) {
			this.setGoodsName(goodsName);
			this.setPrice(price);
			this.setQuantity(quantity);
		}
		
		//����
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
