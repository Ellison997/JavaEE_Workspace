package cn.itheima.web.servlet;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class testMyServlet {
	@Test
	public void testMyServlet() {
		MyServletImpl ml = new MyServletImpl();
		ml.init();
		ml.service();
		ml.destory();
	}

	@Test
	public void testMySerlet1() {
		// TODO Auto-generated method stub
		try {
			String className = "cn.itheima.web.servlet.MyServletImpl";
			Class clazz = Class.forName(className);
			MyServletImpl mli = (MyServletImpl) clazz.newInstance();
			mli.init();
			mli.service();
			mli.destory();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testSum() {
		System.out.println(12 * 7);

	}

	@Test
	public void testMyServletAndXml() {
		try {
			SAXReader ar = new SAXReader();
			String xmlSrc = "src/cn/itheima/xml/schema/web.xml";
			Document document = ar.read(xmlSrc);
			// 获取根节点
			Element rootElement = document.getRootElement();
			List<Element> elements = rootElement.elements("servlet");
			for (Element element : elements) {
				Element eleServletName = element.element("servlet-name");
				System.out.println(eleServletName.getName());
				if (eleServletName.getText().equals("MyServletImpl")) {
					String servletClass = element.element("servlet-class").getText();
					System.out.println(servletClass);
					Class<?> clazz = Class.forName(servletClass);
					MyServletImpl ms = (MyServletImpl) clazz.newInstance();
					ms.init();
					ms.service();
					ms.destory();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
