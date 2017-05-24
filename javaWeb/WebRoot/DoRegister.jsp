<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.day1020.User" %>
<%@ page import="com.day1020.UsersDAO" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'DoRegister.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%--
    	从用户注册页面接收用户填写的信息
    	把用户填写的信息添加到数据库
    	如果添加成功，用户注册是成功
    	如果添加失败，用户注册是失败
     --%>
     <%
     	//解决中文乱码，只针对form以post方式提交的中文问题
     	request.setCharacterEncoding("utf-8");
     	
     	String uname = request.getParameter("uname");
     	out.println(uname + "<br />");
     	String upwd = request.getParameter("upwd");
     	String address = request.getParameter("address");
     	String strSex = request.getParameter("sex");
     	int sex = 0;
     	if(strSex != null && !strSex.equals("")) {
     		sex = Integer.parseInt(strSex);
     	}
     	
     	//String habit = request.getParameter("habit");
     	//out.println(habit);
     	//只能接收到一个取值
     	
     	/*
     	String[] habits = request.getParameterValues("habit");
     	for(int i = 0; i < habits.length; i++) {
     		out.println(habits[i]);
     	}
     	*/
     	
     	User user = new User();
     	user.setUname(uname);
     	user.setUpwd(upwd);
     	user.setAddress(address);
     	user.setSex(sex);
     	
     	UsersDAO uDao = new UsersDAO();
     	boolean isSuccess = uDao.insert(user);
     	if(isSuccess) {
     		//进入index.jsp
     		response.sendRedirect("login.jsp");
     	} else {
     		//重新进行注册,进入register.jsp
     		response.sendRedirect("register.jsp");
     	}
      %>
  </body>
</html>
