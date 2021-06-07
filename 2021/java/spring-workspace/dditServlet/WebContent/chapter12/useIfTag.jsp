<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>if Tag</title>
</head>
<body>
	<c:if test="true">
		<p>무조건 실행함</p>
	</c:if>

	<c:if test="${param.name == 'ddit'}">
		<c:set var="name" value="${param.name}"></c:set>
		<p>name 파라미터 값이 ${param.name}입니다.</p>
	</c:if>
	<c:if test="${param.age >= 23}">
		<c:set var="age" value="${param.age}"></c:set>
		<p>당신의 나이는 23세 이상입니다.</p>
	</c:if>
	
	<p>${name}</p>
	<p>${age}</p>
	
	<c:if test="${name eq 'ddit'}">
		<p><c:out value="${age}"></c:out></p>
	</c:if>
</body>
</html>