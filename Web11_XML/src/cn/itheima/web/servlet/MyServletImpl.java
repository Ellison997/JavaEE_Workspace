package cn.itheima.web.servlet;

public class MyServletImpl implements IMyServlet {

	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("��ʼ�� ��");
	}
	
	@Override
	public void service() {
		// TODO Auto-generated method stub
		System.out.println("�ҿ���Ϊ�����");
	}
	
	@Override
	public void destory() {
		// TODO Auto-generated method stub
		System.out.println("���� �����ˣ�");
	}

}
