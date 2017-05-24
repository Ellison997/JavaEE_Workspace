<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
  <h1>商品销售系统</h1>
  <!-- 
  点击了登录按钮，跳转到一个页面
  页面完成接收到输入的用户名和密码、
  接收到的用户要进行判断，是否合法
  合法，登录
  不合法，提示错误，重新登录
   -->
    <form action="doLogin.jsp">
    用户名：<input type="text" name="uname" id="uname" /><br />
    密码：<input type="password" name="upwd" id="upwd" /><br />
    <input type="submit" name="submit" value="登录" />
    &nbsp;&nbsp;
   <input type="button" name="button"  value="用户注册" onclick="location.href='register.jsp'" />   
    </form>
  </body>
</html>
