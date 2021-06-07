<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pageContext 기본 객체</title>
</head>
<body>
	<%
	//servlet Request 타입으로 return하는 것이 아니라, HttpServeletRequest 타입으로 리턴
	HttpServletRequest httpRequest = (HttpServletRequest) pageContext.getRequest();
	%>
	동일여부?
	<%=request == httpRequest%>
	<br />
	<%
	pageContext.getOut().println("안녕하세요?");
	%>
</body>
</html>