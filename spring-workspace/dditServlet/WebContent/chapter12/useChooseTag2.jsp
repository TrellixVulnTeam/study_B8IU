<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Choose Tag 연습</title>
</head>
<body>
	<c:set value="사과" var="name" scope="request"></c:set>

	<c:choose>
		<c:when test="${name eq \"사과\"}">
			<p>사과입니다.</p>
		</c:when>
		<c:when test="${name eq \"바나나\"}">
			<p>바나나입니다.</p>
		</c:when>
		<c:otherwise>
			<p>오렌지도 아니고 바나나도 아닙니다.</p>
		</c:otherwise>
	</c:choose>
</body>
</html>