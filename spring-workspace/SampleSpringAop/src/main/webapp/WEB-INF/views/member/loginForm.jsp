<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 로그인</title>
<style type="text/css">
label {
	display: inline-block;
	width: 80px;
	text-align: center;
}
</style>
<script type="text/javascript">
	function fn_login() {
		const varId = document.getElementById('memberid');
		const varPwd = document.getElementById('password');

		if (varId.value.trim() == "") {
			alert("아이디를 입력해주세요");

			return false;
		}

		if (varPwd.value.trim() == "") {
			alert("비밀번호를 입력해주세요");

			return false;
		}

		return true
	}
</script>
</head>
<body>
<c:choose>
<c:when test="${!empty memberVO}">
	${memberVO.name} (${memberVO.memberid})님, 안녕하세요
	<script type="text/javascript">
		opener.location.href = "/list";

		setTimeout(function() {
			this.close();
		}, 3000);
	</script>
</c:when>
<c:otherwise>
	<form method="post" action="/member/login" onsubmit="return fn_login()">
		<p>
			아이디 : <label for="memberid"><input type="text" name="memberid" id="memberid" value=""></label>
		</p>
		<p>
			비밀번호 : <label for="password"><input type="password" name="password" id="password" value=""></label>
		</p>
		<input type="submit" value="로그인" />
	</form>
</c:otherwise>
</c:choose>
</body>
</html>