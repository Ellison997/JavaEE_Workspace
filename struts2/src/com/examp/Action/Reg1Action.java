package com.examp.Action;

import com.examp.ShoppingOnline.User;
import com.examp.ShoppingOnline.hibernate.DBOperator;
import com.opensymphony.xwork2.Action;

public class Reg1Action implements Action {
	private String username;	//用户名
	private String password;	//密码
	private String password2;	//确认密码
	private String realname;	//真实姓名
	private String tel;			//联系电话
	private String address;		//家庭地址
	private String zip;			//邮编
	private String email;		//Email地址
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(this.getPassword().equals(this.getPassword2())) {
			User user = new User();
			user.setUsername(this.getUsername());
			user.setPassword(this.getPassword());
			user.setRealname(this.getRealname());
			user.setTel(this.getTel());
			user.setAddress(this.getAddress());
			user.setZip(this.getZip());
			user.setEmail(this.getEmail());
			
			DBOperator op = new DBOperator();
			op.save(user);
			
			return SUCCESS;
		}
		return INPUT;
	}

}
