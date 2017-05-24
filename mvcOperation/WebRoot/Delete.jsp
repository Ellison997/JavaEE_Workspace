<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.sitcl.mvcoperation.dao.GoodsDAO" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>删除操作</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>

<%
	request.setCharacterEncoding("UTF-8");
   String name=new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
   %>

  <body>
  你确定要删除商品？
  <p>
 <form action="/operation/DoDelete" method="post">
 商品名称：<input type="text" name="goodsname" value="<%=name%>"/>
   <input type="submit" name="submit" value="确定" />
    	&nbsp;&nbsp;&nbsp;&nbsp;
    	<input type="button" name="button"  value="取消" onclick="location.href='index.jsp'"/>
   </form> 
  </body>
</html>
