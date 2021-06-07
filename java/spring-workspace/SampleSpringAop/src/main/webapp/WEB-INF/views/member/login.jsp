<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<style type="text/css">
label {
	display: inline-block;
	width: 75px;
	text-align: center;
}
</style>
</head>
<body>
	<form method="post">
		<p>
			<label for="memberid">아이디</label><input type="text" id="memberid" name="memberid" />
		</p>
		<p>
			<label for="password">비밀번호</label><input type="password" id="password" name="password" />
		</p>
		<p>
			<input type="submit" value="로그인" />
		</p>
	</form>
</body>
</html>