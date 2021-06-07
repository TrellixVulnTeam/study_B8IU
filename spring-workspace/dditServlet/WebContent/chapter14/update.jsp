<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.SQLException"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("UTF-8");

String id = request.getParameter("id");
String name = request.getParameter("name");

Class.forName("oracle.jdbc.driver.OracleDriver");

Connection conn = null;
Statement stmt = null;
int rs = 0;
try {
	String jdbcDriver = "jdbc:oracle:thin:@localhost:1521:xe";

	String dbUser = "jspexam";
	String dbPass = "java";
	String query = "update member set name = '" + name + "' where memberid = '" + id + "'";

	conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
	stmt = conn.createStatement();
	rs = stmt.executeUpdate(query);
} catch (SQLException ex) {
	ex.printStackTrace();
} finally {
	if (stmt != null) {
		try {
	stmt.close();
		} catch (SQLException ex) {
	ex.printStackTrace();
		}
	}
	if (conn != null) {
		try {
	stmt.close();
		} catch (SQLException ex) {
	ex.printStackTrace();
		}
	}
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이름 변경</title>
</head>
<body>
	<%
	if (rs > 0) {
	%>
	<p><%=id%>의 이름을
		<%=name%>(으)로 변경했습니다.
	</p>
	<p><a href="viewMemberList.jsp">회원 목록으로 이동</a></p>
	<%
	} else {
	%>
	<p><%=id%>
		아이디가 존재하지 않습니다.
	</p>
	<%
	}
	%>
</body>
</html>