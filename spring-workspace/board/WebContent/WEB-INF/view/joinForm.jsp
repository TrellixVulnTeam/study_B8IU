<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style type="text/css">
label {
	display: inline-block;
	width: 75px;
	text-align: center;
}
</style>
</head>
<body>
	<form action="" method="post">
		<p>
			<label for="id">아이디</label><input type="text" id="id" name="id" value="${param.id}" />
			<c:if test="${errors.id}">ID를 입력하세요.</c:if>
			<c:if test="${errors.duplicateId}">이미 사용중인 아이디입니다.</c:if>
		</p>
		<p>
			<label for="name">이름</label><input type="text" id="name" name="name" value="${param.name}" />
			<c:if test="${errors.name}">이름을 입력하세요.</c:if>
		</p>
		<p>
			<label for="password">비밀번호</label><input type="password" id="password" name="password" value="${param.password}" />
			<c:if test="${errors.password}">비밀번호를 입력하세요.</c:if>
		</p>
		<p>
			<label for="confirmPassword">확인</label><input type="password" id="confirmPassword" name="confirmPassword" value="${param.confirmPassword}" />
			<c:if test="${errors.confirmPassword}">확인을 입력하세요.</c:if>
			<c:if test="${errors.notMatch}">비밀번호 확인이 일치하지 않습니다.</c:if>
		</p>
		<input type="submit" value="가입" />
	</form>
</body>
</html>