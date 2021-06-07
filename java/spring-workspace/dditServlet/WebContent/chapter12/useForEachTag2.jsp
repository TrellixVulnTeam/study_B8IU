<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forEach Tag 연습</title>
</head>
<body>
	<!-- c:forEach를 이용하여 30개의 input type="text"를 만들고						-->
	<!-- 10, 20, 30번째의 input type="text"의 배경색을 각각 노랑, 초록, 빨강으로 처리하자	-->
	<!-- 단, javascript 또는 jQuery를 이용하지 않고 색상을 변경할 것					-->
	<form method="post" action="./useForEachTag2.jsp">
		<c:forEach var="i" begin="1" end="30">
			<c:choose>
				<c:when test="${i == 10}">
					<input type="text" name="txt${i}" style="background-color: yellow;">
					<br />
				</c:when>
				<c:when test="${i == 20}">
					<input type="text" name="txt${i}" style="background-color: green;">
					<br />
				</c:when>
				<c:when test="${i == 30}">
					<input type="text" name="txt${i}" style="background-color: red;">
					<br />
				</c:when>
				<c:otherwise>
					<input type="text" name="txt${i}">
					<br />
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</form>
</body>
</html>