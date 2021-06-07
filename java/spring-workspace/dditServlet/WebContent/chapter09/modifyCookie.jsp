<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder"%>
<%
Cookie[] cookies = request.getCookies();

// for (int i = 0; i < cookies.length; i++) {
// 	if (cookies[i].getName().equals("name")) {
//name 쿠키가 존재하는 경우, name인 Cookie 객체를 새롭게 생성
//응답 헤더에 추가
Cookie cookie = new Cookie("name", URLEncoder.encode("정우성", "UTF-8"));
response.addCookie(cookie);
// 	}
// }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 값 변경</title>
</head>
<body>name 쿠키 값을 변경함
</body>
</html>