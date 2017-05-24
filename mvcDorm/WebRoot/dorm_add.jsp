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
    
    <title>添加学生入住</title>
    
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
  <li><a href="student.jsp"> 宿舍基本信息 </a> <span class="divider">/</span></li>
  <li class="active">添加宿舍</li>
</ul>
<div class="container-fluid">
  <div class="row-fluid">
    <div class="bb-alert alert alert-info" style="display: none;"> <span>操作成功</span> </div>
    <!-- START 以上内容不需更改，保证该TPL页内的标签匹配即可 -->
    
    <div class="well">
      <ul class="nav nav-tabs">
        <li class="active"><a href="http://www.baidu.com" data-toggle="tab">请填写要添加的宿舍资料</a></li>
      </ul>
      <div id="myTabContent" class="tab-content">
        <div class="tab-pane active in" id="home">
		<form id="tab" method="post" action="/mvcDorm/Dorm_DoAdd" autocomplete="off">
          <label>宿舍编号</label>
          <input type="text" name="did" value="" class="input-xlarge" autofocus="true" required="true" >
          <label>学院</label>
          <select name="dcollege" id="" class="input-xlarge">
              <option value="电信学院">电信学院</option>
              <option value="会计学院">会计学院</option>
              <option value="艺术与建筑学院">艺术与建筑学院</option>
              <option value="机电学院">机电学院</option>
              <option value="金融高等职业技术学院">金融高等职业技术学院</option>
            </select>
          <label>位置</label>
          <input type="text" name="dlocation" value="" class="input-xlarge" required="true">
          <label>剩余电量</label>
          <input type="text" name="dcharge" value="" class="input-xlarge" required ="true" >
          <label>人数标准</label>
           <select name="dbed" id="" class="input-xlarge">
              <option value="6">六人间</option>
              <option value="8">八人间</option>
			</select>              
          
           <label>已住人数</label>
           <select name="dman" id="" class="input-xlarge">
              <option value="1">一人</option>
              <option value="2">二人</option>
              <option value="3">三人</option>
              <option value="4">四人</option>
              <option value="5">五人</option>
              <option value="6">六人</option>
              <option value="7">七人</option>
              <option value="8">八人</option>
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
