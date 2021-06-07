<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="chapter08.member.MemberInfo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<title>JSTL 객체의 프로퍼티 값 설정</title>
</head>
<body>

<%MemberInfo member = new MemberInfo();%>
<%member.setName("개똥이");%>
<%-- <c:set target="<%=member%>" property="name" value="개똥이" /> --%>
<%=member.getName()%><br />
<table border="1">
<%List<MemberInfo> list = new ArrayList<MemberInfo>(10);%>
<%
for(MemberInfo vo : list){
	out.print("<tr><td>"+vo.getId()+"</td></tr>");
}
%>
</table>

<c:set var="m" value="<%=member%>" />
<c:set target="${m}" property="name" value="정은경" />
${m.name}<br />


</body>
</html>