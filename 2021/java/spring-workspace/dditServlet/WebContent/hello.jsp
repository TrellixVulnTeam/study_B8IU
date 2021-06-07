<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>안녕? JSP</title>
</head>
<body>
JSP 코드의 주된 목적은 HTML 문서를 생성하여 웹 브라우저에 보여주는 것임.
<br/> 1. 설정 부분
<br/> 2. 응답 생성 부분
<br/>
<%
    String title = "반가워 JSP";
    String author = "이학재";
%>
<b><%=title%>
</b>(<%=author%>)
</body>
</html>