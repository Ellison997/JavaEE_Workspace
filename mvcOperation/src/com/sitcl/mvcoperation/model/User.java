package com.sitcl.mvcoperation.model;

public class User {
	private int uid;	//用户编号
	private String uname;	//用户名
	private String upwd;	//密码
	private String address;	//地址
	private int sex = 0;	//性别
	//0——女，1——男
	
	//private String[] habit;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	
}
