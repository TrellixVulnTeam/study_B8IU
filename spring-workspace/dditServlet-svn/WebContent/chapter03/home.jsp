<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.net.URLEncoder"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% //request.setCharacterEncoding("UTF-8"); %>
<%// String name =  request.getParameter("name");%>
<% String name =  (String)session.getAttribute("userName");%>
<%=name %>님 환영합니다
</body>
</html>