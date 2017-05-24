<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>

<head>
<base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>宿舍管理系统-登录</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>
</head>

<body class="gray-bg">
<%
  	String error = "";
  	Object oError = request.getAttribute("error");
  	if(oError != null) {
  		error = (String)oError;
  	}
   %>
   <%=error %>
    <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
            <div>

                <h1 class="logo-name">宿</h1>

            </div>
            <h3>欢迎使用 小宿管宿舍管理系统</h3>

            <form class="m-t" role="form" action="/mvcDorm/DoLogin" method="post">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="教职工编号" name="uname" id="uname" required="true">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="密码" name="upwd" id="upwd" required="true">
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>


                <p> <a onclick="location.href='register.jsp'">注册一个Admin账号</a>
                </p>

            </form>
        </div>
    </div>

    <!-- 全局js -->
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>

    
    

</body>

</html>
