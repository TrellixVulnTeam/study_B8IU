<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="kr.or.ddit.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Connection con = DBConnect.getCon();

	String sql = "select mem_id, mem_name from Member";

	Statement stmt = con.createStatement();
	//PreparedStatement pst = con.prepareStatement(sql);
	
	ResultSet rs = stmt.executeQuery(sql);
%>
[

<%
	int i = 0;
	while (rs.next()) {
		String id = rs.getString("mem_id");
		String name = rs.getString("mem_name");
		if (i > 0) out.print(", ");
%>
		{
			"id" : "<%= id %>",
			"name" : "<%= name %>"
		}
<%
		i++;
	}
%>
]