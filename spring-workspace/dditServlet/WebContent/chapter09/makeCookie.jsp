<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%
//cookie 객체를 생성
Cookie cookie = new Cookie("name", URLEncoder.encode("개똥이", "UTF-8"));
//response 기본 객체에 해당 cookie 객체를 add함
response.addCookie(cookie);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 생성</title>
</head>
<body>
	<%=cookie.getName()%>
	쿠키의 값 =
	<%=cookie.getValue()%>
	<br />Decode 된 쿠키의 값 =
	<%=URLDecoder.decode(cookie.getValue(), "UTF-8")%>
</body>
</html>