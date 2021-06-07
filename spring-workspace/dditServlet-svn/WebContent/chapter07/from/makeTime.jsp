<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.Calendar"%>
<%
	Calendar cal = Calendar.getInstance();
	request.setAttribute("time", cal);
%>
<jsp:forward page="/chapter07/to/viewTime.jsp" />