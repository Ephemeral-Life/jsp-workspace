<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Now you see me soon you won't</title>
</head>
<body>
	<%
		String key = "";
		key = new String(request.getParameter("search_key").getBytes("ISO-8859-1"), "gbk");
		session.setAttribute("search_key", key);
		out.print("<script>window.location='../main.jsp'</script>");
	%>
</body>
</html>