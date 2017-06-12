package cn.yese.content;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡҪ���ص��ļ�����
		String filename=request.getParameter("filename");
		System.out.println(filename);
		//Ҫ���ص�����ļ�������---�ͻ���ͨ���ļ���MIME����ȥ��������
		response.setContentType(this.getServletContext().getMimeType(filename));
		//������������ļ�����ֱ�ӽ��������Ѹ�������ʽ�򿪣����أ�
		response.setHeader("Content-Disposition","attachment;filename="+filename);
		//��÷������ϵ��ļ��ľ���·��
		String filePath=this.getServletContext().getRealPath("download/"+filename);
		//��ø��ļ���������
		InputStream inputStream = new FileInputStream(filePath);
		//����ļ����������ͨ��response����������������ͻ���д����
		ServletOutputStream outputStream = response.getOutputStream();
		int len=0;
		byte[] buffer=new byte[1024];
		while((len=inputStream.read(buffer))>0){
			outputStream.write(buffer, 0, len);
		}
		inputStream.close();
		//outputStream.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}