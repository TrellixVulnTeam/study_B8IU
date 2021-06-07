<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>옵션 선택 화면</title>
</head>
<body>

<form name="frm" id="frm" method="get" action="view.jsp">
	<select name="code" id="code" style="margin-right:10px;">
		<option value="A">A페이지</option>
		<option value="B">B페이지</option>
		<option value="C">C페이지</option>
	</select>
	<input type="submit" value="이동" />
</form>

</body>
</html>