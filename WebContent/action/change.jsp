<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>修改页面--by:王泽洋</title>
<link href="../css/mainRules.css" rel="stylesheet" />
<script type="text/javascript" src="../js/jsFunction.js"></script>
</head>
<body>
	<jsp:useBean id="manage" class="com.Ephemeral.bean.dao.impl.DatabaseManageImpl"></jsp:useBean>
	<jsp:useBean id="stuc" class="com.Ephemeral.entity.Stuc"></jsp:useBean>
	<%
		String changeId = request.getParameter("id");
		session.setAttribute("changeById", changeId);
		stuc = manage.getstucById(Integer.valueOf(changeId));
	%>
	<form action="../servlet/do_change" method="post">
		<table class="dirName-t">
			<tr>
				<td colspan="2" align="center">
					<p class="dirName-p-title" >
						<b style="font-size: 18px">做出你的修改</b>
					</p>
				</td>
			</tr>
			<tr>
				<td>
					<p class="dirName-p">课程序号：</p>
				</td>
				<td>
					<input class="new" name = "newcID" value="<%= stuc.getID()%>"/>
				</td>
			</tr>
			<tr>
				<td>
					<p class="dirName-p">课程编号：</p>
				</td>
				<td>
					<input class="new" name = "newcNo" value="<%= stuc.getcNo()%>"/>
				</td>
			</tr>
			<tr>
				<td>
					<p class="dirName-p">课程名称：</p>
				</td>
				<td>
					<input class="new" name = "newcName" value="<%= stuc.getcName()%>"/>
				</td>
			</tr>
			<tr>
				<td>
					<p class="dirName-p">授课教师：</p>
				</td>
				<td>
					<input class="new" name = "newcTeac" value="<%= stuc.getcTeac()%>"/>
				</td>
			</tr>
			<tr>
				<td>
					<p class="dirName-p">授课部门：</p>
				</td>
				<td>
					<input class="new" name = "newcDep" value="<%= stuc.getcDep()%>"/>
				</td>
			</tr>
				<td>
					<p class="dirName-p">线上授课：</p>
				</td>
				<td>
					<input class="new" name = "newisOnline" value="<%= stuc.getIsOnline()%>"/>
				</td>
			<tr>
				<td>
					<p class="dirName-p">授课平台：</p>
				</td>
				<td>
					<input class="new" name = "newcPf" value="<%= stuc.getcPf()%>"/>
				</td>
			</tr>
			<tr>
				<td>
					<p class="dirName-p">授课方式：</p>
				</td>
				<td>
					<input class="new" name = "newcMethod" value="<%= stuc.getcMethod()%>"/>
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="提交修改"/>
				</td>
				<td align="right" >
					<input type="button" value="取消" onclick="change_cover_change_re();"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>