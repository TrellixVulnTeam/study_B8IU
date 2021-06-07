<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="kr.or.ddit.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String mem_id = request.getParameter("mem_id");
	String mem_pw = request.getParameter("mem_pw");
	String mem_name = request.getParameter("mem_name");
	String mem_zipcode = request.getParameter("mem_zipcode");
	String mem_address1 = request.getParameter("mem_address1");
	String mem_address2 = request.getParameter("mem_address2");
	String mem_tel = request.getParameter("mem_tel");
	String mem_email = request.getParameter("mem_email");
	
	Connection con = DBConnect.getCon();
	
	String sql = "insert into member(mem_id, mem_pass, mem_name, mem_zip, mem_add1, mem_add2, mem_hp, mem_mail) "
		+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	
	PreparedStatement stmt = con.prepareStatement(sql);
	stmt.setString(1, mem_id);
	stmt.setString(2, mem_pw);
	stmt.setString(3, mem_name);
	stmt.setString(4, mem_zipcode);
	stmt.setString(5, mem_address1);
	stmt.setString(6, mem_address2);
	stmt.setString(7, mem_tel);
	stmt.setString(8, mem_email);
	
	int result = stmt.executeUpdate();
	if (result > 0) {
%>
		{"sw" : "<%= mem_name %>님 가입을 축하합니다."}
<%
	} else {
%>
		{"sw" : "저장 실패"}
<%
	}
%>


