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
<table border='1'>
	<tr class='tr1'><td>LPROD_ID</td><td>LPROD_GU</td><td>LPROD_NM</td></tr>
<%
	int i = 0;
	while (rs.next()) {
		int id = rs.getInt("LPROD_ID");
		String gu = rs.getString("LPROD_GU");
		String nm = rs.getString("LPROD_NM");
%>
	<tr>
		<td><%= id %></td>
		<td><%= gu %></td>
		<td><%= nm %></td>
	</tr>
<%
	}
%>
</table>
