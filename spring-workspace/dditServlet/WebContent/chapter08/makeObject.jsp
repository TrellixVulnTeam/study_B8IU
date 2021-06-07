<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="member" class="chapter08.member.MemberInfo" scope="request"></jsp:useBean>

<%
member.setId("ddit");
member.setName("개똥이");
%>
<jsp:forward page="useObject.jsp"></jsp:forward>