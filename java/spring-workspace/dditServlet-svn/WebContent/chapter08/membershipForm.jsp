<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>회원가입 입력 폼</title>
</head>
<body>

<form name="frm" id="frm" method="post" action="/dditServlet/chapter08/processJoining.jsp">
<table border="1" style="width:30%;cellpadding:0px;cellspacing:0px;">
	<tr>
		<th>아이디</th>
		<td colspan="3"><input type="text" name="id" id="id" size="10" /></td>
	</tr>
	<tr>
		<th>이름</th>
		<td><input type="text" name="name" id="name" size="10" /></td>
		<th>이메일</th>
		<td><input type="text" name="email" id="email" size="10" /></td>
	</tr>
	<tr>
		<th>주소</th>
		<td colspan="3"><input type="text" name="address" id="address" size="10" /></td>
	</tr>
	<tr>
		<td colspan="4" style="text-align:center;">
			<input type="submit" value="회원가입" />
		</td>
	</tr>
</table>
</form>

</body>
</html>