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
    <title>小宿管-注册</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">
    <script>
    if(window.top !== window.self){ window.top.location = window.location;}
    </script>

</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen   animated fadeInDown">
        <div>
            <div>

                <h1 class="logo-name">宿</h1>

            </div>
            <h3>欢迎注册 小宿管</h3>
            <p>创建一个Admin新账户</p>
            <form class="m-t" role="form" action="/mvcDorm/DoRegister" method="post">
                <div class="form-group">
                    <input type="text" name="tnumber" class="form-control" placeholder="教职工编号" required="true">
                </div>
                <div class="form-group">
                    <input type="text" name="tname" class="form-control" placeholder="姓名" required="true">
                </div>
                <div class="form-group">
                    <input type="text" name="tphone" class="form-control" placeholder="联系电话" required pattern="\d{11}">
                </div>
               
                <div class="form-group">
                    <input type="text" name="tcollege" class="form-control" placeholder="所在学院" required="true">
                </div>
                <div class="form-group">
                    <input type="password" name="tpwd" class="form-control" placeholder="密码" required="true">
                </div>
                <div class="form-group">
                    <input type="password" name="tpwd1" class="form-control" placeholder="确认密码" required="true">
                </div>
                <div class="form-group text-left">
                    <div class="checkbox i-checks">
                        <label class="no-padding">
                            <input type="checkbox"><i></i> 我同意注册协议</label>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">注 册</button>

                <p class="text-muted text-center"><small>已经有账户了？</small><a href="login.jsp">点此登录</a>
                </p>

            </form>
        </div>
    </div>

    <!-- 全局js -->
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>
    <!-- iCheck -->
    <script src="js/plugins/iCheck/icheck.min.js"></script>
    <script>
        $(document).ready(function () {
            $('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
        });
    </script>

    
    

</body>

</html>
