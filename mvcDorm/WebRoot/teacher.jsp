<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.sitcl.mvcoperation.service.TeachersService"%>
<%@ page import="com.sitcl.mvcoperation.model.Manage"%>
<%@ page import="com.sitcl.mvcoperation.dao.TeachersDAO"%>
<%@ include file="checkSession.jsp"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户端基本信息</title>
<link rel="stylesheet" type="text/css"
	href="lib/bootstrap/css/bootstrap.css">
<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
<link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
<script src="lib/jquery-1.11.1.min.js" type="text/javascript"></script>
<style type="text/css">
#below {
	position: fixed;
	bottom: 110px;
	width: 100%;
	right: 5px;
}
</style>
<!-- 引导程序，字体，主题界面-->
<script type="text/javascript"> 
function del(){ 
if(!confirm("确认要删除？")){ 
window.event.returnValue = false; 
} 
} 
</script> 
</head>
<body class=" theme-blue">

	<div class="content">
		<div class="header">
			<h1 class="page-title">教职工人员入住信息</h1>
		</div>
		<div class="main-content">
			<div class="btn-toolbar list-toolbar">
				<a href="teacher_add.jsp">
				<button class="btn btn-primary">
					<i class="fa fa-plus"></i>添加教师
				</button>
				</a>
			<!-- 
			<button class="btn btn-default">Import</button>
				 -->	
				<div class="btn-group"></div>
			</div>
			<table class="table">
				<thead>

					<tr>
						<th>教师编号</th>
						<th>教师姓名</th>
						<th>性别</th>
						<th>联系电话</th>
						<th>学院</th>
						<th>管理楼层</th>
						<th>职位</th>
						<th style="width: 4.5em;"></th>
					</tr>

				</thead>

				<tbody>
					<%
				TeachersService tServer=new TeachersService();
				ArrayList<Manage> list=tServer.selectTeachers();
				for(int i=0;i<list.size();i++){
				Manage m=(Manage)list.get(i);

 %>
					<tr>
						<td><%=m.getTnumber() %></td>
						<td><%=m.getTname() %></td>
						<td><%=m.getTsex() %></td>
						<td><%=m.getTphone() %></td>
						<td><%=m.getTcollege() %></td>
						<td><%=m.getTmanage() %></td>
						<td><%=m.getTposition() %></td>
						<td><a href="teacher_update.jsp?tnumber=<%=m.getTnumber() %>&&tname=<%=m.getTname() %>"><i class="fa fa-pencil"></i> </a>
					
					<a href="/mvcDorm/Teacher_DoDele?tnumber=<%=m.getTnumber() %>" onclick="return del()"><i
								class="fa fa-trash-o"></i> </a>
					
					
						<!--  <a  role="button" data-toggle="modal"><i
								class="fa fa-trash-o" ></i> </a>
							 -->	
								</td>
					</tr>
					<%
					}
					 %>

				</tbody>
			</table>
			<!--ul class="pagination">
				<li><a href="#">&laquo;</a></li>
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li><a href="#">&raquo;</a></li>
			</ul-->
			<div class="modal small fade" id="myModal" tabindex="-1"
				role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
							<h3 id="myModalLabel">确认删除</h3>
						</div>
						<div class="modal-body">
							<p class="error-text">
								<i class="fa fa-warning modal-icon"></i>确认删除此条教职工记录？
							</p>
						</div>
						<div class="modal-footer">
					
							<button class="btn btn-default" data-dismiss="modal"
								aria-hidden="true">返回</button>
								
							<button class="btn btn-danger" data-dismiss="modal">删除</button>
						</div>
					</div>
				</div>
			</div>
			<div id="below">
				<footer>
					<hr>
					<p class="pull-right">
						小宿管 宿舍管理系统 <a href=# " target="_blank">&&欢迎你的登录</a>
					</p>
					<p>
						© 2016 <a href="#" target="_blank">小宿管</a>
					</p>
				</footer>
			</div>
		</div>
	</div>
	<script src="lib/bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
</body>
</html>
