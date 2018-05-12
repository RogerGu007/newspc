<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
	<title></title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/base.css">
	<link rel="stylesheet" type="text/css" href="css/topic.css">
</head>
<body>
<%@ include file="header.jsp" %>


	<div class="main w clearfix">
		<div class="main-left">
			<div class="share">
				<div class="share-left"><span class="glyphicon glyphicon-th-large"></span>&nbsp;话题广场</div>
			</div>
			<div class="topic-root">
				<div class="topic-root-wrap">
					<c:forEach items="${topicList}" var="topic">
						<c:choose>
							<c:when test="${topic.name eq '招聘'}">
								<a href="listPostByTime.do?curPage=1&location=21&newsType=2&subNewsType=0">${topic.name}</a>
							</c:when>
							<c:when test="${topic.name eq '鹊桥'}">
								<a href="listPostByTime.do?curPage=1&location=21&newsType=3&subNewsType=0">${topic.name}</a>
							</c:when>
							<c:when test="${topic.name eq '实习/兼职'}">
								<a href="listPostByTime.do?curPage=1&location=21&newsType=2&subNewsType=2">${topic.name}</a>
							</c:when>
							<c:when test="${topic.name eq '全职'}">
								<a href="listPostByTime.do?curPage=1&location=21&newsType=2&subNewsType=1">${topic.name}</a>
							</c:when>
							<c:when test="${topic.name eq '上海'}">
								<a href="listPostByTime.do?curPage=1&location=21&newsType=2&subNewsType=0">${topic.name}</a>
							</c:when>
							<c:when test="${topic.name eq '北京'}">
								<a href="listPostByTime.do?curPage=1&location=10&newsType=2&subNewsType=0">${topic.name}</a>
							</c:when>
							<c:when test="${topic.name eq '杭州'}">
								<a href="listPostByTime.do?curPage=1&location=571&newsType=2&subNewsType=0">${topic.name}</a>
							</c:when>
							<c:when test="${topic.name eq '南京'}">
								<a href="listPostByTime.do?curPage=1&location=25&newsType=2&subNewsType=0">${topic.name}</a>
							</c:when>
							<c:when test="${topic.name eq '武汉'}">
								<a href="listPostByTime.do?curPage=1&location=27&newsType=2&subNewsType=0">${topic.name}</a>
							</c:when>
						</c:choose>
                    </c:forEach>
				</div>
			</div>
			<%--话题列表--%>
			<div class="topic-list">
				<div class="topic-list-wrap clearfix">
                    <c:forEach items="${topicList}" var="topic" varStatus="status">
                        <c:choose>
                            <c:when test="${status.count%2!=0}">
                                <div class="topic-odd relative">
                                    <a href="#" class="topic-image"><img src="${topic.image}"></a>
                                    <div class="topic-content">
										<c:choose>
											<c:when test="${topic.name eq '招聘'}">
												<a href="listPostByTime.do?curPage=1&location=21&newsType=2&subNewsType=0">${topic.name}</a>
											</c:when>
											<c:when test="${topic.name eq '鹊桥'}">
												<a href="listPostByTime.do?curPage=1&location=21&newsType=3&subNewsType=0">${topic.name}</a>
											</c:when>
											<c:when test="${topic.name eq '实习/兼职'}">
												<a href="listPostByTime.do?curPage=1&location=21&newsType=2&subNewsType=2">${topic.name}</a>
											</c:when>
											<c:when test="${topic.name eq '全职'}">
												<a href="listPostByTime.do?curPage=1&location=21&newsType=2&subNewsType=1">${topic.name}</a>
											</c:when>
											<c:when test="${topic.name eq '上海'}">
												<a href="listPostByTime.do?curPage=1&location=21&newsType=2&subNewsType=0">${topic.name}</a>
											</c:when>
											<c:when test="${topic.name eq '北京'}">
												<a href="listPostByTime.do?curPage=1&location=10&newsType=2&subNewsType=0">${topic.name}</a>
											</c:when>
											<c:when test="${topic.name eq '杭州'}">
												<a href="listPostByTime.do?curPage=1&location=571&newsType=2&subNewsType=0">${topic.name}</a>
											</c:when>
											<c:when test="${topic.name eq '南京'}">
												<a href="listPostByTime.do?curPage=1&location=25&newsType=2&subNewsType=0">${topic.name}</a>
											</c:when>
											<c:when test="${topic.name eq '武汉'}">
												<a href="listPostByTime.do?curPage=1&location=27&newsType=2&subNewsType=0">${topic.name}</a>
											</c:when>
										</c:choose>
										<a href="#" class="topic-desc">${topic.content}</a>
                                    </div>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="topic-even relative">
                                    <a href="#" class="topic-image"><img src="${topic.image}"></a>
                                    <div class="topic-content">
										<c:choose>
											<c:when test="${topic.name eq '招聘'}">
												<a href="listPostByTime.do?curPage=1&location=21&newsType=2&subNewsType=0">${topic.name}</a>
											</c:when>
											<c:when test="${topic.name eq '鹊桥'}">
												<a href="listPostByTime.do?curPage=1&location=21&newsType=3&subNewsType=0">${topic.name}</a>
											</c:when>
											<c:when test="${topic.name eq '实习/兼职'}">
												<a href="listPostByTime.do?curPage=1&location=21&newsType=2&subNewsType=2">${topic.name}</a>
											</c:when>
											<c:when test="${topic.name eq '全职'}">
												<a href="listPostByTime.do?curPage=1&location=21&newsType=2&subNewsType=1">${topic.name}</a>
											</c:when>
											<c:when test="${topic.name eq '上海'}">
												<a href="listPostByTime.do?curPage=1&location=21&newsType=2&subNewsType=0">${topic.name}</a>
											</c:when>
											<c:when test="${topic.name eq '北京'}">
												<a href="listPostByTime.do?curPage=1&location=10&newsType=2&subNewsType=0">${topic.name}</a>
											</c:when>
											<c:when test="${topic.name eq '杭州'}">
												<a href="listPostByTime.do?curPage=1&location=571&newsType=2&subNewsType=0">${topic.name}</a>
											</c:when>
											<c:when test="${topic.name eq '南京'}">
												<a href="listPostByTime.do?curPage=1&location=25&newsType=2&subNewsType=0">${topic.name}</a>
											</c:when>
											<c:when test="${topic.name eq '武汉'}">
												<a href="listPostByTime.do?curPage=1&location=27&newsType=2&subNewsType=0">${topic.name}</a>
											</c:when>
										</c:choose>
										<a href="#" class="topic-desc">${topic.content}</a>
                                    </div>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
				</div>
			</div>
			<div class="topic-more">
				<%--<a href="#">更多</a>--%>
			</div>
		</div>
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

	<div class="mask"></div>
	<div class="upon-mask">
		<form>
			<input type="text" name="" placeholder="请输入话题名称">
			<button>提交申请</button>
		</form>
		<span id="close-mask">×</span>
	</div>
<%@ include file="footer.jsp" %>
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/base.js"></script>
<script type="text/javascript">
	$(function(){

		var openMask = $("#open-mask");
		var closeMask = $("#close-mask");
		var mask = $(".mask");
		var uponMask = $(".upon-mask");

		openMask.click(function(){
			mask.show();
			uponMask.show();
		});

		closeMask.click(function(){
			mask.hide();
			uponMask.hide();
		});
	});

</script>
</body>
</html>













