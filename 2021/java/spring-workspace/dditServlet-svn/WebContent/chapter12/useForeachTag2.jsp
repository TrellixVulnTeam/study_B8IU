<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.HashMap"%>
<!DOCTYPE html>
<html>
<head>
<title>foreach tag연습2</title>
</head>
<body>
<!-- <숙제> 
	c:forEach를 이용하여 30개의 textbox를 만들고,
	 10, 20, 30번째의 textbox의 배경색을 각각 노랑, 초록, 빨강으로 처리하자.
	 이 때, javascript 또는 jQuery를 이용하지 말아보자. c:if 등 이용
-->
<form name="frm" id="frm" method="post" action="./useForeachTag2.jsp">
	<input type="text" name="txt" id="txt" value="" /><br />
</form>

</body>
</html>
