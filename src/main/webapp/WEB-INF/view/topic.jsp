﻿<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" import="java.util.*" %>

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
				<div class="share-left"><span class="glyphicon glyphicon-th-large"></span>&nbsp;&nbsp;话题广场</div>
			</div>
			<div class="topic-root">
				<div class="topic-root-wrap">
					<c:forEach items="${topicList}" var="topic">
						<c:choose>
							<c:when test="${topic.name eq '招聘'}">
								<c:choose>
									<c:when test="${cookie.location.value == null || cookie.location.value == ''}">
										<a href="listPostByTime.do?curPage=1&location=21&newsType=2&subNewsType=0" onclick="locationChange(21)">${topic.name}</a>
									</c:when>
									<c:otherwise>
										<a href="listPostByTime.do?curPage=1&location=${cookie.location.value}&newsType=2&subNewsType=0" onclick="locationChange(${cookie.location.value})">${topic.name}</a>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:when test="${topic.name eq '鹊桥'}">
								<c:choose>
									<c:when test="${cookie.location.value == null || cookie.location.value == ''}">
										<a href="listPostByTime.do?curPage=1&location=21&newsType=3&subNewsType=0" onclick="locationChange(21)">${topic.name}</a>
									</c:when>
									<c:otherwise>
										<a href="listPostByTime.do?curPage=1&location=${cookie.location.value}&newsType=3&subNewsType=0" onclick="locationChange(${cookie.location.value})">${topic.name}</a>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:when test="${topic.name eq '实习/兼职'}">
								<c:choose>
									<c:when test="${cookie.location.value == null || cookie.location.value == ''}">
										<a href="listPostByTime.do?curPage=1&location=21&newsType=2&subNewsType=2" onclick="locationChange(21)">${topic.name}</a>
									</c:when>
									<c:otherwise>
										<a href="listPostByTime.do?curPage=1&location=${cookie.location.value}&newsType=2&subNewsType=2" onclick="locationChange(${cookie.location.value})">${topic.name}</a>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:when test="${topic.name eq '全职'}">
								<c:choose>
									<c:when test="${cookie.location.value == null || cookie.location.value == ''}">
										<a href="listPostByTime.do?curPage=1&location=21&newsType=2&subNewsType=1" onclick="locationChange(21)">${topic.name}</a>
									</c:when>
									<c:otherwise>
										<a href="listPostByTime.do?curPage=1&location=${cookie.location.value}&newsType=2&subNewsType=1" onclick="locationChange(${cookie.location.value})">${topic.name}</a>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:when test="${topic.name eq '上海'}">
								<a href="listPostByTime.do?curPage=1&location=21&newsType=2&subNewsType=0" onclick="locationChange(21)">${topic.name}</a>
							</c:when>
							<c:when test="${topic.name eq '北京'}">
								<a href="listPostByTime.do?curPage=1&location=10&newsType=2&subNewsType=0" onclick="locationChange(10)">${topic.name}</a>
							</c:when>
							<c:when test="${topic.name eq '杭州'}">
								<a href="listPostByTime.do?curPage=1&location=571&newsType=2&subNewsType=0" onclick="locationChange(571)">${topic.name}</a>
							</c:when>
							<c:when test="${topic.name eq '南京'}">
								<a href="listPostByTime.do?curPage=1&location=25&newsType=2&subNewsType=0" onclick="locationChange(25)">${topic.name}</a>
							</c:when>
							<c:when test="${topic.name eq '武汉'}">
								<a href="listPostByTime.do?curPage=1&location=27&newsType=2&subNewsType=0" onclick="locationChange(27)">${topic.name}</a>
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
									<c:choose>
										<c:when test="${topic.name eq '招聘'}">
											<c:choose>
												<c:when test="${cookie.location.value == null || cookie.location.value == ''}">
													<a href="listPostByTime.do?curPage=1&location=21&newsType=2&subNewsType=0" class="topic-image"><img src="${topic.image}"></a>
												</c:when>
												<c:otherwise>
													<a href="listPostByTime.do?curPage=1&location=${cookie.location.value}&newsType=2&subNewsType=0" class="topic-image"><img src="${topic.image}"></a>
												</c:otherwise>
											</c:choose>
										</c:when>
										<c:when test="${topic.name eq '鹊桥'}">
											<c:choose>
												<c:when test="${cookie.location.value == null || cookie.location.value == ''}">
													<a href="listPostByTime.do?curPage=1&location=21&newsType=3&subNewsType=0" class="topic-image"><img src="${topic.image}"></a>
												</c:when>
												<c:otherwise>
													<a href="listPostByTime.do?curPage=1&location=${cookie.location.value}&newsType=3&subNewsType=0" class="topic-image"><img src="${topic.image}"></a>
												</c:otherwise>
											</c:choose>
										</c:when>
										<c:when test="${topic.name eq '实习/兼职'}">
											<c:choose>
												<c:when test="${cookie.location.value == null || cookie.location.value == ''}">
													<a href="listPostByTime.do?curPage=1&location=21&newsType=2&subNewsType=2" class="topic-image"><img src="${topic.image}"></a>
												</c:when>
												<c:otherwise>
													<a href="listPostByTime.do?curPage=1&location=${cookie.location.value}&newsType=2&subNewsType=2" class="topic-image"><img src="${topic.image}"></a>
												</c:otherwise>
											</c:choose>
										</c:when>
										<c:when test="${topic.name eq '全职'}">
											<c:choose>
												<c:when test="${cookie.location.value == null || cookie.location.value == ''}">
													<a href="listPostByTime.do?curPage=1&location=21&newsType=2&subNewsType=1" class="topic-image"><img src="${topic.image}"></a>
												</c:when>
												<c:otherwise>
													<a href="listPostByTime.do?curPage=1&location=${cookie.location.value}&newsType=2&subNewsType=1" class="topic-image"><img src="${topic.image}"></a>
												</c:otherwise>
											</c:choose>
										</c:when>
										<c:when test="${topic.name eq '上海'}">
											<a href="listPostByTime.do?curPage=1&location=21&newsType=2&subNewsType=0" class="topic-image"><img src="${topic.image}"></a>
										</c:when>
										<c:when test="${topic.name eq '北京'}">
											<a href="listPostByTime.do?curPage=1&location=10&newsType=2&subNewsType=0" class="topic-image"><img src="${topic.image}"></a>
										</c:when>
										<c:when test="${topic.name eq '杭州'}">
											<a href="listPostByTime.do?curPage=1&location=571&newsType=2&subNewsType=0" class="topic-image"><img src="${topic.image}"></a>
										</c:when>
										<c:when test="${topic.name eq '南京'}">
											<a href="listPostByTime.do?curPage=1&location=25&newsType=2&subNewsType=0" class="topic-image"><img src="${topic.image}"></a>
										</c:when>
										<c:when test="${topic.name eq '武汉'}">
											<a href="listPostByTime.do?curPage=1&location=27&newsType=2&subNewsType=0" class="topic-image"><img src="${topic.image}"></a>
										</c:when>
									</c:choose>
                                    <div class="topic-content">
										<c:choose>
											<c:when test="${topic.name eq '招聘'}">
												<c:choose>
													<c:when test="${cookie.location.value == null || cookie.location.value == ''}">
														<a href="listPostByTime.do?curPage=1&location=21&newsType=2&subNewsType=0" onclick="locationChange(21)">${topic.name}</a>
													</c:when>
													<c:otherwise>
														<a href="listPostByTime.do?curPage=1&location=${cookie.location.value}&newsType=2&subNewsType=0" onclick="locationChange(${cookie.location.value})">${topic.name}</a>
													</c:otherwise>
												</c:choose>
											</c:when>
											<c:when test="${topic.name eq '鹊桥'}">
												<c:choose>
													<c:when test="${cookie.location.value == null || cookie.location.value == ''}">
														<a href="listPostByTime.do?curPage=1&location=21&newsType=3&subNewsType=0" onclick="locationChange(21)">${topic.name}</a>
													</c:when>
													<c:otherwise>
														<a href="listPostByTime.do?curPage=1&location=${cookie.location.value}&newsType=3&subNewsType=0" onclick="locationChange(${cookie.location.value})">${topic.name}</a>
													</c:otherwise>
												</c:choose>
											</c:when>
											<c:when test="${topic.name eq '实习/兼职'}">
												<c:choose>
													<c:when test="${cookie.location.value == null || cookie.location.value == ''}">
														<a href="listPostByTime.do?curPage=1&location=21&newsType=2&subNewsType=2" onclick="locationChange(21)">${topic.name}</a>
													</c:when>
													<c:otherwise>
														<a href="listPostByTime.do?curPage=1&location=${cookie.location.value}&newsType=2&subNewsType=2" onclick="locationChange(${cookie.location.value})">${topic.name}</a>
													</c:otherwise>
												</c:choose>
											</c:when>
											<c:when test="${topic.name eq '全职'}">
												<c:choose>
													<c:when test="${cookie.location.value == null || cookie.location.value == ''}">
														<a href="listPostByTime.do?curPage=1&location=21&newsType=2&subNewsType=1" onclick="locationChange(21)">${topic.name}</a>
													</c:when>
													<c:otherwise>
														<a href="listPostByTime.do?curPage=1&location=${cookie.location.value}&newsType=2&subNewsType=1" onclick="locationChange(${cookie.location.value})">${topic.name}</a>
													</c:otherwise>
												</c:choose>
											</c:when>
											<c:when test="${topic.name eq '上海'}">
												<a href="listPostByTime.do?curPage=1&location=21&newsType=2&subNewsType=0" onclick="locationChange(21)">${topic.name}</a>
											</c:when>
											<c:when test="${topic.name eq '北京'}">
												<a href="listPostByTime.do?curPage=1&location=10&newsType=2&subNewsType=0" onclick="locationChange(10)">${topic.name}</a>
											</c:when>
											<c:when test="${topic.name eq '杭州'}">
												<a href="listPostByTime.do?curPage=1&location=571&newsType=2&subNewsType=0" onclick="locationChange(571)">${topic.name}</a>
											</c:when>
											<c:when test="${topic.name eq '南京'}">
												<a href="listPostByTime.do?curPage=1&location=25&newsType=2&subNewsType=0" onclick="locationChange(25)">${topic.name}</a>
											</c:when>
											<c:when test="${topic.name eq '武汉'}">
												<a href="listPostByTime.do?curPage=1&location=27&newsType=2&subNewsType=0" onclick="locationChange(27)">${topic.name}</a>
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
												<c:choose>
													<c:when test="${cookie.location.value == null || cookie.location.value == ''}">
														<a href="listPostByTime.do?curPage=1&location=21&newsType=2&subNewsType=0" onclick="locationChange(21)">${topic.name}</a>
													</c:when>
													<c:otherwise>
														<a href="listPostByTime.do?curPage=1&location=${cookie.location.value}&newsType=2&subNewsType=0" onclick="locationChange(${cookie.location.value})">${topic.name}</a>
													</c:otherwise>
												</c:choose>
											</c:when>
											<c:when test="${topic.name eq '鹊桥'}">
												<c:choose>
													<c:when test="${cookie.location.value == null || cookie.location.value == ''}">
														<a href="listPostByTime.do?curPage=1&location=21&newsType=3&subNewsType=0" onclick="locationChange(21)">${topic.name}</a>
													</c:when>
													<c:otherwise>
														<a href="listPostByTime.do?curPage=1&location=${cookie.location.value}&newsType=3&subNewsType=0" onclick="locationChange(${cookie.location.value})">${topic.name}</a>
													</c:otherwise>
												</c:choose>
											</c:when>
											<c:when test="${topic.name eq '实习/兼职'}">
												<c:choose>
													<c:when test="${cookie.location.value == null || cookie.location.value == ''}">
														<a href="listPostByTime.do?curPage=1&location=21&newsType=2&subNewsType=2" onclick="locationChange(21)">${topic.name}</a>
													</c:when>
													<c:otherwise>
														<a href="listPostByTime.do?curPage=1&location=${cookie.location.value}&newsType=2&subNewsType=2" onclick="locationChange(${cookie.location.value})">${topic.name}</a>
													</c:otherwise>
												</c:choose>
											</c:when>
											<c:when test="${topic.name eq '全职'}">
												<c:choose>
													<c:when test="${cookie.location.value == null || cookie.location.value == ''}">
														<a href="listPostByTime.do?curPage=1&location=21&newsType=2&subNewsType=1" onclick="locationChange(21)">${topic.name}</a>
													</c:when>
													<c:otherwise>
														<a href="listPostByTime.do?curPage=1&location=${cookie.location.value}&newsType=2&subNewsType=1" onclick="locationChange(${cookie.location.value})">${topic.name}</a>
													</c:otherwise>
												</c:choose>
											</c:when>
											<c:when test="${topic.name eq '上海'}">
												<a href="listPostByTime.do?curPage=1&location=21&newsType=2&subNewsType=0" onclick="locationChange(21)">${topic.name}</a>
											</c:when>
											<c:when test="${topic.name eq '北京'}">
												<a href="listPostByTime.do?curPage=1&location=10&newsType=2&subNewsType=0" onclick="locationChange(10)">${topic.name}</a>
											</c:when>
											<c:when test="${topic.name eq '杭州'}">
												<a href="listPostByTime.do?curPage=1&location=571&newsType=2&subNewsType=0" onclick="locationChange(571)">${topic.name}</a>
											</c:when>
											<c:when test="${topic.name eq '南京'}">
												<a href="listPostByTime.do?curPage=1&location=25&newsType=2&subNewsType=0" onclick="locationChange(25)">${topic.name}</a>
											</c:when>
											<c:when test="${topic.name eq '武汉'}">
												<a href="listPostByTime.do?curPage=1&location=27&newsType=2&subNewsType=0" onclick="locationChange(27)">${topic.name}</a>
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

			<div class="hot-user">
				<div class="clearfix"><div class="hot-user-title"><span></span>&nbsp;app下载</div></div>
				<ul class="myimg"><img id="download" src="http://www.211sq.com/asset/image/211apk.png"></ul>
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
	
	function locationChange(location) {
	    setCookie("location", location);
	}

    function setCookie(name,value){
        var Days = 30;//此 cookie 将被保存 30 天
        var exp = new Date();//new Date("December 31, 9998");
        exp.setTime(exp.getTime() + Days*24*60*60*1000);
        document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
    }
</script>
</body>
</html>













