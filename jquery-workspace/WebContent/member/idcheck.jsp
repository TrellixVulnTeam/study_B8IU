<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.or.ddit.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId = request.getParameter("mem_id");

	Connection con = DBConnect.getCon();

	String sql = "select mem_id from member where mem_id='" + userId + "'"; 
	
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	
	if (!rs.next()) {
%>
		{"isActivate" : "true"}
<%
	} else {
%>
		{"isActivate" : "false"}
<%
	}
%>