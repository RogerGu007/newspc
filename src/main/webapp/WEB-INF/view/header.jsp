<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" import="java.util.*" %>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="header clearfix">
    <div class="w">
        <h1 class="logo">
            <a href="listTopic.do">211社区</a>
        </h1>
        <ul class="left-nav" id="left-nav">
            <%--<li class="current-nav"><a href="listTopic.do" target="_blank">首页</a></li>--%>
            <li><a href="listTopic.do" id="0">首页</a></li>
            <c:choose>
                <c:when test="${cookie.location.value eq null || cookie.location.value eq ''}">
                    <li><a href="listPostByTime.do?curPage=1&location=21&newsType=2&subNewsType=0" id="1">招聘</a></li>
                    <li><a href="listPostByTime.do?curPage=1&location=21&newsType=3&subNewsType=0" id="2">鹊桥</a></li>
                    <li><a href="download.do" id="3">下载APP</a></li>
                </c:when>
                <c:otherwise>
                    <li><a id="5" href="listPostByTime.do?curPage=1&location=${cookie.location.value}&newsType=2&subNewsType=0">招聘</a></li>
                    <li><a id="6" href="listPostByTime.do?curPage=1&location=${cookie.location.value}&newsType=3&subNewsType=0">鹊桥</a></li>
                    <li><a id="7" href="download.do">下载APP</a></li>
                </c:otherwise>
            </c:choose>
        </ul>

        <ul class="right-nav">
            <c:choose>
                <c:when test="${cookie.isLogin != null && cookie.isLogin.value == 1}">
                    <li class="login2 relative">
                        <a href="toMyProfile.do?userid=${cookie.userId.value}" id="profile">
                            <%--<img id="avatarUrl" src="${cookie.avatarUrl.value}">--%>
                            <img id="avatarUrl" src="">
                        </a>
                        <ul id="down-menu">
                            <li><a href="toMyProfile.do?userid=${cookie.userId.value}">个人主页</a></li>
                            <li><a href="MyFavourite.do?userid=${cookie.userId.value}">我的收藏</a></li>
                            <li><a href="MyPost.do?userid=${cookie.userId.value}">我的发帖</a></li>
                            <li><a id="logout" onclick="logout()">退出登录</a></li>
                            <%--<li><a id="more" onclick="window.location = '/df/download.do'">更多</a></li>--%>
                        </ul>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="login">
                        <a href="toLogin.do">登录/注册</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</div>

<script type="text/javascript">

    window.onload = function () {
        var avatarUrl = getCookie("avatarUrl");
        if (avatarUrl == "" || avatarUrl == null) {
            avatarUrl = "http://www.211sq.com/asset/image/avatar/avator_default.png";
        }
        var avatarObj = document.getElementById("avatarUrl");
        if (avatarObj != null)
            avatarObj.setAttribute("src", avatarUrl);

//        var as = document.getElementById('left-nav').getElementsByTagName('a');
        var as = $(".left-nav a");
        if (getCookie("newstype") == null || getCookie("newstype") == '')
            as[0].parentNode.className = 'current-nav';
        else
            as[getCookie("newstype")].parentNode.className = 'current-nav';

        for (var i = 0; i < as.length; i++) as[i].onclick = function () {
            var index = parseInt(this.id)%4;
            setCookie("newstype", index, 24*24*60*60*1000);
        }
    }

    function logout() {
        clearAllCookie();
        window.location.reload();
    }

</script>