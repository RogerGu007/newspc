﻿<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" import="java.util.*" %>
<%--<%@ page isELIgnored="false"%>--%>

<!DOCTYPE html>
<html>
<head>
	<title></title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/wangEditor.css">
	<link rel="stylesheet" type="text/css" href="css/base.css">
	<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
<%@ include file="header.jsp" %>


	<!-- 中间主体板块 -->
	<div class="main w clearfix">
		<div class="buttons clearfix">
			<a href="#" id="login-button" class="selected"><span class="glyphicon glyphicon-user"></span>&nbsp;登录</a>
		</div>
		<div class="contents">
			<div id="login-area">
				<form>
				<%--<form>--%>
					<div class="error-message">${error}</div>
					<div class="user-name">
						用户名&nbsp;
						<input id="username" type="text" name="username" value="${username}" required>
					</div>
					<div class="password-field">
						密&nbsp;&nbsp;&nbsp;码&nbsp;
						<input id="password" type="password" name="password" value="${password}" required>
					</div>
					<br>
					<button type="button" id="admin-login-submit">立即登录</button>
				</form>
			</div>
		</div>
	</div><!-- 主体结束 -->



<%@ include file="footer.jsp" %>
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/base.js"></script>
<script type="text/javascript">
	$(function(){
		//登陆
        $("#admin-login-submit").click(function() {
            $.ajax({
                type:"POST",
                url:"adminLogin.do",
                data:{username:$("#username").val(), password:$("#password").val()},
                success:function(response){
                    if (response.errcode != "0") {
                        alert("用户名或密码错误，请重新输入");
                        window.location.reload();
					} else {
                        alert("登陆成功");
                        setCookie("sessionID", response.sessionID, 15*60*1000);
                        setCookie("adminID", response.ID, 15*60*1000);
						window.location.href = "editPost.do";
                    }
                }
            });
        });
	});

</script>
</body>
</html>

