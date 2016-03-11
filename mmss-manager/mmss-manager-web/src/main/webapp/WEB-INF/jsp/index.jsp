<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1 , user-scalable=no">
<%@ include file="common/global.jsp"%>
<link href="css/ace-rtl.min.css" rel="stylesheet" />
<link href="css/ace-skins.min.css" rel="stylesheet" />
<link href="css/ace.min.css" rel="stylesheet" />
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
			<a href="#" class="navbar-brand"><i class="icon-lemon"></i>&nbsp;物资调度管理系统</a>
		</div>
		<ul class="nav navbar-nav navbar-right" style="margin-right: 25px;">
			<li><a href="#"><span class="badge"
					style="background: #AC2925;">23</span></a></li>
			<li><a href="#"><span class="glyphicon glyphicon-off"></span>&nbsp;注销</a></li>
		</ul>
		</nav>
		<div class="sidebar" id="sidebar">
			<ul class="nav nav-list" id="menu"></ul>
			<div class="sidebar-collapse" id="sidebar-collapse">
				<i class="icon-double-angle-left"
					data-icon1="icon-double-angle-left"
					data-icon2="icon-double-angle-right"></i>
			</div>
		</div>
		<div class="main-content">
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12" style="padding-left: 5px;">
						<ul class="nav nav-tabs" role="tablist">
							<li class="active"><a href="#Index" role="tab"
								data-toggle="tab">首页</a></li>
						</ul>
						<div class="tab-content">
							<div role="tabpanel" class="tab-pane active" id="Index"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	

	<script src="js/ace-extra.min.js"></script>
	<script src="js/ace.min.js"></script>

	<script src="js/sidebar-menu.js"></script>
	<script src="js/bootstrap-tab.js"></script>
	<script type="text/javascript">
		$(function() {
			$('#menu').sidebarMenu({
				data : [ {
					id : '1',
					text : '系统设置',
					icon : 'icon-cog',
					url : '',
					menus : [ {
						id : '11',
						text : '编码管理',
						icon : 'icon-glass',
						url : '/CodeType/Index'
					} ]
				}, {
					id : '2',
					text : '基础数据',
					icon : 'icon-leaf',
					url : '',
					menus : [ {
						id : '21',
						text : '基础特征',
						icon : 'icon-glass',
						url : '/BasicData/BasicFeature/Index'
					}, {
						id : '22',
						text : '特征管理',
						icon : 'icon-glass',
						url : '/BasicData/Features/Index'
					}, {
						id : '23',
						text : '物料维护',
						icon : 'icon-glass',
						url : '/Model/Index'
					}, {
						id : '24',
						text : '站点管理',
						icon : 'icon-glass',
						url : '/Station/Index'
					} ]
				}, {
					id : '3',
					text : '权限管理',
					icon : 'icon-user',
					url : '',
					menus : [ {
						id : '31',
						text : '用户管理',
						icon : 'icon-user',
						url : '/SystemSetting/User'
					}, {
						id : '32',
						text : '角色管理',
						icon : 'icon-apple',
						url : '/SystemSetting/Role'
					}, {
						id : '33',
						text : '菜单管理',
						icon : 'icon-list',
						url : '/SystemSetting/Menu'
					}, {
						id : '34',
						text : '部门管理',
						icon : 'icon-glass',
						url : '/SystemSetting/Department'
					} ]
				}, {
					id : '4',
					text : '订单管理',
					icon : 'icon-envelope',
					url : '',
					menus : [ {
						id : '41',
						text : '订单查询',
						icon : 'icon-glass',
						url : '/Order/Query'
					}, {
						id : '42',
						text : '订单排产',
						icon : 'icon-glass',
						url : '/Order/PLANTPRODUCT'
					}, {
						id : '43',
						text : '订单撤排',
						icon : 'icon-glass',
						url : '/Order/cancelPRODUCT'
					}, {
						id : '44',
						text : '订单HOLD',
						icon : 'icon-glass',
						url : '/Order/hold'
					}, {
						id : '45',
						text : '订单删除',
						icon : 'icon-glass',
						url : '/Order/delete'
					}, {
						id : '47',
						text : '订单插单',
						icon : 'icon-glass',
						url : '/Order/insertorder'
					}, {
						id : '48',
						text : '订单导入',
						icon : 'icon-glass',
						url : '/Order/Import'
					} ]
				} ]
			});
		});
	</script>
</body>
</html>