package cn.iteima.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testUtil {

	@Test
	public void demo1(){
		System.out.println("测试Test");
	}
	
	@Before
	public void demoBedore(){
		System.out.println("方法前");
		
	}
	
	@After
	public void demoAfter(){
		System.out.println("方法后！");
	}
	
	
}
