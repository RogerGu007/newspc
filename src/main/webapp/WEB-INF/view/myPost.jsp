<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
	<title></title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/wangEditor.css">
	<link rel="stylesheet" type="text/css" href="css/base.css">
	<link rel="stylesheet" type="text/css" href="css/profile.css">
</head>
<body>
<%@ include file="header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


	<!-- 中间主体板块 -->
	<div class="main w clearfix">
		<div class="m-left">
			<div class="user-image"><img src="${user.avatarUrl}"></div>
			<div class="user-info">
				<div class="user-name">${user.nickName}</div>
			</div>

			<div class="clearfix" style="border-bottom: 0px dashed #ddd;"></div>
			<%--<div class="user-button">--%>
				<%--<a class="button-follow">清空收藏列表</a>--%>
			<%--</div>--%>
			<div class="user-post">
				<div class="user-post-title"><span></span>&nbsp;发帖</div>
				<ul class="user-post-list">
					<c:forEach items="${postList}" var="post">
						<li>
							<span class="glyphicon glyphicon-file"></span>&nbsp;
							<a href="toPost.do?newsid=${post.ID}">${post.content}</a>
							<span class="user-post-time">发布于：${fn:substring(post.createAt, 0, 19)}</span>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>

<%@ include file="footer.jsp" %>
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/base.js"></script>
<script type="text/javascript">

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













