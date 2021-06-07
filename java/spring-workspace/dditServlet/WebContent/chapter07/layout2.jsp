<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>layout2</title>
</head>
<body>
	<table border="1" style="width: 100%; cellpadding: 0px; cellspacing: 0px;">
		<tr>
			<td colspan="2"><jsp:include page="/chapter07/module/top.jsp"></jsp:include></td>
		</tr>
		<tr>
			<td style="width: 25%;"><jsp:include page="/chapter07/module/left.jsp"></jsp:include></td>
			<td style="width: 75%;">3</td>
		</tr>
		<tr>
			<td colspan="2"><jsp:include page="/chapter07/module/bottom.jsp"></jsp:include></td>
		</tr>
	</table>
</body>
</html>