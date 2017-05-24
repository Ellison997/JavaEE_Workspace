package cn.itheima.xml.dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class TestDom4j {
	@Test
	public void testReadWebXML(){
		try {
			//获取解析器
			SAXReader sr=new SAXReader();
			//获取文档对象
			Document read = sr.read("src/cn/itheima/xml/dtd/web-app.xml");
			//获取根元素
			Element rootElement = read.getRootElement();
			System.out.println(rootElement.getName());
			//获取根元素所有的子元素
			@SuppressWarnings("unchecked")
			List<Element> elements = rootElement.elements();
			//遍历子元素
			for (Element element : elements) {
				//判断元素名为servlet的元素
				if("servlet".equals(element.getName())){
					Element servletName = element.element("servlet-name");
					//获取servletClass 元素
					Element servletClass=element.element("servlet-class");
					//打印元素的值
					System.out.println(servletName.getText());
					System.out.println(servletClass.getText());
				}
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
