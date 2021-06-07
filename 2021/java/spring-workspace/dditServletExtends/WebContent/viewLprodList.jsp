<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.Connection"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
Connection conn = null;
Statement stmt = null;
ResultSet rs = null;

try {
	String url = "jdbc:apache:commons:dbcp:chapter14";
	String sql = "select * from lprod order by lprod_gu";

	conn = DriverManager.getConnection(url);
	stmt = conn.createStatement();
	rs = stmt.executeQuery(sql);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 분류 코드</title>
</head>
<body>
<p>
	<table border="1" style="width: 100%;">
		<tr>
			<th>상품분류id</th>
			<th>상품분류코드</th>
			<th>상품분류명</th>
		</tr>
		<%
		while (rs.next()) {
		%>
		<tr>
			<td><%=rs.getString("lprod_id")%></td>
			<td><%=rs.getString("lprod_gu")%></td>
			<td><%=rs.getString("lprod_nm")%></td>
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