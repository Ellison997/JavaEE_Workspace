package cn.itheima.web.servlet;

public class MyServletImpl implements IMyServlet {

	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("初始化 啊");
	}
	
	@Override
	public void service() {
		// TODO Auto-generated method stub
		System.out.println("我可以为你服务！");
	}
	
	@Override
	public void destory() {
		// TODO Auto-generated method stub
		System.out.println("哈哈 我走了！");
	}

}
