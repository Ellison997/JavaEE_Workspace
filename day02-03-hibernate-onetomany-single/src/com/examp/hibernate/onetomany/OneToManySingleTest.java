package com.examp.hibernate.onetomany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.examp.ShoppingOnline.hibernate.HibernateUtil;
import com.examp.domain.Classes;
import com.examp.domain.Student;

/**
 * 1、保存一个班级
 * 2、保存一个学生
 * 3、保存班级同时保存学生
 * 4、已经存在一个班级，新增加一个学生，把该学生加入到该班级
 * 5、已经存在一个班级，已经存在一个学生，解除该学生和该班级之间的关系
 * 6、已知存在两个班级，已知存在一个学生，该学生从一个班级转移到另外一个班级
 * 7、已经存在一个班级，新增加一些学生，把这些学生加入到该班级
 * 8、删除一个学生
 * 9、移除整个班级的所有的学生
 * 10、从班级中移除一些学生
 * 11、删除整个班级 
 * @author Administrator
 */
public class OneToManySingleTest {
	HibernateUtil hiber=new HibernateUtil();
	/*
 * 保存一个班级
 */
	@Test
	public void testSaveClasses(){
		Session session=hiber.currentSession();
		Transaction tx=session.beginTransaction();
		Classes classes=new Classes();
		classes.setName("软件1503");
		session.save(classes);
		tx.commit();
	}
	
	/*
	 * 保存一个学生
	 */
	@Test
	public void textSaveStudent(){
		Session session=hiber.currentSession();
		Transaction tx=session.beginTransaction();
		Student student=new Student();
		student.setName("田春乐");
		session.save(student);
		tx.commit();
	}
	/*
	 * 保存班级的时候同时保存学生
	 */
	@Test
	public void testSaveClassesAndStudent(){
		Session session=hiber.currentSession();
		Transaction tx=session.beginTransaction();
		Classes classes=new Classes();
		classes.setName("软件1502");
		Student student=new Student();
		student.setName("孙旭杰");
		session.save(classes);
		session.save(student);
		tx.commit();
		
	}
	
	/*
	 * 在保存班级的时候同时级联保存学生
	 */
	@Test
	public void testSaveClasses_Cascade_Sava_Student(){
		Session session=hiber.currentSession();
		Transaction tx=session.beginTransaction();
		Classes classes=new Classes();
		classes.setName("软件1501");
		/*
		 * 创建一个set集合，往set集合中添加三个学生
		 */
		Set<Student> students=new HashSet<Student>();
		Student s1=new Student();
		s1.setName("哈哈");
		Student s2=new Student();
		s2.setName("嘻嘻");
		Student s3=new Student();
		s3.setName("呵呵");
		students.add(s1);
		students.add(s2);
		students.add(s3);
		//建立班级与学生之间的关联
		classes.setStudents(students);
		session.save(classes);
		tx.commit();
		
	}
/*
 * 在保存班级的同时级联更新学生
 */
	@Test
	public void textSaveClasses_update_Student(){
		Session session=hiber.currentSession();
		Transaction tx=session.beginTransaction();
		Classes classes=new Classes();
		classes.setName("水波梁上");
		Set<Student> students=new HashSet<Student>();
		Student s1=(Student) session.get(Student.class, 1L);
		s1.setName("你的笑");
		Student s2=(Student) session.get(Student.class, 2L);
		s2.setName("我系话");
		students.add(s1);
		students.add(s2);
		classes.setStudents(students);
		session.save(classes);
		tx.commit();
	}
	
	/*
	 * 在更新班级的时候级联更新学生
	 */
	@Test
	public void textUpdateClasses_Cascade_UpdateStudent(){
		Session session=hiber.currentSession();
		Transaction ta=session.beginTransaction();
		Classes classes=(Classes) session.get(Classes.class, 4L);
		classes.setName("传智博客");		//修改的是持久化对象
		Set<Student> students=classes.getStudents();
		for(Student s:students){	//遍历班级的每一个学生
			s.setName("Tomm");
		}
		ta.commit();
	}
	/*
	 * 已经存在一个班级，新增加一个学生，把该学生加入到该班级
	 */
	@Test
	public void testUpdateCalsses_AddStudent(){
		Session session=hiber.currentSession();
		Transaction ta=session.beginTransaction();
		//添加一个学生
		Student s1=new Student();
		s1.setName("习惯");
		Student s2=new Student();
		s2.setName("有你");
		Classes classes=(Classes) session.get(Classes.class, 2L); 
		Set<Student> students=classes.getStudents();
		students.add(s1);
		students.add(s2);
		ta.commit();
	}
	/*
	 * 已经存在一个班级，存在一个学生，解除该学生与班级的关系
	 * 实际上就是把学生表中该学生对应行的外键设置为null
	 * 1、得到班级
	 * 2、得到学生
	 * 3、从班级中移除学生
	 */
	@Test
	public void testRelease_R(){
		Session session=hiber.currentSession();
		Transaction ta=session.beginTransaction();
		Classes classes=(Classes) session.get(Classes.class, 4L);
		Set<Student> student=classes.getStudents();
		Student s=(Student) session.get(Student.class, 2L);
		student.remove(s);
		ta.commit();
	}
	
	/*
	 * 已知存在两个班级，已知存在一个学生，该学生从一个班级转移到另外一个班级
	 */
	@Test
	public void testUpdataStudent_Classes(){
		Session session=hiber.currentSession();
		Transaction ta=session.beginTransaction();
		Classes css=(Classes) session.get(Classes.class, 2L);
		Student s=(Student) session.get(Student.class, 6L);
		Set<Student> students=css.getStudents();
		students.add(s);
		ta.commit();
		
	}
	
	@Test
	public void TestSum(){
		int arr[]={299,129,599,99,155,2995,899,185,249,1846,79,59,1399,1699,118,75};
		System.out.println(arr.length);
		for(int a=0;a<arr.length;a++){
			for(int b=0;b<arr.length;b++){
				for(int c=0;c<arr.length;c++){
					for(int d=0;d<arr.length;d++){
						for(int e=0;e<arr.length;e++){
							for(int i=0;i<arr.length;i++){
								if((a!=b)&&(b!=c)&&(c!=d)&&(d!=e)&&(e!=i)&&(i!=a)&&(a!=c)&&(a!=d)){
				if(arr[a]+arr[b]+arr[c]+arr[d]+arr[e]+arr[i]==6666){
					System.out.println(arr[a]+",,"+arr[b]+",,"+arr[c]
							+",,"+arr[d]+",,"+arr[e]+",,"+arr[i]);
				}				
				}	
			}	
						}	
					}	
				}	
			}	
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
