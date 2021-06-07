<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HTML 문서를 생성하는 전형적인 JSP 코드</title>
</head>
<body>
<%
String bookTitle = "JSP 프로그래밍";
String author = "개똥이";
%>
<b><%=bookTitle%></b>(<%=author%>)입니다.
</body>
</html>