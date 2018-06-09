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
			<a href="#" id="login-button" class="selected"><span class="glyphicon glyphicon-user"></span>&nbsp;登陆</a>
			<%--<a href="#" id="register-button" class="unselected"><span class="glyphicon glyphicon-pencil"></span>&nbsp;注册</a>--%>
		</div>
		<div class="contents">
			<div id="login-area">
				<form action="login.do?phoneno=${phoneno}&smscode=${smscode}" method="post">
				<%--<form>--%>
					<%--<div>sss</div>--%>
					<div class="error-message">${error}</div>
					<div id="tip">● 首次通过验证码登陆即可完成注册</div>
					<br>
					<div class="email">
						手机号&nbsp;
						<input id="login-phone" type="text" name="phoneno" value="${phoneno}" required>
					</div>
					<div class="smscode">
						验证码&nbsp;
						<input id="login-sms" type="text" name="smscode" value="${smscode}" required>
					</div>
					<br>
					<button type="button" id="get-smscode">获取验证码</button>
					<button type="button" id="login-submit">立即登录</button>
				</form>
			</div>
			<%--<div id="register-area">--%>
				<%--<form action="register.do" method="post">--%>
					<%--<div id="error-message" class="error-message">${error}</div>--%>
					<%--<div class="email">--%>
						<%--邮箱&nbsp;--%>
						<%--<input type="text" name="email" value="${email}" id="email" required>--%>
					<%--</div>--%>
					<%--<div class="password">--%>
						<%--密码&nbsp;--%>
						<%--<input type="password" name="password" id="password" required>--%>
					<%--</div>--%>
					<%--<div class="password relative clearfix">--%>
						<%--<span style="position: absolute;left: -30px;">重复密码&nbsp;</span>--%>
						<%--<input type="password" name="repassword" id="repassword" required style="position: absolute;left: 40px;">--%>
					<%--</div>--%>
					<%--<div class="relative">--%>
						<%--<button id="register-submit">立即注册</button>--%>
					<%--</div>--%>
				<%--</form>--%>
			<%--</div>--%>
		</div>
	</div><!-- 主体结束 -->



<%@ include file="footer.jsp" %>
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/base.js"></script>
<script type="text/javascript">
	$(function(){
        //输入校验
        //手机号
        $("#login-phone").blur(function() {
            var value = $(this).val();
            if (!/^([0-9]){11}$/.test(value)) {
                $("#error-message").text("手机号格式错误~");
            }else{
                $("#error-message").text("");
            }
        });
		//验证码格式
        $("#login-sms").blur(function() {
            var value = $(this).val();
            if (!/^([0-9]{4})$/.test(value)) {
                $("#error-message").text("验证码格式错误啦~");
            }else{
                $("#error-message").text("");
            }
        });

        //获取验证码
        $("#get-smscode").click(function(){
            $.ajax({
                type:"POST",
                url:"getsmscode.do",
                data:{phoneno:$("#login-phone").val()},
                success:function(response){
                    if (response.errcode != "0")
                        alert(response.errmsg);
                    else
                        alert("验证码发送成功！");
                }
            });
        });

		//登陆
        $("#login-submit").click(function() {
            setCookie("phoneno", $("#login-phone").val());
            setCookie("smscode", $("#login-sms").val());
            $.ajax({
                type:"POST",
                url:"login.do",
                data:{phoneno:getCookie("phoneno"), smscode:getCookie("smscode")},
                success:function(response){
                    if (response.errcode != "0") {
                        alert("验证码错误，请重新输入");
                        setCookie("isLogin", "0");
                        window.location.reload();
					} else {
                        alert("登陆成功");
                        setCookie("isLogin", "1");
                        setCookie("userId", response.userId);
                        setCookie("avatarUrl", response.avatarUrl);
//                        window.history.go(-1);
						window.location.href = document.referrer;
                    }
                }
            });
        });
	});

    //两个参数，一个是cookie的名子，一个是值
    function setCookie(name,value){
        var Days = 30;//此 cookie 将被保存 30 天
        var exp = new Date();//new Date("December 31, 9998");
        exp.setTime(exp.getTime() + Days*24*60*60*1000);
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

