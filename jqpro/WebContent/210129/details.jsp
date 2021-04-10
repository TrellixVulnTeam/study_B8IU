<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="kr.or.ddit.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Connection con = DBConnect.getCon();
	
// 	String sql = "select * from buyer where buyer_id = '" + request.getParameter("id") + "'";
// 	Statement stmt = con.createStatement();
// 	ResultSet rs = stmt.executeQuery(sql);
	
	String sql = "select * from buyer where buyer_id = ?";
	PreparedStatement stmt = con.prepareStatement(sql);
	stmt.setString(1, request.getParameter("id"));
	ResultSet rs = stmt.executeQuery();
	
	rs.next();
%>
	{
		"BUYER_ID" : "<%= rs.getString("BUYER_ID") %>",
		"BUYER_NAME" : "<%= rs.getString("BUYER_NAME") %>",
		"BUYER_LGU" : "<%= rs.getString("BUYER_LGU") %>",
		"BUYER_BANK" : "<%= rs.getString("BUYER_BANK") %>",
		"BUYER_BANKNO" : "<%= rs.getString("BUYER_BANKNO") %>",
		"BUYER_BANKNAME" : "<%= rs.getString("BUYER_BANKNAME") %>",
		"BUYER_ZIP" : "<%= rs.getString("BUYER_ZIP") %>",
		"BUYER_ADD1" : "<%= rs.getString("BUYER_ADD1") %>",
		"BUYER_ADD2" : "<%= rs.getString("BUYER_ADD2") %>",
		"BUYER_COMTEL" : "<%= rs.getString("BUYER_COMTEL") %>",
		"BUYER_FAX" : "<%= rs.getString("BUYER_FAX") %>",
		"BUYER_MAIL" : "<%= rs.getString("BUYER_MAIL") %>",
		"BUYER_CHARGER" : "<%= rs.getString("BUYER_CHARGER") %>",
		"BUYER_TELEXT" : "<%= rs.getString("BUYER_TELEXT") %>"
	}
