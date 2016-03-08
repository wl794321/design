<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1 , user-scalable=no">
<%@ include file="common/global.jsp"%>
<link href="${ctx}/css/style.css" rel="stylesheet">
<title>物资调度管理系统</title>
</head>
<body>
	<nav class="navbar navbar-default navbar-static-top">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only"></span> <span class="icon-bar"> </span> <span
					class="icon-bar"> </span> <span class="icon-bar"></span>
			</button>
			<a href="#" class="navbar-brand"><i class="fa fa-leaf"></i>&nbsp;物资调度管理系统</a>
		</div>
		<ul class="nav navbar-nav navbar-right" style="margin-right: 25px;">
			<li><a href="#"><span class="badge"
					style="background: #AC2925;">23</span></a></li>
			<li><a href="#"><span class="glyphicon glyphicon-off"></span>&nbsp;注销</a></li>
		</ul>
		<!--
            	作者：1044913154@qq.com
            	时间：2016-02-29
            	描述：侧边功能栏
            -->
		<div class="navbar-default navbar-collapse" id="slider-sub">
			<ul class="nav" style="text-align: center;">
				<li>
					<!--
                        	作者：1044913154@qq.com
                        	时间：2016-02-29
                        	描述：搜索
                        -->
					<div class="input-group mysearch">
						<input type="text" class="form-control" /> <span
							class="input-group-btn">
							<button type="button" class="btn btn-default">
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</span>
					</div>
				</li>
				<li id="t1"><a href="#sub1" data-toggle="collapse"><i
						class="fa fa-cog"></i>&nbsp;系统功能<span
						class="glyphicon glyphicon-chevron-up pull-right"></span></a>
					<ul id="sub1" class="nav collapse menu">
						<li><a href="javascript:;" _link="main.html"><i
								class="fa fa-user"></i>&nbsp;用户管理</a></li>
						<li><a href="javascript:;"><i class="fa fa-user-plus"></i>&nbsp;角色管理</a></li>
						<li><a href="javascript:;"><i class="fa fa-cogs"></i>&nbsp;权限管理</a></li>
						<li><a href="javascript:;"><i class="fa fa-user"></i>&nbsp;角色权限</a></li>
					</ul></li>
				<li id="t2"><a href="#sub2" data-toggle="collapse"><i
						class="fa fa-tasks"></i>&nbsp;流程功能<span
						class="glyphicon glyphicon-chevron-up pull-right"></span></a>
					<ul id="sub2" class="nav collapse menu">
						<li><a href="javascript:;"><i
								class="glyphicon glyphicon-user"></i>&nbsp;用户管理</a></li>
						<li><a href="javascript:;"><i
								class="glyphicon glyphicon-user"></i>&nbsp;角色管理</a></li>
						<li><a href="javascript:;"><i
								class="glyphicon glyphicon-user"></i>&nbsp;权限管理</a></li>
						<li><a href="javascript:;"><i
								class="glyphicon glyphicon-user"></i>&nbsp;角色权限</a></li>
					</ul></li>
				<li id="t3"><a href="#sub3" data-toggle="collapse"><i
						class="fa fa-cog"></i>&nbsp;栏目功能<span
						class="glyphicon glyphicon-chevron-up pull-right"></span></a>
					<ul id="sub3" class="nav collapse menu">
						<li><a href="javascript:;"><i
								class="glyphicon glyphicon-user"></i>&nbsp;用户管理</a></li>
						<li><a href="javascript:;"><i
								class="glyphicon glyphicon-user"></i>&nbsp;角色管理</a></li>
						<li><a href="javascript:;"><i
								class="glyphicon glyphicon-user"></i>&nbsp;权限管理</a></li>
						<li><a href="javascript:;"><i
								class="glyphicon glyphicon-user"></i>&nbsp;角色权限</a></li>
					</ul></li>
				<li id="t4"><a href="#sub4" data-toggle="collapse"><i
						class="fa fa-cog"></i>&nbsp;新闻功能<span
						class="glyphicon glyphicon-chevron-up pull-right"></span></a>
					<ul id="sub4" class="nav collapse menu">
						<li><a href="#"><i class="glyphicon glyphicon-user"></i>&nbsp;用户管理</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-user"></i>&nbsp;角色管理</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-user"></i>&nbsp;权限管理</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-user"></i>&nbsp;角色权限</a></li>
					</ul></li>

			</ul>
		</div>
	</nav>
	<div class="page-main">

		<iframe id="main" name="main" frameborder="0" scrolling="yes" src=""></iframe>
	</div>
	<script src="${ctx}/js/index.js"></script>

</body>
</html>