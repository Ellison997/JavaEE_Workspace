package cn.yese.register;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;

import cn.yese.utils.C3P0Utils;
public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����request�ı��뷽ʽ��ֻ�ʺ�POTS����
		request.setCharacterEncoding("utf-8");
		
		//ʹ��BeanUtils�����Զ�ӳ���װ
		//BeanUtils����ԭ����map�е����ݸ���key��ʵ������ԵĶ�Ӧ��ϵ��װֻҪkey��������ʵ��������Ե�����һ�����Զ���װ��ʵ����
		Map<String, String[]> properties = request.getParameterMap();
		User user = new User();
		try {
			BeanUtils.populate(user, properties);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		//�������User�����Ѿ�������
		//����uid�ǿյģ��ֶ���סuid--uuid--������ظ����ַ���32λ--java�������ɺ�36λ
		user.setUid(UUID.randomUUID().toString());
		//���������ݸ�һ��ҵ���������
		int register = register(user);
		if(register>0){
			//ע��ɹ���ת����¼ҳ��,ת���ķ�ʽ��Ч�ʱȽϸߣ����ǵ�ַ������
			//request.getRequestDispatcher("/login.jsp").forward(request, response);
			
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}
		
	}
	//ע��ķ���
	public int register(User user){
		//�������ݿ�
		int count=0;
		QueryRunner runner=new QueryRunner(C3P0Utils.getDataSource());
		String sql = "insert into user(uid,username,password,name,email,birthday,sex) values (?,?,?,?,?,?,?)";
		Object[] object={user.getUid(),user.getUsername(),user.getPassword(),user.getName(),
				user.getEmail(),user.getBirthday(),user.getSex()};
		try {
			count=runner.update(sql,object);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}