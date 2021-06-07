<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<jsp:useBean id="member" scope="request" class="chapter08.member.MemberInfo" />
<!DOCTYPE html>
<html>
<head>
<title>인사말</title>
</head>
<body>

<%=member.getName()%>(<%=member.getId()%>) 회원님<br />
안녕하세요?

</body>
</html>