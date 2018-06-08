<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" import="java.util.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>211社区下载</title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/base.css">
</head>
<body>
<style type="text/css">
	*{margin:0; padding:0;}
	img{max-width: 100%; height: auto;}
	.test{
		text-align: center;
		height: 200px;
		max-width: 1000px;
		font-size: 40px;
		left: 50%;
		top: 50%;
	}
	.test .download-button{
		height: 100px;
		width: 400px;
		text-align: center;
		border-radius: 3px;
		background-color: #00B091;
		color: #fff;
		font: 23px/38px "微软雅黑";
		left: 50%;
		top: 50%;
	}
</style>

<%--<div class="test">--%>
	<%--<a><img src="http://www.211sq.com/asset/image/首页.jpg"></a>--%>
<%--</div>--%>
<div class="test">
	<a><img src="http://www.211sq.com/asset/image/download2.png"></a>
</div>
<br><br><br><br><br><br><br><br><br><br><br><br>
<div class="test">
	<button class="download-button" onclick="window.location = 'http://www.211sq.com/asset/apk/211sq.apk'">点击下载APP</button>
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