package cn.yese.content;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;

public class DownloadServlet2 extends HttpServlet {

	/**
	 * responseϸ�ڵ㣺
	 * response��õ�������Ҫ�ֶ��رգ�Tomcat����������ǹر�
	 * �ᱨ�� getWriter()��getOutputStream()����ͬʱ����
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//************�ļ����������ĵ�����*********
		// ��ȡҪ���ص��ļ�����
		String filename = request.getParameter("filename");	//???.jpg
		//���������Ĳ���������
		filename=new String(filename.getBytes("ISO8859-1"),"utf-8");
		System.out.println(filename);
		
		//�������ͷ�е�user-Agent
		String agent = request.getHeader("User-Agent");
		System.out.println(agent);
		//���ݲ�ͬ��������в�ͬ�ı���
		String filenameEncoder = "";
		if (agent.contains("MSIE")) {
			// IE�����
			filenameEncoder = URLEncoder.encode(filename, "utf-8");
			filenameEncoder = filenameEncoder.replace("+", " ");
		} else if (agent.contains("Firefox")) {
			// ��������
			BASE64Encoder base64Encoder = new BASE64Encoder();
			filenameEncoder = "=?utf-8?B?"
					+ base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
		} else {
			// ���������
			filenameEncoder = URLEncoder.encode(filename, "utf-8");				
		}
		
		// Ҫ���ص�����ļ�������---�ͻ���ͨ���ļ���MIME����ȥ��������
		response.setContentType(this.getServletContext().getMimeType(filename));
		// ������������ļ�����ֱ�ӽ��������Ѹ�������ʽ�򿪣����أ�
		response.setHeader("Content-Disposition", "attachment;filename=" + filenameEncoder);
		// ��÷������ϵ��ļ��ľ���·��
		String filePath = this.getServletContext().getRealPath("download/" + filename);
		// ��ø��ļ���������
		InputStream inputStream = new FileInputStream(filePath);
		// ����ļ����������ͨ��response����������������ͻ���д����
		ServletOutputStream outputStream = response.getOutputStream();
		int len = 0;
		byte[] buffer = new byte[1024];
		while ((len = inputStream.read(buffer)) > 0) {
			outputStream.write(buffer, 0, len);
		}
		inputStream.close();
		// outputStream.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}