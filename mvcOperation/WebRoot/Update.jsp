<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.tool.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改货品信息</title>
    
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
    String name=new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
   %>
     <h1>修改商品信息</h1>
    <form action="/operation/DoUpdate" method="post">
    <p>
    商品名称：<input type="text" name="goodsname" value="<%=name%>"/>
    </p>
    <p>
    商品单价：<input type="text" name="price" />
    </p>
    <p>
    商品库存：<input type="text" name="quantity" />
    </p>
    <p>
			<input type="submit" value="修改" />
		</p>
    </form>
  </body>
</html>
