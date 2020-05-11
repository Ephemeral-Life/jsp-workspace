<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Now you see me soon you won't</title>
	<link href="../css/mainRules.css" rel="stylesheet" />
	<script type="text/javascript" src="../js/jsFunction.js"></script>
</head>
<body>
	<jsp:useBean id="manage" class="com.Ephemeral.bean.dao.impl.DatabaseManageImpl"></jsp:useBean>
	<jsp:useBean id="stuc" class="com.Ephemeral.entity.Stuc"></jsp:useBean>
	<%
		session.setAttribute("verify", 0);
		session.setAttribute("newType", 2);
	%>
	<form action="../servlet/do_register" method="post">
		<table class="dirName-t">
			<tr>
				<td colspan="2" align="center">
					<p class="dirName-p-title" >
						<b style="font-size: 18px">新建管理员账号</b>
					</p>
				</td>
			</tr>
			<tr>
				<td>
					<p class="dirName-p">账号：</p>
				</td>
				<td>
					<input class="new" name = "username" value=""/>
				</td>
			</tr>
			<tr>
				<td>
					<p class="dirName-p">密码：</p>
				</td>
				<td>
					<input class="new" name = "password" value=""/>
				</td>
			</tr>
			<tr>
				<td>
					<p class="dirName-p">确认密码：</p>
				</td>
				<td>
					<input class="new" name = "confirm_password" value=""/>
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="新建账号"/>
				</td>
				<td align="right" >
					<input type="button" value="取消" onclick="change_cover_newAccount_re();"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>