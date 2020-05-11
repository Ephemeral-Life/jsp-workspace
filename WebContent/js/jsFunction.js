function deleteConfirm(id)
{
	var ask = confirm("这将删除这个课程，确定执行吗？");
	if (ask == true)
	{
		window.location="/loginServlet/servlet/do_delStuc?id="+id;
	}
	else
	{
		;
	}
}

//弹窗初始化高度、下降至底，循环调用
function tips_pop()
{
	var MsgPop = document.getElementById("winpop");
	var popH = parseInt(MsgPop.style.height); 
	if (popH == 0)
	{
		MsgPop.style.display = "block";
		show = setInterval("changeH('up')", 30);
	} 
	else
	{
		hide = setInterval("changeH('down')", 30);
	}
}

//高度变化实现
function changeH(str)
{
	var MsgPop = document.getElementById("winpop");
	var popH = parseInt(MsgPop.style.height);
	if (str == "up") 
	{
		if (popH <= 84)
		{
			MsgPop.style.height = (popH + 3).toString() + "px";
		} 
		else 
		{
			clearInterval(show);
		}
	}
	if (str == "down")
	{
		if (popH >= 4)
		{
			MsgPop.style.height = (popH - 4).toString() + "px";
		}
		else
		{
			clearInterval(hide);
			MsgPop.style.display = "none";
		}
	}
}
//高度上升3像素
function changeUpline()
{
	var MsgPop = document.getElementById("winpop");
	var popH = parseInt(MsgPop.style.height);
	MsgPop.style.height = (popH + 3).toString() + "px";
}

function cookie_login_servler()
{
	window.location.href='servlet/do_cookie_login';
}
function cookie_login_show()
{
	var MsgPop = document.getElementById("winpop");
    var strcookie = document.cookie;
    var arrcookie = strcookie.split("; ");
	var userName = null;
	var passWord = null;
	var contect = null;
	var runTime = 0;
	var br = "<br//>";
	var show_passWord = "";

	if(arrcookie.length > 1)
	{
		for (var i = 0; i < arrcookie.length; i++)
		{
		    var arr = arrcookie[i].split("=");
		    if (arr[0] == "userNameCookie")
		    {
		        userName = arr[1];
		    }
		    if (arr[0] == "passWordCookie")
		    {
		        passWord = arr[1];
		    }
		}
		for(var j = 0;j< passWord.length; j++)
			show_passWord = show_passWord + "*";
		contect = "<p class = 'pop-content-p-alert'   onclick='tips_pop();'>检测到已保存的cookie</p>" + br +
				  "<p class = 'pop-content-p-alert' onclick='tips_pop();'>用户名：" + userName + "</p>" + br + 
				  "<p class = 'pop-content-p-alert' onclick='tips_pop();'>密码：" + show_passWord + "</p>" + br +
				  "<p class = 'pop-content-p-alert' onclick='tips_pop();'>尝试使用cookie登录...</p>";
		MsgPop.innerHTML = MsgPop.innerHTML + br + br + contect;
		document.getElementById("cookie_login_enter").href = "javascript:void(0);"; 
		var show_login_note = setInterval
		(
			function()
			{
				runTime = runTime + 1;
				if(runTime >= 42)
				{
					runTime = 0;
					clearInterval(show_login_note); 
				}
				else
				{
					changeUpline();
				}
			}
		, 30);
		setInterval("cookie_login_servler()", 3000);
	}
	else
	{
		contect = "<p class = 'pop-content-p-alert' onclick='tips_pop();'>没找到登录cookie，\n"+br+"至少成功登录过一次才能使用cookie登录。</p>";
		MsgPop.innerHTML = MsgPop.innerHTML + br + br + contect;
		var show_alert = setInterval
			(
				function()
				{
					runTime = runTime + 1;
					if(runTime >= 21)
					{
						runTime = 0;
						clearInterval(show_alert); 
					}
					else
					{
						changeUpline();
					}
				}
			, 30);
	}
}

function ask_cookie_save()
{
	var ask = confirm("正在登录的账号没有启用自动登录，\n现在启用自动登录？");
	if (ask == true)
	{
		var days = window.prompt("你想在多少天内自动登录：");
		alert("完成，现在你可以直接访问main.jsp了。")
		window.location="/loginServlet/servlet/do_redirecter?days="+days;
	}
	else
	{
		window.location="/loginServlet/servlet/do_redirecter";
	}
	
}

function root_login()
{
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
}

function no_authorize_change()
{
	alert("你没有权限修改课程。")
}

function no_authorize_delete()
{
	alert("你没有权限删除课程。")
}

function change_cover_change()
{
	document.getElementById("float-cover-change").style.display="block";
}
function change_cover_change_re()
{
	window.parent.document.getElementById("float-cover-change").style.display="none";
}
function change_cover_newStuc()
{
	document.getElementById("float-cover-newStuc").style.display="block";
}
function change_cover_newStuc_re()
{
	window.parent.document.getElementById("float-cover-newStuc").style.display="none";
}
function change_cover_newAccount()
{
	document.getElementById("float-cover-newAccount").style.display="block";
}
function change_cover_newAccount_re()
{
	window.parent.document.getElementById("float-cover-newAccount").style.display="none";
}