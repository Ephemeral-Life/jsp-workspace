<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<link href="./css/reset.css" rel="stylesheet" />
		<link href="./css/login&register.css" rel="stylesheet" />
		<script type="text/javascript" src="js/jsFunction.js"></script>
		<title>注册页面--by:王泽洋</title>
		<script type="text/javascript">
			function reload()
			{
				document.getElementById("image").src="<%=request.getContextPath() %>/servlet/do_verify?date="+new Date().getTime();
				$("#checkcode").val("");
			} 	
		</script>
	</head>
	<body>
		<%
			session.setAttribute("verify", 1);
			session.setAttribute("newType", 3);
		%>
		<div class="box">
			<div class="mainHolder">
				<img src="img/index_pic1.jpg" width=100%/>
			</div>
			<div class="textHolder" style="">
			</div>
			<div class="text">
				<form name="form1" id="form1" method="post" action="servlet/do_register">
					<table width="100%" border="0" cellspacing="5" cellpadding="0" align="center">
						<tr>
							<td width="100%" colspan="2" align="left">
								<font style="font-size: 33px;color: red;font-weight: bolder;display: block;text-align: center">
								   这是一个注册页面
								</font>
							</td>
						</tr>
						<tr>
							<td width="39%" height="22" align="right">
								<span style="font-size: 12px;font-weight: 700"><font color="red">账号:</font></span>
							</td>
							<td width="61%" height="22">
								<input name="username" type="text" style="height:20px;width:130px; border:solid 1px #bbbbbb">
							</td>
						</tr>
						<tr>
							<td width="39%" height="22" align="right">
								<span style="font-size: 12px;font-weight: 700"><font color="red">密码:</font></span>
							</td>
							<td width="61%" height="22">
								<input name="password" type="password" style="height:20px;width:130px; border:solid 1px #bbbbbb">
							</td>
						</tr>
						<tr>
							<td width="39%" height="22" align="right">
								<span style="font-size: 12px;font-weight: 700"><font color="red">确认密码:</font></span>
							</td>
							<td width="61%" height="22">
								<input name="confirm_password" type="password" style="height:20px; width:130px; border:solid 1px #bbbbbb">
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
							<td width="25%" height="22">
								
							</td>
							<td width="75%" height="22">
								<input type="submit" value="注册"  style="width: 60px;" >
								<input type="button" value="返回" style="width: 60px;" onclick="javascript: window.location.href='index.jsp';">
								<span style="font-size: 12px;font-weight: 700"><font color="red">&nbsp;&nbsp;&nbsp;*只能注册用户帐户</font></span>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</body>
</html>
