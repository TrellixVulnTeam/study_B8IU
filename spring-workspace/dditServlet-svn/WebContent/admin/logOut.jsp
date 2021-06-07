<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	if(session.getAttribute("id")!=null){
		session.invalidate();
		out.println("<script type='text/javascript'>location.href='index.jsp';</script>");
	}else{
		response.sendRedirect("loginForm.jsp");
	}
%>