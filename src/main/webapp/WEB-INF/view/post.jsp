<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" import="java.util.*" %>

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
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

	<!-- 中间主体板块 -->
	<div class="main w clearfix">

		<!-- 主体左部分 -->
		<div class="main-left">
			
			<!-- 帖子内容板块 -->
			<div class="post-content">
				<div class="post-title">
					<span class="glyphicon glyphicon-th"></span>&nbsp;${newsdetail.subject}
				</div>
				<div class="post-user clearfix">
					<div class="user-image"><a href="toProfile.do?uid=${newsdetail.publisher_id}"><img src="${newsdetail.publisher_avatar_url}"></a></div>
					<div class="user-info">
						<div class="user-name">${newsdetail.publisher_name}</div>
						<div class="post-time">
                            编辑于 ${fn:substring(newsdetail.postDate, 0, 19)}
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <span class="like" id="like${newsdetail.newsID}">&#10084;</span>
                        </div>
					</div>
					<div class="other-count">
						<%--<span class="reply-count"><a href="#">回复 ${newsdetail.}</a></span>&nbsp;--%>
                        <c:choose>
                            <c:when test="${sessionScope.uid==null}">
                                <%--<span class="up-count"><a>赞 ${newsdetail.}</a></span>&nbsp;--%>
                            </c:when>
                            <c:when test="${liked==true}">
                                <%--<span class="up-count"><a style="color:#2e6da4;">已赞 ${newsdetail.likeCount}</a></span>&nbsp;--%>
                            </c:when>
                            <c:when test="${sessionScope.uid!=null}">
                                <%--<span class="up-count"><a href="#" id="like-button">赞 ${newsdetail.likeCount}</a></span>&nbsp;--%>
                            </c:when>
                        </c:choose>
						<%--<span class="scan-count"><a href="#">浏览 ${newsdetail.}</a></span>--%>
					</div>
				</div>
				<div class="post-desc">
					${newsdetail.detailContent}
				</div>
			</div>


			<!-- 帖子回复内容板块 -->
			<div class="post-reply">
				<!-- 回复区标题 -->
				<div class="post-reply-title">
					<%--<h2 class="reply-count"><span class="glyphicon glyphicon-th"></span>&nbsp;${post.replyCount}条回帖</h2>--%>
                    <h2 class="reply-count"><span class="glyphicon glyphicon-th"></span>&nbsp;共${replyList.size()}条评论</h2>
                    <%--<a href="#reply-area">回复</a>--%>
				</div>

                <!-- 回复区，副文本编辑器板块 -->
                <div id="reply-area" class="post-reply-textarea">
                    <div style="width: 650px;margin: 10px 20px">
                        <%--<form action="reply.do" method="post" enctype="multipart/form-data">--%>
                        <form>
                            <input type="hidden" name="newsid" value="${newsdetail.newsID}" />
                            <input type="hidden" name="userid" value="${newsdetail.publisher_id}" />
                            <textarea name="content" id="textarea" style="height: 200px;max-height: 1000px;"></textarea>
                            <button class="reply-button" id="replybutton">评论</button>
                        </form>
                    </div>
                </div>

				<!-- 回复区内容 -->
				<div class="post-reply-content">
					<!-- 回复条目 -->
                    <c:forEach items="${replyList}" var="reply" varStatus="status">
                        <div class="post-reply-item clearfix">
                            <div class="item-image"><a href="toProfile.do?uid=${reply.userID}"><img src="${reply.avatarUrl}"></a></div>
                            <div class="item-info">
                                <div class="item-user-name"><a href="#">${reply.nickName}</a></div>
                                <div class="item-content">${reply.comment}</div>
                                <div class="item-date">发表于 ${fn:substring(reply.createAt, 0, 19)}</div>

                                <!-- 楼中楼，即嵌套的回复内容 -->
                                <div class="item-more">
                                    <c:forEach items="${reply.secondLevelComments}" var="secondReply">
                                        <%--一个wrap开始--%>
                                        <div class="item-wrap">
                                            <div class="item-more-1">
                                                <a href="toProfile.do?uid=${secondReply.fromUserID}" class="item-more-user">${secondReply.fromUserNickName}</a>
                                                <span>：</span>
                                                <span class="item-more-content">${secondReply.replyComment}</span>
                                            </div>

                                            <div class="item-more-date">${fn:substring(secondReply.createAt, 0, 19)}</div>
                                            <div class="item-more-other">
                                                <%--<a href="#s${secondReply.fromUserID}" class="item-more-reply">回复</a>&nbsp;--%>
                                            </div>
                                        </div><!-- 一个wrap结束-->
                                    </c:forEach>
                                    <!-- 楼中楼的回复框 -->
                                    <div class="reply-input">
                                        <%--<form action="comment.do" method="post">--%>
                                        <%--<button type="submit" id="commentButton" onclick="commentFocus()">回复</button>--%>
                                        <form name="commentForm">
                                            <input type="hidden" name="newsid" value="${reply.newsID}"/>
                                            <input type="hidden" name="rid" value="${reply.id}"/>
                                            <input type="hidden" name="fromuserid"  value= "${cookie.userId.value}"/>
                                            <input type="hidden" name="touserid" value="${newsdetail.publisher_id}"/>
                                            <textarea id="s${reply.id}" name="content" ></textarea>
                                            <button type="submit" class="commentButton">回复</button>
                                        </form>
                                    </div>
                                </div><!-- 楼中楼结束 -->

                            </div>
                            <div class="item-other">
                                <%--<a href="#s${status.count}" class="item-reply">回复</a>&nbsp;--%>
                            </div>

                        </div>
                    </c:forEach><!-- 回复条目结束 -->
				</div>
			</div>


			<%--<!-- 回复区，副文本编辑器板块 -->--%>
			<%--<div id="reply-area" class="post-reply-textarea">--%>
				<%--<div style="width: 650px;margin: 10px 20px">--%>
					<%--&lt;%&ndash;<form action="reply.do" method="post" enctype="multipart/form-data">&ndash;%&gt;--%>
                    <%--<form>--%>
						<%--<input type="hidden" name="newsid" value="${newsdetail.newsID}" />--%>
                        <%--<input type="hidden" name="userid" value="${newsdetail.publisher_id}" />--%>
						<%--<textarea name="content" id="textarea" style="height: 200px;max-height: 1000px;"></textarea>--%>
						<%--<button class="reply-button" id="replybutton">评论</button>--%>
					<%--</form>--%>
				<%--</div>--%>
			<%--</div>--%>

		</div>


		<!-- 主体右部分 -->
        <div class="main-right">

            <div class="hot-user">
                <div class="clearfix"><div class="hot-user-title"><span></span>&nbsp;推荐论坛</div></div>
                <ul class="hot-user-list">
                    <li class="clearfix">
                        <a href="http://www.newsmth.net" class="hot-user-image"><img src="https://ss1.baidu.com/70cFfyinKgQFm2e88IuM_a/forum/pic/item/ce2e42a7d933c8953198e931d71373f0830200a4.jpg"></a>
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
                        <a href="https://bbs.sjtu.edu.cn" class="hot-user-image"><img src="https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=3375747713,2591547652&fm=58&bpow=1024&bpoh=1024"></a>
                        <a href="https://bbs.sjtu.edu.cn" class="hot-user-name">饮水思源</a>
                    </li>
                    <li class="clearfix">
                        <a href="https://bbs.tongji.net/" class="hot-user-image"><img src="https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2951361712,2965132577&fm=58&bpow=971&bpoh=974"></a>
                        <a href="https://bbs.tongji.net/" class="hot-user-name">同济之声</a>
                    </li>
                    <li class="clearfix">
                        <a href="http://bbs.nju.edu.cn/" class="hot-user-image"><img src="https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=1076576704,4283853172&fm=58&bpow=1200&bpoh=1504"></a>
                        <a href="http://bbs.nju.edu.cn/" class="hot-user-name">小百合</a>
                    </li>
                    <li class="clearfix">
                        <a href="http://www.zju1.com/" class="hot-user-image"><img src="https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2646922489,2681531337&fm=58&bpow=908&bpoh=908"></a>
                        <a href="http://www.zju1.com/" class="hot-user-name">梧桐树</a>
                    </li>
                    <li class="clearfix">
                        <a href="http://bbs.whu.edu.cn" class="hot-user-image"><img src="https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=659974452,3463077321&fm=58&bpow=600&bpoh=600"></a>
                        <a href="http://bbs.whu.edu.cn" class="hot-user-name">珞珈山水</a>
                    </li>
                    <li class="clearfix">
                        <a href="http://bbs.iecnu.com/" class="hot-user-image"><img src="https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=2025476624,2981669612&fm=58&bpow=600&bpoh=600"></a>
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
    var newsId = "${newsdetail.newsID}";
    $(function(){
        var userId = getCookie("userId");
        if (userId != null && userId != "")
            $.ajax({
                type:"POST",
                url:"getIsFavorite.do",
                data:{newsId:newsId, userId:userId},
                success:function(response){
                    if (response.errcode == "0" ) {
                        if (response.isFavorite)
                            $(".like").toggleClass('cs');
                    }
                }
            });

        $(".like").click(function () {
            var newsId = $(this).attr("id").substr(4);
            var userId = getCookie("userId");
            if (userId == null || userId == "") {
                alert("请登录后收藏!");
                return;
            }

            var badd = false;
            var obj = $(this);
            $.ajax({
                type:"POST",
                url:"getIsFavorite.do",
                data:{newsId:newsId, userId:userId},
                success:function(response){
                    if (response.errcode == "0" ) {
                        //已收藏，完成取消收藏的动作;未收藏，完成收藏的动作
                        badd = !(response.isFavorite);
                        $.ajax({
                            type:"POST",
                            url:"addorremovefavoritenews.do",
                            data:{bAdd:badd, newsId:newsId, userId:userId},
                            success:function (response2) {
                                if (response2.errcode == "0" ) {
                                    obj.toggleClass('cs');
                                    if (response.isFavorite) {
                                        alert("取消收藏");
                                    } else {
                                        alert("收藏成功");
                                    }
                                } else {
                                    alert(response2.errmsg);
                                }
                            }
                        });
                    } else {
                        alert("操作失败！");
                    }
                }
            });
        })
    });

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
            data:{pid:${newsdetail.newsID}},
            success:function(response,status,xhr){
                likeButton.text("赞 "+response);
                likeButton.removeAttr("href");
            }
        });
    });

    $("#replybutton").click(function () {
        if (nullAlert($.trim($("#textarea").val()), "评论内容不能为空~"))
            return;

        var userId = getCookie("userId");
        if (userId == null || userId == '') {
            alert("请登陆后评论!");
            window.location.href = "toLogin.do";
        }

        if(getCookie("isLogin") == "1") {
            //提交评论
            $.ajax({
                type:"POST",
                url:"reply.do",
                data:{newsid:newsId, userid:getCookie("userId"), content:$("#textarea").val()},
                success:function(response){
                    if (response.errcode == "0") {
                        alert("评论发表成功");
                        window.location.reload();
                    } else {
                        alert(response.errmsg);
                    }
                }
            });
        } else {
            alert("请登陆后评论");
            window.event.returnValue=false;
            window.location.href = "toLogin.do";
        }
    });

    $(".commentButton").click(function () {
        var replyId = $(this).parent().find(':input:eq(1)').val();
        var fromUserId = $(this).parent().find(':input:eq(2)').val();
        var toUserId = $(this).parent().find(':input:eq(3)').val();
        var replyContent = $("#s"+replyId).val();

        if (nullAlert($.trim(replyContent), "回复内容不能为空~"))
            return;

        if (fromUserId == null || fromUserId == '') {
            alert("请登陆后评论!");
            window.location.href = "toLogin.do";
        }

        if(getCookie("isLogin") == "1") {
            //提交评论
            $.ajax({
                type:"POST",
                url:"comment.do",
                data:{newsid:newsId, rid:replyId, fromuserid:fromUserId, touserid:toUserId, content:replyContent},
                success:function(response){
                    if (response.errcode == "0") {
                        alert("回复成功！");
                        window.location.reload();
                    } else {
                        alert(response.errmsg);
                    }
                }
            });
        } else {
            alert("请登陆后评论");
            window.event.returnValue=false;
            window.location.href = "toLogin.do";
        }
    });
    <%--$("#commentButton").click(function () {--%>
        <%--if(getCookie("isLogin") == "1") {--%>
            <%--//提交评论--%>
            <%--$.ajax({--%>
                <%--type:"POST",--%>
                <%--url:"comment.do",--%>
                <%--data:{commentId:${newsdetail.newsID}, fromuserid:getCookie("userId"), touserid:${newsdetail.publisher_id}, content:$("#textarea").val()},--%>
                <%--success:function(response){--%>
                    <%--if (response.errcode == "0") {--%>
                        <%--alert("回复成功");--%>
                        <%--window.location.reload();--%>
                    <%--} else {--%>
                        <%--alert(response.errmsg);--%>
                    <%--}--%>
                <%--}--%>
            <%--});--%>
        <%--} else {--%>
            <%--alert("需要再次登陆");--%>
            <%--window.event.returnValue=false;--%>
            <%--window.location.href = "toLogin.do";--%>
        <%--}--%>
    <%--});--%>

    //取cookies函数
    function getCookie(name){
        var arr = document.cookie.match(new RegExp("(^| )" + name + "=([^;]*)(;|$)"));
        if (arr != null) {
            return unescape(arr[2]);
        }
        return null;
    }

    function nullAlert(value, msg) {
        if(value == "") {
            alert(msg);
            return true;
        }

        return false;
    }

</script>
</body>
</html>
