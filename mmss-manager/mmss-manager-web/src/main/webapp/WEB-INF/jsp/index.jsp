<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
	<%@ include file="common/global.jsp"%>
	<link href="${ctx}/css/index.css" rel="stylesheet">
	<link href="${ctx }/css/animate.min.css" rel="stylesheet">
	<title>物资调度管理系统</title>
</head>
<body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
    <div class="navbar-left">
                   物资调度管理系统
    </div>
    <div class="profile navbar-right">
                <ul class="nav navbar-nav">
                    <div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="nav-header">
                        <div class="dropdown profile-element">
                            <span><img alt="image" height="50px" class="img-circle" src="${ctx }/images/profile_small.jpg" /></span>
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                                <span class="text-muted text-xs block">超级管理员<b class="caret"></b></span>
                                </span>
                            </a>
                             <ul class="dropdown-menu animated fadeInRight m-t-xs">
                                <li><a href="login.html">安全退出</a>
                                </li>
                            </ul>
                        </div>
                        </li>
                   </ul>
                  </div>
                </ul>
            </div>
            
    </div>
    </nav>
</body>
</html>