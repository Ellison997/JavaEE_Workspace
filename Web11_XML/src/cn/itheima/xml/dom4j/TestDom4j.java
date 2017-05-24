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
			//��ȡ������
			SAXReader sr=new SAXReader();
			//��ȡ�ĵ�����
			Document read = sr.read("src/cn/itheima/xml/dtd/web-app.xml");
			//��ȡ��Ԫ��
			Element rootElement = read.getRootElement();
			System.out.println(rootElement.getName());
			//��ȡ��Ԫ�����е���Ԫ��
			@SuppressWarnings("unchecked")
			List<Element> elements = rootElement.elements();
			//������Ԫ��
			for (Element element : elements) {
				//�ж�Ԫ����Ϊservlet��Ԫ��
				if("servlet".equals(element.getName())){
					Element servletName = element.element("servlet-name");
					//��ȡservletClass Ԫ��
					Element servletClass=element.element("servlet-class");
					//��ӡԪ�ص�ֵ
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
