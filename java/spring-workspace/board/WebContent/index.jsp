<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원제 게시판 예제</title>
</head>
<body>
	<c:choose>
		<c:when test="${authUser != null and not empty authUser}">
			<p>${authUser.name} ( ${authUser.memberid} ) 님, 안녕하세요.</p>
			<p>[<a href="logout.do">로그아웃</a>]</p>
			<p>[<a href="changePassword.do">비밀번호 변경</a>]</p>
		</c:when>
		<c:otherwise>
			<p>[<a href="join.do">회원가입</a>]</p>
			<p>[<a href="login.do">로그인</a>]</p>
		</c:otherwise>
	</c:choose>
</body>
</html>