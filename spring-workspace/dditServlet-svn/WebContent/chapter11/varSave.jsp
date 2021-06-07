<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	pageContext.setAttribute("id", "page객체의 id의 값");
	request.setAttribute("id", "request객체의 id의 값");
	session.setAttribute("id", "session객체의 id의 값");
	application.setAttribute("id", "application객체의 id의 값");
%>
<!DOCTYPE html>
<html>
<head>
<title>EL 변수 정리</title>
</head>
<body>
pageContext : ${pageScope.id}<br /> 
request : ${requestScope.id}<br /> 
session : ${sessionScope.id}<br /> 
application : ${applicationScope.id}<br />
${id}<br />
우선순위 : pageScope > requestScope > sessionScope > applicationScope<br />
${param.name}<br />
${(empty param.name)?"없음":param.name}<br />
</body>
</html>



