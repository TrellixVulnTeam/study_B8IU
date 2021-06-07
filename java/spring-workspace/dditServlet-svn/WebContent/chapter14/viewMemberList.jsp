<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
<title>회원 목록</title>
</head>
<body>

MEMBER 테이블의 내용<br />
<table border="1" style="width:100%;">
<tr>
	<th>이름</th><th>아이디</th><td>이메일</td>
</tr>
<%
	//1. JDBC 드라이버 로딩. 오라클 jdbc 드라이버는 오라클드라이버다.
	Class.forName("oracle.jdbc.driver.OracleDriver");
	//DB와 연결
	Connection conn = null;
	//쿼리 실행을 위한 객체
	Statement stmt = null;
	//쿼리 실행 결과 사용
	ResultSet rs = null;
	try{
	//jdbc 오라클 thin 드라이버
	String jdbcDriver = "jdbc:oracle:thin:@localhost:1521:xe";
	String dbUser = "jspexam";
	String dbPass = "java";
	String query = "select * from member order by memberid";
	
	//2. DB Connection 생성
	conn = DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
	//3. Statement 생성
	stmt = conn.createStatement();
	//4. 쿼리 실행
	rs = stmt.executeQuery(query);
	//5. 쿼리 실행 결과 출력
	while(rs.next()){
%>
<tr>
	<td><%=rs.getString("name")%></td>
	<td><a href="viewMember.jsp?memberId=<%=rs.getString("memberid")%>">
			<%=rs.getString("memberid")%></a></td>
	<td><%=rs.getString("email")%></td>
</tr>
<%
	}
	}catch(SQLException ex){
		out.println(ex.getMessage());
		ex.printStackTrace();
	}finally{
		//6. 사용한 rs, stmt를 종료
		if(rs != null) try{rs.close();}catch(SQLException ex){}
		if(stmt != null) try{stmt.close();}catch(SQLException ex){}
		//7. conn 종료
		if(conn != null) try{conn.close();}catch(SQLException ex){}
	}
%>
</table>

</body>
</html>