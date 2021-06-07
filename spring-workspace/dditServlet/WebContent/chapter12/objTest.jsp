<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="chapter08.member.MemberInfo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 객체의 프로퍼티 값 설정</title>
</head>
<body>
	<%
	MemberInfo member = new MemberInfo();
	%>
	<p>
		<c:set target="<%=member%>" property="name" value="개똥이"></c:set>
		&lt;c:set target="&lt;%=member%>" property="name" value="개똥이">&lt;/c:set>
		<br />&lt;%=member.getName()%>
		<br />→ <%=member.getName()%>
	</p>
	<p>
	<c:set var="m" value="<%=member%>"></c:set>
	<c:set target="${m}" property="name" value="정은경"></c:set>
	&lt;c:set var="m" value="&lt;%=member%>">&lt;/c:set>
	<br />&lt;c:set target="\${m}" property="name" value="정은경">&lt;/c:set>
	<br />\${m.name}
	<br />→ ${m.name}
	</p>
</body>
</html>