<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경</title>
<style type="text/css">
label {
	display: inline-block;
	width: 125px;
	text-align: center;
}
</style>
</head>
<body>
	<form action="" method="post">
		<p>
			<label for="currentPassword">현재 비밀번호</label><input type="password" name="currentPassword" />
			<c:if test="${errors.currentPasswordEmpty}">비밀번호를 입력하세요.</c:if>
			<c:if test="${errors.invalidPassword}">비밀번호가 일치하지 않습니다.</c:if>
		</p>
		<p>
			<label for="newPassword">새로운 비밀번호</label><input type="password" name="newPassword" />
			<c:if test="${errors.newPasswordEmpty}">비밀번호를 입력하세요.</c:if>
		</p>
	</form>
</body>
</html>