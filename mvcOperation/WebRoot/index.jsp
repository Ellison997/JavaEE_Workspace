<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.sitcl.mvcoperation.service.GoodsService"%>
<%@ page import="com.sitcl.mvcoperation.model.Goods"%>
<%@ page import="com.sitcl.mvcoperation.dao.GoodsDAO"%>
<%@ include file="checkSession.jsp" %>
<%@ include file="time.jsp" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>商品信息</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
font-size
:
40px;
</style>
</head>
<body>
	<h4>
		欢迎<%=user%>用户进入系统
		<br>
		<%=currentDate%>
	</h4>
	<h1>商品管理系统</h1>
	<input type=button value="添加商品" onclick="location.href='addition.jsp'" />
	<p>
	<table width="400px" border="0">
		<tr>
			<td>商品名称</td>
			<td>商品单价</td>
			<td>商品库存量</td>
		</tr>

		<%
			GoodsService gService=new GoodsService();
			ArrayList<Goods> list = gService.selectGoods();
			for (int i = 0; i < list.size(); i++) {
				Goods g = (Goods) list.get(i);
		%>
		<%
			if (i % 2 == 0) {
		%>
		<tr bgcolor="#CCCCCC">
			<%
				} else {
			%>
		
		<tr>
			<%
				}
			%>
			<td><%=g.getGoodsName()%></td>
			<td><%=g.getPrice()%></td>
			<td><%=g.getQuantity()%></td>
			<td><a
				href="Update.jsp?name=<%=g.getGoodsName()%>">修改</a>
			</td>
			<td><a
				href="Delete.jsp?method=transparams&name=<%=g.getGoodsName()%>">删除</a>
			</td>
		</tr>
		<%
			}
		%>
	</table>
	在这个页面搭建整个后台界面，包含对商品的维护，对订单的处理。
	<input type=button value="退出登录" onclick="location.href='login.jsp'" />
</body>
</html>
