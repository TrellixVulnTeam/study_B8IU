<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>choose Tag 연습</title>
</head>
<body>
	<c:choose>
		<c:when test="${param.name == 'ddit'}">
			<p>이름은 ${param.name}입니다.</p>
		</c:when>
		<c:when test="${param.age > 20}">
			<p>나이는 20살 이상입니다.</p>
		</c:when>
		<c:otherwise>
			<p>아이디가 'ddit'가 아니고, 20살 미만입니다.</p>
		</c:otherwise>
	</c:choose>
</body>
</html>