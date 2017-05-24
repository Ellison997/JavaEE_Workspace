<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.day1020.UsersDAO" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'doLogin.jsp' starting page</title>
    
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
    <!-- 获取用户在表单中输入的用户名和密码 -->
    <%
    String s1 = request.getParameter("uname");
    String s2 = request.getParameter("upwd");
     %>
     用户名：<%
     out.println(s1);
      %>
      <br />
      密码：<%=s2 %>
      <%
      UsersDAO udao=new UsersDAO();
      boolean b=udao.selectByNameAndPwd(s1, s2);
      if(b){
      response.sendRedirect("index.jsp");
      }else{
      out.println("失败");
      }
      
       %>
  </body>
</html>
