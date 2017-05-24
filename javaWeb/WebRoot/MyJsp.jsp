<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.day1020.Customers,com.day1020.CusDAO"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'MyJsp.jsp' starting page</title>
    
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
    <table border="1">
  <tr>
  	<td>客户编号</td>
  	<td>客户姓名</td>
  	<td>客户地址</td>
  </tr>
  <%! 
        CusDAO cDao = new CusDAO();
		ArrayList list = cDao.selectAll();	
   %>	
   <%		
		for(int i= 0; i < list.size(); i++) {
			Customers c = (Customers)list.get(i);
	%>	
    <tr>
    <td><%=c.getID() %></td>
    <td><%=c.getCusName() %></td>
    <td><%=c.getAddress() %></td>
    </tr>			
	<% 
		}
	%>
	</table>
  </body>
</html>
