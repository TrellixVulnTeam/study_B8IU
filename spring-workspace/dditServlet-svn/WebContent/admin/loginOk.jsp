<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	if(id.equals("a001")&&password.equals("1234")){
		session.setAttribute("id", id);
		session.setAttribute("password", password);
		response.sendRedirect("index.jsp");
	}else{
		out.println("<script type='text/javascript'>alert('잘못된 아이디 또는 비밀번호입니다.');location.href='loginForm.jsp';</script>");
	}	
%>