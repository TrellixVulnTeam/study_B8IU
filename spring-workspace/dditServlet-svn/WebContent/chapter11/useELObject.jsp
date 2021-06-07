<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	request.setAttribute("name", "홍길동");
	session.setAttribute("id","a001");
	application.setAttribute("ban", "401호");
	session.setAttribute("phone","010-123-1234");
%>
<!DOCTYPE html>
<html>
<head>
<title>EL Object</title>
</head>
<body>
<!-- 이름이 name인 요청 파라미터의 값을 출력함. 없을 때는 null -->
${param.name}<br />
<!-- request 기본 객체에 저장된 속성의 <속성, 값> 매핑을 저장한 Map 객체 -->
requestScope의 name : ${requestScope.name}<br />
sessionScope의 id : ${sessionScope.id}<br />
applicationScope의 class : ${applicationScope.ban}<br />
속성값 검색 : ${phone}<br />
<!-- 
	pageContext : JSP의 page 기본 객체와 동일함	
 -->
${pageContext.request.requestURI}<br />

</body>
</html>



