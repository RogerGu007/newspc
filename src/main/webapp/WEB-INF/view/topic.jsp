<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-type" content="text/html"/>
	<title>211社区-校园生活工作情报站,招聘求职交友一站式服务</title>
	<meta name="keywords" content="校园,招聘,求职,交友,鹊桥,校园生活,工作情报站,211,社区,高校bbs">
	<meta name="description" content="校园生活工作情报站,招聘求职交友一站式服务,各大高校招聘、求职、交友">
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
						<a rel="nofollow" href="http://www.newsmth.net" class="hot-user-image"><img src="http://www.211sq.com/asset/image/university/tsing.jpg"></a>
						<a rel="nofollow" href="http://www.newsmth.net" class="hot-user-name">水木清华</a>
					</li>
					<li class="clearfix">
						<a rel="nofollow" href="https://bbs.pku.edu.cn/v2/home.php" class="hot-user-image"><img src="http://www.211sq.com/asset/image/university/pku.jpg"></a>
						<a rel="nofollow" href="https://bbs.pku.edu.cn/v2/home.php" class="hot-user-name">北大未名</a>
					</li>
					<li class="clearfix">
						<a rel="nofollow" href="https://bbs.fudan.edu.cn/bbs/top10" class="hot-user-image"><img src="http://www.211sq.com/asset/image/university/fudan.jpg"></a>
						<a rel="nofollow" href="https://bbs.fudan.edu.cn/bbs/top10" class="hot-user-name">日月光华</a>
					</li>
					<li class="clearfix">
						<a rel="nofollow" href="https://bbs.sjtu.edu.cn" class="hot-user-image"><img src="http://www.211sq.com/asset/image/university/sjtu.jpg"></a>
						<a rel="nofollow" href="https://bbs.sjtu.edu.cn" class="hot-user-name">饮水思源</a>
					</li>
                    <li class="clearfix">
                        <a rel="nofollow" href="https://bbs.tongji.net/" class="hot-user-image"><img src="http://www.211sq.com/asset/image/university/tj.jpg"></a>
                        <a rel="nofollow" href="https://bbs.tongji.net/" class="hot-user-name">同济之声</a>
                    </li>
                    <li class="clearfix">
                        <a rel="nofollow" href="http://bbs.nju.edu.cn/" class="hot-user-image"><img src="http://www.211sq.com/asset/image/university/nju.jpg"></a>
                        <a rel="nofollow" href="http://bbs.nju.edu.cn/" class="hot-user-name">小百合</a>
                    </li>
                    <li class="clearfix">
                        <a rel="nofollow" href="http://www.zju1.com/" class="hot-user-image"><img src="http://www.211sq.com/asset/image/university/zju.jpg"></a>
                        <a rel="nofollow" href="http://www.zju1.com/" class="hot-user-name">梧桐树</a>
                    </li>
                    <li class="clearfix">
                        <a rel="nofollow" href="http://bbs.whu.edu.cn" class="hot-user-image"><img src="http://www.211sq.com/asset/image/university/whu.jpg"></a>
                        <a rel="nofollow" href="http://bbs.whu.edu.cn" class="hot-user-name">珞珈山水</a>
                    </li>
                    <li class="clearfix">
                        <a rel="nofollow" href="http://bbs.iecnu.com/" class="hot-user-image"><img src="http://www.211sq.com/asset/image/university/iecnu.jpg"></a>
                        <a rel="nofollow" href="http://bbs.iecnu.com/" class="hot-user-name">爱在华师</a>
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













