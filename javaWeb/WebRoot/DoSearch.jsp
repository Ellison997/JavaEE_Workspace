<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.day1020.Goods" %>
<%@ page import="com.day1020.GoodsDAO" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'DoSearch.jsp' starting page</title>
    
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
    <%--
    	接收搜索页面传递过来的参数：操作符和具体价格
    	根据搜索条件进行搜索，获取满足要求的数据
    	如果这些数据存在，显示相应的商品信息
    	如果没有满足要求的数据存在，提示相关的信息
     --%>
     <%
     //1.获取用户填写的数据
     String op=request.getParameter("sc");
     String strPrice=request.getParameter("price");
     double price =0.0;
     if(strPrice !=null && !strPrice.equals("")){
     price=Double.parseDouble(strPrice);
     }
     if(op.equals("")){
     //必须设置查询条件，才能显示商品信息
     //response.sendRedirect("search.jsp");
     //没有设置查询条件，显示所有商品信息
     response.sendRedirect("index.jsp");
     }
      %>
      <table border="1" width="80%">
      <tr>
      <td>商品名称</td>
      <td>价格</td>
      <td>库存</td>
      </tr>
      <%
      //2.根据接受的数据进行查询
      //数据库的操作，不放在JSP页面进行书写
     GoodsDAO gDao=new GoodsDAO();
     ArrayList<Goods> list=gDao.selectByPrice(op,price);
     if(list!=null){
        if(list.size()==0){
        //没有满足的数据
        %>
        <tr>
            <td colspan="3" align="center">没有要查询相应的商品</td>
         </tr>
         <%
         }else{
               //有满足要求的数据，显示这些数据
               for(int i=0;i<list.size();i++){
               Goods g=(Goods)list.get(i);
               if(i%2==0){
               %>
               <tr bgcolor="#ccc">
               <%
               }else{
               %>
               <tr bgcolor="gray"> 
               <%
               }
               %>
               <td><%=g.getGoodsName() %></td>
               <td><%=g.getPrice() %></td>
               <td><%=g.getQuantity() %></td>
               </tr>
               <%
                   }
               
               }
               
          }   
       %>
      </table>
  </body>
</html>
