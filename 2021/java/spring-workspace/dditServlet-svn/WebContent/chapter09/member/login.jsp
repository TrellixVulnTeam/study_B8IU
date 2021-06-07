<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");
%>
<!DOCTYPE html>
<html>
<head>
<title>로그인 성공</title>
</head>
<body>
<%
	if(id.equals("a001")&&password.equals("1234")){
		//로그인 성공
		Cookie cookieId = new Cookie("id",id);
		Cookie cookiePassword = new Cookie("password",password);
		
		response.addCookie(cookieId);
		response.addCookie(cookiePassword);
		
		out.println(
		"<script type='text/javascript'>alert('로그인 성공!');" + 
		"location.href='loginForm.jsp';</script>"
		);
	}else{
		out.println(
		"<script type='text/javascript'>alert('로그인 실패!');"+
		"history.go(-1);</script>"
		);
	}
%>
</body>
</html>