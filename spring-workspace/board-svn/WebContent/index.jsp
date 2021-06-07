<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>회원제 게시판 예제</title>
</head>
<body>

<c:if test="${!empty authUser}">
${authUser.name}님, 안녕하세요.<br />
	<a href="logout.do">[로그아웃]</a><br />
	<a href="changePwd.do">[비밀번호변경]</a><br />
</c:if>
<c:if test="${empty authUser}">
	<a href="join.do">[회원가입]</a><br />
	<a href="login.do">[로그인]</a><br />
</c:if>

</body>
</html>




