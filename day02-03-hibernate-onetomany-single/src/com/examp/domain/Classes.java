package com.examp.domain;
/*
 * Java ���л������������㽫һ�������״̬д�뵽һ�� IO ������ҿ��Դ�����
 * �ط��Ѹ� IO ��������ݶ����������¹���һ����ͬ�Ķ�������е����㽫���ݴ洢
 * �����ݿ��Ȼ�����ó�������ǰ��õ��Ķ�����һ���ġ��������ֻ��������㽫����
 * ͨ��������д�������������ʱ�Ѷ���־û������ݿ⡢�ļ���ϵͳ�
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
