<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="guestbook.service.DeleteMessageService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("UTF-8");

String messageId = request.getParameter("messageId");
String password = request.getParameter("password");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 메시지 삭제</title>
</head>
<body>
	<%
	try {
		if (DeleteMessageService.getInstance().deleteMessage(messageId, password) > 0) {
	%><p>삭제 성공</p>
	<%
	} else {
	%><p>삭제 실패</p>
	<%
	}
	} catch (Exception ex) {
	%>
	<p>
		오류 발생:
		<%=ex.getMessage()%></p>
	<%
	}
	%>
	<p>
		<input type="button" value="목록으로 이동" onclick="location.href='list.jsp'" />
	</p>
</body>
</html>
