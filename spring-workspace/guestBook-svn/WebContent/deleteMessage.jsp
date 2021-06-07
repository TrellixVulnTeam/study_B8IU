<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="guestbook.service.DeleteMessageService"%>
<%@page import="guestbook.service.InvalidPasswordException"%>
<%
int messageId = Integer.parseInt(request.getParameter("messageId"));
String password = request.getParameter("password");
boolean invalidPasswrd = false;
try{
	DeleteMessageService deleteService = DeleteMessageService.getInstances();
	deleteService.deleteMessage(messageId, password);
}catch(InvalidPasswordException ex){
	invalidPasswrd = true;
}
%>
<!DOCTYPE html>
<html>
<head>
<title>방명록 메시지 삭제함</title>
</head>
<body>
<%
	if(!invalidPasswrd){
		out.println("메시지를 삭제하였습니다.");
	}else{
		out.println("입력한 암호가 올바르지 않습니다. 암호를 확인해주세요");
	}
%>
<br />
<a href="list.jsp">[목록 보기]</a>
</body>
</html>




