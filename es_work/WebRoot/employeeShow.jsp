<%@page import="com.eswork.mvcempsys.model.Employee"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%
	ArrayList<Employee> emList = null;
	Object oEmp = session.getAttribute("emp");
	//System.out.print(oEmp);
	if (oEmp != null) {
		emList = (ArrayList) oEmp;

	} else {
		request.getRequestDispatcher("employeeSearch.jsp").forward(
				request, response);
	}
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>员工信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
body {
	text-align: center;
}

td {
	text-align: center;
}
</style>

</head>

<body>
	<h1>员工基本资料</h1>
	<table width="400px" border="1" align="center">
		<tr>
			<th>姓名</th>
			<th>性别</th>
			<th>年龄</th>
			<th>职位名称</th>
		<tr />
		<%
			for (int i = 0; i < emList.size(); i++) {
				Employee emp = (Employee) emList.get(i);
		%>
		<tr>
			<td><%=emp.getName()%></td>
			<td><%=emp.getSex()%></td>
			<td><%=emp.getAge()%></td>
			<td><%=emp.getPost_Id()%></td>

		</tr>
		<%
			}
		%>

	</table>
</body>
</html>
