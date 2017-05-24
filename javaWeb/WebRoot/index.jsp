<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" import="java.lang.Math" %>
<%--@ path import="java.lang.Math" --%>
<!-- language:制定JSP页面常用脚本 ，默认值：JAVA -->
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

<title>My JSP 'index.jsp' starting page</title>
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
	啦啦啦 我要向数组中添加十个字符串，哈哈哈
	<br>
	<%
		ArrayList arr = new ArrayList();
		for (int i = 1; i <= 11; i++) {
			if (i >= 1 && i <= 10) {
				arr.add("第" + i + "个字符串");
			} else {
				out.println("添加完毕");
			}
		}
	%>
	<br>
	<font size="4px">JSP表达式</font>
	PI的值：<%out.println(Math.PI);%><br>
	1000,9999中最大的值为：<% out.println(Math.max(10000, 9999)); %><br>
	1000,999中最小的值为：<% out.println(Math.min(10000, 9999)); %><br>
	1+2-3的值为：<% out.println(1+2-3); %><br>
	1+2==3的值为：<% out.println(1+2==3); %><br>
	1+2！=3的值为：<% out.println(1+2!=3); %><br>
	
	1~100之间的连续和为:
	<% 
	int sum=0;
	for(int z=1;z<=100;z++){
	sum+=z;
	}
	out.println(sum);
	%>
	<br>
	<font size=20px> JSP Scriptlet(小脚本)</font>
	
	<table width="400" border="1" bgcolor="#00f">
	<%
    int i;
    for(i=1;i<=9;i++)
    {
    out.println("<tr>");
    out.println("<td>循环值：</td>");
    out.println("<td>"+i+"</td>"); 
    out.println("</tr>");
    
    }
    
     %>
	</table>
	
</body>
</html>
