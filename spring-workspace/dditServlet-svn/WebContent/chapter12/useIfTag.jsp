<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>if 태그</title>
</head>
<body>
<!-- 조건문의 결과값이 true이므로 항상 실행함 -->
<c:if test="true">
무조건 실행함<br />	
</c:if>

<!-- test : 검사조건 -->
<c:if test="${param.name=='ddit'}">
name 파라미터 값이 ${param.name} 입니다.<br />
</c:if>

<c:if test="${param.age>=23}">
당신의 나이는 23세 이상입니다.<br />
</c:if>

<c:set var="name" value="${param.name}" />
<c:set var="age" value="${param.age}" />
<span>${name}</span><br />
<span>${age}</span><br />

<c:if test="${name eq 'ddit'}">
	<c:out value="${age}" /><br />
</c:if>

</body>
</html>

