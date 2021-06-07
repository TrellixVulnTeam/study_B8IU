<%@page import="guestbook.service.WriteMessageService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="guestbook.model.Message"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="message" class="guestbook.model.Message">
	<jsp:setProperty name="message" property="*" />
</jsp:useBean>
<%
WriteMessageService writeService = 
	WriteMessageService.getInstance();
writeService.write(message);
%>
<!DOCTYPE html>
<html>
<head>
<title>방명록 메시지 남김</title>
</head>
<body>
방명록에 메시지를 남겼습니다.<br />
<a href="list.jsp">목록으로 이동</a>
</body>
</html>





