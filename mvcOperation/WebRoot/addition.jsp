<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加商品</title>
    
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
  <h1>添加商品</h1>
    <form action="/operation/DoAddition" method="post">
    <p>
    商品名称：<input type="text" name="goodsname" />
    </p>
    <p>
    商品单价：<input type="text" name="price" />
    </p>
    <p>
    商品库存：<input type="text" name="quantity" />
    </p>
    <p>
			<input type="submit" value="添加" />
		</p>
    </form>
  </body>
</html>
