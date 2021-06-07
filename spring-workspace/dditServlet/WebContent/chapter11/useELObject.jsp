<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setAttribute("name", "홍길동");
session.setAttribute("id", "a001");
application.setAttribute("ban", "401호");
session.setAttribute("phone", "010-123-1234");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL Object</title>
</head>
<body>
	<!-- 이름이 name인 요청 파라미터 값을 출력함. 없을 때는 null					-->
	<p>${param.name}</p>

	<!-- request 기본 객체에 포함된 속성의 <속성, 값> 매핑을 저장한 Map 객체		-->
	<p>
		requestScope의 name<br />→ ${requestScope.name}
	</p>
	<p>
		sessionScope의 id<br />→ ${sessionScope.id}
	</p>
	<p>
		applicationScope의 ban<br />→ ${applicationScope.ban}
	</p>
	<p>
		속성값 검색<br />→ ${phone}
	</p>

	<!-- pageContext.request.requestURI: JSP의 page 기본 객체와 동일함	-->
	<p>${pageContext.request.requestURI}</p>
</body>
</html>