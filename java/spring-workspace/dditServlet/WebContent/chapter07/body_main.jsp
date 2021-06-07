<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INFO</title>
</head>
<body>
	include 전 name 파라미터 값:
	<%=request.getParameter("name")%>
	<hr />
	<jsp:include page="body_sub.jsp">
		<jsp:param value="개똥이" name="name"/>
	</jsp:include>
	<hr />
	include 전 name 파라미터 값:
	<%=request.getParameter("name")%>
</body>
</html>