<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
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
  	<div id="div1">
    	用户信息注册：
    	<form action="register.action" method="post">
    	<table>
    		<tr>
    			<td>姓名:</td>
    			<td><input type="text" name="username" /></td>
    		</tr>
    		<tr>
    			<td>密码:</td>
    			<td><input type="password" name="password" /></td>
    		</tr>
    		<tr>
    			<td>确认密码:</td>
    			<td><input type="password" name="password2" /></td>
    		</tr>
    		<tr>
    			<td>真实姓名:</td>
    			<td><input type="text" name="realname" /></td>
    		</tr>
    		<tr>
    			<td>联系电话:</td>
    			<td><input type="text" name="tel" /></td>
    		</tr>
    		<tr>
    			<td>家庭地址:</td>
    			<td><input type="text" name="address" /></td>
    		</tr>
    		<tr>
    			<td>邮政编码:</td>
    			<td><input type="text" name="zip" /></td>
    		</tr>
    		<tr>
    			<td>Email:</td>
    			<td><input type="text" name="email" /></td>
    		</tr>
    		<tr>
    			<td colspan="2"><input type="submit" value="注册" /></td>
    		</tr>
    	</table>
    	</form>
    </div>
  </body>
</html>
