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
		int type = Integer.valueOf(session.getAttribute("type").toString());
		if(type != 1)
			out.println("<script>alert('不要打破第四面墙!');change_cover_newStuc_re();</script>");
		else
		{
	%>
			<form action="../servlet/do_newStuc" method="post">
				<table class="dirName-t">
					<tr>
						<td colspan="2" align="center">
							<p class="dirName-p-title" >
								<b style="font-size: 18px">新建一门课程</b>
							</p>
						</td>
					</tr>
					<tr>
						<td>
							<p class="dirName-p">课程编号：</p>
						</td>
						<td>
							<input class="new" name = "newcNo" value=""/>
						</td>
					</tr>
					<tr>
						<td>
							<p class="dirName-p">课程名称：</p>
						</td>
						<td>
							<input class="new" name = "newcName" value=""/>
						</td>
					</tr>
					<tr>
						<td>
							<p class="dirName-p">授课教师：</p>
						</td>
						<td>
							<input class="new" name = "newcTeac" value=""/>
						</td>
					</tr>
					<tr>
						<td>
							<p class="dirName-p">授课部门：</p>
						</td>
						<td>
							<input class="new" name = "newcDep" value=""/>
						</td>
					</tr>
						<td>
							<p class="dirName-p">线上授课：</p>
						</td>
						<td>
							<input class="new" name = "newisOnline" value=""/>
						</td>
					<tr>
						<td>
							<p class="dirName-p">授课平台：</p>
						</td>
						<td>
							<input class="new" name = "newcPf" value=""/>
						</td>
					</tr>
					<tr>
						<td>
							<p class="dirName-p">授课方式：</p>
						</td>
						<td>
							<input class="new" name = "newcMethod" value=""/>
						</td>
					</tr>
					<tr>
						<td>
							<input type="submit" value="新建课程"/>
						</td>
						<td align="right" >
							<input type="button" value="取消" onclick="change_cover_newStuc_re();"/>
						</td>
					</tr>
				</table>
			</form>
	<%
		}
	%>
</body>
</html>