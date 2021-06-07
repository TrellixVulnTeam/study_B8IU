<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="member" class="chapter08.member.MemberInfo" scope="request"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인사말</title>
</head>
<body>
	<%=member.getName()%>(<%=member.getId()%>) 회원님
	<br />안녕하세요?
</body>
</html>