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
 * 1������һ���༶
 * 2������һ��ѧ��
 * 3������༶ͬʱ����ѧ��
 * 4���Ѿ�����һ���༶��������һ��ѧ�����Ѹ�ѧ�����뵽�ð༶
 * 5���Ѿ�����һ���༶���Ѿ�����һ��ѧ���������ѧ���͸ð༶֮��Ĺ�ϵ
 * 6����֪���������༶����֪����һ��ѧ������ѧ����һ���༶ת�Ƶ�����һ���༶
 * 7���Ѿ�����һ���༶��������һЩѧ��������Щѧ�����뵽�ð༶
 * 8��ɾ��һ��ѧ��
 * 9���Ƴ������༶�����е�ѧ��
 * 10���Ӱ༶���Ƴ�һЩѧ��
 * 11��ɾ�������༶ 
 * @author Administrator
 */
public class OneToManySingleTest {
	HibernateUtil hiber=new HibernateUtil();
	/*
 * ����һ���༶
 */
	@Test
	public void testSaveClasses(){
		Session session=hiber.currentSession();
		Transaction tx=session.beginTransaction();
		Classes classes=new Classes();
		classes.setName("���1503");
		session.save(classes);
		tx.commit();
	}
	
	/*
	 * ����һ��ѧ��
	 */
	@Test
	public void textSaveStudent(){
		Session session=hiber.currentSession();
		Transaction tx=session.beginTransaction();
		Student student=new Student();
		student.setName("�ﴺ��");
		session.save(student);
		tx.commit();
	}
	/*
	 * ����༶��ʱ��ͬʱ����ѧ��
	 */
	@Test
	public void testSaveClassesAndStudent(){
		Session session=hiber.currentSession();
		Transaction tx=session.beginTransaction();
		Classes classes=new Classes();
		classes.setName("���1502");
		Student student=new Student();
		student.setName("�����");
		session.save(classes);
		session.save(student);
		tx.commit();
		
	}
	
	/*
	 * �ڱ���༶��ʱ��ͬʱ��������ѧ��
	 */
	@Test
	public void testSaveClasses_Cascade_Sava_Student(){
		Session session=hiber.currentSession();
		Transaction tx=session.beginTransaction();
		Classes classes=new Classes();
		classes.setName("���1501");
		/*
		 * ����һ��set���ϣ���set�������������ѧ��
		 */
		Set<Student> students=new HashSet<Student>();
		Student s1=new Student();
		s1.setName("����");
		Student s2=new Student();
		s2.setName("����");
		Student s3=new Student();
		s3.setName("�Ǻ�");
		students.add(s1);
		students.add(s2);
		students.add(s3);
		//�����༶��ѧ��֮��Ĺ���
		classes.setStudents(students);
		session.save(classes);
		tx.commit();
		
	}
/*
 * �ڱ���༶��ͬʱ��������ѧ��
 */
	@Test
	public void textSaveClasses_update_Student(){
		Session session=hiber.currentSession();
		Transaction tx=session.beginTransaction();
		Classes classes=new Classes();
		classes.setName("ˮ������");
		Set<Student> students=new HashSet<Student>();
		Student s1=(Student) session.get(Student.class, 1L);
		s1.setName("���Ц");
		Student s2=(Student) session.get(Student.class, 2L);
		s2.setName("��ϵ��");
		students.add(s1);
		students.add(s2);
		classes.setStudents(students);
		session.save(classes);
		tx.commit();
	}
	
	/*
	 * �ڸ��°༶��ʱ��������ѧ��
	 */
	@Test
	public void textUpdateClasses_Cascade_UpdateStudent(){
		Session session=hiber.currentSession();
		Transaction ta=session.beginTransaction();
		Classes classes=(Classes) session.get(Classes.class, 4L);
		classes.setName("���ǲ���");		//�޸ĵ��ǳ־û�����
		Set<Student> students=classes.getStudents();
		for(Student s:students){	//�����༶��ÿһ��ѧ��
			s.setName("Tomm");
		}
		ta.commit();
	}
	/*
	 * �Ѿ�����һ���༶��������һ��ѧ�����Ѹ�ѧ�����뵽�ð༶
	 */
	@Test
	public void testUpdateCalsses_AddStudent(){
		Session session=hiber.currentSession();
		Transaction ta=session.beginTransaction();
		//���һ��ѧ��
		Student s1=new Student();
		s1.setName("ϰ��");
		Student s2=new Student();
		s2.setName("����");
		Classes classes=(Classes) session.get(Classes.class, 2L); 
		Set<Student> students=classes.getStudents();
		students.add(s1);
		students.add(s2);
		ta.commit();
	}
	/*
	 * �Ѿ�����һ���༶������һ��ѧ���������ѧ����༶�Ĺ�ϵ
	 * ʵ���Ͼ��ǰ�ѧ�����и�ѧ����Ӧ�е��������Ϊnull
	 * 1���õ��༶
	 * 2���õ�ѧ��
	 * 3���Ӱ༶���Ƴ�ѧ��
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
	 * ��֪���������༶����֪����һ��ѧ������ѧ����һ���༶ת�Ƶ�����һ���༶
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
