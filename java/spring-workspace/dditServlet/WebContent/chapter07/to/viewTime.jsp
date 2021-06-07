<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
Calendar cal = (Calendar) request.getAttribute("time");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>현재 시간</title>
<meta http-equiv="refresh" content="1;url='/dditServlet/chapter07/from/makeTime.jsp'" />
</head>
<body>
	현재 시간은?
	<br /><%=cal.get(Calendar.HOUR)%>시
	<%=cal.get(Calendar.MINUTE)%>분
	<%=cal.get(Calendar.SECOND)%>초 입니다.
</body>
</html>