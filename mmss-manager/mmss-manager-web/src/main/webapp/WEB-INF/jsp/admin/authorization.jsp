<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1 , user-scalable=no">
<%@ include file="../common/global.jsp"%>
<link href="${ctx}/css/auth.css" rel="stylesheet">
<title>权限管理</title>
</head>
<body>
	<!--导航-->
	<nav class="navbar navbar-default">
		<div class="container">
			<!--小屏幕导航按钮和logo-->
			<div class="navbar-header">
				<button class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a href="first.do" class="navbar-brand">MMSS</a>
			</div>
			<!--小屏幕导航按钮和logo-->
			<!--导航-->
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="first.do"><span
							class="glyphicon glyphicon-home"></span>&nbsp;&nbsp;后台首页</a></li>
					<li class="active"><a href="authorization.do"><span
							class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;权限管理</a></li>
					<li><a href="flow.do"><span
							class="glyphicon glyphicon-tasks"></span>&nbsp;&nbsp;调度管理</a></li>
					<li><a href="tag.html"><span
							class="glyphicon glyphicon-tags"></span>&nbsp;&nbsp;物资管理</a></li>
					<li><a href="tag.html"><span
							class="glyphicon glyphicon-tags"></span>&nbsp;&nbsp;车辆管理</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a id="dLabel" type="button"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							${activeUser.username } <span class="caret"></span>
					</a>
						<ul class="dropdown-menu" aria-labelledby="dLabel">
							<li><a href="index.html"><span
									class="glyphicon glyphicon-screenshot"></span>&nbsp;&nbsp;前台首页</a></li>
							<li><a href="index.html"><span
									class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;个人主页</a></li>
							<li><a href="index.html"><span
									class="glyphicon glyphicon-cog"></span>&nbsp;&nbsp;个人设置</a></li>
							<li><a href="index.html"><span
									class="glyphicon glyphicon-credit-card"></span>&nbsp;&nbsp;账户中心</a></li>
							<li><a href="index.html"><span
									class="glyphicon glyphicon-heart"></span>&nbsp;&nbsp;我的收藏</a></li>
						</ul></li>
					<li><a href="loginout.do"><span
							class="glyphicon glyphicon-off"></span>&nbsp;&nbsp;退出</a></li>
				</ul>
			</div>
			<!--导航-->

		</div>
	</nav>
	<!--导航-->
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2">
				<ul id="main-nav" class="nav nav-tabs nav-stacked" style="">
					<li class="active"><a href="first.do"> <i
							class="glyphicon glyphicon-th-large"></i> 首页
					</a></li>
					<li><a href="#" class="nav-header collapsed"
						data-toggle="collapse"> <i class="glyphicon glyphicon-cog"></i>
							权限管理 <span class="pull-right glyphicon glyphicon-chevron-down"></span>
					</a>
						<ul id="systemSetting" class="nav nav-list collapse secondmenu"
							style="height: 0px;">
							<li><a href="#"><i class="glyphicon glyphicon-user"></i>用户管理</a></li>
							<li><a href="#"><i class="glyphicon glyphicon-th-list"></i>菜单管理</a></li>
							<li><a href="#"><i class="glyphicon glyphicon-asterisk"></i>角色管理</a></li>
							<li><a href="#"><i class="glyphicon glyphicon-edit"></i>修改密码</a></li>
							<li><a href="#"><i class="glyphicon glyphicon-eye-open"></i>日志查看</a></li>
						</ul></li>
					<li><a href="./plans.html"> <i
							class="glyphicon glyphicon-credit-card"></i> 物料管理
					</a></li>

					<li><a href="./grid.html"> <i
							class="glyphicon glyphicon-globe"></i> 分发配置 <span
							class="label label-warning pull-right">5</span>
					</a></li>

					<li><a href="./charts.html"> <i
							class="glyphicon glyphicon-calendar"></i> 图表统计
					</a></li>
					<li><a href="#"> <i class="glyphicon glyphicon-fire"></i>
							关于系统
					</a></li>

				</ul>
			</div>
		</div>
	</div>


	<footer>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<p>
						Copyright&nbsp;©&nbsp;2012-2015&nbsp;&nbsp;www.maiziedu.com&nbsp;&nbsp;蜀ICP备13014270号-4
					</p>
				</div>
			</div>
		</div>
	</footer>
	<!--footer-->

</body>
</html>