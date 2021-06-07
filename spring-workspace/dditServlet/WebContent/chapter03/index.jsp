<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인에 실패</title>
</head>
<body>
	<h2>index.jsp 페이지입니다.</h2>
	<br />
	<%
	String name = request.getParameter("name") == null ? "" : request.getParameter("name");
	%>
	name은?
	<%=name%>
</body>
</html>