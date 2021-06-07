<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
</head>
<body>
<c:if test="${errors.idOrPwNotMatch}">
아이디와 비밀번호가 일치하지 않습니다.
</c:if>
<form name="frm" id="frm" method="post" action="login.do">
<p>
	아이디:<br /><input type="text" name="id" value="" />
	<c:if test="${errors.id}">ID를 입력하세요.</c:if>
</p>
<p>
	비밀번호 : <br /><input type="password" name="password" />
	<c:if test="${errors.password}">비밀번호를 입력하세요.</c:if>
</p>
<input type="submit" value="로그인" />
</form>

</body>
</html>