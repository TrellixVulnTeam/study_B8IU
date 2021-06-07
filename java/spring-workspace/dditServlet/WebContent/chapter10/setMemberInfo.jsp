<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
session.setAttribute("memberid", "ddit");
session.setAttribute("name", "개똥이");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션에 정보 저장</title>
</head>
<body>
	<p>세션에 정보를 저장했습니다.</p>
	<%
	String memberId = (String) session.getAttribute("memberid");
	String name = (String) session.getAttribute("name");
	%>
	<p>
		회원 아이디:
		<%=memberId%></p>
	<p>
		회원 이름:
		<%=name%></p>
		<input type="button" id="btn" onclick="location.href='closeSession.jsp'" value="로그아웃">
</body>
</html>