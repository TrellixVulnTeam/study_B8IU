<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%
	request.setCharacterEncoding("UTF-8");

	String memberId = request.getParameter("memberId");
	String name = request.getParameter("name");
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	
	int updateCount = 0;
	Connection conn = null;
	Statement stmt = null;
	
	try{
		String jdbcDriver = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUser = "jspexam";
		String dbPass = "java";
		String query = "update member set name='" + name + "' " + 
					   "where memberid='" + memberId + "'";
		conn = DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
		stmt = conn.createStatement();
		updateCount = stmt.executeUpdate(query);
	}catch(SQLException ex){
		ex.printStackTrace();
	}finally{
		if(stmt!=null) try{stmt.close();}catch(SQLException ex){}
		if(conn!=null) try{conn.close();}catch(SQLException ex){}
	}
%>
<!DOCTYPE html>
<html>
<head>
<title>이름 변경</title>
</head>
<body>

<%
	if(updateCount > 0){
		out.println(memberId + "의 이름을 " + name + "으로 변경했습니다.");
	}else{
		out.println(memberId + " 아이디가 존재하지 않습니다.");
	}
%>
<br />
<a href="viewMemberList.jsp">회원 목록으로 이동</a>
</body>
</html>








