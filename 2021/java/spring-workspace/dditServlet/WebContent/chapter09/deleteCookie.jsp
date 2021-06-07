<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
Cookie cookie = new Cookie("name", "");
//유효 시간을 0으로 지정.
//Cookie 클래스는 쿠키를 삭제하는 기능을 별도로 제공안함
cookie.setMaxAge(0);
response.addCookie(cookie);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 삭제</title>
</head>
<body>

</body>
</html>