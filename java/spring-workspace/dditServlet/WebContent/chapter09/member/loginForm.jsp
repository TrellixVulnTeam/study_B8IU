<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
Cookie[] cookies = request.getCookies();
String id = null;
for (Cookie cookie : cookies) {
	if (cookie.getName().equals("id")) {
		id = cookie.getValue();
	}
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 폼</title>
<style type="text/css">
label {
	display: inline-block;
	width: 75px;
	text-align: center;
}
</style>
</head>
<body>
	<%
	if (id != null) {
	%>
	<%=id%>님 환영합니다.
	<input type="button" onclick="location.href='deleteCookie.jsp'" value="로그아웃" />
	<%
	} else {
	%>
	<form action="./login.jsp" method="post">
		<label for="id">아이디</label><input type="text" name="id" id="id" style="width: 150px;"> <br /> <label for="password">비밀번호</label><input type="password" name="password" id="password" style="width: 150px;"> <br /> <input type="submit" value="로그인" />
	</form>
	<%
	}
	%>
</body>
</html>