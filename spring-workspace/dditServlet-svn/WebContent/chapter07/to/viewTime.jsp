<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.Calendar"%>
<%
	Calendar cal = (Calendar)request.getAttribute("time");
%>
<!DOCTYPE html>
<html>
<head>
<title>현재 시간</title>
<meta http-equiv="refresh" content="1;url='/dditServlet/chapter07/from/makeTime.jsp'" />
</head>
<body>
현재 시간은? 
<%=cal.get(Calendar.HOUR)%>시 
<%=cal.get(Calendar.MINUTE)%>분 
<%=cal.get(Calendar.SECOND)%>초 입니다.

</body>
</html>