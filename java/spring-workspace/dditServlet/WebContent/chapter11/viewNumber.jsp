<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="elfunction" uri="/WEB-INF/tlds/el-functions.tld"%>
<%
request.setAttribute("price", 12345);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 함수 호출</title>
</head>
<body>
	<p>
		가격은 <b>${elfunction:formatNumber(price, "#,##0")}</b>원 입니다.
	</p>
</body>
</html>