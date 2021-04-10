<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Class.forName("oracle.jdbc.driver.OracleDriver");

	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection con = DriverManager.getConnection(url, "LHJ", "java");

	Statement stmt = con.createStatement();

	String sql = "select mem_id, mem_name, mem_hp from member";

	ResultSet rs = stmt.executeQuery(sql);
%>
[
<%
	int i = 0;
	while (rs.next()) {
		String id = rs.getString("mem_id");
		String name = rs.getString("mem_name");
		String hp = rs.getString("mem_hp");
		if (i > 0) out.print(", ");
%>
		{
			"id" : "<%= id %>",
			"name" : "<%= name %>",
			"hp" : "<%= hp %>"
		}
<%
		i++;
	}
%>
]
