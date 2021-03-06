﻿<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" import="java.util.*" %>

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
				<%--<div class="user-desc">${user.description}</div>--%>
				<div class="user-phone">电话：${user.phoneNo}</div>
				<c:choose>
					<c:when test="${user.sex eq '男'}">
						<div class="user-sex">性别：男</div>
					</c:when>
					<c:when test="${user.sex eq '女'}">
						<div class="user-sex">性别：女</div>
					</c:when>
					<c:otherwise>
						<div class="user-sex">性别：未设置</div>
					</c:otherwise>
				</c:choose>
				<div class="user-school">学校：${user.college}</div>
				<div class="user-verified">认证：${user.verified}</div>
			</div>
			<div class="clearfix" style="border-bottom: 1px dashed #ddd;"></div>
			<div class="user-button">
				<c:choose>
					<c:when test="${user.ID.toString() eq cookie.userId.value}">
						<a href="toEditProfile.do?userid=${cookie.userId.value}" class="button-follow">编辑信息</a>
					</c:when>
				</c:choose>
			</div>

			<div class="user-post">
				<c:choose>
					<c:when test="${user.ID.toString() eq cookie.userId.value}">
						<div class="user-post-title"><span></span>&nbsp;收藏</div>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test="${favourList != null && favourList.size()>0}">
						<ul class="user-post-list">
							<c:forEach items="${favourList}" var="favour">
								<li>
									<span class="glyphicon glyphicon-file"></span>&nbsp;
									<a href="toPost.do?newsid=${favour.ID}">${favour.content}</a>
									<span class="user-post-time">收藏于：${fn:substring(favour.createAt, 0, 19)}</span>
								</li>
							</c:forEach>
						</ul>
					</c:when>
				</c:choose>
			</div>

			<div class="user-post">
				<c:choose>
					<c:when test="${user.ID.toString() eq cookie.userId.value}">
						<div class="user-post-title"><span></span>&nbsp;发帖</div>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test="${postList != null && postList.size()>0}">
						<ul class="user-post-list">
							<c:forEach items="${postList}" var="post">
								<li>
									<span class="glyphicon glyphicon-file"></span>&nbsp;
									<a href="toPost.do?newsid=${post.ID}">${post.content}</a>
									<span class="user-post-time">发布于：${fn:substring(post.createAt, 0, 19)}</span>
								</li>
							</c:forEach>
						</ul>
					</c:when>
				</c:choose>
			</div>
		</div>

		<%--<div class="m-right">--%>
			<%--<div class="user-follow">--%>
				<%--<div class="user-follow">关注了<span class="user-count">${user.followCount}</span>人</div>--%>
				<%--<div class="user-follower">关注者<span class="user-count">${user.followerCount}</span>人</div>--%>
			<%--</div>--%>
			<%--<div class="user-attr">--%>
				<%--<span class="user-like-count">获赞：${user.likeCount}</span>&nbsp;--%>
				<%--<span class="user-post-count">发帖：${user.postCount}</span>--%>

			<%--</div>--%>
			<%--<div class="user-scan-count">个人主页被浏览${user.scanCount}次</div>--%>
		<%--</div>--%>

	</div><!-- 主体结束 -->

<%@ include file="footer.jsp" %>
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/base.js"></script>
</body>
</html>













