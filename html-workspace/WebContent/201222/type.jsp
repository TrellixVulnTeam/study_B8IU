<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="../css/public.css" type="text/css">
	</head>
	<body>
		<%
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String userInfo = request.getParameter("area");
		userInfo = userInfo.replaceAll("\r","").replaceAll("\n", "<br>");
		%>
		
		<img src="../images/커피2.jpg" alt="">
		<p><%=id %>님 한영합니다.</p>
		<%=userInfo %>
	</body>
</html>