<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%
	String idValue = request.getParameter("id");
	
	Connection conn = null;
	PreparedStatement pstmtItem = null;
	PreparedStatement pstmtDetail = null;
	
	String jdbcDriver = "jdbc:oracle:thin:@localhost:1521/xe";
	String dbUser = "jspexam";
	String dbPass = "java";
	
	Throwable occuredException = null;
	
	try{
		int id = Integer.parseInt(idValue);
		conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
		//트랜잭션이 시작됨(수동 commit)
		conn.setAutoCommit(false);
		//첫번째 Query
		pstmtItem = conn.prepareStatement("insert into item(item_id,name) values(?,?)");
		pstmtItem.setInt(1,id);
		pstmtItem.setString(2,"상품명"+id);
		pstmtItem.executeUpdate();
		
		if(request.getParameter("error")!=null){
			throw new Exception("의도적 exception 발생");
		}
		
		//두번째 Query
		pstmtDetail = conn.prepareStatement("insert into item_detail(item_id,detail) values(?,?)");
		pstmtDetail.setInt(1,id);
		pstmtDetail.setString(2,"상세설명"+id);
		pstmtDetail.executeUpdate();
		//트랜잭션 반영. 종료. 새로운 트랜잭션 시작
		conn.commit();
	}catch(Throwable e){
		if(conn!=null){try{conn.rollback();}catch(SQLException ex){}}
		occuredException = e;
	}finally{
		if(pstmtItem!=null)try{pstmtItem.close();}catch(SQLException ex){}
		if(pstmtDetail!=null)try{pstmtDetail.close();}catch(SQLException ex){}
		if(conn!=null)try{conn.close();}catch(SQLException ex){}		
	}
%>
<!DOCTYPE html>
<html>
<head>
<title>ITEM값 입력</title>
</head>
<body>
<%
if(occuredException!=null){
	out.println("오류발생 : " + occuredException.getMessage());
}else{
	out.println("데이터가 성공적으로 들어감");
}
%>
</body>
</html>



