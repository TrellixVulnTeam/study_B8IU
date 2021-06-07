<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 입력 폼</title>
</head>
<body>
	<form action="/dditServlet/chapter08/processJoining.jsp" name="frm" id="frm" method="post">
		<table border="1" style="width: 30%; cellpadding: 0px; cellspacing: 0px;">
			<tr>
				<th>아이디</th>
				<td colspan="3"><input type="text" name="id" size="10"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" size="10"></td>
				<th>이메일</th>
				<td><input type="email" name="email" size="10"></td>
			</tr>
			<tr>
				<th>주소</th>
				<td colspan="3"><input type="text" name="address" size="30"></td>
			</tr>
			<tr>
				<th colspan="4"><input type="submit" value="제출"></th>
			</tr>
		</table>
	</form>
</body>
</html>