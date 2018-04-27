﻿<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
	<title></title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/wangEditor.css">
	<link rel="stylesheet" type="text/css" href="css/base.css">
	<link rel="stylesheet" type="text/css" href="css/post.css">
</head>
<body>
<%@ include file="header.jsp" %>


	<!-- 中间主体板块 -->
	<div class="main w clearfix">

		<!-- 主体左部分 -->
		<div class="main-left">
			
			<!-- 帖子内容板块 -->
			<div class="post-content">
				<div class="post-title">
					<span class="glyphicon glyphicon-th"></span>&nbsp;${post.title}
				</div>
				<div class="post-user clearfix">
					<div class="user-image"><a href="toProfile.do?uid=${post.user.uid}"><img src="${post.user.headUrl}"></a></div>
					<div class="user-info">
						<div class="user-name">${post.user.username}</div>
						<div class="post-time">编辑于 ${post.publishTime}</div>
					</div>
					<div class="other-count">
						<span class="reply-count"><a href="#">回复 ${post.replyCount}</a></span>&nbsp;
                        <c:choose>
                            <c:when test="${sessionScope.uid==null}">
                                <span class="up-count"><a>赞 ${post.likeCount}</a></span>&nbsp;
                            </c:when>
                            <c:when test="${liked==true}">
                                <span class="up-count"><a style="color:#2e6da4;">已赞 ${post.likeCount}</a></span>&nbsp;
                            </c:when>
                            <c:when test="${sessionScope.uid!=null}">
                                <span class="up-count"><a href="#" id="like-button">赞 ${post.likeCount}</a></span>&nbsp;
                            </c:when>
                        </c:choose>
						<span class="scan-count"><a href="#">浏览 ${post.scanCount}</a></span>
					</div>
				</div>
				<div class="post-desc">
					${post.content}
				</div>
			</div>



			<!-- 帖子回复内容板块 -->
			<div class="post-reply">
				<!-- 回复区标题 -->
				<div class="post-reply-title">
					<h2 class="reply-count"><span class="glyphicon glyphicon-th"></span>&nbsp;${post.replyCount}条回帖</h2>
					<a href="#reply-area">回复</a>
				</div>
				<!-- 回复区内容 -->
				<div class="post-reply-content">
					<!-- 回复条目 -->
                    <c:forEach items="${replyList}" var="reply" varStatus="status">
                        <div class="post-reply-item clearfix">
                            <div class="item-image"><a href="toProfile.do?uid=${reply.user.uid}"><img src="${reply.user.headUrl}"></a></div>
                            <div class="item-info">
                                <div class="item-user-name"><a href="#">${reply.user.username}</a></div>
                                <div class="item-content">${reply.content}</div>
                                <div class="item-date">发表于 ${reply.replyTime}</div>

                                <!-- 楼中楼，即嵌套的回复内容 -->
                                <div class="item-more">
                                    <c:forEach items="${reply.commentList}" var="comment">
                                        <%--一个wrap开始--%>
                                        <div class="item-wrap">
                                            <div class="item-more-1">
                                                <a href="toProfile.do?uid=${comment.user.uid}" class="item-more-user">${comment.user.username}</a>
                                                <span>：</span>
                                                <span class="item-more-content">${comment.content}</span>
                                            </div>

                                            <div class="item-more-date">${comment.commentTime}</div>
                                            <div class="item-more-other">
                                                <a href="#s${status.count}" class="item-more-reply">回复</a>&nbsp;
                                            </div>
                                        </div><!-- 一个wrap结束-->
                                    </c:forEach>

                                    <!-- 楼中楼的回复框 -->
                                    <div class="reply-input">
                                        <form action="comment.do" method="post">
                                            <input type="hidden" name="pid" value="${post.pid}"/>
                                            <input type="hidden" name="rid" value="${reply.rid}"/>
                                            <textarea id="s${status.count}" name="content"></textarea>
                                            <button type="submit">回复</button>
                                        </form>
                                    </div>
                                </div><!-- 楼中楼结束 -->

                            </div>
                            <div class="item-other">
                                <a href="#s${status.count}" class="item-reply">回复</a>&nbsp;
                            </div>

                        </div>
                    </c:forEach><!-- 回复条目结束 -->
				</div>
			</div>



			<!-- 回复区，付文本编辑器板块 -->
			<div id="reply-area" class="post-reply-textarea">
				<div style="width: 650px;margin: 10px 20px">
					<form action="reply.do" method="post" enctype="multipart/form-data">
						<input type="hidden" name="pid" value="${post.pid}" />
						<textarea name="content" id="textarea" style="height: 200px;max-height: 1000px;"></textarea>
						<button class="reply-button">回帖</button>
					</form>
				</div>
			</div>

		</div>


		<!-- 主体右部分 -->
        <div class="main-right">

            <div class="hot-user">
                <div class="clearfix"><div class="hot-user-title"><span></span>&nbsp;推荐网站</div></div>
                <ul class="hot-user-list">
                    <li class="clearfix">
                        <a href="http://www.newsmth.net" class="hot-user-image"><img src="http://images.newsmth.net/nForum/img/logo.gif"></a>
                        <a href="http://www.newsmth.net" class="hot-user-name">水木清华</a>
                    </li>
                    <li class="clearfix">
                        <a href="https://bbs.pku.edu.cn/v2/home.php" class="hot-user-image"><img src="https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=4127653021,2219382705&fm=58"></a>
                        <a href="https://bbs.pku.edu.cn/v2/home.php" class="hot-user-name">北大未名</a>
                    </li>
                    <li class="clearfix">
                        <a href="https://bbs.fudan.edu.cn/bbs/top10" class="hot-user-image"><img src="https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2031677745,545048845&fm=58&bpow=400&bpoh=400"></a>
                        <a href="https://bbs.fudan.edu.cn/bbs/top10" class="hot-user-name">日月光华</a>
                    </li>
                    <li class="clearfix">
                        <a href="https://bbs.sjtu.edu.cn" class="hot-user-image"><img src="https://www.baidu.com/s?wd=%E4%B8%8A%E6%B5%B7%E4%BA%A4%E9%80%9A%E5%A4%A7%E5%AD%A6%E5%AE%89%E6%B3%B0%E7%BB%8F%E6%B5%8E%E4%B8%8E%E7%AE%A1%E7%90%86%E5%AD%A6%E9%99%A2&usm=3&ie=utf-8&rsv_cq=%E4%B8%8A%E6%B5%B7%E4%BA%A4%E9%80%9A%E5%A4%A7%E5%AD%A6&rsv_dl=0_right_recommends_merge_20826&euri=2ec767baade64807bddb57634cc47ee0"></a>
                        <a href="https://bbs.sjtu.edu.cn" class="hot-user-name">饮水思源</a>
                    </li>
                    <li class="clearfix">
                        <a href="https://bbs.tongji.net/" class="hot-user-image"><img src="https://bbs.tongji.net/static/image/common/tongji-logo.png"></a>
                        <a href="https://bbs.tongji.net/" class="hot-user-name">同济之声</a>
                    </li>
                    <li class="clearfix">
                        <a href="http://bbs.nju.edu.cn/" class="hot-user-image"><img src="http://bbs.nju.edu.cn/images/bbs.gif"></a>
                        <a href="http://bbs.nju.edu.cn/" class="hot-user-name">小百合</a>
                    </li>
                    <li class="clearfix">
                        <a href="http://www.zju1.com/" class="hot-user-image"><img src="http://www.zju1.com/up/61619-201527211737.jpg"></a>
                        <a href="http://www.zju1.com/" class="hot-user-name">梧桐树</a>
                    </li>
                    <li class="clearfix">
                        <a href="http://bbs.whu.edu.cn" class="hot-user-image"><img src="https://www.baidu.com/link?url=lnyiM_g1I8dTEKFW0sizw3BCSvmdtVvFw0SY7JYt_bHhQQxqCkW6H8Gc031eYr2RvyDwabl8swvMqa7LGO7S0he-EipCVaA5y0syogyWg-a&wd=&eqid=cf97f7cb00004a79000000065ae366ce"></a>
                        <a href="http://bbs.whu.edu.cn" class="hot-user-name">珞珈山水</a>
                    </li>
                    <li class="clearfix">
                        <a href="http://bbs.iecnu.com/" class="hot-user-image"><img src="http://bbs.iecnu.com/static/image/common/logo.gif"></a>
                        <a href="http://bbs.iecnu.com/" class="hot-user-name">爱在华师</a>
                    </li>
                </ul>
            </div>
        </div>
	</div>



<%@ include file="footer.jsp" %>
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/wangEditor.js"></script>
<script type="text/javascript" src="js/base.js"></script>
<script type="text/javascript">
    var editor = new wangEditor('textarea');

    editor.config.menus = [
        'source',
        '|',
        'bold',
        'underline',
        'italic',
        'strikethrough',
        'eraser',
        'fontsize',
        '|',
        'link',
        'table',
        'emotion',
        '|',
        'img',
        'insertcode',
        '|',
        'undo',
     ];
     
     //配置处理图片上传的路径，最好用相对路径
     editor.config.uploadImgUrl = 'upload.do';
     //配置图片上传到后台的参数名称
     editor.config.uploadImgFileName = 'myFileName';

		
    editor.create();

    //点赞按钮处理
    var likeButton = $("#like-button");
    likeButton.click(function(){
        $.ajax({
            type:"GET",
            url:"ajaxClickLike.do",
            data:{pid:${post.pid}},
            success:function(response,status,xhr){
                likeButton.text("赞 "+response);
                likeButton.removeAttr("href");
            }
        });
    });
    
</script>
</body>
</html>
