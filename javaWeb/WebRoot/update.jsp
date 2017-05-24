<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改</title>
    
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
    <h1>修改货品信息界面</h1>
    <%
   request.setCharacterEncoding("UTF-8");
   String name=request.getParameter("name");
   
    %>
    
    <form action="DoUpdate.jsp" method="post">
    <p>
    商品名称：<input type="text" name="name" value="<%=name%>" />
    </p>
    <p>
   商品单价：<input type="text" name="price" />
    </p>
    <p>
    商品库存量：<input type="text" name="quantity" />
    </p>
    <p>
			<input type="submit" value="修改"  />
		</p>
    </form>
  </body>
</html>
