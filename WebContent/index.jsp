<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<link href="./css/reset.css" rel="stylesheet" />
	<link href="./css/login&register.css" rel="stylesheet" />
	<script type="text/javascript" src="js/jsFunction.js" charset="utf-8"></script>
	<title>登录页面--by:王泽洋</title>
	<script type="text/javascript">
		function reload()
		{
			document.getElementById("image").src="<%=request.getContextPath() %>/servlet/do_verify?date="+new Date().getTime();
			$("#checkcode").val("");
		}
	</script>
</head>
<body onload="tips_pop(); cookie_login();">
	<div class="box">
		<div class="mainHolder">
			<img src="img/index_pic1.jpg" width=100% />
		</div>
		<div class="textHolder" style=""></div>
		<div class="text">
			<form name="form1" id="form1" method="post" action="servlet/do_account_login">
				<table width="100%" border="0" cellspacing="5" cellpadding="0" align="center">
					<tr>
						<td width="100%" colspan="2" align="left">
							<font style="font-size: 33px; color: red; font-weight: bolder; display: block; text-align: center">
									这是一个登录页面
							</font>
						</td>
					</tr>
					<tr>
						<td width="100%" colspan="2" align="center">
							<font style="font-size: 18px; color: red; font-weight: bolder; display: block; text-align: right">
							</font>
						</td>
					</tr>
					<tr>
						<td width="100%" colspan="2" height="20"></td>
					</tr>
					<tr>
						<td width="39%" height="22" align="right">
							<span style="font-size: 12px; font-weight: 700">
								<font color="red">
									账号:
								</font>
							</span>
						</td>
						<td width="61%" height="22">
							<input name="username" type="text" style="height: 20px; width: 130px; border: solid 1px #bbbbbb">
						</td>
					</tr>
					<tr>
						<td width="39%" height="22" align="right">
							<span style="font-size: 12px; font-weight: 700">
								<font color="red">
									密码:
								</font>
							</span>
						</td>
						<td width="61%" height="22">
							<input name="password" type="password" style="height: 20px; width: 130px; border: solid 1px #bbbbbb">
						</td>
					</tr>
					<tr height="15px">
						<td width="39%" height="22" align="right">
							<span style="font-size: 12px;font-weight: 700">
								<font color="red">
									验证码:
								</font>
							</span>
						</td>
						<td width="61%" height="22">
							<input type="text" name="checkcode"  id="checkcode" style="width: 68px;"/>
						  	<img src="<%=request.getContextPath() %>/servlet/do_verify" alt="验证码" id="image" style="width: 58px; height: 18px;" onclick="javascript:reload();" />
						</td>
					</tr>
					<tr>
						<td width="25%" height="22"></td>
						<td width="75%" height="22">
						<input type="submit" value="登录" style="width: 60px;"> 
						<input type="button" value="注册" style="width: 60px;"
							onclick="javascript:window.location.href='register.jsp'">
						</td>
					</tr>
				</table>
			</form>
		</div>
		<script language="javascript" type="text/javascript">
			window.onload = function tanchuang() 
			{
	            document.getElementById('winpop').style.height = '0px';
	            setTimeout("tips_pop()",0);
	        }  
		</script>
		<div id="winpop">
			<div class="title">
				<p onclick="tips_pop();">登录提示--by:王泽洋</p><br> <span class="close" onclick="tips_pop();">关闭</span>
			</div>
			<p class = "pop-content-p">站点现在支持cookie登录，</p>
			<br/>
			<p class = "pop-content-p" style = "padding-right: 0px">点击</p>
			<a class = "pop-content-a" href="javascript:cookie_login_show();" id="cookie_login_enter">这里</a>
			<p class = "pop-content-p" style = "padding-left: 0px">尝试使用cookie登录。</p>
		</div>
	</div>
</body>
</html>