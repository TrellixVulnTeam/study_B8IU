<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	Cookie cookie = new Cookie("name",null);
	Cookie cookieId = new Cookie("id",null);
	Cookie cookiePassword = new Cookie("password",null);
	//유효시간을 0으로 지정. 
	//Cookie 클래스는 쿠키를 삭제하는 기능을 별도로 제공안함
	cookie.setMaxAge(0);
	cookieId.setMaxAge(0);
	cookiePassword.setMaxAge(0);
	
	response.addCookie(cookie);
	response.addCookie(cookieId);
	response.addCookie(cookiePassword);	
	
	response.sendRedirect("/dditServlet/chapter09/member/loginForm.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<title>쿠키 삭제</title>
</head>
<body>
name 쿠키를 삭제합니다.
</body>
</html>