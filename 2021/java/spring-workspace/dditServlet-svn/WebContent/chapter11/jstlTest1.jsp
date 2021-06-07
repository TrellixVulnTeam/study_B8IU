<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="chapter08.member.MemberInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>

<c:set var="name" value="개똥이" />
<c:set var="name2" value="홍길동" scope="request" />
\${name} : ${name}<br />
\${name2} : ${name2}<br />
<c:set var="name3">박명수</c:set>
\${name3} : ${name3}<br />
<%MemberInfo member = new MemberInfo(); %>
<c:set target="<%=member%>" property="name" value="김철수" />
<%=member.getName()%><br />
<c:set var="m" value="<%=member%>" />
<c:set target="${m}" property="name" value="홍명보" />
${m.name}<br />
<%Map<String, String> prop = new HashMap<String, String>(); %>
<c:set target="<%=prop%>" property="host" value="localhost" />
<%=prop.get("host")%><br />
</body>
</html>