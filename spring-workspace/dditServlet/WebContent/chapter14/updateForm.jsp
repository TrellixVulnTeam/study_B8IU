<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이름 변경 폼</title>
<style type="text/css">
label {
	display: inline-block;
	width: 75px;
	text-align: center;
}
</style>
</head>
<body>
	<form action="/dditServlet/chapter14/update.jsp" method="post">
		<table border="1">
			<tr>
				<th><label for="id">아이디</label></th>
				<td><input type="text" name="id" id="id"></td>
				<th><label for="name">이름</label></th>
				<td><input type="text" name="name" id="name"></td>
			</tr>
			<tr>
				<td colspan="4"><input type="submit" value="변경"></td>
			</tr>
		</table>
	</form>
</body>
</html>