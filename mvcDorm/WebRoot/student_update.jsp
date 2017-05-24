<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="lib/reserve/bootstrap.css">
<link rel="stylesheet" href="lib/reserve/theme.css">

    <base href="<%=basePath%>">
    
    <title>学生入住信息修改</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  
<body class="theme-blue">
<%
   request.setCharacterEncoding("UTF-8");
    String snumber=new String(request.getParameter("snumber").getBytes("ISO-8859-1"),"UTF-8");
     String sname=new String(request.getParameter("sname").getBytes("ISO-8859-1"),"UTF-8");
   String ssex=new String(request.getParameter("ssex").getBytes("ISO-8859-1"),"UTF-8");
   %>
<div class="content">
<ul class="breadcrumb">
  <li><a href="student.jsp"> 学生入住信息 </a> <span class="divider">/</span></li>
  <li class="active">修改学生信息</li>
</ul>
<div class="container-fluid">
  <div class="row-fluid">
    <div class="bb-alert alert alert-info" style="display: none;"> <span>操作成功</span> </div>
    <!-- START 以上内容不需更改，保证该TPL页内的标签匹配即可 -->
    
    <div class="well">
      <ul class="nav nav-tabs">
        <li class="active"><a href="http://www.baidu.com" data-toggle="tab">请填写要修改的信息资料</a></li>
      </ul>
      <div id="myTabContent" class="tab-content">
        <div class="tab-pane active in" id="home">
		<form id="tab" method="post" action="/mvcDorm/Student_DoUpdate" autocomplete="off">
          <label>学生学号</label>
          <input type="text" name="snumber" value="<%=snumber %>" class="input-xlarge" autofocus="true" required="true" >
          <label>姓名</label>
          <input type="text" name="sname" value="<%=sname%>" class="input-xlarge" required="true" >
          <label>性别</label>
          <input type="text" name="ssex" value="<%=ssex%>" class="input-xlarge" required="true">
          <label>联系电话</label>
          <input type="text" name="sphone" value="" class="input-xlarge" required pattern="\d{11}" >
            <label>家庭住址</label>
          <input type="text" name="saddress" value="" class="input-xlarge" autofocus="true"  >
          <label>学院</label>
          <select name="scollege" id="" class="input-xlarge">
              <option value="电信学院">电信学院</option>
              <option value="会计学院">会计学院</option>
              <option value="艺术与建筑学院">艺术与建筑学院</option>
              <option value="机电学院">机电学院</option>
              <option value="金融高等职业技术学院">金融高等职业技术学院</option>
            </select>
            <label>宿舍号</label>
          <input type="text" name="sclass" value="" class="input-xlarge" required="true">
           <label>床位号</label>
           <select name="sbed" id="" class="input-xlarge">
              <option value="1">一号床</option>
              <option value="2">二号床</option>
              <option value="3">三号床</option>
              <option value="4">四号床</option>
              <option value="5">五号床</option>
              <option value="6">六号床</option>
              <option value="7">七号床</option>
              <option value="8">八号床</option>
            </select>
          <div class="btn-toolbar">
            <button type="submit" class="btn btn-primary"><strong>修改</strong></button>
            <div class="btn-group"></div>
          </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
</div>
</body>
</html>
