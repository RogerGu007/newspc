<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" import="java.util.*" %>
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
                        setCookie("sessionID", response.sessionID);
                        setCookie("adminID", response.ID);
						window.location.href = "editPost.do";
                    }
                }
            });
        });
	});

    //两个参数，一个是cookie的名子，一个是值
    function setCookie(name,value){
        var minutes = 15;//此 cookie 将被保存 15 分钟
        var exp = new Date();//new Date("December 31, 9998");
        exp.setTime(exp.getTime() + minutes*15*60*1000);
        document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
    }

    //取cookies函数
    function getCookie(name){
        var arr = document.cookie.match(new RegExp("(^| )" + name + "=([^;]*)(;|$)"));
        if (arr != null) {
            return unescape(arr[2]);
        }
        return null;
    }

</script>
</body>
</html>

