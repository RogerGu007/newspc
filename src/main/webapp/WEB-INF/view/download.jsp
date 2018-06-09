<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" import="java.util.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>211社区下载</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/base.css">
</head>
<body>
<%@ include file="header.jsp" %>
<style type="text/css">
	*{
		margin:0;
		padding:0;
	}
	img {
		max-width: 100%;
		height: auto;
	}
	.test {
		position: relative;
	}
	#btn {
		font-size: 40px;
		letter-spacing: 10px;
		position: absolute;
		top: 60%;
		left: 20%;
		width: 500px;
		background: url("http://www.211sq.com/asset/image/downbutton.JPG") no-repeat;
	}
</style>

<div class="main w clearfix">
	<div class="main-left">
		<div class="test">
			<img src="http://www.211sq.com/asset/image/downloadpage2.jpg" width="100%">
			<input type="button" id="btn" onclick="window.location = 'http://www.211sq.com/asset/apk/211sq.apk'"/>
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
			<div class="clearfix"><div class="hot-user-title"><span></span>&nbsp;app下载</div></div>
			<ul class="myimg"><img id="download" src="http://www.211sq.com/asset/image/211apk.png"></ul>
		</div>

	</div>
</div>


<%@ include file="footer.jsp" %>
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
    function is_weixin() {
        var ua = navigator.userAgent.toLowerCase();
        if (ua.match(/MicroMessenger/i) == "micromessenger") {
            return true;
        } else {
            return false;
        }
    }
    var isWeixin = is_weixin();
    var winHeight = typeof window.innerHeight != 'undefined' ? window.innerHeight : document.documentElement.clientHeight;
    function loadHtml(){
        var div = document.createElement('div');
        div.id = 'weixin-tip';
        div.innerHTML = '<p><img src="http://www.211sq.com/asset/image/live_weixin.png" alt="微信打开"/></p>';
        document.body.appendChild(div);
    }

    function loadStyleText(cssText) {
        var style = document.createElement('style');
        style.rel = 'stylesheet';
        style.type = 'text/css';
        try {
            style.appendChild(document.createTextNode(cssText));
        } catch (e) {
            style.styleSheet.cssText = cssText; //ie9以下
        }
        var head=document.getElementsByTagName("head")[0]; //head标签之间加上style样式
        head.appendChild(style);
    }
    var cssText = "#weixin-tip{position: fixed; left:0; top:0; background: rgba(0,0,0,0.8); filter:alpha(opacity=80); width: 100%; height:100%; z-index: 100;} #weixin-tip p{text-align: center; margin-top: 10%; padding:0 5%;}";
    if(isWeixin){
        loadHtml();
        loadStyleText(cssText);
    }
</script>
</body>
</html>