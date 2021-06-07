<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
label {
	display: inline-block;
	width: 75px;
}
</style>
<script type="text/javascript">
	function fn_submit() {
		if (document.querySelector('input[name=job]:checked') === null) {
			alert("직업이 선택되지 않았습니다.");
			return false;
		}
		if (document.querySelector('input[name=memId]').value.trim().length === 0) {
			alert('아이디가 입력되지 않았습니다.');
			return false;
		}
		if (document.querySelector('input[name=memPass]').value.trim().length === 0) {
			alert('비밀번호가 입력되지 않았습니다.');
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<form action="loginCheck.jsp" method="post" onsubmit="return fn_submit()">
		<input type="radio" name="job" id="student" value="student"><label for="student">학생</label>
		<input type="radio" name="job" id="teacher" value="teacher"><label for="teacher">교사</label>
		<input type="radio" name="job" id="admin" value="admin"><label for="admin">관리자</label><br />
		<label for="memId">아이디</label><input type="text" name="memId" id="memId"><br />
		<label for="memPass">비밀번호</label><input type="password" name="memPass" id="memPass"><br />
		<input type="submit" value="로그인">
	</form>
</body>
</html>