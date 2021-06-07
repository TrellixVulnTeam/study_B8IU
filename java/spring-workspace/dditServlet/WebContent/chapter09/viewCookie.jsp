<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
//쿠키를 구하면 배열로 저장 됨
Cookie[] cookies = request.getCookies();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 목록</title>
</head>
<body>
	<%
	if (cookies != null && cookies.length > 0) {
		for (int i = 0; i < cookies.length; i++) {
			out.print(cookies[i].getName() + ": ");
			out.println(URLDecoder.decode(cookies[i].getValue(), "UTF-8") + "<br />");
		}
	} else {
		out.println("쿠키가 없습니다.");
	}
	%>
</body>
</html>