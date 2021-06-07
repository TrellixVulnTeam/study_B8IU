<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>catch Tag 연습</title>
</head>
<body>
	<c:catch var="ex">
		<p><%=request.getParameter("name")%></p>
		<%
		if (request.getParameter("name").equals("ddit")) {
		%>
		<p>${param.name}은 ddit입니다.</p>
		<%
		}
		%>
	</c:catch>
	<c:if test="${ex != null}">
		<p>오류 발생: ${ex}</p>
	</c:if>
</body>
</html>