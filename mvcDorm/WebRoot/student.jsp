<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.sitcl.mvcoperation.model.Student"%>
<%@page import="com.sitcl.mvcoperation.service.StudentService"%>
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
<title>学生基本信息</title>
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
			<h1 class="page-title">学生入住信息</h1>
		</div>
		<div class="main-content">
			<div class="btn-toolbar list-toolbar">
				<button class="btn btn-primary" onclick="location.href='student_add.jsp'">
					<i class="fa fa-plus"></i>添加学生
				</button>
				<div class="btn-group"></div>
			</div>
			<table class="table">
				<thead>

					<tr>
						<th>学生学号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>宿舍号</th>
						<th>床位</th>
						<th>学院</th>
						<th>手机号</th>
						<th>家庭住址</th>
						<th style="width: 4.5em;"></th>
					</tr>

				</thead>

				<tbody>
					<%
					StudentService sService=new StudentService();
					ArrayList<Student> list=sService.selectStudent();
					for(int i=0;i<list.size();i++){
					Student s=list.get(i);
					
					%>
					<tr>
						<td><%=s.getSnumber() %></td>
						<td><%=s.getSname() %></td>
						<td><%=s.getSsex() %></td>
						<td><%=s.getSclass() %></td>
						<td><%=s.getSbed() %></td>
						<td><%=s.getScollege() %></td>
						<td><%=s.getSphone() %></td>
						<td><%=s.getSaddress() %></td>
			
						<td><a href="student_update.jsp?snumber=<%=s.getSnumber() %>&&sname=<%=s.getSname() %>&&ssex=<%=s.getSsex() %>"><i class="fa fa-pencil"></i> </a>
					
					<a href="/mvcDorm/Student_Dodel?snumber=<%=s.getSnumber() %>" onclick="return del()"><i
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
								<i class="fa fa-warning modal-icon"></i>确认删除此条学生信息？
							</p>
						</div>
						<div class="modal-footer">
						<%
						request.setCharacterEncoding("UTF-8");
						String tnumber = request.getParameter("tnumber");
						out.print(tnumber);
						 %>
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
