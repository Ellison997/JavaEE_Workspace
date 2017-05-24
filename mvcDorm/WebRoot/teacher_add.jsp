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
    
    <title>教职工人员入住信息修改</title>
    
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

<div class="content">
<ul class="breadcrumb">
  <li><a href="teacher.jsp"> 教职工人员入住信息 </a> <span class="divider">/</span></li>
  <li class="active">添加教职工</li>
</ul>
<div class="container-fluid">
  <div class="row-fluid">
    <div class="bb-alert alert alert-info" style="display: none;"> <span>操作成功</span> </div>
    <!-- START 以上内容不需更改，保证该TPL页内的标签匹配即可 -->
    
    <div class="well">
      <ul class="nav nav-tabs">
        <li class="active"><a href="http://www.baidu.com" data-toggle="tab">请填写要添加教职工资料</a></li>
      </ul>
      <div id="myTabContent" class="tab-content">
        <div class="tab-pane active in" id="home">
		<form id="tab" method="post" action="/mvcDorm/Teacher_DoAdd" autocomplete="off">
          <label>教师编号</label>
          <input type="text" name="tnumber" value="" class="input-xlarge" autofocus="true" required="true" >
          <label>教师姓名</label>
          <input type="text" name="tname" value="" class="input-xlarge" required="true" >
          <label>性别</label>
          <input type="text" name="tsex" value="" class="input-xlarge" required="true">
           <label>管理楼层</label>
          <input type="text" name="tmanage" value="入住" class="input-xlarge" autofocus="true" >
          <label>联系电话</label>
          <input type="text" name="tphone" value="" class="input-xlarge" required pattern="\d{11}" >
           
          <label>学院</label>
          <select name="tcollege" id="" class="input-xlarge">
              <option value="电信学院">电信学院</option>
              <option value="会计学院">会计学院</option>
              <option value="艺术与建筑学院">艺术与建筑学院</option>
              <option value="机电学院">机电学院</option>
              <option value="金融高等职业技术学院">金融高等职业技术学院</option>
            </select>
           <label>职位</label>
           <select name="tposition" id="" class="input-xlarge">
              <option value="值班教师">值班教师</option>
              <option value="老师">教师</option>
              <option value="宿管大爷">宿管大爷</option>
            </select>
          <div class="btn-toolbar">
            <button type="submit" class="btn btn-primary"><strong>添加</strong></button>
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
