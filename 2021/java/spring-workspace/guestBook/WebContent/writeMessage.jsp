<%@page import="guestbook.service.WriteMessageService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="message" class="guestbook.model.Message">
	<jsp:setProperty name="message" property="*" />
</jsp:useBean>
<%
int result = WriteMessageService.getInstance().write(message);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 메시지 남기기</title>
</head>
<body>
	<%
	if (result > 0) {
	%>
	<p>방명록에 메시지를 남겼습니다.</p>
	<%
	} else {
	%>
	<p>메시지 남기기를 실패하였습니다.</p>
	<%
	}
	%>
	<p>[<a href="list.jsp">목록으로</a>]</p>
</body>
</html>