<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="oracle.sql.CLOB"%>
<%@page import="oracle.jdbc.OracleResultSet"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.Reader"%>
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
	//clob 데이터를 위해 PrepareStatement 클래스로 변경
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	//clob 데이터를 위한 CLOB 클래스를 추가
	CLOB clob = null;	
	
	try{
		String jdbcDriver = "jdbc:oracle:thin:@localhost:1521/xe";
		String query = "select * from member_history where memberid='" + memberId + "'";
		String dbUser = "jspexam";
		String dbPass = "java";
		conn = DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
		//autoCommit을 false
		conn.setAutoCommit(false);
		pstmt = conn.prepareStatement(query);
		rs = pstmt.executeQuery();
		
		//clob 데이터를 읽기
		Reader reader = null;
		char[] char_array;
		
		if(rs.next()){
%>
<table border="1" style="width:100%;">
<tr>
	<th>아이디</th><td><%=memberId%></td>
</tr>
<tr>
	<th>히스토리</th>
	<td>
<%
	String contents = "";
	try{
		clob = ((OracleResultSet)rs).getCLOB("history");
		//clob 자료형의 데이터를 읽어오기
		reader = clob.getCharacterStream();
		//읽어온 clob 데이터의 길이만큼 char 형으로 생성
		char_array = new char[(int)clob.length()];
		int rcnt = reader.read(char_array);
		contents = (new String(char_array));
	}catch(IOException ex){
		out.println("예외 발생 : " + ex.getMessage());
	}finally{
		if(reader!=null)try{reader.close();}catch(IOException ex){}
	}
%>
	<%=contents%>
	</td>
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
		if(pstmt!=null) try{pstmt.close();} catch(SQLException ex){}
		if(conn!=null) try{conn.close();} catch(SQLException ex){}
	}
%>
</body>
</html>





