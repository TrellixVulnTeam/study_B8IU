<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.SQLException"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String memberId = request.getParameter("memberId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세 정보</title>
</head>
<body>
	<%
	Class.forName("oracle.jdbc.driver.OracleDriver");

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	try {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUser = "jspexam";
		String dbPass = "java";

		String sql = "select * from member where memberId = '" + memberId + "'";

		conn = DriverManager.getConnection(url, dbUser, dbPass);
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		if (rs.next()) {
	%>
	<table border="1">
		<tr>
			<th>아이디</th>
			<td><%=rs.getString("memberid")%></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><%=rs.getString("password")%></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><%=rs.getString("name")%></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><%=rs.getString("email")%></td>
		</tr>
	</table>
	<a href="viewMemberList.jsp">목록으로</a>
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
</body>
</html>