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
		//获取要下载的文件名称
		String filename=request.getParameter("filename");
		System.out.println(filename);
		//要下载的这个文件的类型---客户端通过文件的MIME类型去区分类型
		response.setContentType(this.getServletContext().getMimeType(filename));
		//告诉浏览器该文件不是直接解析而是已附件的形式打开（下载）
		response.setHeader("Content-Disposition","attachment;filename="+filename);
		//获得服务器上的文件的绝对路径
		String filePath=this.getServletContext().getRealPath("download/"+filename);
		//获得该文件的输入流
		InputStream inputStream = new FileInputStream(filePath);
		//获得文件的输出流。通过response获得输出流，用于向客户端写内容
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