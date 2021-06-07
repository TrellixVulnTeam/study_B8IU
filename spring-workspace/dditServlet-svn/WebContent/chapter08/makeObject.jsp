<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<jsp:useBean id="member" scope="request" class="chapter08.member.MemberInfo" />
<%
	member.setId("ddit");
	member.setName("개똥이");
%>
<jsp:forward page="useObject.jsp" />