<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>안녕? JSP</title>
</head>
<body>
JSP코드의 주된 목적은 HTML문서를 생성하여 웹 브러우저에 보여주는 것임.
<br />
1. 설정 부분<br />
2. 응답 생성 부분<br />
<%
	String title = "반가워 JSP";
	String author = "박상빈";
%>
<b><%=title%></b>(<%=author%>)

</body>
</html>