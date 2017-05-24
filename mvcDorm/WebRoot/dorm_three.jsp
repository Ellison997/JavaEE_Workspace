<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.sitcl.mvcoperation.service.DormService"%>
<%@ page import="com.sitcl.mvcoperation.model.Dorms"%>
<%@ include file="checkSession.jsp"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>二号宿舍楼</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">



  </head>
  
  <body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
       <div class="btn-toolbar list-toolbar">
      <button class="btn btn-primary" onclick="location.href='dorm_add.jsp'">
      <i class="fa fa-plus"></i> 添加宿舍</button>
      <div class="btn-group"> </div>
    </div>
    <br/>
        <div class="row">
     <%
     DormService dServer=new DormService();
     ArrayList<Dorms> list=dServer.selectDorm(3);
     for(int i=0;i<list.size();i++){
     Dorms d=list.get(i);     
      %>
            <div class="col-sm-4">
                <div class="contact-box">
                    <a href="profile.html">
                        <div class="col-sm-4">
                            <div class="text-center">
                                <img alt="image" class="img-circle m-t-xs img-responsive" src="<%=d.getDimg()%>">
                            </div>
                        </div>
                        <div class="col-sm-8">
                            <h3><strong><%=d.getDid() %></strong></h3>
                            <p><i class="fa fa-map-marker"></i><%=d.getDlocation() %></p>
                            <address>
                            <strong>床位：<%=d.getDbed() %>, 已入住：<%=d.getDman() %></strong><br>
                            学院：<%=d.getDcollege() %><br>
                            <abbr >剩余电量:</abbr><%=d.getDcharge() %>
                        </address>
                        </div>
                        <div class="clearfix"></div>
                    </a>
                </div>
            </div>
            
            <%
            }
             %>
            
            
        </div>
    </div>

    <!-- 全局js -->
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>



    <!-- 自定义js -->
    <script src="js/content.js?v=1.0.0"></script>



    <script>
        $(document).ready(function () {
            $('.contact-box').each(function () {
                animationHover(this, 'pulse');
            });
        });
    </script>

    
    

</body>
</html>
