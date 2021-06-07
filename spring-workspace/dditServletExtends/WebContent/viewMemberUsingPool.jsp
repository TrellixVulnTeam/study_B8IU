<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.Connection"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
Connection conn = null;
Statement stmt = null;
ResultSet rs = null;
try {
	String jdbcDriver = "jdbc:apache:commons:dbcp:chapter14";
	String sql = "select * from member order by memberid";
	conn = DriverManager.getConnection(jdbcDriver);
	stmt = conn.createStatement();
	rs = stmt.executeQuery(sql);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>
	<table border="1" style="width: 100%;">
		<tr>
			<th>이름</th>
			<th>아이디</th>
			<th>이메일</th>
		</tr>
		<%
		while (rs.next()) {
		%>
		<tr>
			<td><%=rs.getString("name")%></td>
			<td><%=rs.getString("memberid")%></td>
			<td><%=rs.getString("email")%></td>
		</tr>
		<%
		}
		} catch (SQLException ex) {
		ex.printStackTrace();
		} finally {
		if (rs != null) {
		try {
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		}
		if (stmt != null) {
		try {
			stmt.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		}
		if (conn != null) {
		try {
			conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		}
		}
		%>
	</table>
</body>
</html>