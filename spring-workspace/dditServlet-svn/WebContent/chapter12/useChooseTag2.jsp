<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>choose 태그 연습</title>
</head>
<body>

<c:set var="name" value="사과" scope="request" />

<c:choose>
	<c:when test="${name eq '사과'}">
		사과입니다.
	</c:when>
	<c:when test="${name eq '바나나'}">
		바나나입니다.
	</c:when>
	<c:otherwise>
		오렌지도 아니고 바나나도 아닙니다.
	</c:otherwise>
</c:choose>

</body>
</html>