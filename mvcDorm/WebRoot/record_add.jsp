<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" href="lib/reserve/bootstrap.css">
<link rel="stylesheet" href="lib/reserve/theme.css">

<base href="<%=basePath%>">

<title>添加学生违纪信息</title>

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
			<li><a href="record.jsp"> 学生违纪记录 </a> <span class="divider">/</span>
			</li>
			<li class="active">添加记录</li>
		</ul>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="bb-alert alert alert-info" style="display: none;">
					<span>操作成功</span>
				</div>
				<!-- START 以上内容不需更改，保证该TPL页内的标签匹配即可 -->

				<div class="well">
					<ul class="nav nav-tabs">
						<li class="active"><a href="http://www.baidu.com"
							data-toggle="tab">请填写要添加违纪记录</a>
						</li>
					</ul>
					<div id="myTabContent" class="tab-content">
						<div class="tab-pane active in" id="home">
							<form id="tab" method="post" action="/mvcDorm/Record_DoAdd"
								autocomplete="off">
								<label>学号</label> <input type="text" name="number" value=""
									class="input-xlarge" autofocus="true" required="true">
									<label>姓名</label> <input type="text" name="name" value=""
									class="input-xlarge" autofocus="true" required="true">
										<label>班级</label> <input type="text" name="squad" value=""
										class="input-xlarge" autofocus="true" required="true">
											<div class="form-group">
												<label class="col-sm-2 control-label">检查时间</label>
												<div class="col-sm-10">
													<input name="time" id="hello"
														class="laydate-icon form-control layer-date">
												</div>
												<br />
											</div><label>违纪类型</label> <select name="typee" id=""
									class="input-xlarge">
									<option value="夜不归宿">夜不归宿</option>
									<option value="违禁">违禁</option>
								</select>


								<div class="btn-toolbar">
									<button type="submit" class="btn btn-primary">
										<strong>添加</strong>
									</button>
									<div class="btn-group"></div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- 全局js -->
	<script src="js/jquery.min.js?v=2.1.4"></script>
	<script src="js/bootstrap.min.js?v=3.3.6"></script>



	<!-- 自定义js -->
	<script src="js/content.js?v=1.0.0"></script>


	<!-- layerDate plugin javascript -->
	<script src="js/plugins/layer/laydate/laydate.js"></script>
	<script>
        //外部js调用
        laydate({
            elem: '#hello', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
            event: 'focus' //响应事件。如果没有传入event，则按照默认的click
        });

        //日期范围限制
        var start = {
            elem: '#start',
            format: 'YYYY/MM/DD hh:mm:ss',
            min: laydate.now(), //设定最小日期为当前日期
            max: '2099-06-16 23:59:59', //最大日期
            istime: true,
            istoday: false,
            choose: function (datas) {
                end.min = datas; //开始日选好后，重置结束日的最小日期
                end.start = datas //将结束日的初始值设定为开始日
            }
        };
        var end = {
            elem: '#end',
            format: 'YYYY/MM/DD hh:mm:ss',
            min: laydate.now(),
            max: '2099-06-16 23:59:59',
            istime: true,
            istoday: false,
            choose: function (datas) {
                start.max = datas; //结束日选好后，重置开始日的最大日期
            }
        };
        laydate(start);
        laydate(end);
    </script>

</body>
</html>
