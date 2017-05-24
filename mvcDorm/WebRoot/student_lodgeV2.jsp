<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.sitcl.mvcoperation.service.StudentService"%>
<%@ page import="com.sitcl.mvcoperation.model.Student"%>
<%@ include file="checkSession.jsp"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>学生入住管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="favicon.ico">
<link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/style.css?v=4.1.0" rel="stylesheet">

<style type="text/css">
#cent {
	width: 95%;
	height: 800px;
	position: absolute;
	left: 35px;
	top: 185px;
}
</style>


</head>

<%
  	String did = "";
  	Object dID = request.getAttribute("did");
  	if(dID != null) {
  		did = (String)dID;
  	}
   %>
<body class="gray-bg">
<div class="wrapper wrapper-content  animated fadeInRight">
  <div class="col-sm-8">
    <div class="ibox">
      <div class="ibox-content">
        <h2>学生管理</h2>
        <p> 请输入要搜索的宿舍号 </p>
        <form action="/mvcDorm/Student_DoLodge" method="post">
        <div class="input-group">
          <input type="text" name="lod" class="input form-control" size="100" placeholder="查找宿舍">
          <span class="input-group-btn">
          <button type="submit" class="btn btn btn-primary"> <i class="fa fa-search"></i> 搜索</button>
          </span> </div></form>
      </div>
    </div>
  </div>
</div>
        


<div id="cent">
       <div class="btn-toolbar list-toolbar">
      <button class="btn btn-primary" onclick="location.href='student_add.jsp'" >
      <i class="fa fa-plus"></i> 添加学生</button>
      <div class="btn-group"> </div>
    </div>
    <br/>
        <div class="row">
    <%
					StudentService sService=new StudentService();
					ArrayList<Student> list=sService.studentDorm(did);
					for(int i=0;i<list.size();i++){
					Student s=list.get(i);
					
					%>
            <div class="col-sm-4">
                <div class="contact-box">
                    <a href="profile.html">
                        <div class="col-sm-4">
                            <div class="text-center">
                                <img alt="image" class="img-circle m-t-xs img-responsive" src="<%=s.getSimg() %>">
                             <div class="m-t-xs font-bold"><%=s.getSnumber() %></div>
                            </div>
                        </div>
                        <div class="col-sm-8">
                            <h3><strong><%=s.getSname() %></strong></h3>
                            <p><i class="fa fa-map-marker"></i><%=s.getSaddress()%></p>
                            <address>
                            <strong>宿舍号：<%=s.getSclass() %>, 床位：<%=s.getSbed() %>号床</strong><br>
                            性别：<%=s.getSsex() %>
                            <br>
                            学院：<%=s.getScollege()%><br>
                            <abbr >联系电话:</abbr><%=s.getSphone() %>
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






<!-- 
	<div id="cent">
		<div class="row J_mainContent" id="content-main">
			<iframe id="J_iframe" width="100%" height="100%" src="clients.html"
				frameborder="0" data-id="www.baidu.com" seamless></iframe>
		</div>

	</div>
	 -->
	<!--
           

-->

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
