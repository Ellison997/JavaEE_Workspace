<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="checkSession.jsp" %>
<%@ include file="time.jsp" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<style type="text/css">
#timename{
	position:fixed;
	right:30px;
	top: 10px;
	font-size:20px;
	font-weight:bold;
	color:#336;
	}

</style>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="renderer" content="webkit">
<title>小宿管 宿舍管理系统</title>
<meta name="keywords" content="">
<meta name="description" content="">

<!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->

<link rel="shortcut icon" href="favicon.ico">
<link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/style.css?v=4.1.0" rel="stylesheet">
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div id="wrapper"> 
  <!--左侧导航开始-->
  <nav class="navbar-default navbar-static-side" role="navigation">
    <div class="nav-close"><i class="fa fa-times-circle"></i> </div>
    <div class="sidebar-collapse">
      <ul class="nav" id="side-menu">
        <li class="nav-header">
          <div class="dropdown profile-element"> <a data-toggle="dropdown" class="dropdown-toggle" href="#"> <span class="clear"> <span class="block m-t-xs" style="font-size:30px;"> <img src="img/STU_TO.png" width="60" height="60"/> <strong class="font-bold" >小宿管</strong> </span> </span> </a> </div>
          <div class="logo-element">大宿管 </div>
        </li>
        <li class="hidden-folded padder m-t m-b-sm text-muted text-xs"> <span class="ng-scope">导航</span> </li>
        <li> <a class="J_menuItem" href="index_v1.html"> <i class="fa fa-picture-o"></i> <span class="nav-label">主页</span> </a> </li>
        <li> <a href="#"> <i class="fa fa fa-bar-chart-o"></i> <span class="nav-label">校园人员统计</span> <span class="fa arrow"></span> </a>
          <ul class="nav nav-second-level">
            <li> <a class="J_menuItem" href="teacher.jsp">教职工管理</a> </li>
            <li> <a class="J_menuItem" href="student.jsp">学生管理</a> </li>
          </ul>
        </li>
        <li class="line dk"></li>
        <li class="hidden-folded padder m-t m-b-sm text-muted text-xs"><span class="ng-scope">宿舍管理</span> </li>
        <li> <a class="J_menuItem" href="dorm_one.jsp"><i class="fa fa-home"></i><span class="nav-label">一号宿舍楼</span></a></li>
        <li> <a class="J_menuItem" href="dorm_two.jsp"><i class="fa fa-home"></i><span class="nav-label">二号宿舍楼</span></a></li>
        <li> <a class="J_menuItem" href="dorm_three.jsp"><i class="fa fa-home"></i><span class="nav-label">三号宿舍楼</span></a></li>
        <li> <a class="J_menuItem" href="dorm_five.jsp"><i class="fa fa-home"></i><span class="nav-label">五号宿舍楼</span></a>
        </li>
        <li class="line dk"></li>
        <li class="hidden-folded padder m-t m-b-sm text-muted text-xs"> <span class="ng-scope">人员管理</span> </li>
        <li> <a class="J_menuItem" href="student_lodge.jsp"><i class="fa fa-flask"></i> <span class="nav-label">学生入住管理</span></a> </li>
        <li> <a class="J_menuItem" href="record.jsp"><i class="fa fa-table"></i> <span class="nav-label">缺寝记录</span></a> </li>
        <li class="line dk"></li>
        <li class="hidden-folded padder m-t m-b-sm text-muted text-xs"> <span class="ng-scope">帮助</span> </li>
        <li> <a class="J_menuItem" href="http://www.baidu.com"><i class="fa fa-desktop"></i> <span class="nav-label">百度</span></a> </li>
        <li> <a href="login.jsp"><i class="fa fa-magic"></i> <span class="nav-label">退出登录</span></a> </li>
      </ul>
    </div>
  </nav>
  <!--左侧导航结束--> 
  <!--右侧部分开始-->
  <div id="page-wrapper" class="gray-bg dashbard-1">
    <div class="row border-bottom">
      <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header"><a class="navbar-minimalize minimalize-styl-2 btn btn-info " href="#"><i class="fa fa-bars"></i> </a>

        </div>
        <div id="timename">欢迎用户<%=user%>   &nbsp;&nbsp;  <%=currentDate%></div>
        
        <!--ul class="nav navbar-top-links navbar-right">
          <li class="dropdown"> <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#"> <i class="fa fa-envelope"></i> <span class="label label-warning">16</span> </a>
         </li>
        </ul-->
      </nav>
    </div>
    <div class="row J_mainContent" id="content-main">
    
    <!--iframe name="content" src="client_basic.php" frameborder="0" width=100% height="740" overflow-x: hidden; overflow-y: auto; ></iframe-->
    
      <iframe id="J_iframe" width="100%" height="100%" src="index_v1.html" frameborder="0"  overflow-x: hidden; overflow-y: auto; data-id="index_v1.html" seamless></iframe>
    </div>
  </div>
  <!--右侧部分结束--> 
</div>

<!-- 全局js --> 
<script src="js/jquery.min.js?v=2.1.4"></script> 
<script src="js/bootstrap.min.js?v=3.3.6"></script> 
<script src="js/plugins/metisMenu/jquery.metisMenu.js"></script> 
<script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script> 
<script src="js/plugins/layer/layer.min.js"></script> 

<!-- 自定义js --> 
<script src="js/hAdmin.js?v=4.1.0"></script> 
<script type="text/javascript" src="js/index.js"></script> 

<!-- 第三方插件 --> 
<script src="js/plugins/pace/pace.min.js"></script>
</body>
</html>
