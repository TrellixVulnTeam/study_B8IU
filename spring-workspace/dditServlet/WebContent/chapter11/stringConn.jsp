<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String name = "개똥이";
request.setAttribute("name", name);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 문자열 연결</title>
</head>
<body>
	${"사과" += "는 맛있다."}
	<br />${name}에게는 ${"3" + 2}개의 사과가 있다.
	<br />${5}명이 먹는당.
</body>
</html>