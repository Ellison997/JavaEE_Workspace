package com.examp.ShoppingOnline;

public class Order {
private int id;
private String orderno;
private User user;
private String realname;
private String address;
private String zip;
private String tel;
private String payment;
private String email;
private String memo;
private double price;
private String time;
private int tag;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getOrderno() {
	return orderno;
}
public void setOrderno(String orderno) {
	this.orderno = orderno;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public String getRealname() {
	return realname;
}
public void setRealname(String realname) {
	this.realname = realname;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getZip() {
	return zip;
}
public void setZip(String zip) {
	this.zip = zip;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}
public String getPayment() {
	return payment;
}
public void setPayment(String payment) {
	this.payment = payment;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMemo() {
	return memo;
}
public void setMemo(String memo) {
	this.memo = memo;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public int getTag() {
	return tag;
}
public void setTag(int tag) {
	this.tag = tag;
}

	
}
