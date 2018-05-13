<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" import="java.util.*" %>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="header clearfix">
    <div class="w">
        <h1 class="logo">
            <a href="listTopic.do">211社区</a>
        </h1>
        <ul class="left-nav">
            <li class="current-nav"><a href="listTopic.do">首页</a></li>
            <li><a id="JobIndex" href="listPostByTime.do?curPage=1&location=21&newsType=2&subNewsType=0">招聘</a></li>
            <li><a id="FriendIndex" href="listPostByTime.do?curPage=1&location=21&newsType=3&subNewsType=0">鹊桥</a></li>
        </ul>

        <ul class="right-nav">
            <c:choose>
                <c:when test="${cookie.isLogin != null && cookie.isLogin.value == 1}">
                    <li class="login2 relative">
                        <a href="toMyProfile.do" id="profile"><img id="avatarUrl" src="${cookie.avatarUrl.value}"></a>
                        <ul id="down-menu">
                            <li><a href="toMyProfile.do?userid=${cookie.userId.value}">个人主页</a></li>
                            <%--<li><a href="logout.do" >退出登录</a></li>--%>
                            <li><a id="logout" onclick="logout()">退出登录</a></li>
                        </ul>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="login">
                        <a href="toLogin.do">登录</a>
                        <%--<a href="toLogin.do">/</a>--%>
                        <%--<a href="toLogin.do#register">注册</a>--%>
                    </li>
                </c:otherwise>
            </c:choose>


                <li>
                    <a href="#"><span class="glyphicon glyphicon-search"></span></a>
                </li>
                <li><input type="text"></li>
        </ul>
    </div>
</div>

<script type="text/javascript">

    window.onload = function () {
        var avatarUrl = getCookie("avatarUrl");
        if (avatarUrl == "" || avatarUrl == null) {
            avatarUrl = "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3267121572,2544905960&fm=27&gp=0.jpg";
        }
        document.getElementById("avatarUrl").setAttribute("src", avatarUrl);
    }

    function logout() {
        clearAllCookie();
        window.location.reload();
    }

    //删除cookie
    function delCookie(name){
        var exp = new Date();
        exp.setTime(exp.getTime() - 1);
        var cval = getCookie(name);
        if (cval != null) document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
    }

    function clearAllCookie() {
        var keys = document.cookie.match(/[^ =;]+(?=\=)/g);
        if(keys) {
            for(var i = keys.length; i--;)
                document.cookie = keys[i] + '=0;expires=' + new Date(0).toUTCString()
        }
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