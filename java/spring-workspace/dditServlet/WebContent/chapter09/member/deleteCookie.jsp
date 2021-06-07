<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	Cookie cookie = new Cookie("name", "");
	Cookie cookieId = new Cookie("id", "");
	Cookie cookiePassword = new Cookie("password", "");
	
	//유효시간을 0으로 지정
	//Cookie 클래스는 쿠키를 삭제하는 기능을 별도로 제공안함
	cookie.setMaxAge(0);
	cookieId.setMaxAge(0);
	cookiePassword.setMaxAge(0);
	response.addCookie(cookie);
	response.addCookie(cookieId);
	response.addCookie(cookiePassword);
	response.sendRedirect("loginForm.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>