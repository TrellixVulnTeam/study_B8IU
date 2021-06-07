<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
Date time = new Date();
SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션정보</title>
</head>
<body>
	<p>
		세션 ID:
		<%=session.getId()%></p>
	<%
	// 세션의 생성 시간을 Date 객체인 time에 저장함
	time.setTime(session.getCreationTime());
	%>
	<p>
		세션 생성 시간:
		<%=formatter.format(time)%></p>
	<%
	time.setTime(session.getLastAccessedTime());
	%>
	<p>
		최근 접근시간:
		<%=formatter.format(time)%></p>
</body>
</html>