<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String name = request.getParameter("name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공</title>
</head>
<body>
<%
	if(session.getAttribute("memName") == null) {
		out.println("로그인되지 않았습니다.");
	} else {
		out.println(session.getAttribute("memName") + "님 환영합니다.");
	}
%>
</body>
</html>