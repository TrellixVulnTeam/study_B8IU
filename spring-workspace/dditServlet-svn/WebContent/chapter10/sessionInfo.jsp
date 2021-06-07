<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.Date"%>
<%@ page session = "true" %>
<%
	Date time = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
%>
<!DOCTYPE html>
<html>
<head>
<title>세션정보</title>
</head>
<body>
세션ID : <%=session.getId()%><br />
<%
	//세션의 생성 시간을 Date 객체인 time에 저장함
	time.setTime(session.getCreationTime());
%>
세션 생성 시간 : <%=formatter.format(time)%><br />
<%
	//세션의 마지막 접근 시간을 출력함
	time.setTime(session.getLastAccessedTime());
%>
최근 접근 시간 : <%=formatter.format(time)%>
</body>
</html>



