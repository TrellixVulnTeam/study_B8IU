<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.SQLException"%>
<%
	String memberId = request.getParameter("memberId");
%>
<!DOCTYPE html>
<html>
<head>
<title>회원 상세 정보</title>
</head>
<body>
<%
	Class.forName("oracle.jdbc.driver.OracleDriver");

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	try{
		String jdbcDriver = "jdbc:oracle:thin:@localhost:1521/xe";
		String query = "select * from member where memberid='" + memberId + "'";
		String dbUser = "jspexam";
		String dbPass = "java";
		conn = DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
		stmt = conn.createStatement();
		rs = stmt.executeQuery(query);
		if(rs.next()){
%>
<table border="1" style="width:100%;">
<tr>
	<th>아이디</th><td><%=memberId%></td>
</tr>
<tr>
	<th>비밀번호</th><td><%=rs.getString("password")%>
</tr>
<tr>
	<th>이름</th><td><%=rs.getString("name")%></td>
</tr>
<tr>
	<th>이메일</th><td><%=rs.getString("email")%></td>
</tr>
</table><br />
<input type="button" id="btnList" value="목록으로"
		 onclick="script:location.href='viewMemberList.jsp';" />
<%			
		}else{
			out.println(memberId + " 회원의 정보가 없습니다.");
		}
	}catch(SQLException ex){
		out.println("오류 발생 : " + ex.getMessage());
	}finally{
		if(rs!=null) try{rs.close();} catch(SQLException ex){}
		if(stmt!=null) try{stmt.close();} catch(SQLException ex){}
		if(conn!=null) try{conn.close();} catch(SQLException ex){}
	}
%>
</body>
</html>





