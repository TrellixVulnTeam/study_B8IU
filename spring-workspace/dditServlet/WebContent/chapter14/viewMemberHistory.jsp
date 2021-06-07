<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="oracle.sql.CLOB"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.io.Reader"%>
<%@ page import="oracle.jdbc.OracleResultSet"%>
<%@ page import="java.io.IOException"%>
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
	//CLOB 데이터를 위해 PreparedStatement 클래스로 변경
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	//CLOB 데이터를 위한 CLOB 클래스를 추가

	CLOB clob = null;

	try {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUser = "jspexam";
		String dbPass = "java";

		String sql = "select * from member_history where memberId = '" + memberId + "'";

		conn = DriverManager.getConnection(url, dbUser, dbPass);
		conn.setAutoCommit(false);

		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();

		//CLOB 데이터를 읽기
		Reader reader = null;
		char[] char_array;

		if (rs.next()) {
	%>
	<table border="1">
		<tr>
			<th>아이디</th>
			<td><%=rs.getString("memberid")%></td>
		</tr>
		<tr>
			<th>히스토리</th>
			<td>
				<%
				String contents = null;
				try {
					clob = ((OracleResultSet)rs).getCLOB("history");
					
					//CLOB 자료형의 데이터를 읽어오기
					reader = clob.getCharacterStream();
					
					//읽어온 CLOB 데이터의 길이만큼 char 형으로 생성
					char_array = new char[(int)clob.length()];
					int rcnt = reader.read(char_array);
					contents = (new String(char_array));
				} catch (IOException ex) {
					out.println("예외 발생: " + ex.getMessage());
				} finally {
					if (reader != null) {
						try {
					reader.close();
						} catch (IOException ex) {
					out.println("예외 발생: " + ex.getMessage());
						}
					}
				}
				%>
				<%=contents %>
			</td>
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
	if (pstmt != null) {
	try {
		pstmt.close();
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