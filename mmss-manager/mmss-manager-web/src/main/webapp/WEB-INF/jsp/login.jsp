<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
	<%@ include file="common/global.jsp"%>
	<link href="${ctx}/css/login.css" rel="stylesheet">
	<title>登录系统</title>
	<script>
	function randomcode_refresh(){
		var img = document.getElementById("randomcode_img");
		img.src = "${ctx}/validatecode.jsp?"+new Date().getTime();
	}
	
	</script>
</head>
<body>
<div class="box">
		<div class="login-box">
			<div class="login-title text-center">
				<h1><small>登录</small></h1>
			</div>
			<div class="login-content ">
			<div class="form">
			<form action="${ctx}/login.do" method="post" data-toggle="validator" role="form">
				<div class="form-group">
					<div class="col-xs-12  ">
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
							<input type="text" id="username" name="username" class="form-control" placeholder="用户名" required>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-xs-12  ">
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
							<input type="password" data-minlength="6" id="password" name="password" class="form-control" placeholder="密码" required> 
						</div>
					</div>
				</div>
				<div class="form-group form-actions">
				<div class="col-xs-12">
				   <div class="col-xs-8">
				   验证码:<input id="randomcode" name="randomcode" size="8" /> <img
								id="randomcode_img" src="${ctx}/validatecode.jsp" alt=""
								width="56" height="20" align='absMiddle' /> <a
								href=javascript:randomcode_refresh()>刷新</a>
				   </div>
				   <div class="col-xs-4">
				   <input type="checkbox" name="remeberMe"/>自动登陆
				   </div>
				   </div>
					<div class="col-xs-4 col-xs-offset-8 ">
						<button type="submit" id="button" class="btn btn-sm btn-info"><span class="glyphicon glyphicon-off"></span> 登录</button>
					</div>
				</div>
			</form>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
/* $(document).ready(function(){
	$("#button").click(function(){
		var error = "${requestScope.shiroLoginFailure}";
		alert(error);
		toastr.warning(error);
		
	});
	}); */
	//toastr.options.positionClass = 'toast-top-center';
	
 var error = "${requestScope.shiroLoginFailure}";
 if(error != null && typeof(error)!="undefined" && error!=0){
	 //Command: toastr[success](error);
	 toastr.options.positionClass = 'toast-top-center';
	 toastr.warning(error);
	 
 }

//alert(error);
//toastr.warning(error); 
</script>
</body>
</html>