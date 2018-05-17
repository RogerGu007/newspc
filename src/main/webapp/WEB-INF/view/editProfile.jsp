<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
	<title></title>
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/wangEditor.css">
	<link rel="stylesheet" type="text/css" href="css/base.css">
	<link rel="stylesheet" type="text/css" href="css/editProfile.css">
</head>
<body>
<%@ include file="header.jsp" %>


	<!-- 中间主体板块 -->
	<div class="main w clearfix">
		<div class="edit-header"><span></span>&nbsp;编辑信息</div>
		<form action="editProfile.do" method="post">
			<div class="edit-title">
                <input type="hidden" name="ID" value="${cookie.userId.value}">
				昵&nbsp;&nbsp;&nbsp;称：<input type="text" name="nickName" value="${user.nickName}">
			</div>
			<div class="edit-title">
				电&nbsp;&nbsp;&nbsp;话：<input type="text" name="phoneNo" value="${user.phoneNo}">
			</div>
			<div class="edit-title">
				性&nbsp;&nbsp;&nbsp;别：
				<select name="sex">
					<%--<option value="保密" selected="selected">保密</option>--%>
					<option value="男" selected="selected">男</option>
					<option value="女">女</option>
				</select>
			</div>
			<div class="edit-title">
				学&nbsp;&nbsp;&nbsp;校：<input type="text" name="college" value="${user.college}">
			</div>
			<div class="relative">
				<button class="edit-submit">确认编辑</button>
			</div>
		</form>

        <%--<div style="margin-top: 60px;"></div>--%>
		<%--<div class="edit-header"><span></span>&nbsp;修改密码</div>--%>
		<%--<form action="updatePassword.do" method="post">--%>
			<%--<div class="edit-title">--%>
                <%--<div class="text-danger">${passwordError}</div>--%>
				<%--原密码：<input type="password" name="password">--%>
			<%--</div>--%>
			<%--<div class="edit-title">--%>
				<%--新密码：<input type="password" name="newpassword">--%>
			<%--</div>--%>
			<%--<div class="edit-title">--%>
				<%--确&nbsp;&nbsp;&nbsp;认：<input type="password" name="repassword">--%>
			<%--</div>--%>
			<%--<div class="relative">--%>
				<%--<button class="edit-submit">确认修改</button>--%>
			<%--</div>--%>
		<%--</form>--%>

        <%--<div style="margin-top: 60px;"></div>--%>
        <%--<div class="edit-header"><span></span>&nbsp;更换头像</div>--%>
        <%--&lt;%&ndash;<form action="updateHeadUrl.do" method="post" enctype="multipart/form-data">&ndash;%&gt;--%>
		<%--<form action="updateHeadUrl.do" method="post">--%>
            <%--<div class="edit-title">--%>
				<%--<span class="text-danger">${error3}</span>--%>
				<%--<input type="hidden" name="userid" value="${cookie.userId.value}">--%>
				<%--链&nbsp;&nbsp;&nbsp;接：<input name="avatarurl" value="${user.avatarUrl}">--%>
                <%--&lt;%&ndash;<input type="file" name="myFileName">&ndash;%&gt;--%>
            <%--</div>--%>
            <%--<div class="relative">--%>
                <%--<button class="edit-submit">确认更新</button>--%>
            <%--</div>--%>
        <%--</form>--%>

	</div><!-- 主体结束 -->


<%@ include file="footer.jsp" %>
<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>

</body>
</html>













