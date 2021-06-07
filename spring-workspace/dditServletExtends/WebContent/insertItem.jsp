<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.SQLException"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
request.setCharacterEncoding("UTF-8");

String idValue = request.getParameter("id") == null ? "" : request.getParameter("id");

Connection conn = null;
PreparedStatement pstmtItem = null;
PreparedStatement pstmtDetail = null;

String jdbcDriver = "jdbc:oracle:thin:@localhost:1521:xe";
String dbUser = "jspexam";
String dbPass = "java";

Throwable occuredException = null;

try {
	conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
	conn.setAutoCommit(false);
	pstmtItem = conn.prepareStatement("insert into item(item_id, name) values(?, ?)");
	pstmtItem.setInt(1, Integer.valueOf(idValue));
	pstmtItem.setString(2, "상품명 " + idValue);
	pstmtItem.executeUpdate();
	
// 	if (request.getParameter("error") != null) {
// 		throw new Exception("의도적 exception 발생");
// 	}
	pstmtDetail = conn.prepareStatement("insert into item_detail(item_id, detail) values(?, ?)");
	pstmtDetail.setInt(1, Integer.valueOf(idValue));
	pstmtDetail.setString(2, "상세설명 " + idValue);
	pstmtDetail.executeUpdate();
	conn.commit();
} catch (Throwable e) {
	e.printStackTrace();
	occuredException = e;
	if (conn != null) {
		try {
	conn.rollback();
		} catch (SQLException ex) {
	ex.printStackTrace();
		}
	}
} finally {
	if (pstmtDetail != null) {
		try {
	pstmtDetail.close();
		} catch (SQLException ex) {
	ex.printStackTrace();
		}
	}
	if (pstmtItem != null) {
		try {
	pstmtItem.close();
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
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insertitem</title>
</head>
<body>
	<%
	if (occuredException == null) {
	%>
	<p>데이터가 성공적으로 들어감</p>
	<%
	} else {
	%>
	<p>
		오류 발생:
		<%=occuredException%>
	</p>
	<%
	}
	%>
</body>
</html>