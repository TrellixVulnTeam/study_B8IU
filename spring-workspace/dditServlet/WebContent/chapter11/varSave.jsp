<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
pageContext.setAttribute("id", "page객체 id의 값");
request.setAttribute("id", "request객체 id의 값");
session.setAttribute("id", "session객체 id의 값");
application.setAttribute("id", "application객체 id의 값");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 변수 정리</title>
</head>
<body>
	<p>
		pageContext<br />→ ${pageScope.id}
	</p>
	<p>
		requestContext<br />→ ${requestScope.id}
	</p>
	<p>
		sessionContext<br />→ ${sessionScope.id}
	</p>
	<p>
		applicationContext<br />→ ${applicationScope.id}
	</p>
	<p>
		\${id}<br />→ ${id}
	</p>
	<p>
		우선순위<br />→ pageScope → requestScope → sessionScope → applicationScope
	</p>
	<hr />
	<p>${(empty param.name)?"name 파라미터가 없습니다.":param.name}</p>
</body>
</html>