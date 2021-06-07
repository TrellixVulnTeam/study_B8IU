<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%
	//cookie 객체를 생성
	Cookie cookie = new Cookie("name",URLEncoder.encode("개똥이","UTF-8"));
	//response기본 객체에 해당 cookie 객체를 add함
	response.addCookie(cookie);
%>
<!DOCTYPE html>
<html>
<head>
<title>쿠키 생성</title>
</head>
<body>
<%
	String value = URLDecoder.decode(cookie.getValue(), "UTF-8");
%>
<%=cookie.getName()%> 쿠키의 값 = <%=value%>

</body>
</html>

