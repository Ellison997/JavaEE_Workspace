package cn.yese.content;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ByteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//使用response获取字节输出流
		ServletOutputStream out = response.getOutputStream();
		
		//获取服务器上的文件
		String path=this.getServletContext().getRealPath("/download/a.jpg");
		InputStream iss=new FileInputStream(path);
		
		int len=0;
		byte[] buffer=new byte[1024];
		while((len=iss.read(buffer))>0){
			out.write(buffer, 0, len);
			
		}
		iss.close();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}