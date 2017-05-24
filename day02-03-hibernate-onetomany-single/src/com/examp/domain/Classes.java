package com.examp.domain;
/*
 * Java 序列化技术可以让你将一个对象的状态写入到一个 IO 流里，并且可以从其它
 * 地方把该 IO 流里的数据读出来。重新构造一个相同的对象。这就有点像你将数据存储
 * 到数据库里，然后再拿出来，这前后得到的东西是一样的。它的这种机制允许你将对象
 * 通过网络进行传播，并可以随时把对象持久化到数据库、文件等系统里。
 */
import java.io.Serializable;		
import java.util.Set;

public class Classes implements Serializable{
	private Long cid;
	private String name;
	private Set<Student> students;
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	

}
