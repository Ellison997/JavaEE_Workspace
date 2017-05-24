<%@page import="com.eswork.mvcempsys.dao.EmployeeDAO"%>
<%@page import="com.eswork.mvcempsys.model.Post"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<%
	ArrayList<Post> psList = null;
	Object oPost = session.getAttribute("posts");
	//System.out.print(oEmp);
	if (oPost != null) {
		psList = (ArrayList) oPost;

	} else {
		request.getRequestDispatcher("employeeSearch.jsp").forward(
				request, response);
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>查询页面</title>

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
</style>

<script type="text/javascript">
window.onsubmit=function(){
var psName=document.getElementById("ps_name");
if(psName.value==""){
alert("请选择一项职位！");
return false;
}
return true;
};
</script>

</head>

<body>
	<h1>员工查询</h1>
	<form action="/es_work/GetEmployyee" method="post" >
		<p>
			雇员姓名：<input type="text" value="" name="em_name" id="em_name">
		</p>
		<p>
			公司职位：<select name="ps_name" id="ps_name">
				<option value="" >请选择要查询的职位</option>
				<%
				
					for (int i = 0; i < psList.size(); i++) {
						Post post = (Post) psList.get(i);
				%>
				<option value=<%=post.getID()%>><%=post.getName()%></option>
				<%
					}
				%>
			</select>
		</p>
		<p>
			<input type="submit" value="查询雇员明细">
		</p>
	</form>
</body>
</html>
