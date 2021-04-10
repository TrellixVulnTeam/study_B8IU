<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Driver"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.or.ddit.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Connection con = DBConnect.getCon();

	Statement stmt = con.createStatement();
	
	String sql = "select buyer_id, buyer_name from buyer";
	
	ResultSet rs = stmt.executeQuery(sql);
%>
[
<%
	int i = 0;
	while (rs.next()) {
		if (i++ > 0) out.print(",");
		String buyer_id = rs.getString("buyer_id");
		String buyer_name = rs.getString("buyer_name");
%>
		{
			"buyer_id" : "<%= buyer_id %>",
			"buyer_name" : "<%= buyer_name %>"
		}
<%
	}
%>
]