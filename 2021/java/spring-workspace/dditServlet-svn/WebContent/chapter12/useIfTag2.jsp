<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>if 태그</title>
</head>
<body>

<!-- 아이디가 a001이고, 비밀번호가 1234일때 로그인 처리
useIfTag2.jsp?id=a001&pass=1234 
test : 검사 조건
var : 검사 조건의 계산 결과값을 저장할 EL 변수
-->
<c:if var="rslt" test="${(param.id eq 'a001') and (param.pass eq '1234')}">
로그인됨<br />
<%session.setAttribute("id", request.getParameter("id"));%>
	<c:out value="${rslt}" />
<%=session.getAttribute("id") %>	
</c:if>

<form name="frm" id="frm" method="post" action="useIfTag2.jsp">
	<input type="text" name="id" id="id" value="${param.id}" /><br />
	<input type="password" name="pass" id="pass" value="${param.pass}" /><br />
	<input type="submit" value="로그인" />
</form>


</body>
</html>

