<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>if Tag</title>
</head>
<body>
	<!-- 아이디가 a001이고, 비밀번호가 1234일 때 로그인 처리	-->
	<!-- test										-->
	<!--	→ 검사 조건								-->
	<!-- var										-->
	<!--	→ 검사 조건의 계산 결과값을 저장할 EL 변수			-->
	<c:if test="${param.id eq 'a001' and param.pw eq '1234'}" var="rslt">
		<p>로그인 됨</p>
		<p>
			<c:out value="${rslt}"></c:out>
		</p>
		<c:set var="id" value="${param.id}" scope="session"></c:set>
		<c:set var="pw" value="${param.pw}" scope="session"></c:set>
	</c:if>

	<form action="./useIfTag2.jsp" method="post">
		<input type="text" name="id" value="${param.id}" placeholder="id를 입력하세요.">
		<br/><input type="password" name="pw" value="${param.pw}" placeholder="비밀번호를 입력하세요.">
		<br/><input type="submit" value="제출">
	</form>
</body>
</html>