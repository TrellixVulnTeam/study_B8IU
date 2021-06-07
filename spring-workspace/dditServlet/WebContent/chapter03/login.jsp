<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
//삼항연산자를 사용하여 request.getParameter의 NULL을 체크함
String id = request.getParameter("memberId");
//memberId 파라미터의 값이 ddit
if ("ddit".equals(id)) {
	response.sendRedirect("index.jsp?name");
} else {
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인에 실패</title>
</head>
<body>
아이디가 ddit가 아닙니다.
</body>
</html>
<%
}
%>
