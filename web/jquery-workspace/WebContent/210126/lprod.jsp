<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection con =  DriverManager.getConnection(url, "LHJ", "java");
	Statement stmt = con.createStatement();
	
	String sql = "select * from lprod";
	
	ResultSet rs = stmt.executeQuery(sql);
%>
[
<%
	int i = 0;
	while (rs.next()) {
		int id = rs.getInt("LPROD_ID");
		String gu = rs.getString("LPROD_GU");
		String nm = rs.getString("LPROD_NM");
		if (i > 0) out.print(", ");
%>
		{
			"id" : "<%= id %>",
			"gu" : "<%= gu %>",
			"nm" : "<%= nm %>"
		}
<%
	i++;
	}
%>
]




