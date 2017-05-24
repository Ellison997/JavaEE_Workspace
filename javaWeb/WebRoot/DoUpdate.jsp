<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.day1020.Goods" %>
<%@ page import="com.day1020.GDAO" %>
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
   <%
 request.setCharacterEncoding("UTF-8");
   String gname=request.getParameter("name");
   String strprice=request.getParameter("price");
   String strquantity=request.getParameter("quantity");
   double price=0;
   if(strprice!=null && !strprice.equals("")){
   price=Double.parseDouble(strprice);
   }
   int quantity=0;
   if(strquantity!=null && !strquantity.equals("")){
   quantity=Integer.parseInt(strquantity);
   }
   Goods g=new Goods();
   g.setGoodsName(gname);
   g.setPrice(price);
   g.setQuantity(quantity);
   GDAO gdao=new GDAO();
   
   boolean isb=gdao.update(g);
   if(isb){
   response.sendRedirect("index.jsp");
   }else{
   out.print("修改失败！");
    response.sendRedirect("update.jsp");
   }
      
    %> 
  </body>
</html>
