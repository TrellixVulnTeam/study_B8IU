<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.Connection"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록</title>
</head>
<body>
	<p>MEMEBER Table의 내용</p>
	<table border="1">
		<tr>
			<th>이름</th>
			<th>아이디</th>
			<th>이메일</th>
		</tr>
		<%
		//1. JDBC 드라이버 로딩.
		//	오라클 jdbc 드라이버는 오라클 드라이버다.
		Class.forName("oracle.jdbc.driver.OracleDriver");

		//DB와 연결
		Connection conn = null;

		//쿼리 실행을 위한 객체
		Statement stmt = null;

		//쿼리 실행 결과 사용
		ResultSet rs = null;

		try {

			//jdbc 오라클 thin 드라이버
			String jdbcDriver = "jdbc:oracle:thin:@localhost:1521:xe";

			String dbUser = "jspexam";
			String dbPass = "java";
			String query = "select * from member order by memberid";

			//2. DB Connection 생성
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);

			//3. Statement 생성
			stmt = conn.createStatement();

			//4. 쿼리 실행
			rs = stmt.executeQuery(query);

			//5. 쿼리 실행 결과 출력

			while (rs.next()) {
		%>
		<tr onclick="location.href='viewMember.jsp?memberId=<%=rs.getString("memberid")%>'" style="cursor: pointer;">
			<td><%=rs.getString("name")%></td>
			<td><%=rs.getString("memberid")%></td>
			<td><%=rs.getString("email")%></td>
		</tr>
		<%
		}
		} catch (SQLException ex) {
		out.println(ex.getMessage());
		ex.printStackTrace();
		} finally {
		// 6. 사용한 rs, stmt를 종료
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

		//7. conn 종료
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