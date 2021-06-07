<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>choose 태그 연습</title>
</head>
<body>

<c:choose>
	<c:when test="${param.name=='ddit'}">
		아이디는 ${param.name} 입니다.
	</c:when>
	<c:when test="${param.age>20}">
		나이는 20살 이상입니다.
	</c:when>
	<c:otherwise>
		아이디가 'ddit'가 아니고, 20살 미만입니다.
	</c:otherwise>
</c:choose>

</body>
</html>