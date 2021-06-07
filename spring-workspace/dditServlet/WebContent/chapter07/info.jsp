<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INFO</title>
</head>
<body>
	<table border="1" style="width: 100%; cellpadding: 0px; cellspacing: 0px;">
		<tr>
			<th>제품번호</th>
			<td>P101000001</td>
		</tr>
		<tr>
			<th>가격</th>
			<td>10,000원</td>
		</tr>
	</table>
	<jsp:include page="infoSub.jsp">
		<jsp:param value="A" name="type"/>
	</jsp:include>
</body>
</html>