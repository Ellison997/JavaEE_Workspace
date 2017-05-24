<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.day1020.GDAO" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>删除</title>
    
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
    <%
 request.setCharacterEncoding("UTF-8");
   String gname=request.getParameter("name");
   GDAO gdao=new GDAO();
   
   boolean bl=gdao.delete(gname);
   if(bl){
   response.sendRedirect("index.jsp");
   }else{
   out.print("删除失败！");
    response.sendRedirect("index.jsp");
   }  
 %>
  </body>
</html>
