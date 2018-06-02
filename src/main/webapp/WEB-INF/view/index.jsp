<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
	<title></title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/base.css">
</head>
<body>
<%@ include file="header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

	<div class="main w clearfix">
		<div class="main-left">
			<div class="share">
				<div class="share-left">
                    <span></span>
                    <%--&nbsp;分享与提问--%>
                    <a id="location">
                        <%--<select id="locationSelect" onchange="window.location.href='listPostByTime.do?curPage='--%>
                                <%--+ ${pageBean.curPage}--%>
                                <%--+ '&newsType=' + ${param.get('newsType')}--%>
                                <%--+ '&subNewsType=' + $('#subNewsTypeSelect').val()--%>
                                <%--+ '&location=' + this.value">--%>
                        <select id="locationSelect"  onchange="locationChange()">
                            <option value="21" <c:if test="${param.get('location') eq 21}"> selected="selected" </c:if>>上海</option>
                            <option value="10" <c:if test="${param.get('location') eq 10}"> selected="selected" </c:if>>北京</option>
                            <option value="571" <c:if test="${param.get('location') eq 571}"> selected="selected" </c:if>>杭州</option>
                            <option value="25" <c:if test="${param.get('location') eq 25}"> selected="selected" </c:if>>南京</option>
                            <option value="27" <c:if test="${param.get('location') eq 27}"> selected="selected" </c:if>>武汉</option>
                        </select>
                    </a>
                    <span id="subNewsTypeSpan"></span>
                    <a id="subNewsType">
                        <select id="subNewsTypeSelect" onchange="window.location.href='listPostByTime.do?curPage=1'
                                + '&newsType=' + ${param.get('newsType')}
                                + '&subNewsType=' + this.value
                                + '&location=' + $('#locationSelect').val()">
                            <%--alert(${param.get("subNewsType")});--%>
                            <option value="0" <c:if test="${param.get('subNewsType') eq 0}"> selected="selected" </c:if>>全部</option>
                            <option value="1" <c:if test="${param.get('subNewsType') eq 1}"> selected="selected" </c:if>>全职</option>
                            <option value="2" <c:if test="${param.get('subNewsType') eq 2}"> selected="selected" </c:if>>实习/兼职</option>
                        </select>
                    </a>
                </div>
				<%--<div class="share-right">--%>
					<%--<a href="toPublish.do"><span class="glyphicon glyphicon-pencil"></span>&nbsp;我要发布</a>--%>
				<%--</div>--%>
			</div>
			<div class="post">
				<div class="post-wrap">
					<div class="post-choice">
						<a href="#" class="post-choice-current">最近</a>
						<%--<a href="#">最热</a>--%>
						<%--<a href="#" class="post-choice-last">精华</a>--%>
                        <%--<c:choose>--%>
                            <%--<c:when test="${param.get('newsType') eq 3}">--%>
                                <%--<a href="#" class="post-choice-last">全部</a>--%>
                                <%--<a href="#" class="post-choice-last">全职</a>--%>
                                <%--<a href="#" class="post-choice-last">实习/兼职</a>--%>
                            <%--</c:when>--%>
                        <%--</c:choose>--%>
					</div>

					<ul class="post-list">
						<c:forEach items="${pageBean.list}" var="post">
                            <li class="clearfix">
                                <%--<div class="post-image">--%>
                                    <%--<a href="${post.publishSourceLinkUrl}"><img src="${post.publishSourceAvatarUrl}"></a>--%>
                                <%--</div>--%>
                                <div class="post-content">
                                    <div class="post-title">
                                        <a href="toPost.do?newsid=${post.ID}">${post.content}</a>
                                        <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                                        <c:choose>
                                            <c:when test="${cookie.sessionID != null && cookie.sessionID != ''}">
                                                <button class="admin-edit-button" id="edit${post.ID}">编辑</button>
                                            </c:when>
                                        </c:choose>
                                        <span>&nbsp;&nbsp;&nbsp;&nbsp;</span>
                                        <c:choose>
                                            <c:when test="${cookie.sessionID != null && cookie.sessionID != ''}">
                                                <button class="admin-delete-button" id="delete${post.ID}">删除</button>
                                            </c:when>
                                        </c:choose>
                                    </div>
                                    <div class="post-other">
                                        <div class="post-other-left">
                                            <span class="post-username"><a href="toMyProfile.do?userid=${post.publisherId}">${post.publishSource}</a></span>
                                            <%--<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>--%>
                                            <%--<span>&nbsp;评论数</span>--%>
                                            <%--<span class="post-time">&nbsp;${post.}</span>--%>
                                            <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
                                            <span>&nbsp;发表于</span>
                                            <span class="post-time">&nbsp;${fn:substring(post.postDate, 0, 19)}</span>
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            <%--<span class="like" id="like${post.ID}">&#10084;</span>&lt;%&ndash;<span>&nbsp;最后回复&nbsp;</span>&ndash;%&gt;--%>
                                            <%--<span class="post-reply-time">${post.postDate}</span>--%>
                                        </div>
                                        <%--<div class="post-other-right">--%>
                                            <%--<span class="post-reply-count">回复 ${post.replyCount}</span>&nbsp;--%>
                                            <%--<span class="post-like-count">赞 ${post.likeCount}</span>&nbsp;--%>
                                            <%--<span class="post-scan-count">浏览 ${post.scanCount}</span>--%>
                                        <%--</div>--%>
                                    </div>
                                </div>
                            </li>
                        </c:forEach>

					</ul>

                    <%--分页导航--%>
                    <nav class="col-md-10 col-md-offset-2">
                        <ul class="pagination pagination-sm">
                            <%--首页--%>
                            <li><a href="listPostByTime.do?curPage=1&newsType=${param.get('newsType')}&location=${param.get('location')}&subNewsType=${param.get('subNewsType')}">首页</a></li>
                            <%--上一页--%>
                            <c:choose>
                                <c:when test="${pageBean.curPage!=1 }">
                                    <li><a href="listPostByTime.do?curPage=${pageBean.curPage-1}&newsType=${param.get('newsType')}&location=${param.get('location')}&subNewsType=${param.get('subNewsType')}"><span>&laquo;</span></a></li>
                                </c:when>
                                <c:otherwise>
                                    <li><span>&laquo;</span></li>
                                </c:otherwise>
                            </c:choose>
                            <%--中间部分--%>
                            <c:choose>
                                <c:when test="${pageBean.allPage<=10 }">
                                    <c:forEach begin="1" end="${pageBean.allPage}" var="i">
                                        <li class="pageNum"><a href="listPostByTime.do?curPage=${i}&newsType=${param.get('newsType')}&location=${param.get('location')}&subNewsType=${param.get('subNewsType')}">${i}</a></li>
                                    </c:forEach>
                                </c:when>
                                <c:when test="${pageBean.curPage<=5}">
                                    <c:forEach begin="1" end="10" var="i">
                                        <li class="pageNum"><a href="listPostByTime.do?curPage=${i}&newsType=${param.get('newsType')}&location=${param.get('location')}&subNewsType=${param.get('subNewsType')}">${i }</a></li>
                                    </c:forEach>
                                </c:when>
                                <c:when test="${pageBean.allPage-pageBean.curPage<5}">
                                    <c:forEach begin="${pageBean.allPage-9}" end="${pageBean.allPage}" var="i">
                                        <li class="pageNum"><a href="listPostByTime.do?curPage=${i}&newsType=${param.get('newsType')}&location=${param.get('location')}&subNewsType=${param.get('subNewsType')}">${i}</a></li>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach begin="${pageBean.curPage-4 }" end="${ pageBean.curPage+5}" var="i">
                                        <li class="pageNum"><a href="listPostByTime.do?curPage=${i}&newsType=${param.get('newsType')}&location=${param.get('location')}&subNewsType=${param.get('subNewsType')}">${i }</a></li>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
                            <%--下一页--%>
                            <c:choose>
                                <c:when test="${pageBean.curPage!=pageBean.allPage}">
                                    <li><a href="listPostByTime.do?curPage=${pageBean.curPage+1}&newsType=${param.get('newsType')}&location=${param.get('location')}&subNewsType=${param.get('subNewsType')}"><span>&raquo;</span></a></li>
                                </c:when>
                                <c:otherwise>
                                    <li><span>&raquo;</span></li>
                                </c:otherwise>
                            </c:choose>
                            <%--尾页--%>
                            <li><a href="listPostByTime.do?curPage=${pageBean.allPage}&newsType=${param.get('newsType')}&location=${param.get('location')}&subNewsType=${param.get('subNewsType')}">尾页</a></li>
                        </ul>
                    </nav>

				</div>
			</div>
		</div>
		<div class="main-right">
			
			<div class="hot-user">
				<div class="clearfix"><div class="hot-user-title"><span></span>&nbsp;最近访问</div></div>
				<ul class="hot-user-list">
					<c:forEach items="${hotUserList}" var="user">
						<li class="clearfix">
							<a href="${user.headUrl}" class="hot-user-image"><img src="${user.headUrl}"></a>
							<a href="${user.headUrl}" class="hot-user-name">${user.username}</a>
						</li>
					</c:forEach>
				</ul>
			</div>

			<div class="hot-user">
				<div class="clearfix"><div class="hot-user-title"><span></span>&nbsp;活跃论坛</div></div>
				<ul class="hot-user-list">
					<c:forEach items="${userList}" var="user">
						<li class="clearfix">
							<a href="${user.headUrl}" class="hot-user-image"><img src="${user.headUrl}"></a>
							<a href="${user.headUrl}" class="hot-user-name">${user.username}</a>
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
    $(function(){
        var curPage = ${pageBean.curPage};
        $(".pageNum").each(function(){
            if($(this).text()==curPage){
                $(this).addClass("active");
            }
        });

        var newsType = ${param.get('newsType')};
        if (newsType==3) {
            $("#subNewsType").hide();
            $("#subNewsTypeSpan").hide();
        } else {
            $("#subNewsType").show();
            $("#subNewsTypeSpan").show();
        }

        setCookie("location", document.getElementById("locationSelect").value);
    });
    
    function locationChange() {
        var location = document.getElementById("locationSelect").value;
        window.location.href='listPostByTime.do?curPage=1'
            + '&newsType=' + ${param.get('newsType')}
            + '&subNewsType=' + $('#subNewsTypeSelect').val()
            + '&location=' + location;

        setCookie("location", location);
    }

    $(".admin-edit-button").click(function () {
        var newsId = $(this).attr('id');
        window.location.href = "toEditNews.do?newsid=" + newsId;
    });

    $(".admin-delete-button").click(function () {
        var newsId = $(this).attr('id');
        newsId = newsId.substr(6);
        if(confirm("是否确认刪除？")) {
            $.ajax({
                type:"POST",
                url:"deleteNews.do",
                data:{newsid:newsId},
                success:function(response){
                    if (response.errcode == "0") {
                        alert("帖子删除成功！");
                        window.location.reload();
                    } else
                        alert(response.errmsg);
                }
            });
        }
    });

    function setCookie(name,value){
        var Days = 30;//此 cookie 将被保存 30 天
        var exp = new Date();//new Date("December 31, 9998");
        exp.setTime(exp.getTime() + Days*24*60*60*1000);
        document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
    }

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
