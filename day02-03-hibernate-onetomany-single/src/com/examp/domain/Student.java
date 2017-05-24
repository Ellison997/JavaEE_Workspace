package com.examp.domain;

import java.io.Serializable;

public class Student implements Serializable {
	private Long sid;
	private String name;
	private Classes classer;
	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Classes getClasser() {
		return classer;
	}
	public void setClasser(Classes classer) {
		this.classer = classer;
	}
	
}
