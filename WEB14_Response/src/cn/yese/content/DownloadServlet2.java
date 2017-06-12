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
	 * response细节点：
	 * response获得的流不需要手动关闭，Tomcat容器会帮我们关闭
	 * 会报错 getWriter()和getOutputStream()不能同时调用
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//************文件名称是中文的下载*********
		// 获取要下载的文件名称
		String filename = request.getParameter("filename");	//???.jpg
		//解决获得中文参数的乱码
		filename=new String(filename.getBytes("ISO8859-1"),"utf-8");
		System.out.println(filename);
		
		//获得请求头中的user-Agent
		String agent = request.getHeader("User-Agent");
		System.out.println(agent);
		//根据不同浏览器进行不同的编码
		String filenameEncoder = "";
		if (agent.contains("MSIE")) {
			// IE浏览器
			filenameEncoder = URLEncoder.encode(filename, "utf-8");
			filenameEncoder = filenameEncoder.replace("+", " ");
		} else if (agent.contains("Firefox")) {
			// 火狐浏览器
			BASE64Encoder base64Encoder = new BASE64Encoder();
			filenameEncoder = "=?utf-8?B?"
					+ base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
		} else {
			// 其它浏览器
			filenameEncoder = URLEncoder.encode(filename, "utf-8");				
		}
		
		// 要下载的这个文件的类型---客户端通过文件的MIME类型去区分类型
		response.setContentType(this.getServletContext().getMimeType(filename));
		// 告诉浏览器该文件不是直接解析而是已附件的形式打开（下载）
		response.setHeader("Content-Disposition", "attachment;filename=" + filenameEncoder);
		// 获得服务器上的文件的绝对路径
		String filePath = this.getServletContext().getRealPath("download/" + filename);
		// 获得该文件的输入流
		InputStream inputStream = new FileInputStream(filePath);
		// 获得文件的输出流。通过response获得输出流，用于向客户端写内容
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