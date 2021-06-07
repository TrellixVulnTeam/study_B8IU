<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style type="text/css">
label {
	display: inline-block;
	width: 75px;
	text-align: center;
}
</style>
</head>
<body>
	<form method="post">
		<p>
			<label for="memberid">아이디</label><input type="text" id="memberid" name="memberid" value="${param.memberid}" />
			<c:if test="${errors.memberid}">ID를 입력하세요.</c:if>
		</p>
		<p>
			<label for="password">비밀번호</label><input type="password" id="password" name="password" value="${param.password}" />
			<c:if test="${errors.password}">비밀번호를 입력하세요.</c:if>
		</p>
		<p>
			<c:if test="${errors.idOrPwNotMatch}">아이디 또는 비밀번호가 일치하지 않습니다.</c:if>
		</p>
		<p>
			<input type="submit" value="로그인" />
		</p>
	</form>
</body>
</html>