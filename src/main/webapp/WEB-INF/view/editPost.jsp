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


	<div class="main w clearfix">
		<div class="m-left">
			<div>
				<form>
					<div>
						ID：&nbsp;&nbsp;&nbsp;<textarea name="newsid" id="newsid" style="height: 25px;max-height: 200px; width: 500px; max-width: 800px"></textarea>
					</div>
					<div>
						链接：<textarea name="linkUrl" id="linkUrl" style="height: 25px;max-height: 200px; width: 500px; max-width: 800px"></textarea>
					</div>
					<div>
						主题：<textarea name="subject" id="subject" style="height: 25px;max-height: 25px; width: 500px; max-width: 800px"></textarea>
					</div>
					<div>
						类型：<select id="newsTypeSelect">
							<option value="" selected="selected"></option>
							<option value="2">求职</option>
							<option value="3">鹊桥</option>
						</select>
					</div>
					<div>
						子类：<select id="subNewsTypeSelect">
							<option value="" selected="selected"></option>
							<option value="1">全职</option>
							<option value="2">实习/兼职</option>
						</select>
					</div>
					<div>
						发帖内容：
					</div>
					<textarea name="content" id="content" style="height: 200px;max-height: 1000px; width: 540px; max-width: 800px"></textarea>
				</form>
			</div>

			<div class="user-button">
				<a class="button-follow" id="submit-edit">提交编辑</a>
			</div>
			<li></li>
			<div class="user-button">
				<a class="button-follow" id="submit-delete">删除帖子</a>
			</div>

			<div class="user-post">
				<div class="user-post-title"></div>
				<div class="user-post-title"><span></span>&nbsp;预览</div>
				<ul class="user-post-list" id="previewContent"></ul>
			</div>
		</div>
	</div>

<%@ include file="footer.jsp" %>
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="js/base.js"></script>
<script type="text/javascript">

    $(function(){
        if (getCookie("sessionID") == null || getCookie("sessionID") == null) {
            alert("请登录管理员账户！")
            window.location.href = "beAdminLogin.do";
		}

		var newsid = "${newsid}";
		if (newsid != null || newsid != '') {
		    $.ajax({
				type:"GET",
				url:"getNewsDetail.do",
				data:{newsid:newsid},
				success:function(response){
				    var subject = response.Subject;
				    var linkurl = response.sourceArticleUrl;
				    var detailContent = response.detailContent;
                    $("#newsid").val(newsid);
                    $("#linkUrl").val(linkurl);
                    $("#subject").val(subject);
                    $("#content").val(detailContent);
				}
		    });
		}
	});

	$("#submit-edit").click(function () {
		$.ajax({
            type:"POST",
            url:"editNews.do",
            data:{sessionId:getCookie("sessionID"),adminID:getCookie("adminID"),
				newsid:$("#newsid").val(), linkUrl:$("#linkUrl").val(),
                subject:$("#subject").val(), content:$("#content").val(),
				newsType:$("#newsTypeSelect").val(), subNewsType:$("#subNewsTypeSelect").val()
			},
            success:function(response){
                if (response.errcode == "0") {
                    alert("帖子修改成功！");
                    //获取更新的数据
                    $.ajax({
                        type:"GET",
                        url:"getNewsDetail.do",
                        data:{newsid:$("#newsid").val()},
                        success:function(detailResp){
                            var subject = detailResp.Subject.toString();
                            var detailContent = detailResp.detailContent.toString();
                            var preview = "<div>"+subject+"</div><br></br><div>" + detailContent + "</div>";
                            $("#previewContent").children().remove();
                            $("#previewContent").append(preview);
                        }
                    });
                } else {
                    alert(response.errmsg);
                    window.location.href = "beAdminLogin.do";
                }
            }
        });
    });

    $("#submit-delete").click(function () {
        if(confirm("是否确认刪除?")) {
            $.ajax({
                type:"POST",
                url:"deleteNews.do",
                data:{newsid:$("#newsid").val()},
                success:function(response){
                    if (response.errcode == "0") {
                        alert("帖子删除成功！");
                        window.location.href = document.referrer;
                    } else
                        alert(response.errmsg);
                }
            });
		}
    });

    //取cookies函数
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













