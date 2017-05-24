package com.eswork.mvcempsys.model;

public class Employee {
private String ID;
private String post_Id;
private String name;
private String sex;
private int age;

public String getID() {
	return ID;
}
public void setId(String ID) {
	this.ID = ID;
}
public String getPost_Id() {
	return post_Id;
}
public void setPost_Id(String post_Id) {
	this.post_Id = post_Id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}

}
