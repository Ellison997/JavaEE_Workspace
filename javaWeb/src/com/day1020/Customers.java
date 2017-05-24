package com.day1020;

public class Customers {
    
	
	private int id;
	private String cusName;
	private String address;
	
	public Customers(){
		
	}
	
	public Customers(int id,String cusName,String address){
		this.setID(id);
		this.setCusName(cusName);
		this.setAddress(address);	
	}
	
	public int getID() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
