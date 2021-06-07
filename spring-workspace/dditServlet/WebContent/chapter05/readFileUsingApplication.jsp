<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.DataInputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.InputStreamReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application 객체를 이용하여 자원 읽기</title>
</head>
<body>
	<%
	String resourcePath = "/chapter05/notice.txt";
	%>
	실제 경로
	<br />
	<%=application.getRealPath(resourcePath)%>
	---
	<br />
	<%
	char[] buff = new char[128];
	int len = -1;

	InputStreamReader br = new InputStreamReader(application.getResourceAsStream(resourcePath), "UTF-8");

	while ((len = br.read(buff)) != -1) {
		out.print(new String(buff, 0, len));
	}
	%>
</body>
</html>