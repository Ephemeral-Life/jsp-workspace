<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.Ephemeral.bean.*" %>
<%@ page import="com.Ephemeral.entity.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="content-type" content = "text/html;charset=utf-8">
<title>主菜单页面--by:王泽洋</title>
<link href="css/reset.css" rel="stylesheet" />
<link href="css/mainRules.css" rel="stylesheet" />
<script type="text/javascript" src="js/jsFunction.js" charset="utf-8"></script>
</head>
<body>
	<jsp:useBean id="manage" class="com.Ephemeral.bean.dao.impl.DatabaseManageImpl"></jsp:useBean>
	<%
		String key = "";
		ArrayList <Stuc>list = null;
		int count = 0;
		try
		{
			key = session.getAttribute("search_key").toString();
			if(key != null || !key.equals(""))
			{
				list = manage.getCNameLike(key);
			}
			else
			{
				key = "";
				list = manage.getAllStuc();
			}
		}
		catch(Exception e)
		{
			key = "";
			list = manage.getAllStuc();
		}
		
		int type = Integer.valueOf(session.getAttribute("type").toString());
		String welcomeWord = "";
		if(type == 1)
			welcomeWord = "最高管理员：";
		else if(type == 2)
			welcomeWord = "管理员：";
		else 
			welcomeWord = "用户：";
	%>
	<div class="box" id = "box">
		<div class="head" id = "head">
			<div class="logo">
				<h1 class="logo-h"><i>Ephemeral</i>&nbsp;网课系统</h1>
			</div>
			<div class="userNameShow">
				<h2>
					<%= welcomeWord%><%= session.getAttribute("userName")%>
				</h2>
			</div>
			<div class="exitShow">
				<h2>
					<a href="servlet/do_exit">退出</a>
				</h2>
			</div>
		</div>
		<div class="content" id = "content">
			<div class="userNote">
				<table class="right">
					<tr>
						<td>
						</td>
						<td>
							ROOT权限选项：
						</td>
						<td>
							<a href="action/do_admin_register.jsp" target="frame-newAccount" onclick="javascript:change_cover_newAccount();" style="color: #003264;">
								<b>新建管理员账号</b>
							</a>
						</td>
						<td>
							<a href="action/newStuc.jsp" target="frame-newStuc" onclick="javascript:change_cover_newStuc();" style="color: #003264;">
								<b>新增课程</b>
							</a>
						</td>
					</tr>
				</table>
			</div>
			<div class="content-table">
					<table border="1px">
						<tr align="right">
							<td colspan="2" align="center" style="border-right: 0px">
								<p class="search_p">
									<i>Ephemeral</i>&nbsp;课程表
								</p>
							</td>
							<td colspan="8" align="right" style="border-left: 0px">
								<form action="action/do_search.jsp" id="search" method="post">
									<p class="search_p">
										搜索课程：
									</p>
									<input class="" name = "search_key" value="<%= key%>"/>
									<input type="submit" form="search" value="搜索"/>
								</form>
							</td>
						</tr>
						<tr>
							<td align="center" class="table-id">
								ID
							</td>
							<td align="center" class="table-classId">
								课程编号
							</td>
							<td align="center" class="table-className">
								课程名称
							</td>
							<td align="center" class="table-classTeacher">
								授课教师
							</td>
							<td align="center" class="table-classDep">
								授课部门
							</td>
							<td align="center" class="table-classOnline">
								线上教学
							</td>
							<td align="center" class="table-classPf">
								授课平台
							</td>
							<td align="center" class="table-classMothod">
								授课方式
							</td>
							<td align="center" class="table-change">
								修改
							</td>
							<td align="center" class="table-delect">
								删除
							</td>
						</tr>
					<%
						for(Stuc stuc:list)
						{
							count++;
					%>
							<tr>
								<td align="center">
									<%= stuc.getID()%>
								</td>
								<td align="center">
									<%= stuc.getcNo() %>
								</td>
								<td align="center">
									<%= stuc.getcName() %>
								</td>
								<td align="center">
									<%= stuc.getcTeac() %>
								</td>
								<td align="center">
									<%= stuc.getcDep() %>
								</td>
								<td align="center">
									<%= stuc.getIsOnline() %>
								</td>
								<td align="center">
									<%= stuc.getcPf() %>
								</td>
								<td align="center">
									<%= stuc.getcMethod() %>
								</td>
								<%
									if(type == 3)
									{
								%>
										<td align="center">
											<a href="javascript: no_authorize_change();">
												修改
											</a>
										</td>
										<td align="center">
											<a class="table-delect-a" href="javascript: no_authorize_delete();">
												删除
											</a>
										</td>
								<%
									}
									else
									{
								%>
										<td align="center">
											<a href="action/change.jsp?id=<%= stuc.getID()%>" target="frame-change" onclick="javascript:change_cover_change();">
												修改
											</a>
										</td>
										<td align="center">
											<a class="table-delect-a" href="javascript: deleteConfirm(<%= stuc.getID()%>);">
												删除
											</a>
										</td>
								<%
									}
								%>
							</tr>
					<%
						}
						if(count == 0)
						{
				%>
							<tr>
								<td align="center" class="table-id" colspan="10">
									<p style="width: 1090.8px">
										这里什么都没有
									</p>
								</td>
							</tr>
				<%
						}
				%>
					</table>
			</div>
			<div class="float-cover-change" id="float-cover-change">
				<div class="window-float" id = "window-float">
					<iframe name="frame-change" height="580px">
					
					</iframe>
				</div>
			</div>
			<div class="float-cover-newStuc" id="float-cover-newStuc">
				<div class="window-float" id = "window-float">
					<iframe name="frame-newStuc" height="580px">
					
					</iframe>
				</div>
			</div>
			<div class="float-cover-newAccount" id="float-cover-newAccount">
				<div class="window-float" id = "window-float">
					<iframe name="frame-newAccount" height="580px">
					
					</iframe>
				</div>
			</div>
			<%
				if(type == 1)
				{
			%>
				<script type="text/javascript">
					var timer=null;
					var divHead=document.getElementById('head');
					var divMove=document.getElementById('content');
					clearInterval(timer);
					timer=setInterval
					(
						function()
						{
							var speed=1;
							if(divMove.offsetTop>=(1 * divHead.clientHeight))
							{
								clearInterval(timer);
							}
							else
							{
								divMove.style.top=divMove.offsetTop+speed+'px';
								divMove.style.height=divMove.clientHeight-speed+"px";
							}
						},30
					);
				</script>
			<%
				}
			%>
		</div>
	</div>
</body>
</html>