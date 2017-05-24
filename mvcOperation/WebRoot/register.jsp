<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>用户注册</title>

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
	<h1>用户注册</h1>

	<form action="/operation/DoRegister" method="post">
		<p>
			用户名：<input type="text" name="uname" />
		</p>
		<p>
			密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="upwd" />
		</p>
		<p>
			确认密码：<input type="password" name="upwd1" />
		</p>
		<p>
			地&nbsp;&nbsp;&nbsp;&nbsp;址：<input type="text" name="address" />
		</p>

		<p>
			性别：<input type="radio" name="sex" value="1" />男 &nbsp;&nbsp; <input
				type="radio" name="sex" value="0">女
		</p>
		<p>
			爱好：<input type="checkbox" name="habit" value="football" />足球 <input
				type="checkbox" name="habit" value="basketball" />篮球 <input
				type="checkbox" name="habit" value="pingpang" />乒乓球
		</p>
		<p>
			<input type="submit" value="提交" />
		</p>

	</form>
</body>
</html>
