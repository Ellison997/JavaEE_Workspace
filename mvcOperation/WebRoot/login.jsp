<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	font-size:24px;
	</style>
  </head>
  
  <body>
   <!-- 
  在表单中输入用户名和密码后点击登录按钮
  进入一个页面，完成判断用户名和密码是否合法
  如果合法，进入index.jsp
  如果不合法，提示错误，重新进行登录 
  -->
   <%
  	String error = "";
  	Object oError = request.getAttribute("error");
  	if(oError != null) {
  		error = (String)oError;
  	}
   %>
   <%=error %>
   <form action="/operation/DoLogin" method="post">
   用户名：<input type="text" name="uname" id="uname" value=""/>
   <br />
   密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="text" name="upwd" id="upwd" value="" />
   <br />
   <input type="submit" name="submit" value="登录" />
    	&nbsp;&nbsp;&nbsp;&nbsp;
    	<input type="button" name="button"  value="用户注册" onclick="location.href='register.jsp'"/>
   </form> 
  </body>
</html>
